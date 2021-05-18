/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import entities.Jeu;
import entities.Scores;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import services.ServiceJeu;
import services.ServiceScore;

/**
 *
 * @author asus
 */
public class statscore  extends Form{
     
        /**
     * Creates a renderer for the specified colors.
     */
    
    Form current;
    public statscore(Form previous) { 
        current=this;
     setTitle("Stats");
                setLayout(BoxLayout.y());
      this.add(createPieChartForm(previous));
      
     
    }
    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    /**
     * Builds a category series using the provided values.
     *
     * @param titles the series titles
     * @param values the values
     * @return the category series
     */
    protected CategorySeries buildCategoryDataset(String title, double[] values,Map<String,Integer> verif) {
        CategorySeries series = new CategorySeries(title);
        
        int k = 0;
      /*  for (double value : values) {
            series.add("Jeux" + ++k, value);
        }*/
      
      for (Map.Entry<String,Integer> entry : verif.entrySet()) {
    series.add("Jeux: "+entry.getKey(),entry.getValue());
    
}
     

        return series;
    }

    public Form createPieChartForm(Form previous) {
        int x=0;
        
           Map<String,Integer> verif = new HashMap<String,Integer>();

     for(Scores d1 : new ServiceScore().afficherall() )
{    
  /* if(!verif.contains(Integer.toString(d1.getCours())))
    {verif.add(Integer.toString(d1.getCours()));
   x++;*/
    if(!verif.containsKey(Integer.toString(d1.getId_jeux())))
    {
        verif.put(Integer.toString(d1.getId_jeux()),1);
    }
   else
    {
        verif.put(Integer.toString(d1.getId_jeux()),verif.get(Integer.toString(d1.getId_jeux()))+1);
    }
}


     //verif mapp
     
     for (Map.Entry<String,Integer> entry : verif.entrySet()) {
     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}
     
     
     
        // Generate the values
        //double[] values = new double[]{12, 14, 11, 10, 2};
        double [] v =new double[verif.size()];
        int i=0;
        for (Integer key: verif.values()) {
            System.out.println(key);
            
            v[i]=key;
            i++;
        }

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(20);
        renderer.setDisplayValues(true);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Tries for each game", v,verif), renderer);
              getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, ev -> previous.showBack() );

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
        Form f = new Form("Tries for each game");
        f.setLayout(new BorderLayout());
        f.addComponent(BorderLayout.CENTER, c);
        return f;
    }
}
    


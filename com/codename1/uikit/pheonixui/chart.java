/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.pheonixui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.mycompany.myapp.Blogform;
import com.mycompany.myapp.entities.Blog;
import com.mycompany.myapp.entities.commentaire;
import com.mycompany.myapp.services.ServiceBlog;
import com.mycompany.myapp.services.Servicecommentaire;
import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author houss
 */
public class chart {
    Form current;
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
    protected CategorySeries buildCategoryDataset(String title, double[] values) {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values) {
            series.add("Blog comments number " + ++k, value);
        }

        return series;
    }

    public Form createPieChartForm() {

        ArrayList<Blog> list_blog=new ServiceBlog().getAllBlog();
          int n=list_blog.size();
          int nb=0;
        
        double[] values = new double[n];
        ArrayList<commentaire> list_commentaire=new Servicecommentaire().getAllcommentaire();
     for(int i = 0;i< list_blog.size();i++ )
     {
         for(int j=0;j < list_commentaire.size();j++ )
         {
             if(list_commentaire.get(j).getIdblog() == list_blog.get(i).getId())
             {
               nb++;  
             }
             
         }
        values[i]=nb;
        nb=0;
     }
        
        
      

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.LTGRAY, ColorUtil.MAGENTA, ColorUtil.GRAY, ColorUtil.LTGRAY};
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
        PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        // Create a form and show it.
        Form f = new Form("Comments stats");
        f.setLayout(new BorderLayout());
        f.addComponent(BorderLayout.CENTER, c);
        Button back=new Button("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
               new Blogform(current).show();
               
            }
        });
        f.addComponent(BorderLayout.SOUTH,back);
        return f;
    }
    
}

package com.codename1.uikit.pheonixui;

import com.darkprograms.speech.translator.GoogleTranslate;

import java.io.IOException;

public class GoogleTTS_Translate {
    public static String google_Translate(String languagetarget,String target)//Hàm in ra từ dịch nghĩa qua api google translate
    {
        String target_translated="";
        try {
            target_translated= GoogleTranslate.translate(languagetarget,target);

        }catch (IOException e)
        {
          
        }
        return target_translated;
    }
}

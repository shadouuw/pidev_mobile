
package com.mycompany.myapp;
import com.codename1.system.NativeInterface;

/**
*Native Interface for text to speech
*@houss
*/

public interface TTS extends  NativeInterface
{
public void say(String text);
}
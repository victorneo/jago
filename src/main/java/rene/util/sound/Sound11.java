package rene.util.sound;

import java.io.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;


public class Sound11 implements Sound
{
    AudioFormat AFormat;
    AudioInputStream A;
    String Name;
    DataLine.Info info;

    public Sound11 (String name)
    {
        setName(name);
        load(name);
    }

    public void setName (String name)
    {
        Name = name;
    }

    public String getName ()
    {
        return Name;
    }

    public void load (String file)
    {
        try
        {
            InputStream in = getClass().getClassLoader().getResourceAsStream(file);
            load(in);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void load (InputStream in)
    {
        try
        {
            A = AudioSystem.getAudioInputStream(in);
            AFormat = A.getFormat();
            info = new DataLine.Info(SourceDataLine.class, AFormat);
        }
        catch (Exception e)
        {
            System.out.println(e);
            info = null;
        }

    }

    public void start ()
    {
        if (info != null)
        {
            try {
                Clip audioClip = (Clip) AudioSystem.getLine(info);
                audioClip.open(A);
                audioClip.start();
                audioClip.close();
                A.close();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }

    public static void main (String args[])
    {
        Sound11 s = new Sound11("/sounds/message.au");
        s.start();
        s.start();
        try
        {
            Thread.sleep(5000);
        }
        catch (Exception e)
        {}
    }
}

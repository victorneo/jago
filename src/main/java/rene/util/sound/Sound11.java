package rene.util.sound;

import java.io.*;

// TODO Replace sun package
// import sun.audio.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound11 implements Sound
{
    // TODO Replace sun package
    // AudioData Data;
    AudioInputStream A;
    String Name;
    int Length;

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
            // TODO Replace sun package
            // @SuppressWarnings("resource") AudioStream AS = new AudioStream(in);
            InputStream in = getClass().getResourceAsStream(file);
            load(in);
        }
        catch (Exception e)
        {
            System.out.println(e);
            // TODO Replace sun package
            // Data = null;
        }
    }

    public void load (InputStream in)
    {
        // TODO Replace sun package
        /*
        try
        {
            @SuppressWarnings("resource") AudioStream AS = new AudioStream(in);
            Length = AS.available();
            Data = AS.getData();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        */

    }

    public void start ()
    {
        // TODO Replace sun package
        /*
        if (Data != null)
        {
            try
            {
                if (A == null)
                    A = new AudioDataStream(Data);
                else A.reset();
                AudioPlayer.player.start(A);
                Thread.sleep(Length * 1000 / 8000 + 500);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        */
    }

    public static void main (String args[])
    {
        Sound11 s = new Sound11("/jagoclient/au/message.au");
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

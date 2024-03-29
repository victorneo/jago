package rene.util.sound;

import java.io.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class Beep
{
    byte B[];
    AudioInputStream A;
    AudioFormat AFormat;

    public Beep ()
    {
        B = null;
    }

    public Beep (int frequ, int dur)
    {
        init(frequ, dur);
    }

    public void beep (int frequ, int dur)
    {
        init(frequ, dur);
        play();
    }

    public void init (int frequ, int dur)
    {
        try
        {
            int Offset = 24;
            int Length = dur * 8;
            if (B == null || B.length < Offset + Length)
                B = new byte[Offset + Length];
            storeInt(B, 0, 0x2E736E64);
            storeInt(B, 4, Offset);
            storeInt(B, 8, Length);
            storeInt(B, 12, 1);
            storeInt(B, 16, 8000);
            storeInt(B, 20, 1);
            for (int i = 0; i < Length; i++)
            {
                store(B, Offset + i,
                    0.3 * Math.sin(i / 8000.0 * 2 * Math.PI * frequ) + 0.2
                        * Math.sin(i / 8000.0 * 2 * Math.PI * 2 * frequ) + 0.1
                        * Math.sin(i / 8000.0 * 2 * Math.PI * 3 * frequ));
            }
            InputStream in = new ByteArrayInputStream(B);
            AudioInputStream audio = AudioSystem.getAudioInputStream(in);
            AFormat = audio.getFormat();
            B = new byte[audio.available()];
            audio.read(B);
            audio.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void play ()
    {
        try
        {
            DataLine.Info info=new DataLine.Info(SourceDataLine.class,AFormat);
            SourceDataLine line=(SourceDataLine)AudioSystem.getLine(info);
            line.open(AFormat);
            line.start();
            line.write(B,0,B.length);
            line.drain();
            line.close();
        }
        catch (Exception e)
        {   System.out.println(e);
        }
    }

    public void store (byte b[], int pos, double value)
    {
        if (value > 0)
        {
            b[pos] = (byte)(127 - (int)Math.floor((int)(value * 128)));
        }
        else
        {
            b[pos] = (byte)(0x00000080 | 127 - (int)Math
                .floor((int)( -value * 128)));
        }
    }

    public void storeInt (byte[] b, int pos, int value)
    {
        b[pos] = (byte)((value & 0xFF000000) >> 24);
        b[pos + 1] = (byte)((value & 0x00FF0000) >> 16);
        b[pos + 2] = (byte)((value & 0x0000FF00) >> 8);
        b[pos + 3] = (byte)(value & 0x000000FF);
    }

}

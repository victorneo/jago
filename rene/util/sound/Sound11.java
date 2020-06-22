package rene.util.sound;

import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound11 implements Sound
{
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
			InputStream in = getClass().getResourceAsStream(file);
			load(in);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	public void load (InputStream in)
	{

	}

	public void start ()
	{
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

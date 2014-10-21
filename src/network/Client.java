package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client
{
	public void startClient()
	{
		Runnable clientTask = new Runnable()
		{

			@Override
			public void run()
			{
				byte[] data_in = new byte[2048];
				OutputStream out;
				InputStream in;

				Socket s;
				try
				{
					s = new Socket("localhost", 6524); //176.189.122.201 //localhost
					out = s.getOutputStream();
					in = s.getInputStream();

					do
					{
						// Send Request
						ComPool.SendFrameNextRPK(out, in);

						try
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} while (data_in[0] != 'q');
					s.close();

				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};
		Thread clientThread = new Thread(clientTask);
		clientThread.start();

	}
}

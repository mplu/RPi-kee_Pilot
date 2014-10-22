package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client
{
	private static String IP_address;
	private static int connection_port;
	private static boolean connect = false;
	private static boolean connected ;

	public static void startClient()
	{
		Runnable clientTask = new Runnable()
		{

			@Override
			public void run()
			{
				OutputStream out;
				InputStream in;

				Socket s;

				while (true)
				{
					if (connect == true)
					{
						try
						{
							s = new Socket(IP_address, connection_port);
																	// 
							out = s.getOutputStream();
							in = s.getInputStream();
							
							connected = true;

							do
							{
								// Send Request
								ComPool.SendFrameNextRPK(out, in);

								Thread.sleep(100);

							} while (connect == true);
							connected = false;
							
							s.close();

						} catch (IOException e1)
						{
							// catch d'un erreur réseau
							e1.printStackTrace();
							connect = false;
							connected = false;
						} catch (InterruptedException e)
						{
							// catch du Thread.sleep
							e.printStackTrace();
						}
					} else
					{
						try
						{
							Thread.sleep(100);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
					}

				}

			}
		};
		Thread clientThread = new Thread(clientTask);
		clientThread.start();

	}

	public static String getIP_address()
	{
		return IP_address;
	}

	public static void setIP_address(String iP_address)
	{
		IP_address = iP_address;
	}

	public  static int getConnection_port()
	{
		return connection_port;
	}

	public static void setConnection_port(int connection_port)
	{
		Client.connection_port = connection_port;
	}

	
	public static boolean isConnected()
	{
		return connected;
	}

	public static void setConnect(boolean connect)
	{
		Client.connect = connect;
	}
	
	
}

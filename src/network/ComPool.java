package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;

import protocol.RPK;

public class ComPool
{
	static class QueueElement
	{
		private byte[] data;
		private short length;

		public QueueElement(byte[] data, short length)
		{

			this.data = data;
			this.length = length;

		}

		public byte[] getData()
		{
			return data;
		}

		public short getLength()
		{
			return length;
		}

	}

	static class QueueElementOut extends QueueElement
	{
		static private int outframeID;

		public QueueElementOut(byte[] data, short length)
		{
			super(data, length);
			outframeID++;
		}

		public int getOutframeID()
		{
			return outframeID;
		}		

	}

	static class QueueElementIn extends QueueElement
	{
		private int inframeID;

		public QueueElementIn(byte[] data, short length, int frameid)
		{
			super(data, length);
			setInframeID(frameid);
		}

		public int getInframeID()
		{
			return inframeID;
		}

		public void setInframeID(int inframeID)
		{
			this.inframeID = inframeID;
		}

	}

	static LinkedList<QueueElementIn> inQueue = new LinkedList<QueueElementIn>();
	static LinkedList<QueueElementOut> outQueue = new LinkedList<QueueElementOut>();

	public static int PostFrameRequest(RPK frame)
	{
		outQueue.add(new QueueElementOut(frame.toBytes(), frame.getLength()));
		return QueueElementOut.outframeID;
	}

	public static boolean SendFrameNextRPK(OutputStream out,InputStream in) throws IOException
	{
		boolean something_sent;
		int size = 0;
		int fID;
		byte[] data_in = new byte[RPK.RPK_MAX_DATA];
		if (outQueue.size() > 0)
		{
			out.write(outQueue.element().getData(), 0, (int) outQueue.element().getLength());
			fID = outQueue.element().getOutframeID();
			outQueue.remove();
			something_sent = true;
			
			
			size = in.read(data_in);
			inQueue.add(new QueueElementIn(data_in, (short) size,fID));
		}else
		{
			something_sent = false;
		}
		return something_sent;
	}

	public static RPK GetFrameAnswer(int fID)
	{
		RPK frame = new RPK();
		if (inQueue.size() > 0)
		{
			if (inQueue.element().getInframeID() == fID)
			{
				frame.Frame_Manage(inQueue.element().getData());
				inQueue.remove();
			}
		}
		return frame;
	}

}

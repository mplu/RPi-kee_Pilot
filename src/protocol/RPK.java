package protocol;

import network.ComPool;
import misc.CRC;



public class RPK
{

	public final static short RPK_MAX_DATA = 100;
	public final static short RPK_RASPBERRY_PI_HANDLE = 115;
	public final static short RPK_VERSION = 1;
	public final static short HEADER_SIZE = 16;
	public final static short HEADER_SIZE_wo_CKSM = 14;
	
	public final static short RPK_C_READ = 1;
	public final static short RPK_C_WRITE = 2;
	public final static short RPK_C_DUMMY = 3;

	public final static short RPK_SC_REQUEST = 1;
	public final static short RPK_SC_REPLY = 2;
	public final static short RPK_SC_ERROR = 0xFF;

	private short handle;
	private short version;
	private short length;
	private short command;
	private short subcommand;
	private short option1;
	private short option2;

	private byte data[] = new byte[RPK_MAX_DATA];
	private short checksum;
	
	

	public RPK(short command, short subcommand, short option1, short option2, byte[] data,short datalength)
	{
		handle = RPK_RASPBERRY_PI_HANDLE;
		version = RPK_VERSION;
		this.command = command;
		this.subcommand = subcommand;
		this.option1 = option1;
		this.option2 = option2;
		this.data = data;
		this.length = (short) (datalength + HEADER_SIZE) ;
	}
	
	public RPK()
	{
		  handle = RPK_RASPBERRY_PI_HANDLE;
		  version = RPK_VERSION;
	}

	public RPK Read(int paramID, int length)
	{
		this.length = HEADER_SIZE;
		command = RPK_C_READ;
		subcommand = RPK_SC_REQUEST;
		option1 = (short)paramID;
		option2 = (short)length;
		
		int fID = ComPool.PostFrameRequest(this);
		
		return ComPool.GetFrameAnswer(fID);
		
	}
	
	public void Dummy()
	{
		this.length = HEADER_SIZE;
		command = RPK_C_DUMMY;
		subcommand = RPK_SC_REQUEST;
		option1 = 0;
		option2 = 0;
		
	}
	
	public RPK Write(int paramID, int length,byte[] data)
	{
		this.length = (short) (HEADER_SIZE + length);
		command = RPK_C_WRITE;
		subcommand = RPK_SC_REQUEST;
		option1 = (short)paramID;
		option2 = (short)length;
		this.data = data;
		
		int fID = ComPool.PostFrameRequest(this);
		
		return ComPool.GetFrameAnswer(fID);
		
	}
	
	public boolean Frame_Manage(byte[] data_in)
	{
		boolean error = false;
		int i;
		
		handle = 	(short) (data_in[1]<<8 | data_in[0]) ;
		version = 	(short) (data_in[3]<<8 | data_in[2]) ;
		length = 	(short) (data_in[5]<<8 | data_in[4]) ;
		command = 	(short) (data_in[7]<<8 | data_in[6]) ;
		subcommand =(short) (data_in[9]<<8 | data_in[8]) ;
		option1 = 	(short) (data_in[11]<<8 | data_in[10]) ;
		option2 = 	(short) (data_in[13]<<8 | data_in[12]) ;
	
		
	    //data
		for(i=0;i<length-HEADER_SIZE;i++)
		{
			this.data[i] = data_in[HEADER_SIZE_wo_CKSM+i];
		}
		
		checksum = (short) (data_in[length-1]<<8 | data_in[length-2]) ;
		
		return error;
	}
	
	public short getLength()
	{
		return length;
	}

	private void SetCRC16()
	{
		short i;
		byte data[] = new byte[length-2];
	    // header
		data[0] = (byte) (0xFF & handle);
		data[1] = (byte) ((0xFF00 & handle)>>8);
		data[2] = (byte) (0xFF & version);
		data[3] = (byte) ((0xFF00 & version)>>8);
		data[4] = (byte) (0xFF & length) ;
		data[5] = (byte) ((0xFF00 & length)>>8) ;
		data[6] = (byte) (0xFF & command);
		data[7] = (byte) ((0xFF00 & command)>>8);
		data[8] = (byte) (0xFF & subcommand);
		data[9] = (byte) ((0xFF00 & subcommand)>>8);
		data[10] = (byte) (0xFF & option1);
		data[11] = (byte) ((0xFF00 & option1)>>8);
		data[12] = (byte) (0xFF & option2);
		data[13] = (byte) ((0xFF00 & option2)>>8);

	    //data
		for(i=0;i<length-HEADER_SIZE;i++)
		{
			data[HEADER_SIZE_wo_CKSM+i]=this.data[i];
		}
		
		//this.checksum =  (short) CRC.CRC16_3(data);
		this.checksum =  CRC.CRC16(data, (short) (length - 2));
		//this.checksum =  CRC.CRC16_2(data, (short) (lenght - 2));
		
	}
	
	public byte[] toBytes()
	{	
		short i;
		byte data[] = new byte[RPK_MAX_DATA+20];
	    // header
		data[0] = (byte) (0xFF & handle);
		data[1] = (byte) ((0xFF00 & handle)>>8);
		data[2] = (byte) (0xFF & version);
		data[3] = (byte) ((0xFF00 & version)>>8);
		data[4] = (byte) (0xFF & length) ;
		data[5] = (byte) ((0xFF00 & length)>>8) ;
		data[6] = (byte) (0xFF & command);
		data[7] = (byte) ((0xFF00 & command)>>8);
		data[8] = (byte) (0xFF & subcommand);
		data[9] = (byte) ((0xFF00 & subcommand)>>8);
		data[10] = (byte) (0xFF & option1);
		data[11] = (byte) ((0xFF00 & option1)>>8);
		data[12] = (byte) (0xFF & option2);
		data[13] = (byte) ((0xFF00 & option2)>>8);

	    //data
		for(i=0;i<length-HEADER_SIZE;i++)
		{
			data[HEADER_SIZE_wo_CKSM+i]=this.data[i];
		}
		
		SetCRC16();
		
		data[length-1] = (byte) (0xFF & checksum);
		data[length-2] = (byte) ((0xFF00 & checksum)>>8);
		
		return data;
	}

	public byte[] getData()
	{
		return data;
	}
	
	
	
}

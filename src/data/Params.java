package data;

public class Params
{
	public class t_MOTOR_COMMAND
	{
		public short Steps;
		public short Delay;
		public int ParamID;
		public int Size;

		public t_MOTOR_COMMAND(int pid)
		{
			ParamID = pid;
			Size = (Short.SIZE * 2) / 8;
		}

		public byte[] toBytes()
		{
			byte data[] = new byte[Size];
			data[0] = (byte) (0xFF & Steps);
			data[1] = (byte) ((0xFF00 & Steps) >> 8);
			data[2] = (byte) (0xFF & Delay);
			data[3] = (byte) ((0xFF00 & Delay) >> 8);
			return data;
		}

		public void SetParam(byte data[])
		{
			Steps = CombineBytes(data[0], data[1]);
			Delay = CombineBytes(data[2], data[3]);
		}

	};

	public class t_GENERAL_INFO
	{
		public byte SoftVersion[] = new byte[32];
		public byte ParamVersion[] = new byte[32];
		public int ParamID;
		public int Size;

		public t_GENERAL_INFO(int pid)
		{
			ParamID = pid;
			Size = (Byte.SIZE * 2 * 32) / 8;
		}

		public byte[] toBytes()
		{
			byte data[] = new byte[Size];
			for (int i = 0; i < Size / 2; i++)
			{
				data[i] = SoftVersion[i];
			}
			for (int i = 0; i < Size / 2; i++)
			{
				data[i + Size / 2] = ParamVersion[i];
			}

			return data;
		}

		public void SetParam(byte data[])
		{
			for (int i = 0; i < Size / 2; i++)
			{
				this.SoftVersion[i] = data[i];
			}
			for (int i = 0; i < Size / 2; i++)
			{
				this.ParamVersion[i] = data[i + Size / 2];
			}
		}

	};

	public class t_ANALOG_VALUES
	{
		public short LongIRDistance;
		public short ShortIRDistance;
		public short VoltageBattery;
		public short Voltage12V;
		public short CPUTemperature;
		public short AuxTemperature;
		public short ImgMoveDirection;
		public int ParamID;
		public int Size;

		public t_ANALOG_VALUES(int pid)
		{
			ParamID = pid;
			Size = (Short.SIZE * 7) / 8;
		}

		public byte[] toBytes()
		{
			byte data[] = new byte[Size];
			data[0] = (byte) (0xFF & LongIRDistance);
			data[1] = (byte) ((0xFF00 & LongIRDistance) >> 8);
			data[2] = (byte) (0xFF & ShortIRDistance);
			data[3] = (byte) ((0xFF00 & ShortIRDistance) >> 8);
			data[4] = (byte) (0xFF & VoltageBattery);
			data[5] = (byte) ((0xFF00 & VoltageBattery) >> 8);
			data[6] = (byte) (0xFF & Voltage12V);
			data[7] = (byte) ((0xFF00 & Voltage12V) >> 8);
			data[8] = (byte) (0xFF & CPUTemperature);
			data[9] = (byte) ((0xFF00 & CPUTemperature) >> 8);
			data[10] = (byte) (0xFF & AuxTemperature);
			data[11] = (byte) ((0xFF00 & AuxTemperature) >> 8);
			data[12] = (byte) (0xFF & ImgMoveDirection);
			data[13] = (byte) ((0xFF00 & ImgMoveDirection) >> 8);
			return data;
		}

		public void SetParam(byte data[])
		{
			LongIRDistance = CombineBytes(data[0], data[1]);
			ShortIRDistance = CombineBytes(data[2], data[3]);
			VoltageBattery = CombineBytes(data[4], data[5]);
			Voltage12V = CombineBytes(data[6], data[7]);
			CPUTemperature = CombineBytes(data[8], data[9]);
			AuxTemperature =CombineBytes(data[10], data[11]);
			ImgMoveDirection = CombineBytes(data[12], data[13]);
		}
	};

	public class t_COMMAND_REG
	{
		public byte Manual;
		public byte LineFollow;
		public byte Survey;
		public byte UDPLiveFeed;
		public byte MovementMotorEnable;
		public byte TurretMotorEnable;
		public short MoveDirection;
		public short MoveDuration;
		public int ParamID;
		public int Size;

		public t_COMMAND_REG(int pid)
		{
			ParamID = pid;
			Size = (Short.SIZE * 2 + Byte.SIZE * 6) / 8;
		}
		public byte[] toBytes()
		{
			byte data[] = new byte[Size];
			data[0] = (byte) (0xFF & Manual);
			data[1] = (byte) (0xFF & LineFollow);
			data[2] = (byte) (0xFF & Survey);
			data[3] = (byte) (0xFF & UDPLiveFeed);
			data[4] = (byte) (0xFF & MovementMotorEnable);
			data[5] = (byte) (0xFF & TurretMotorEnable);
			data[7] = (byte) ((0xFF00 & MoveDirection) >> 8);
			data[6] = (byte) (0xFF & MoveDirection);
			data[9] = (byte) ((0xFF00 & MoveDuration) >> 8);
			data[8] = (byte) (0xFF & MoveDuration);

			return data;
		}

		public void SetParam(byte data[])
		{
			Manual 		= data[0]; 
			LineFollow 	= data[1];
			Survey 		= data[2]; 
			UDPLiveFeed	= data[3];
			MovementMotorEnable = data[4]; 
			TurretMotorEnable	= data[5]; 
			MoveDirection 		= CombineBytes(data[6], data[7]);
			MoveDuration  		= CombineBytes(data[8], data[9]);
		}
	};

	public class t_STATUS_REG
	{
		public byte Manual;
		public byte LineFollow;
		public byte Survey;
		public byte UDPLiveFeed;
		public byte MovementMotorEnable;
		public byte TurretMotorEnable;
		public short MoveDirection;
		public short MoveDuration;
		public int ParamID;
		public int Size;

		public t_STATUS_REG(int pid)
		{
			ParamID = pid;
			Size = (Short.SIZE * 2 + Byte.SIZE * 6) / 8;
		}
		public byte[] toBytes()
		{
			byte data[] = new byte[Size];
			data[0] = (byte) (0xFF & Manual);
			data[1] = (byte) (0xFF & LineFollow);
			data[2] = (byte) (0xFF & Survey);
			data[3] = (byte) (0xFF & UDPLiveFeed);
			data[4] = (byte) (0xFF & MovementMotorEnable);
			data[5] = (byte) (0xFF & TurretMotorEnable);
			data[7] = (byte) ((0xFF00 & MoveDirection) >> 8);
			data[6] = (byte) (0xFF & MoveDirection);
			data[9] = (byte) ((0xFF00 & MoveDuration) >> 8);
			data[8] = (byte) (0xFF & MoveDuration);

			return data;
		}

		public void SetParam(byte data[])
		{
			Manual 		= data[0]; 
			LineFollow 	= data[1];
			Survey 		= data[2]; 
			UDPLiveFeed	= data[3];
			MovementMotorEnable = data[4]; 
			TurretMotorEnable	= data[5]; 
			MoveDirection 		= CombineBytes(data[6], data[7]);
			MoveDuration  		= CombineBytes(data[8], data[9]);
		}

	};

	public class t_GENERIC_PROTECTION
	{
		public short DetectionThreshold;
		public short CompDirection;
		public short TimeWindow;
		public short ConfThreshold;
		public int ParamID;
		public int Size;

		public t_GENERIC_PROTECTION(int pid)
		{
			ParamID = pid;
			Size = (Short.SIZE * 4) / 8;
		}
		public byte[] toBytes()
		{
			byte data[] = new byte[Size];
			data[0] = (byte) (0xFF & DetectionThreshold);
			data[1] = (byte) ((0xFF00 & DetectionThreshold) >> 8);
			data[2] = (byte) (0xFF & CompDirection);
			data[3] = (byte) ((0xFF00 & CompDirection) >> 8);
			data[4] = (byte) (0xFF & TimeWindow);
			data[5] = (byte) ((0xFF00 & TimeWindow) >> 8);
			data[6] = (byte) (0xFF & ConfThreshold);
			data[7] = (byte) ((0xFF00 & ConfThreshold) >> 8);
			return data;
		}

		public void SetParam(byte data[])
		{
			DetectionThreshold = 	CombineBytes(data[0], data[1]);
			CompDirection = 		CombineBytes(data[2], data[3]);
			TimeWindow = 			CombineBytes(data[4], data[5]);
			ConfThreshold = 		CombineBytes(data[6], data[7]);
		}

	};

	public class t_PROTECTION_CONF
	{
		public t_GENERIC_PROTECTION IRDistanceDetect;
		public t_GENERIC_PROTECTION VoltageBatteryDetect;
		public t_GENERIC_PROTECTION Voltage12VDetect;
		public t_GENERIC_PROTECTION CPUTemperatureDetect;
		public t_GENERIC_PROTECTION AuxTemperatureDetect;

		public t_PROTECTION_CONF()
		{
			IRDistanceDetect = new t_GENERIC_PROTECTION(8);
			VoltageBatteryDetect = new t_GENERIC_PROTECTION(9);
			Voltage12VDetect = new t_GENERIC_PROTECTION(10);
			CPUTemperatureDetect = new t_GENERIC_PROTECTION(11);
			AuxTemperatureDetect = new t_GENERIC_PROTECTION(12);
		}
	};

	public class t_FAILURE_REG
	{
		public short global_1;
		public int ParamID;
		public int Size;

		public t_FAILURE_REG(int pid)
		{
			ParamID = pid;
			Size = (Short.SIZE * 2) / 8;

		}
		
		public void SetParam(byte data[])
		{
			global_1 = 	CombineBytes(data[0], data[1]);
		}
	}

	public t_GENERAL_INFO Info;
	public t_ANALOG_VALUES Analog_Values;
	public t_MOTOR_COMMAND LeftMotorCommand;
	public t_MOTOR_COMMAND RightMotorCommand;
	public t_COMMAND_REG CommandReg;
	public t_STATUS_REG StatusReg;
	public t_FAILURE_REG FailureReg;
	public t_PROTECTION_CONF ProtectionConf;

	public Params()
	{

		Info = new t_GENERAL_INFO(1);
		Analog_Values = new t_ANALOG_VALUES(2);
		LeftMotorCommand = new t_MOTOR_COMMAND(3);
		RightMotorCommand = new t_MOTOR_COMMAND(4);
		CommandReg = new t_COMMAND_REG(5);
		StatusReg = new t_STATUS_REG(6);
		FailureReg = new t_FAILURE_REG(7);
		ProtectionConf = new t_PROTECTION_CONF();
	}
	
	short CombineBytes(byte byte1, byte byte2)
	{
		short temp1,temp2,ret;
		temp1 = byte1;
		temp2 = byte2;
		
		temp1 &= 0xFF;
		temp2 &= 0xFF;
		
		temp2 = (short) (temp2 << 8);
		
		ret = (short) (temp1 | temp2);
		return ret;
	}

}

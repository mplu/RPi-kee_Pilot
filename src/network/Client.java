package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import GUI.MainWindow;
import data.Params;
import protocol.RPK;

public class Client
{
	public static void main(String[] args)
	{

		byte[] data_in = new byte[2048];
		byte[] datatosend = new byte[4];
		OutputStream out;
		InputStream in;

		int fID1;
		int fID2;

		datatosend[0] = 31;
		datatosend[1] = 32;
		datatosend[2] = 33;
		datatosend[3] = 34;

		RPK RPK_out = new RPK();
		RPK RPK_in = new RPK();

		Params p = new Params();

		MainWindow fenprinc = new MainWindow();
		fenprinc.setVisible(true);

		try
		{
			Socket s = new Socket("localhost", 6523);
			out = s.getOutputStream();
			in = s.getInputStream();

			do
			{

				RPK_out.Read(p.Analog_Values.ParamID, p.Analog_Values.Size);
				fID1 = ComPool.PostFrameRequest(RPK_out);

				RPK_out.Read(p.LeftMotorCommand.ParamID, p.LeftMotorCommand.Size);
				fID2 = ComPool.PostFrameRequest(RPK_out);

				// Send Request
				ComPool.SendFrameNextRPK(out, in);

				// Send Request
				ComPool.SendFrameNextRPK(out, in);
				// RPK_in.Frame_Manage(data_in);

				RPK_in = ComPool.GetFrameAnswer(fID1);
				p.Analog_Values.SetParam(RPK_in.getData());

				RPK_in = ComPool.GetFrameAnswer(fID2);
				p.LeftMotorCommand.SetParam(RPK_in.getData());

				fenprinc.setLb_LongIRDistance_val(Integer.toString(p.Analog_Values.LongIRDistance));
				fenprinc.setLb_ShortIRDistance_val(Integer.toString(p.Analog_Values.ShortIRDistance));
				fenprinc.setLb_VoltageBattery_val(Integer.toString(p.Analog_Values.VoltageBattery));
				fenprinc.setLb_Voltage12V_val(Integer.toString(p.Analog_Values.Voltage12V));
				fenprinc.setLb_CPUTemperature_val(Integer.toString(p.Analog_Values.CPUTemperature));
				fenprinc.setLb_AuxTemperature_val(Integer.toString(p.Analog_Values.AuxTemperature));
				fenprinc.setLb_ImgMoveDirection_val(Integer.toString(p.Analog_Values.ImgMoveDirection));

				// Modify Param

				// Write Param
				/*
				 * RPK_out.Write( p.ProtectionConf.CPUTemperatureDetect.ParamID,
				 * p.ProtectionConf.CPUTemperatureDetect.Size,
				 * p.ProtectionConf.CPUTemperatureDetect.toBytes());
				 * out.write(RPK_out.toBytes(), 0, (int) RPK_out.getLength());
				 * // Receive Ack in.read(data_in);
				 * RPK_in.Frame_Manage(data_in);
				 */
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
		} catch (IOException e)
		{
			System.out.println("Erreur de connexion au serveur");
		}
	}
}

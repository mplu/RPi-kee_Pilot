package _main;

import java.awt.Color;

import javax.swing.JFrame;

import network.Client;
import protocol.RPK;
import GUI.ControlPanel;
import GUI.JImagePanel;
import data.Params;

public class Startup
{

	public static void main(String[] args)
	{

		RPK RPK_out = new RPK();
		RPK RPK_in = new RPK();

		Params p = new Params();

		Client.setIP_address("localhost");// 176.189.122.201 //localhost
		Client.setConnection_port(6524);
		Client.setConnect(false);
		Client.startClient();

		// TODO Auto-generated method stub
		ControlPanel fenprinc = new ControlPanel();
		fenprinc.setVisible(true);

		JImagePanel imagePanel = new JImagePanel("TOP.jpg");
		// Centrer l'image
		imagePanel.setStretch(false);
		// Etirer l'image
		// imagePanel.setStretch(true);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(imagePanel);
		
		frame.setSize(400, 400);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		
		imagePanel.setImage(null);
		
		frame.validate();

		while (true)
		{
			if (Client.isConnected() == false)
			{
				fenprinc.setLblNetStatus("Disconnected");
			} else
			{
				fenprinc.setLblNetStatus("Connected to " + Client.getIP_address());

				// Info
				RPK_in = RPK_out.Read(p.Info.ParamID, p.Info.Size);
				p.Info.SetParam(RPK_in.getData());
				fenprinc.setTxf_softversion(new String(p.Info.SoftVersion));
				fenprinc.setTxf_paramversion(new String(p.Info.ParamVersion));

				// Analog_Values
				RPK_in = RPK_out.Read(p.Analog_Values.ParamID, p.Analog_Values.Size);
				p.Analog_Values.SetParam(RPK_in.getData());
				fenprinc.setLb_LongIRDistance_val(Integer.toString(p.Analog_Values.LongIRDistance));
				fenprinc.setLb_ShortIRDistance_val(Integer.toString(p.Analog_Values.ShortIRDistance));
				fenprinc.setLb_VoltageBattery_val(Float.toString((float) ((float) p.Analog_Values.VoltageBattery / 1000.0)));
				fenprinc.setLb_Voltage12V_val(Float.toString((float) ((float) p.Analog_Values.Voltage12V / 1000.0)));
				fenprinc.setLb_CPUTemperature_val(Float.toString((float) ((float) p.Analog_Values.CPUTemperature / 100.0)));
				fenprinc.setLb_AuxTemperature_val(Float.toString((float) ((float) p.Analog_Values.AuxTemperature / 100.0)));
				fenprinc.setLb_ImgMoveDirection_val(Integer.toString(p.Analog_Values.ImgMoveDirection));

				// LeftMotorCommand
				RPK_in = RPK_out.Read(p.LeftMotorCommand.ParamID, p.LeftMotorCommand.Size);
				p.LeftMotorCommand.SetParam(RPK_in.getData());
				fenprinc.setLb_LMCDelay_val(Integer.toString(p.LeftMotorCommand.Delay));
				fenprinc.setLb_LMCSteps_val(Integer.toString(p.LeftMotorCommand.Steps));

				// RightMotorCommand
				RPK_in = RPK_out.Read(p.RightMotorCommand.ParamID, p.RightMotorCommand.Size);
				p.RightMotorCommand.SetParam(RPK_in.getData());
				fenprinc.setLb_RMCDelay_val(Integer.toString(p.RightMotorCommand.Delay));
				fenprinc.setLb_RMCSteps_val(Integer.toString(p.RightMotorCommand.Steps));

				// CommandReg
				RPK_in = RPK_out.Read(p.CommandReg.ParamID, p.CommandReg.Size);
				p.CommandReg.SetParam(RPK_in.getData());
				fenprinc.setCManual_val(Integer.toString(p.CommandReg.Manual));
				fenprinc.setCLineFollow_val(Integer.toString(p.CommandReg.LineFollow));
				fenprinc.setCSurvey_val(Integer.toString(p.CommandReg.Survey));
				fenprinc.setCUDPLiveFeed_val(Integer.toString(p.CommandReg.UDPLiveFeed));
				fenprinc.setCMovementMotorEnable_val(Integer.toString(p.CommandReg.MovementMotorEnable));
				fenprinc.setCTurretMotorEnable_val(Integer.toString(p.CommandReg.TurretMotorEnable));
				fenprinc.setCMoveDirection_val(Integer.toString(p.CommandReg.MoveDirection));
				fenprinc.setCMoveDuration_val(Integer.toString(p.CommandReg.MoveDuration));


				// StatusReg
				RPK_in = RPK_out.Read(p.StatusReg.ParamID, p.StatusReg.Size);
				p.StatusReg.SetParam(RPK_in.getData());
				fenprinc.setSManual_val(Integer.toString(p.StatusReg.Manual));
				fenprinc.setSLineFollow_val(Integer.toString(p.StatusReg.LineFollow));
				fenprinc.setSSurvey_val(Integer.toString(p.StatusReg.Survey));
				fenprinc.setSUDPLiveFeed_val(Integer.toString(p.StatusReg.UDPLiveFeed));
				fenprinc.setSMotorPSEnable_val(Integer.toString(p.StatusReg.MovementMotorEnable));
				fenprinc.setSTurretMotorEnable_val(Integer.toString(p.StatusReg.TurretMotorEnable));
				fenprinc.setSMoveDirection_val(Integer.toString(p.StatusReg.MoveDirection));
				fenprinc.setSMoveDuration_val(Integer.toString(p.StatusReg.MoveDuration));
				
				

				// FailureReg
				RPK_in = RPK_out.Read(p.FailureReg.ParamID, p.FailureReg.Size);
				p.FailureReg.SetParam(RPK_in.getData());
				fenprinc.setFRglobal1_val(Integer.toString(p.FailureReg.global_1));

				// Change color
				if (p.StatusReg.Manual == 1)
				{
					fenprinc.setColorbtnManual(new Color(150, 200, 150));

				} else
				{
					fenprinc.setColorbtnManual(new Color(200, 150, 150));
				}

				if (p.StatusReg.LineFollow == 1)
				{
					fenprinc.setColorbtnLiveFollow(new Color(150, 200, 150));
				} else
				{
					fenprinc.setColorbtnLiveFollow(new Color(200, 150, 150));
				}
				
				if (p.StatusReg.Survey == 1)
				{
					fenprinc.setColorbtnSurvey(new Color(150, 200, 150));
				} else
				{
					fenprinc.setColorbtnSurvey(new Color(200, 150, 150));
				}

				if (p.StatusReg.UDPLiveFeed == 1)
				{
					fenprinc.setColorbtnUDPLiveFeed(new Color(150, 200, 150));
				} else
				{
					fenprinc.setColorbtnUDPLiveFeed(new Color(200, 150, 150));
				}

				if (p.StatusReg.MovementMotorEnable == 1)
				{
					fenprinc.setColorbtnMovementMotorEnable(new Color(150, 200, 150));
				} else
				{
					fenprinc.setColorbtnMovementMotorEnable(new Color(200, 150, 150));
				}
				
				if (p.StatusReg.TurretMotorEnable == 1)
				{
					fenprinc.setColorbtnTurretMotorEnable(new Color(150, 200, 150));
				} else
				{
					fenprinc.setColorbtnTurretMotorEnable(new Color(200, 150, 150));
				}

			}

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

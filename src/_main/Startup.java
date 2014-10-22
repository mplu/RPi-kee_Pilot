package _main;

import java.awt.Color;

import network.Client;
import protocol.RPK;
import GUI.ControlPanel;
import data.Params;

public class Startup
{

	public static void main(String[] args)
	{
		

		RPK RPK_out = new RPK();
		RPK RPK_in = new RPK();

		Params p = new Params();
		
		
		Client.setIP_address("localhost");// 176.189.122.201 //localhost
		Client.setConnection_port(6526);
		Client.setConnect(false);
		Client.startClient();
		
		// TODO Auto-generated method stub
		ControlPanel fenprinc = new ControlPanel();
		fenprinc.setVisible(true);

		while (true)
		{
			if(Client.isConnected() == false)
			{
				fenprinc.setLblNetStatus("Disconnected");
			}else
			{
				fenprinc.setLblNetStatus("Connected to "+Client.getIP_address());
				
				//Info
				RPK_in = RPK_out.Read(p.Info.ParamID, p.Info.Size);
				p.Info.SetParam(RPK_in.getData());
				fenprinc.setTxf_softversion(new String(p.Info.SoftVersion));
				fenprinc.setTxf_paramversion(new String(p.Info.ParamVersion));
				
				//Analog_Values
				RPK_in = RPK_out.Read(p.Analog_Values.ParamID, p.Analog_Values.Size);
				p.Analog_Values.SetParam(RPK_in.getData());
				fenprinc.setLb_LongIRDistance_val(Integer.toString(p.Analog_Values.LongIRDistance));
				fenprinc.setLb_ShortIRDistance_val(Integer.toString(p.Analog_Values.ShortIRDistance));
				fenprinc.setLb_VoltageBattery_val(Float.toString((float)((float)p.Analog_Values.VoltageBattery/1000.0)));
				fenprinc.setLb_Voltage12V_val(Float.toString((float)((float)p.Analog_Values.Voltage12V/1000.0)));
				fenprinc.setLb_CPUTemperature_val(Float.toString((float)((float)p.Analog_Values.CPUTemperature/100.0)));
				fenprinc.setLb_AuxTemperature_val(Float.toString((float)((float)p.Analog_Values.AuxTemperature/100.0)));
				fenprinc.setLb_ImgMoveDirection_val(Integer.toString(p.Analog_Values.ImgMoveDirection));
				
				//LeftMotorCommand
				RPK_in = RPK_out.Read(p.LeftMotorCommand.ParamID, p.LeftMotorCommand.Size);
				p.LeftMotorCommand.SetParam(RPK_in.getData());
				fenprinc.setLb_LMCDelay_val(Integer.toString(p.LeftMotorCommand.Delay));
				fenprinc.setLb_LMCSteps_val(Integer.toString(p.LeftMotorCommand.Steps));
				
				//RightMotorCommand
				RPK_in = RPK_out.Read(p.RightMotorCommand.ParamID, p.RightMotorCommand.Size);
				p.RightMotorCommand.SetParam(RPK_in.getData());
				fenprinc.setLb_RMCDelay_val(Integer.toString(p.RightMotorCommand.Delay));
				fenprinc.setLb_RMCSteps_val(Integer.toString(p.RightMotorCommand.Steps));
				
				//CommandReg
				RPK_in = RPK_out.Read(p.CommandReg.ParamID, p.CommandReg.Size);
				p.CommandReg.SetParam(RPK_in.getData());
				fenprinc.setCManual_val(Integer.toString(p.CommandReg.Manual));
				fenprinc.setCAuto_val(Integer.toString(p.CommandReg.Auto));
				fenprinc.setCMoveDirection_val(Integer.toString(p.CommandReg.MoveDirection));
				fenprinc.setCMoveDuration_val(Integer.toString(p.CommandReg.MoveDuration));
				fenprinc.setCUDPLiveFeed_val(Integer.toString(p.CommandReg.UDPLiveFeed));
				fenprinc.setCMotorPSEnable_val(Integer.toString(p.CommandReg.MotorPSEnable));
				
				//StatusReg
				RPK_in = RPK_out.Read(p.StatusReg.ParamID, p.StatusReg.Size);
				p.StatusReg.SetParam(RPK_in.getData());
				fenprinc.setSManual_val(Integer.toString(p.StatusReg.Manual));
				fenprinc.setSAuto_val(Integer.toString(p.StatusReg.Auto));
				fenprinc.setSMoveDirection_val(Integer.toString(p.StatusReg.MoveDirection));
				fenprinc.setSMoveDuration_val(Integer.toString(p.StatusReg.MoveDuration));
				fenprinc.setSUDPLiveFeed_val(Integer.toString(p.StatusReg.UDPLiveFeed));
				fenprinc.setSMotorPSEnable_val(Integer.toString(p.StatusReg.MotorPSEnable));
				
				
				//FailureReg
				RPK_in = RPK_out.Read(p.FailureReg.ParamID, p.FailureReg.Size);
				p.FailureReg.SetParam(RPK_in.getData());
				fenprinc.setFRglobal1_val(Integer.toString(p.FailureReg.global_1));
				
				
				
				
				//  Change color
				if(p.StatusReg.Manual == 1)
				{
					fenprinc.setColorbtnManual(new Color(150,200,150));
					
				}else
				{
					fenprinc.setColorbtnManual(new Color(200,150,150));
				}
				
				if(p.StatusReg.Auto == 1)
				{
					fenprinc.setColorbtnAuto(new Color(150,200,150));
				}else
				{
					fenprinc.setColorbtnAuto(new Color(200,150,150));
				}
				
				if(p.StatusReg.UDPLiveFeed == 1)
				{
					fenprinc.setColorbtnUDPLiveFeed(new Color(150,200,150));
				}else
				{
					fenprinc.setColorbtnUDPLiveFeed(new Color(200,150,150));
				}
				
				if(p.StatusReg.MotorPSEnable == 1)
				{
					fenprinc.setColorbtnMotorPSEnable(new Color(150,200,150));
				}else
				{
					fenprinc.setColorbtnMotorPSEnable(new Color(200,150,150));
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

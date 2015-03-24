package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import protocol.RPK;
import data.Params;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import network.Client;

import java.awt.Font;

public class ControlPanel extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7748535948804673486L;

	private JPanel main_panel;

	// Info
	private JLabel lbl_softversion;
	private JLabel lbl_paramversion;
	private JTextField txf_softversion;
	private JTextField txf_paramversion;

	// Analog_Values
	private JLabel lb_LongIRDistance;
	private JLabel lb_ShortIRDistance;
	private JLabel lb_VoltageBattery;
	private JLabel lb_Voltage12V;
	private JLabel lb_CPUTemperature;
	private JLabel lb_AuxTemperature;
	private JLabel lb_ImgMoveDirection;
	private JLabel lb_LongIRDistance_val;
	private JLabel lb_ShortIRDistance_val;
	private JLabel lb_VoltageBattery_val;
	private JLabel lb_Voltage12V_val;
	private JLabel lb_CPUTemperature_val;
	private JLabel lb_AuxTemperature_val;
	private JLabel lb_ImgMoveDirection_val;

	// Left&RightMotorCommand
	private JLabel lb_LMCSpeed;
	private JLabel lb_LMCUnused;
	private JLabel lb_LMCSpeed_val;
	private JLabel lb_LMCUnused_val;
	private JLabel lb_RMCSpeed_val;
	private JLabel lb_RMCUnused_val;

	// CommandReg
	private JLabel CManual;
	private JLabel CLineFollow;
	private JLabel CSurvey;
	private JLabel CUDPLiveFeed;
	private JLabel CMovementMotorEnable;
	private JLabel CTurretMotorEnable;
	private JLabel CMoveDirection;
	private JLabel CMoveDuration;
	private JLabel CManual_val;
	private JLabel CLineFollow_val;
	private JLabel CSurvey_val;
	private JLabel CUDPLiveFeed_val;
	private JLabel CMovementMotorEnable_val;
	private JLabel CTurretMotorEnable_val;
	private JLabel CMoveDirection_val;
	private JLabel CMoveDuration_val;


	// StatusReg
	private JLabel SManual;
	private JLabel SLineFollow;
	private JLabel SSurvey;
	private JLabel SUDPLiveFeed;
	private JLabel SMovementMotorEnable;
	private JLabel STurretMotorEnable;
	private JLabel SMoveDirection;
	private JLabel SMoveDuration;
	private JLabel SManual_val;
	private JLabel SLineFollow_val;
	private JLabel SSurvey_val;
	private JLabel SUDPLiveFeed_val;
	private JLabel SMovementMotorEnable_val;
	private JLabel STurretMotorEnable_val;
	private JLabel SMoveDirection_val;
	private JLabel SMoveDuration_val;

	// FailureReg
	private JLabel FRglobal1;
	private JLabel FRglobal1_val;

	// Bouton
	private JButton btnManual;
	private JButton btnLineFollow;
	private JButton btnUDPLiveFeed;
	private JButton btnMovementMotorEnable;

	private JPanel panel_Info;
	private JPanel panel_Analog_Values;
	private JPanel panel_MotorCommanddata;
	private JPanel panel_CommandReg;
	private JPanel panel_StatusReg;
	private JPanel panel_FailureReg;
	private JLabel lblRightMotor;
	private JLabel lblLeftMotor;
	private JLabel lblCommand;
	private JLabel lblStatus;
	private JLabel lblCm;
	private JLabel lblCm_1;
	private JLabel lblV;
	private JLabel lblV_1;
	private JLabel lblc;
	private JLabel lblc_1;
	private JLabel label;
	private JPanel panel_button;
	private JLabel lblMotorCommand;
	private JPanel panel_MotorCommand;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnTools;
	private JMenu mnAbout;
	private JMenuItem mntmAbout;
	private JMenuItem mntmManualCommand;
	private JMenuItem mntmQuit;
	private JMenuItem mntmConnectionSetting;
	private JMenuItem mntmConnect;
	private JMenuItem mntmDisconnect;
	private JSeparator mntmSep1;
	private JSeparator mntmSep2;
	private JLabel lblNetStatus;
	private JButton btnTurretMotorEnable;
	private JButton btnSurvey;
	private JPanel panel;

	public ControlPanel()
	{
		setTitle("R-Pikee Pilot");
		setSize(572, 507);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main_panel = new JPanel();

		panel_Info = new JPanel();
		panel_Info.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		main_panel.add(panel_Info);
		GridBagLayout gbl_panel_Info = new GridBagLayout();
		gbl_panel_Info.columnWidths = new int[] { 58, 86, 0 };
		gbl_panel_Info.rowHeights = new int[] { 0, 20, 0 };
		gbl_panel_Info.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Info.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_Info.setLayout(gbl_panel_Info);

		// Info
		lbl_softversion = new JLabel("Version Soft");
		GridBagConstraints gbc_lbl_softversion = new GridBagConstraints();
		gbc_lbl_softversion.anchor = GridBagConstraints.WEST;
		gbc_lbl_softversion.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_softversion.gridx = 0;
		gbc_lbl_softversion.gridy = 0;
		panel_Info.add(lbl_softversion, gbc_lbl_softversion);
		txf_softversion = new JTextField("_", 10);
		GridBagConstraints gbc_txf_softversion = new GridBagConstraints();
		gbc_txf_softversion.anchor = GridBagConstraints.NORTHWEST;
		gbc_txf_softversion.insets = new Insets(0, 0, 5, 0);
		gbc_txf_softversion.gridx = 1;
		gbc_txf_softversion.gridy = 0;
		panel_Info.add(txf_softversion, gbc_txf_softversion);

		lbl_paramversion = new JLabel("Version Param");
		GridBagConstraints gbc_lbl_paramversion = new GridBagConstraints();
		gbc_lbl_paramversion.anchor = GridBagConstraints.WEST;
		gbc_lbl_paramversion.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_paramversion.gridx = 0;
		gbc_lbl_paramversion.gridy = 1;
		panel_Info.add(lbl_paramversion, gbc_lbl_paramversion);
		txf_paramversion = new JTextField("_", 10);
		GridBagConstraints gbc_txf_paramversion = new GridBagConstraints();
		gbc_txf_paramversion.anchor = GridBagConstraints.NORTHWEST;
		gbc_txf_paramversion.gridx = 1;
		gbc_txf_paramversion.gridy = 1;
		panel_Info.add(txf_paramversion, gbc_txf_paramversion);

		panel_Analog_Values = new JPanel();
		panel_Analog_Values.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		main_panel.add(panel_Analog_Values);
		GridBagLayout gbl_panel_Analog_Values = new GridBagLayout();
		gbl_panel_Analog_Values.columnWidths = new int[] { 75, 45, 0, 0 };
		gbl_panel_Analog_Values.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 14, 0 };
		gbl_panel_Analog_Values.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Analog_Values.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_Analog_Values.setLayout(gbl_panel_Analog_Values);

		// Analog_Values
		lb_LongIRDistance = new JLabel("LongIRDistance");
		GridBagConstraints gbc_lb_LongIRDistance = new GridBagConstraints();
		gbc_lb_LongIRDistance.anchor = GridBagConstraints.NORTHWEST;
		gbc_lb_LongIRDistance.insets = new Insets(0, 0, 5, 5);
		gbc_lb_LongIRDistance.gridx = 0;
		gbc_lb_LongIRDistance.gridy = 0;
		panel_Analog_Values.add(lb_LongIRDistance, gbc_lb_LongIRDistance);
		lb_LongIRDistance_val = new JLabel("0");
		GridBagConstraints gbc_lb_LongIRDistance_val = new GridBagConstraints();
		gbc_lb_LongIRDistance_val.anchor = GridBagConstraints.NORTHEAST;
		gbc_lb_LongIRDistance_val.insets = new Insets(0, 0, 5, 5);
		gbc_lb_LongIRDistance_val.gridx = 1;
		gbc_lb_LongIRDistance_val.gridy = 0;
		panel_Analog_Values.add(lb_LongIRDistance_val, gbc_lb_LongIRDistance_val);

		lblCm = new JLabel("cm");
		GridBagConstraints gbc_lblCm = new GridBagConstraints();
		gbc_lblCm.insets = new Insets(0, 0, 5, 0);
		gbc_lblCm.gridx = 2;
		gbc_lblCm.gridy = 0;
		panel_Analog_Values.add(lblCm, gbc_lblCm);

		lb_ShortIRDistance = new JLabel("ShortIRDistance");
		GridBagConstraints gbc_lb_ShortIRDistance = new GridBagConstraints();
		gbc_lb_ShortIRDistance.anchor = GridBagConstraints.NORTHWEST;
		gbc_lb_ShortIRDistance.insets = new Insets(0, 0, 5, 5);
		gbc_lb_ShortIRDistance.gridx = 0;
		gbc_lb_ShortIRDistance.gridy = 1;
		panel_Analog_Values.add(lb_ShortIRDistance, gbc_lb_ShortIRDistance);
		lb_ShortIRDistance_val = new JLabel("0");
		GridBagConstraints gbc_lb_ShortIRDistance_val = new GridBagConstraints();
		gbc_lb_ShortIRDistance_val.anchor = GridBagConstraints.NORTHEAST;
		gbc_lb_ShortIRDistance_val.insets = new Insets(0, 0, 5, 5);
		gbc_lb_ShortIRDistance_val.gridx = 1;
		gbc_lb_ShortIRDistance_val.gridy = 1;
		panel_Analog_Values.add(lb_ShortIRDistance_val, gbc_lb_ShortIRDistance_val);

		lblCm_1 = new JLabel("cm");
		GridBagConstraints gbc_lblCm_1 = new GridBagConstraints();
		gbc_lblCm_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblCm_1.gridx = 2;
		gbc_lblCm_1.gridy = 1;
		panel_Analog_Values.add(lblCm_1, gbc_lblCm_1);

		lb_VoltageBattery = new JLabel("VoltageBattery");
		GridBagConstraints gbc_lb_VoltageBattery = new GridBagConstraints();
		gbc_lb_VoltageBattery.anchor = GridBagConstraints.NORTHWEST;
		gbc_lb_VoltageBattery.insets = new Insets(0, 0, 5, 5);
		gbc_lb_VoltageBattery.gridx = 0;
		gbc_lb_VoltageBattery.gridy = 2;
		panel_Analog_Values.add(lb_VoltageBattery, gbc_lb_VoltageBattery);
		lb_VoltageBattery_val = new JLabel("0");
		GridBagConstraints gbc_lb_VoltageBattery_val = new GridBagConstraints();
		gbc_lb_VoltageBattery_val.anchor = GridBagConstraints.NORTHEAST;
		gbc_lb_VoltageBattery_val.insets = new Insets(0, 0, 5, 5);
		gbc_lb_VoltageBattery_val.gridx = 1;
		gbc_lb_VoltageBattery_val.gridy = 2;
		panel_Analog_Values.add(lb_VoltageBattery_val, gbc_lb_VoltageBattery_val);

		lblV = new JLabel("V");
		GridBagConstraints gbc_lblV = new GridBagConstraints();
		gbc_lblV.insets = new Insets(0, 0, 5, 0);
		gbc_lblV.gridx = 2;
		gbc_lblV.gridy = 2;
		panel_Analog_Values.add(lblV, gbc_lblV);

		lb_Voltage12V = new JLabel("Voltage12V");
		GridBagConstraints gbc_lb_Voltage12V = new GridBagConstraints();
		gbc_lb_Voltage12V.anchor = GridBagConstraints.NORTHWEST;
		gbc_lb_Voltage12V.insets = new Insets(0, 0, 5, 5);
		gbc_lb_Voltage12V.gridx = 0;
		gbc_lb_Voltage12V.gridy = 3;
		panel_Analog_Values.add(lb_Voltage12V, gbc_lb_Voltage12V);
		lb_Voltage12V_val = new JLabel("0");
		GridBagConstraints gbc_lb_Voltage12V_val = new GridBagConstraints();
		gbc_lb_Voltage12V_val.anchor = GridBagConstraints.NORTHEAST;
		gbc_lb_Voltage12V_val.insets = new Insets(0, 0, 5, 5);
		gbc_lb_Voltage12V_val.gridx = 1;
		gbc_lb_Voltage12V_val.gridy = 3;
		panel_Analog_Values.add(lb_Voltage12V_val, gbc_lb_Voltage12V_val);

		lblV_1 = new JLabel("V");
		GridBagConstraints gbc_lblV_1 = new GridBagConstraints();
		gbc_lblV_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblV_1.gridx = 2;
		gbc_lblV_1.gridy = 3;
		panel_Analog_Values.add(lblV_1, gbc_lblV_1);

		lb_CPUTemperature = new JLabel("CPUTemperature");
		GridBagConstraints gbc_lb_CPUTemperature = new GridBagConstraints();
		gbc_lb_CPUTemperature.anchor = GridBagConstraints.NORTHWEST;
		gbc_lb_CPUTemperature.insets = new Insets(0, 0, 5, 5);
		gbc_lb_CPUTemperature.gridx = 0;
		gbc_lb_CPUTemperature.gridy = 4;
		panel_Analog_Values.add(lb_CPUTemperature, gbc_lb_CPUTemperature);
		lb_CPUTemperature_val = new JLabel("0");
		GridBagConstraints gbc_lb_CPUTemperature_val = new GridBagConstraints();
		gbc_lb_CPUTemperature_val.anchor = GridBagConstraints.NORTHEAST;
		gbc_lb_CPUTemperature_val.insets = new Insets(0, 0, 5, 5);
		gbc_lb_CPUTemperature_val.gridx = 1;
		gbc_lb_CPUTemperature_val.gridy = 4;
		panel_Analog_Values.add(lb_CPUTemperature_val, gbc_lb_CPUTemperature_val);

		lblc = new JLabel("°C");
		GridBagConstraints gbc_lblc = new GridBagConstraints();
		gbc_lblc.insets = new Insets(0, 0, 5, 0);
		gbc_lblc.gridx = 2;
		gbc_lblc.gridy = 4;
		panel_Analog_Values.add(lblc, gbc_lblc);

		lb_AuxTemperature = new JLabel("AuxTemperature");
		GridBagConstraints gbc_lb_AuxTemperature = new GridBagConstraints();
		gbc_lb_AuxTemperature.anchor = GridBagConstraints.NORTHWEST;
		gbc_lb_AuxTemperature.insets = new Insets(0, 0, 5, 5);
		gbc_lb_AuxTemperature.gridx = 0;
		gbc_lb_AuxTemperature.gridy = 5;
		panel_Analog_Values.add(lb_AuxTemperature, gbc_lb_AuxTemperature);
		lb_AuxTemperature_val = new JLabel("0");
		GridBagConstraints gbc_lb_AuxTemperature_val = new GridBagConstraints();
		gbc_lb_AuxTemperature_val.anchor = GridBagConstraints.NORTHEAST;
		gbc_lb_AuxTemperature_val.insets = new Insets(0, 0, 5, 5);
		gbc_lb_AuxTemperature_val.gridx = 1;
		gbc_lb_AuxTemperature_val.gridy = 5;
		panel_Analog_Values.add(lb_AuxTemperature_val, gbc_lb_AuxTemperature_val);

		lblc_1 = new JLabel("°C");
		GridBagConstraints gbc_lblc_1 = new GridBagConstraints();
		gbc_lblc_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblc_1.gridx = 2;
		gbc_lblc_1.gridy = 5;
		panel_Analog_Values.add(lblc_1, gbc_lblc_1);

		lb_ImgMoveDirection = new JLabel("ImgMoveDirection");
		GridBagConstraints gbc_lb_ImgMoveDirection = new GridBagConstraints();
		gbc_lb_ImgMoveDirection.anchor = GridBagConstraints.NORTHWEST;
		gbc_lb_ImgMoveDirection.insets = new Insets(0, 0, 0, 5);
		gbc_lb_ImgMoveDirection.gridx = 0;
		gbc_lb_ImgMoveDirection.gridy = 6;
		panel_Analog_Values.add(lb_ImgMoveDirection, gbc_lb_ImgMoveDirection);
		lb_ImgMoveDirection_val = new JLabel("0");
		GridBagConstraints gbc_lb_ImgMoveDirection_val = new GridBagConstraints();
		gbc_lb_ImgMoveDirection_val.insets = new Insets(0, 0, 0, 5);
		gbc_lb_ImgMoveDirection_val.anchor = GridBagConstraints.NORTHEAST;
		gbc_lb_ImgMoveDirection_val.gridx = 1;
		gbc_lb_ImgMoveDirection_val.gridy = 6;
		panel_Analog_Values.add(lb_ImgMoveDirection_val, gbc_lb_ImgMoveDirection_val);

		label = new JLabel("°");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridx = 2;
		gbc_label.gridy = 6;
		panel_Analog_Values.add(label, gbc_label);

		panel_MotorCommand = new JPanel();
		panel_MotorCommand.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		main_panel.add(panel_MotorCommand);
		GridBagLayout gbl_panel_MotorCommand = new GridBagLayout();
		gbl_panel_MotorCommand.columnWidths = new int[] { 94, 0 };
		gbl_panel_MotorCommand.rowHeights = new int[] { 16, 0, 0 };
		gbl_panel_MotorCommand.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_MotorCommand.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_MotorCommand.setLayout(gbl_panel_MotorCommand);

		lblMotorCommand = new JLabel("Motor Command");
		GridBagConstraints gbc_lblMotorCommand = new GridBagConstraints();
		gbc_lblMotorCommand.insets = new Insets(0, 0, 5, 0);
		gbc_lblMotorCommand.gridx = 0;
		gbc_lblMotorCommand.gridy = 0;
		panel_MotorCommand.add(lblMotorCommand, gbc_lblMotorCommand);

		panel_MotorCommanddata = new JPanel();
		GridBagConstraints gbc_panel_MotorCommanddata = new GridBagConstraints();
		gbc_panel_MotorCommanddata.gridx = 0;
		gbc_panel_MotorCommanddata.gridy = 1;
		panel_MotorCommand.add(panel_MotorCommanddata, gbc_panel_MotorCommanddata);
		GridBagLayout gbl_panel_MotorCommanddata = new GridBagLayout();
		gbl_panel_MotorCommanddata.columnWidths = new int[] { 46, 45, 45, 0 };
		gbl_panel_MotorCommanddata.rowHeights = new int[] { 0, 0, 14, 0 };
		gbl_panel_MotorCommanddata.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_MotorCommanddata.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_MotorCommanddata.setLayout(gbl_panel_MotorCommanddata);

		lblLeftMotor = new JLabel("Left");
		GridBagConstraints gbc_lblLeftMotor = new GridBagConstraints();
		gbc_lblLeftMotor.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeftMotor.gridx = 1;
		gbc_lblLeftMotor.gridy = 0;
		panel_MotorCommanddata.add(lblLeftMotor, gbc_lblLeftMotor);

		lblRightMotor = new JLabel("Right");
		GridBagConstraints gbc_lblRightMotor = new GridBagConstraints();
		gbc_lblRightMotor.insets = new Insets(0, 0, 5, 0);
		gbc_lblRightMotor.gridx = 2;
		gbc_lblRightMotor.gridy = 0;
		panel_MotorCommanddata.add(lblRightMotor, gbc_lblRightMotor);

		// LeftMotorCommand
		lb_LMCSpeed = new JLabel("Speed");
		GridBagConstraints gbc_lb_LMCSpeed = new GridBagConstraints();
		gbc_lb_LMCSpeed.anchor = GridBagConstraints.NORTHEAST;
		gbc_lb_LMCSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_lb_LMCSpeed.gridx = 0;
		gbc_lb_LMCSpeed.gridy = 1;
		panel_MotorCommanddata.add(lb_LMCSpeed, gbc_lb_LMCSpeed);
		lb_LMCSpeed_val = new JLabel("0");
		GridBagConstraints gbc_lb_LMCSpeed_val = new GridBagConstraints();
		gbc_lb_LMCSpeed_val.anchor = GridBagConstraints.NORTH;
		gbc_lb_LMCSpeed_val.insets = new Insets(0, 0, 5, 5);
		gbc_lb_LMCSpeed_val.gridx = 1;
		gbc_lb_LMCSpeed_val.gridy = 1;
		panel_MotorCommanddata.add(lb_LMCSpeed_val, gbc_lb_LMCSpeed_val);
		lb_RMCSpeed_val = new JLabel("0");
		GridBagConstraints gbc_lb_RMCSpeed_val = new GridBagConstraints();
		gbc_lb_RMCSpeed_val.insets = new Insets(0, 0, 5, 0);
		gbc_lb_RMCSpeed_val.gridx = 2;
		gbc_lb_RMCSpeed_val.gridy = 1;
		panel_MotorCommanddata.add(lb_RMCSpeed_val, gbc_lb_RMCSpeed_val);

		lb_LMCUnused = new JLabel("Unused");
		GridBagConstraints gbc_lb_LMCUnused = new GridBagConstraints();
		gbc_lb_LMCUnused.anchor = GridBagConstraints.NORTHEAST;
		gbc_lb_LMCUnused.insets = new Insets(0, 0, 0, 5);
		gbc_lb_LMCUnused.gridx = 0;
		gbc_lb_LMCUnused.gridy = 2;
		panel_MotorCommanddata.add(lb_LMCUnused, gbc_lb_LMCUnused);
		lb_LMCUnused_val = new JLabel("0");
		GridBagConstraints gbc_lb_LMCUnused_val = new GridBagConstraints();
		gbc_lb_LMCUnused_val.insets = new Insets(0, 0, 0, 5);
		gbc_lb_LMCUnused_val.anchor = GridBagConstraints.NORTH;
		gbc_lb_LMCUnused_val.gridx = 1;
		gbc_lb_LMCUnused_val.gridy = 2;
		panel_MotorCommanddata.add(lb_LMCUnused_val, gbc_lb_LMCUnused_val);
		lb_RMCUnused_val = new JLabel("0");
		GridBagConstraints gbc_lb_RMCUnused_val = new GridBagConstraints();
		gbc_lb_RMCUnused_val.gridx = 2;
		gbc_lb_RMCUnused_val.gridy = 2;
		panel_MotorCommanddata.add(lb_RMCUnused_val, gbc_lb_RMCUnused_val);

		panel_CommandReg = new JPanel();
		panel_CommandReg.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		main_panel.add(panel_CommandReg);
		GridBagLayout gbl_panel_CommandReg = new GridBagLayout();
		gbl_panel_CommandReg.columnWidths = new int[] { 34, 40, 0 };
		gbl_panel_CommandReg.rowHeights = new int[] { 0, 14, 0, 0, 0, 0, 0, 0 };
		gbl_panel_CommandReg.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_CommandReg.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_CommandReg.setLayout(gbl_panel_CommandReg);

		lblCommand = new JLabel("Command");
		GridBagConstraints gbc_lblCommand = new GridBagConstraints();
		gbc_lblCommand.anchor = GridBagConstraints.EAST;
		gbc_lblCommand.insets = new Insets(0, 0, 5, 5);
		gbc_lblCommand.gridx = 0;
		gbc_lblCommand.gridy = 0;
		panel_CommandReg.add(lblCommand, gbc_lblCommand);

		// CommandReg
		CManual = new JLabel("Manual");
		GridBagConstraints gbc_CManual = new GridBagConstraints();
		gbc_CManual.anchor = GridBagConstraints.NORTHWEST;
		gbc_CManual.insets = new Insets(0, 0, 5, 5);
		gbc_CManual.gridx = 0;
		gbc_CManual.gridy = 1;
		panel_CommandReg.add(CManual, gbc_CManual);
		CManual_val = new JLabel("0");
		GridBagConstraints gbc_CManual_val = new GridBagConstraints();
		gbc_CManual_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_CManual_val.insets = new Insets(0, 0, 5, 0);
		gbc_CManual_val.gridx = 1;
		gbc_CManual_val.gridy = 1;
		panel_CommandReg.add(CManual_val, gbc_CManual_val);

		CLineFollow = new JLabel("LineFollow");
		GridBagConstraints gbc_CAuto = new GridBagConstraints();
		gbc_CAuto.anchor = GridBagConstraints.NORTHWEST;
		gbc_CAuto.insets = new Insets(0, 0, 5, 5);
		gbc_CAuto.gridx = 0;
		gbc_CAuto.gridy = 2;
		panel_CommandReg.add(CLineFollow, gbc_CAuto);
		CLineFollow_val = new JLabel("0");
		GridBagConstraints gbc_CAuto_val = new GridBagConstraints();
		gbc_CAuto_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_CAuto_val.insets = new Insets(0, 0, 5, 0);
		gbc_CAuto_val.gridx = 1;
		gbc_CAuto_val.gridy = 2;
		panel_CommandReg.add(CLineFollow_val, gbc_CAuto_val);
	
		CSurvey = new JLabel("Survey");
		GridBagConstraints gbc_CSurvey = new GridBagConstraints();
		gbc_CSurvey.anchor = GridBagConstraints.NORTHWEST;
		gbc_CSurvey.insets = new Insets(0, 0, 5, 5);
		gbc_CSurvey.gridx = 0;
		gbc_CSurvey.gridy = 3;
		panel_CommandReg.add(CSurvey, gbc_CSurvey);
		CSurvey_val = new JLabel("0");
		GridBagConstraints gbc_CSurvey_val = new GridBagConstraints();
		gbc_CSurvey_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_CSurvey_val.insets = new Insets(0, 0, 5, 0);
		gbc_CSurvey_val.gridx = 1;
		gbc_CSurvey_val.gridy = 3;
		panel_CommandReg.add(CSurvey_val, gbc_CSurvey_val);
		
		CUDPLiveFeed = new JLabel("UDPLiveFeed");
		GridBagConstraints gbc_CUDPLiveFeed = new GridBagConstraints();
		gbc_CUDPLiveFeed.anchor = GridBagConstraints.NORTHWEST;
		gbc_CUDPLiveFeed.insets = new Insets(0, 0, 5, 5);
		gbc_CUDPLiveFeed.gridx = 0;
		gbc_CUDPLiveFeed.gridy = 4;
		panel_CommandReg.add(CUDPLiveFeed, gbc_CUDPLiveFeed);
		CUDPLiveFeed_val = new JLabel("0");
		GridBagConstraints gbc_CUDPLiveFeed_val = new GridBagConstraints();
		gbc_CUDPLiveFeed_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_CUDPLiveFeed_val.insets = new Insets(0, 0, 5, 0);
		gbc_CUDPLiveFeed_val.gridx = 1;
		gbc_CUDPLiveFeed_val.gridy = 4;
		panel_CommandReg.add(CUDPLiveFeed_val, gbc_CUDPLiveFeed_val);

		CMovementMotorEnable = new JLabel("MovementMotorEnable");
		GridBagConstraints gbc_CMovementMotorEnable = new GridBagConstraints();
		gbc_CMovementMotorEnable.anchor = GridBagConstraints.NORTHWEST;
		gbc_CMovementMotorEnable.insets = new Insets(0, 0, 5, 5);
		gbc_CMovementMotorEnable.gridx = 0;
		gbc_CMovementMotorEnable.gridy = 5;
		panel_CommandReg.add(CMovementMotorEnable, gbc_CMovementMotorEnable);
		CMovementMotorEnable_val = new JLabel("0");
		GridBagConstraints gbc_CMovementMotorEnable_val = new GridBagConstraints();
		gbc_CMovementMotorEnable_val.insets = new Insets(0, 0, 5, 0);
		gbc_CMovementMotorEnable_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_CMovementMotorEnable_val.gridx = 1;
		gbc_CMovementMotorEnable_val.gridy = 5;
		panel_CommandReg.add(CMovementMotorEnable_val, gbc_CMovementMotorEnable_val);
		
		CTurretMotorEnable = new JLabel("TurretMotorEnable");
		GridBagConstraints gbc_CTurretMotorEnable = new GridBagConstraints();
		gbc_CTurretMotorEnable.anchor = GridBagConstraints.NORTHWEST;
		gbc_CTurretMotorEnable.insets = new Insets(0, 0, 5, 5);
		gbc_CTurretMotorEnable.gridx = 0;
		gbc_CTurretMotorEnable.gridy = 6;
		panel_CommandReg.add(CTurretMotorEnable, gbc_CTurretMotorEnable);
		CTurretMotorEnable_val = new JLabel("0");
		GridBagConstraints gbc_CTurretMotorEnable_val = new GridBagConstraints();
		gbc_CTurretMotorEnable_val.insets = new Insets(0, 0, 5, 0);
		gbc_CTurretMotorEnable_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_CTurretMotorEnable_val.gridx = 1;
		gbc_CTurretMotorEnable_val.gridy = 6;
		panel_CommandReg.add(CTurretMotorEnable_val, gbc_CTurretMotorEnable_val);

		CMoveDirection = new JLabel("MoveDirection");
		GridBagConstraints gbc_CMoveDirection = new GridBagConstraints();
		gbc_CMoveDirection.anchor = GridBagConstraints.NORTHWEST;
		gbc_CMoveDirection.insets = new Insets(0, 0, 5, 5);
		gbc_CMoveDirection.gridx = 0;
		gbc_CMoveDirection.gridy = 7;
		panel_CommandReg.add(CMoveDirection, gbc_CMoveDirection);
		CMoveDirection_val = new JLabel("0");
		GridBagConstraints gbc_CMoveDirection_val = new GridBagConstraints();
		gbc_CMoveDirection_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_CMoveDirection_val.insets = new Insets(0, 0, 5, 0);
		gbc_CMoveDirection_val.gridx = 1;
		gbc_CMoveDirection_val.gridy = 7;
		panel_CommandReg.add(CMoveDirection_val, gbc_CMoveDirection_val);

		CMoveDuration = new JLabel("MoveDuration");
		GridBagConstraints gbc_CMoveDuration = new GridBagConstraints();
		gbc_CMoveDuration.anchor = GridBagConstraints.NORTHWEST;
		gbc_CMoveDuration.insets = new Insets(0, 0, 0, 5);
		gbc_CMoveDuration.gridx = 0;
		gbc_CMoveDuration.gridy = 8;
		panel_CommandReg.add(CMoveDuration, gbc_CMoveDuration);
		CMoveDuration_val = new JLabel("0");
		GridBagConstraints gbc_CMoveDuration_val = new GridBagConstraints();
		gbc_CMoveDuration_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_CMoveDuration_val.gridx = 1;
		gbc_CMoveDuration_val.gridy = 8;
		panel_CommandReg.add(CMoveDuration_val, gbc_CMoveDuration_val);

		panel_StatusReg = new JPanel();
		panel_StatusReg.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		main_panel.add(panel_StatusReg);
		GridBagLayout gbl_panel_StatusReg = new GridBagLayout();
		gbl_panel_StatusReg.columnWidths = new int[] { 34, 40, 0 };
		gbl_panel_StatusReg.rowHeights = new int[] { 0, 14, 0, 0, 0, 0, 0, 0 };
		gbl_panel_StatusReg.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_StatusReg.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_StatusReg.setLayout(gbl_panel_StatusReg);

		lblStatus = new JLabel("Status");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.EAST;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 0;
		panel_StatusReg.add(lblStatus, gbc_lblStatus);

		// StatusReg
		SManual = new JLabel("Manual");
		GridBagConstraints gbc_SManual = new GridBagConstraints();
		gbc_SManual.anchor = GridBagConstraints.NORTHWEST;
		gbc_SManual.insets = new Insets(0, 0, 5, 5);
		gbc_SManual.gridx = 0;
		gbc_SManual.gridy = 1;
		panel_StatusReg.add(SManual, gbc_SManual);
		SManual_val = new JLabel("0");
		GridBagConstraints gbc_SManual_val = new GridBagConstraints();
		gbc_SManual_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_SManual_val.insets = new Insets(0, 0, 5, 0);
		gbc_SManual_val.gridx = 1;
		gbc_SManual_val.gridy = 1;
		panel_StatusReg.add(SManual_val, gbc_SManual_val);

		SLineFollow = new JLabel("LineFollow");
		GridBagConstraints gbc_SAuto = new GridBagConstraints();
		gbc_SAuto.anchor = GridBagConstraints.NORTHWEST;
		gbc_SAuto.insets = new Insets(0, 0, 5, 5);
		gbc_SAuto.gridx = 0;
		gbc_SAuto.gridy = 2;
		panel_StatusReg.add(SLineFollow, gbc_SAuto);
		SLineFollow_val = new JLabel("0");
		GridBagConstraints gbc_SAuto_val = new GridBagConstraints();
		gbc_SAuto_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_SAuto_val.insets = new Insets(0, 0, 5, 0);
		gbc_SAuto_val.gridx = 1;
		gbc_SAuto_val.gridy = 2;
		panel_StatusReg.add(SLineFollow_val, gbc_SAuto_val);
		
		SSurvey = new JLabel("Survey");
		GridBagConstraints gbc_SSurvey = new GridBagConstraints();
		gbc_SSurvey.anchor = GridBagConstraints.NORTHWEST;
		gbc_SSurvey.insets = new Insets(0, 0, 5, 5);
		gbc_SSurvey.gridx = 0;
		gbc_SSurvey.gridy = 3;
		panel_StatusReg.add(SSurvey, gbc_SSurvey);
		SSurvey_val = new JLabel("0");
		GridBagConstraints gbc_SSurvey_val = new GridBagConstraints();
		gbc_SSurvey_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_SSurvey_val.insets = new Insets(0, 0, 5, 0);
		gbc_SSurvey_val.gridx = 1;
		gbc_SSurvey_val.gridy = 3;
		panel_StatusReg.add(SSurvey_val, gbc_SSurvey_val);
		
		SUDPLiveFeed = new JLabel("UDPLiveFeed");
		GridBagConstraints gbc_SUDPLiveFeed = new GridBagConstraints();
		gbc_SUDPLiveFeed.anchor = GridBagConstraints.NORTHWEST;
		gbc_SUDPLiveFeed.insets = new Insets(0, 0, 5, 5);
		gbc_SUDPLiveFeed.gridx = 0;
		gbc_SUDPLiveFeed.gridy = 4;
		panel_StatusReg.add(SUDPLiveFeed, gbc_SUDPLiveFeed);
		SUDPLiveFeed_val = new JLabel("0");
		GridBagConstraints gbc_SUDPLiveFeed_val = new GridBagConstraints();
		gbc_SUDPLiveFeed_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_SUDPLiveFeed_val.insets = new Insets(0, 0, 5, 0);
		gbc_SUDPLiveFeed_val.gridx = 1;
		gbc_SUDPLiveFeed_val.gridy = 4;
		panel_StatusReg.add(SUDPLiveFeed_val, gbc_SUDPLiveFeed_val);

		SMovementMotorEnable = new JLabel("MovementMotorEnable");
		GridBagConstraints gbc_SMotorPSEnable = new GridBagConstraints();
		gbc_SMotorPSEnable.anchor = GridBagConstraints.NORTHWEST;
		gbc_SMotorPSEnable.insets = new Insets(0, 0, 5, 5);
		gbc_SMotorPSEnable.gridx = 0;
		gbc_SMotorPSEnable.gridy = 5;
		panel_StatusReg.add(SMovementMotorEnable, gbc_SMotorPSEnable);
		SMovementMotorEnable_val = new JLabel("0");
		GridBagConstraints gbc_SMotorPSEnable_val = new GridBagConstraints();
		gbc_SMotorPSEnable_val.insets = new Insets(0, 0, 5, 0);
		gbc_SMotorPSEnable_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_SMotorPSEnable_val.gridx = 1;
		gbc_SMotorPSEnable_val.gridy = 5;
		panel_StatusReg.add(SMovementMotorEnable_val, gbc_SMotorPSEnable_val);
		
		STurretMotorEnable = new JLabel("TurretMotorEnable");
		GridBagConstraints gbc_STurretMotorEnable = new GridBagConstraints();
		gbc_STurretMotorEnable.anchor = GridBagConstraints.NORTHWEST;
		gbc_STurretMotorEnable.insets = new Insets(0, 0, 5, 5);
		gbc_STurretMotorEnable.gridx = 0;
		gbc_STurretMotorEnable.gridy = 6;
		panel_StatusReg.add(STurretMotorEnable, gbc_STurretMotorEnable);
		STurretMotorEnable_val = new JLabel("0");
		GridBagConstraints gbc_STurretMotorEnable_val = new GridBagConstraints();
		gbc_STurretMotorEnable_val.insets = new Insets(0, 0, 5, 0);
		gbc_STurretMotorEnable_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_STurretMotorEnable_val.gridx = 1;
		gbc_STurretMotorEnable_val.gridy = 6;
		panel_StatusReg.add(STurretMotorEnable_val, gbc_STurretMotorEnable_val);

		SMoveDirection = new JLabel("MoveDirection");
		GridBagConstraints gbc_SMoveDirection = new GridBagConstraints();
		gbc_SMoveDirection.anchor = GridBagConstraints.NORTHWEST;
		gbc_SMoveDirection.insets = new Insets(0, 0, 5, 5);
		gbc_SMoveDirection.gridx = 0;
		gbc_SMoveDirection.gridy = 7;
		panel_StatusReg.add(SMoveDirection, gbc_SMoveDirection);
		SMoveDirection_val = new JLabel("0");
		GridBagConstraints gbc_SMoveDirection_val = new GridBagConstraints();
		gbc_SMoveDirection_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_SMoveDirection_val.insets = new Insets(0, 0, 5, 0);
		gbc_SMoveDirection_val.gridx = 1;
		gbc_SMoveDirection_val.gridy = 7;
		panel_StatusReg.add(SMoveDirection_val, gbc_SMoveDirection_val);

		SMoveDuration = new JLabel("MoveDuration");
		GridBagConstraints gbc_SMoveDuration = new GridBagConstraints();
		gbc_SMoveDuration.anchor = GridBagConstraints.NORTHWEST;
		gbc_SMoveDuration.insets = new Insets(0, 0, 0, 5);
		gbc_SMoveDuration.gridx = 0;
		gbc_SMoveDuration.gridy = 8;
		panel_StatusReg.add(SMoveDuration, gbc_SMoveDuration);
		SMoveDuration_val = new JLabel("0");
		GridBagConstraints gbc_SMoveDuration_val = new GridBagConstraints();
		gbc_SMoveDuration_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_SMoveDuration_val.gridx = 1;
		gbc_SMoveDuration_val.gridy = 8;
		panel_StatusReg.add(SMoveDuration_val, gbc_SMoveDuration_val);

		panel_FailureReg = new JPanel();
		panel_FailureReg.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		main_panel.add(panel_FailureReg);
		GridBagLayout gbl_panel_FailureReg = new GridBagLayout();
		gbl_panel_FailureReg.columnWidths = new int[] { 54, 0, 0 };
		gbl_panel_FailureReg.rowHeights = new int[] { 14, 0 };
		gbl_panel_FailureReg.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_FailureReg.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_FailureReg.setLayout(gbl_panel_FailureReg);

		// FailureReg
		FRglobal1 = new JLabel("Failure Reg");
		GridBagConstraints gbc_FRglobal1 = new GridBagConstraints();
		gbc_FRglobal1.anchor = GridBagConstraints.NORTHWEST;
		gbc_FRglobal1.insets = new Insets(0, 0, 0, 5);
		gbc_FRglobal1.gridx = 0;
		gbc_FRglobal1.gridy = 0;
		panel_FailureReg.add(FRglobal1, gbc_FRglobal1);
		FRglobal1_val = new JLabel("0");
		GridBagConstraints gbc_FRglobal1_val = new GridBagConstraints();
		gbc_FRglobal1_val.anchor = GridBagConstraints.NORTHWEST;
		gbc_FRglobal1_val.gridx = 1;
		gbc_FRglobal1_val.gridy = 0;
		panel_FailureReg.add(FRglobal1_val, gbc_FRglobal1_val);
		/**/

		panel_button = new JPanel();
		panel_button.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		main_panel.add(panel_button);
		btnManual = new JButton("Manual");
		btnLineFollow = new JButton("LineFollow");
		btnUDPLiveFeed = new JButton("LiveFeed");
		panel_button.add(btnManual);
		panel_button.add(btnLineFollow);
		
		btnSurvey = new JButton("Survey");
		panel_button.add(btnSurvey);
		panel_button.add(btnUDPLiveFeed);

		// ajout du panel à la fenetre
		getContentPane().add(main_panel);
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		main_panel.add(panel);
		
		
		btnMovementMotorEnable = new JButton("MovementMotorEnable");
		panel.add(btnMovementMotorEnable);
		btnMovementMotorEnable.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnMovementMotorEnableClick(e);

			}
		});
		
		btnTurretMotorEnable = new JButton("TurretMotorEnable");
		panel.add(btnTurretMotorEnable);
		btnTurretMotorEnable.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnTurretMotorEnableClick(e);

			}
		});


		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmConnect = new JMenuItem("Connect");

		mnFile.add(mntmConnect);

		mntmDisconnect = new JMenuItem("Disconnect");

		mnFile.add(mntmDisconnect);

		mntmSep1 = new JSeparator();
		mnFile.add(mntmSep1);
		mntmQuit = new JMenuItem("Quit");

		mnFile.add(mntmQuit);

		mnTools = new JMenu("Tools");
		menuBar.add(mnTools);

		mntmConnectionSetting = new JMenuItem("Connection Setting");

		mnTools.add(mntmConnectionSetting);

		mntmSep2 = new JSeparator();
		mnTools.add(mntmSep2);

		mntmManualCommand = new JMenuItem("Manual Command");

		mnTools.add(mntmManualCommand);

		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		mntmAbout = new JMenuItem("About");

		mnAbout.add(mntmAbout);

		lblNetStatus = new JLabel("Net Status");
		lblNetStatus.setFont(new Font("Dialog", Font.PLAIN, 12));
		menuBar.add(lblNetStatus);

		btnManual.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnManualClick(e);

			}
		});
		btnLineFollow.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnLineFollowClick(e);

			}
		});
		btnUDPLiveFeed.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnUDPLiveFeedClick(e);

			}
		});
		
		btnSurvey.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnSurveyClick(e);

			}
		});

		mntmQuit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				it_quitActionClick(e);

			}
		});

		mntmAbout.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				it_AboutClick(e);

			}
		});
		mntmManualCommand.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				it_ManualCommandClick(e);
			}
		});

		mntmConnect.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				it_ConnectClick(e);
			}
		});

		mntmDisconnect.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				it_DisconnectClick(e);
			}
		});

		mntmConnectionSetting.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				it_ConnectionSettingClick(e);
			}
		});

	}

	private void it_ConnectClick(ActionEvent e)
	{
		Client.setConnect(true);
	}

	private void it_DisconnectClick(ActionEvent e)
	{
		Client.setConnect(false);
	}

	private void it_ConnectionSettingClick(ActionEvent e)
	{
		if (NetworkConfig.isIsopen() == false)
		{
			NetworkConfig fen = new NetworkConfig();
			fen.setVisible(true);
		}
		
	}

	public void setLblNetStatus(String lblNetStatus)
	{
		this.lblNetStatus.setText(lblNetStatus);
	}

	private void it_quitActionClick(ActionEvent e)
	{
		this.dispose();
	}

	private void it_AboutClick(ActionEvent e)
	{
		JOptionPane.showMessageDialog(this, "RPi-kee Pilot v0.02 , a JAVA Gui by MPE", "About", JOptionPane.INFORMATION_MESSAGE);
	}

	private void it_ManualCommandClick(ActionEvent e)
	{
		if (ManualCommandPanel.isIsopen() == false)
		{
			ManualCommandPanel fen = new ManualCommandPanel();
			fen.setVisible(true);
		}
	}

	private void btnManualClick(ActionEvent e)
	{

		RPK RPK_out = new RPK();
		RPK RPK_in = new RPK();
		Params p = new Params();
		RPK_in = RPK_out.Read(p.CommandReg.ParamID, p.CommandReg.Size);
		p.CommandReg.SetParam(RPK_in.getData());

		if (p.CommandReg.Manual == 0)
		{
			p.CommandReg.Manual = 1;
		} else
		{
			p.CommandReg.Manual = 0;
		}
		RPK_out.Write(p.CommandReg.ParamID, p.CommandReg.Size, p.CommandReg.toBytes());
		/*try
		{
			Thread.sleep(200);
		} catch (InterruptedException e1)
		{
			e1.printStackTrace();
		}
		RPK_in = RPK_out.Read(p.StatusReg.ParamID, p.StatusReg.Size);
		p.StatusReg.SetParam(RPK_in.getData());
		
		if(p.StatusReg.Manual == 1)
		{
			if (ManualCommandPanel.isIsopen() == false)
			{
				ManualCommandPanel fen = new ManualCommandPanel();
				fen.setVisible(true);
			}
		}*/

	}

	private void btnLineFollowClick(ActionEvent e)
	{
		RPK RPK_out = new RPK();
		RPK RPK_in = new RPK();
		Params p = new Params();
		RPK_in = RPK_out.Read(p.CommandReg.ParamID, p.CommandReg.Size);
		p.CommandReg.SetParam(RPK_in.getData());

		if (p.CommandReg.LineFollow == 0)
		{
			p.CommandReg.LineFollow = 1;
		} else
		{
			p.CommandReg.LineFollow = 0;
		}
		RPK_out.Write(p.CommandReg.ParamID, p.CommandReg.Size, p.CommandReg.toBytes());
	}

	private void btnUDPLiveFeedClick(ActionEvent e)
	{
		RPK RPK_out = new RPK();
		RPK RPK_in = new RPK();
		Params p = new Params();
		RPK_in = RPK_out.Read(p.CommandReg.ParamID, p.CommandReg.Size);
		p.CommandReg.SetParam(RPK_in.getData());

		if (p.CommandReg.UDPLiveFeed == 0)
		{
			p.CommandReg.UDPLiveFeed = 1;
		} else
		{
			p.CommandReg.UDPLiveFeed = 0;
		}
		RPK_out.Write(p.CommandReg.ParamID, p.CommandReg.Size, p.CommandReg.toBytes());
	}
	
	private void btnSurveyClick(ActionEvent e)
	{
		RPK RPK_out = new RPK();
		RPK RPK_in = new RPK();
		Params p = new Params();
		RPK_in = RPK_out.Read(p.CommandReg.ParamID, p.CommandReg.Size);
		p.CommandReg.SetParam(RPK_in.getData());

		if (p.CommandReg.Survey == 0)
		{
			p.CommandReg.Survey = 1;
		} else
		{
			p.CommandReg.Survey = 0;
		}
		RPK_out.Write(p.CommandReg.ParamID, p.CommandReg.Size, p.CommandReg.toBytes());
	}

	private void btnMovementMotorEnableClick(ActionEvent e)
	{
		RPK RPK_out = new RPK();
		RPK RPK_in = new RPK();
		Params p = new Params();
		RPK_in = RPK_out.Read(p.CommandReg.ParamID, p.CommandReg.Size);
		p.CommandReg.SetParam(RPK_in.getData());

		if (p.CommandReg.MovementMotorEnable == 0)
		{
			p.CommandReg.MovementMotorEnable = 1;
		} else
		{
			p.CommandReg.MovementMotorEnable = 0;
		}
		RPK_out.Write(p.CommandReg.ParamID, p.CommandReg.Size, p.CommandReg.toBytes());
	}
	
	
	private void btnTurretMotorEnableClick(ActionEvent e)
	{
		RPK RPK_out = new RPK();
		RPK RPK_in = new RPK();
		Params p = new Params();
		RPK_in = RPK_out.Read(p.CommandReg.ParamID, p.CommandReg.Size);
		p.CommandReg.SetParam(RPK_in.getData());

		if (p.CommandReg.TurretMotorEnable == 0)
		{
			p.CommandReg.TurretMotorEnable = 1;
		} else
		{
			p.CommandReg.TurretMotorEnable = 0;
		}
		RPK_out.Write(p.CommandReg.ParamID, p.CommandReg.Size, p.CommandReg.toBytes());
	}

	public void setLb_LongIRDistance_val(String text)
	{
		this.lb_LongIRDistance_val.setText(text);
	}

	public void setLb_ShortIRDistance_val(String text)
	{
		this.lb_ShortIRDistance_val.setText(text);
	}

	public void setLb_VoltageBattery_val(String text)
	{
		this.lb_VoltageBattery_val.setText(text);
	}

	public void setLb_Voltage12V_val(String text)
	{
		this.lb_Voltage12V_val.setText(text);
	}

	public void setLb_CPUTemperature_val(String text)
	{
		this.lb_CPUTemperature_val.setText(text);
	}

	public void setLb_AuxTemperature_val(String text)
	{
		this.lb_AuxTemperature_val.setText(text);
	}

	public void setLb_ImgMoveDirection_val(String text)
	{
		this.lb_ImgMoveDirection_val.setText(text);
	}

	public void setTxf_softversion(String txf_softversion)
	{
		this.txf_softversion.setText(txf_softversion);
	}

	public void setTxf_paramversion(String txf_paramversion)
	{
		this.txf_paramversion.setText(txf_paramversion);
	}

	public void setLb_LMCSpeed_val(String lb_LMCSpeed_val)
	{
		this.lb_LMCSpeed_val.setText(lb_LMCSpeed_val);
	}

	public void setLb_LMCUnused_val(String lb_LMCUnused_val)
	{
		this.lb_LMCUnused_val.setText(lb_LMCUnused_val);
	}

	public void setLb_RMCSpeed_val(String lb_RMCSpeed_val)
	{
		this.lb_RMCSpeed_val.setText(lb_RMCSpeed_val);
	}

	public void setLb_RMCUnused_val(String lb_RMCUnused_val)
	{
		this.lb_RMCUnused_val.setText(lb_RMCUnused_val);
	}

	public void setCManual_val(String cManual_val)
	{
		CManual_val.setText(cManual_val);
	}

	public void setCLineFollow_val(String cLineFollow_val)
	{
		CLineFollow_val.setText(cLineFollow_val);
	}
	
	public void setCSurvey_val(String cSurvey_val)
	{
		CSurvey_val.setText(cSurvey_val);
	}

	public void setCMoveDirection_val(String cMoveDirection_val)
	{
		CMoveDirection_val.setText(cMoveDirection_val);
	}

	public void setCMoveDuration_val(String cMoveDuration_val)
	{
		CMoveDuration_val.setText(cMoveDuration_val);
	}

	public void setCUDPLiveFeed_val(String cUDPLiveFeed_val)
	{
		CUDPLiveFeed_val.setText(cUDPLiveFeed_val);
	}

	public void setCMovementMotorEnable_val(String cMovementMotorEnable_val)
	{
		CMovementMotorEnable_val.setText(cMovementMotorEnable_val);
	}
	
	
	public void setSTurretMotorEnable_val(String sTurretMotorEnable_val)
	{
		STurretMotorEnable_val.setText(sTurretMotorEnable_val);
	}
	
	public void setCTurretMotorEnable_val(String cTurretMotorEnable_val)
	{
		CTurretMotorEnable_val.setText(cTurretMotorEnable_val);
	}

	public void setSManual_val(String sManual_val)
	{
		SManual_val.setText(sManual_val);
	}

	public void setSLineFollow_val(String sLineFollow_val)
	{
		SLineFollow_val.setText(sLineFollow_val);
	}
	
	public void setSSurvey_val(String sSurvey_val)
	{
		SSurvey_val.setText(sSurvey_val);
	}

	public void setSMoveDirection_val(String sMoveDirection_val)
	{
		SMoveDirection_val.setText(sMoveDirection_val);
	}

	public void setSMoveDuration_val(String sMoveDuration_val)
	{
		SMoveDuration_val.setText(sMoveDuration_val);
	}

	public void setSUDPLiveFeed_val(String sUDPLiveFeed_val)
	{
		SUDPLiveFeed_val.setText(sUDPLiveFeed_val);
	}

	public void setSMotorPSEnable_val(String sMotorPSEnable_val)
	{
		SMovementMotorEnable_val.setText(sMotorPSEnable_val);
	}

	public void setFRglobal1_val(String fRglobal1_val)
	{
		FRglobal1_val.setText(fRglobal1_val);
	}

	public void setColorbtnManual(Color col)
	{
		btnManual.setBackground(col);
	}

	public void setColorbtnLiveFollow(Color col)
	{
		btnLineFollow.setBackground(col);
	}

	public void setColorbtnUDPLiveFeed(Color col)
	{
		btnUDPLiveFeed.setBackground(col);
	}

	public void setColorbtnMovementMotorEnable(Color col)
	{
		btnMovementMotorEnable.setBackground(col);
	}
	
	public void setColorbtnTurretMotorEnable(Color col)
	{
		btnTurretMotorEnable.setBackground(col);
	}
	
	public void setColorbtnSurvey(Color col)
	{
		btnSurvey.setBackground(col);
	}

}

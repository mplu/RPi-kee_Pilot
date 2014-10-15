package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



public class MainWindow extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7748535948804673486L;
	private JPanel mainpanel;

	private JLabel  lb_LongIRDistance;
	private JLabel  lb_ShortIRDistance;
	private JLabel  lb_VoltageBattery;
	private JLabel  lb_Voltage12V;
	private JLabel  lb_CPUTemperature;
	private JLabel  lb_AuxTemperature;
	private JLabel  lb_ImgMoveDirection;
	
	private JLabel  lb_LongIRDistance_val;
	private JLabel  lb_ShortIRDistance_val;
	private JLabel  lb_VoltageBattery_val;
	private JLabel  lb_Voltage12V_val;
	private JLabel  lb_CPUTemperature_val;
	private JLabel  lb_AuxTemperature_val;
	private JLabel  lb_ImgMoveDirection_val;
	private JButton btnRefresh;

	public MainWindow()
	{
		setTitle("R-Pikee Pilot");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		mainpanel = new JPanel();
		GridBagLayout gbl_mainpanel = new GridBagLayout();
		gbl_mainpanel.columnWidths = new int[]{0, 33};
		gbl_mainpanel.rowHeights = new int[]{22, 22, 22, 22, 22, 22, 22};
		mainpanel.setLayout(gbl_mainpanel);
		
		// Creation label et Ajout au panel
		lb_LongIRDistance = new JLabel("LongIRDistance");
		GridBagConstraints gbc_lb_LongIRDistance = new GridBagConstraints();
		gbc_lb_LongIRDistance.insets = new Insets(0, 0, 5, 5);
		
		gbc_lb_LongIRDistance.gridx = 0;
		gbc_lb_LongIRDistance.gridy = 0;
		mainpanel.add(lb_LongIRDistance, gbc_lb_LongIRDistance);
		lb_LongIRDistance_val = new JLabel("0");
		GridBagConstraints gbc_lb_LongIRDistance_val = new GridBagConstraints();
		gbc_lb_LongIRDistance_val.insets = new Insets(0, 0, 5, 0);
		
		gbc_lb_LongIRDistance_val.gridx = 1;
		gbc_lb_LongIRDistance_val.gridy = 0;
		mainpanel.add(lb_LongIRDistance_val, gbc_lb_LongIRDistance_val);
		
		lb_ShortIRDistance = new JLabel("ShortIRDistance");
		GridBagConstraints gbc_lb_ShortIRDistance = new GridBagConstraints();
		gbc_lb_ShortIRDistance.insets = new Insets(0, 0, 5, 5);
		
		gbc_lb_ShortIRDistance.gridx = 0;
		gbc_lb_ShortIRDistance.gridy = 1;
		mainpanel.add(lb_ShortIRDistance, gbc_lb_ShortIRDistance);
		lb_ShortIRDistance_val = new JLabel("0");
		GridBagConstraints gbc_lb_ShortIRDistance_val = new GridBagConstraints();
		gbc_lb_ShortIRDistance_val.insets = new Insets(0, 0, 5, 0);
		
		gbc_lb_ShortIRDistance_val.gridx = 1;
		gbc_lb_ShortIRDistance_val.gridy = 1;
		mainpanel.add(lb_ShortIRDistance_val,gbc_lb_ShortIRDistance_val);
		
		
		
		lb_VoltageBattery = new JLabel("VoltageBattery");
		GridBagConstraints gbc_lb_VoltageBattery = new GridBagConstraints();
		gbc_lb_VoltageBattery.insets = new Insets(0, 0, 5, 5);
		
		gbc_lb_VoltageBattery.gridx = 0;
		gbc_lb_VoltageBattery.gridy = 2;
		mainpanel.add(lb_VoltageBattery, gbc_lb_VoltageBattery);
		lb_VoltageBattery_val = new JLabel("0");
		GridBagConstraints gbc_lb_VoltageBattery_val = new GridBagConstraints();
		gbc_lb_VoltageBattery_val.insets = new Insets(0, 0, 5, 0);
		
		gbc_lb_VoltageBattery_val.gridx = 1;
		gbc_lb_VoltageBattery_val.gridy = 2;
		mainpanel.add(lb_VoltageBattery_val, gbc_lb_VoltageBattery_val);
		
		lb_Voltage12V = new JLabel("Voltage12V");
		GridBagConstraints gbc_lb_Voltage12V = new GridBagConstraints();
		gbc_lb_Voltage12V.insets = new Insets(0, 0, 5, 5);
		
		gbc_lb_Voltage12V.gridx = 0;
		gbc_lb_Voltage12V.gridy = 3;
		mainpanel.add(lb_Voltage12V, gbc_lb_Voltage12V);
		lb_Voltage12V_val = new JLabel("0");
		GridBagConstraints gbc_lb_Voltage12V_val = new GridBagConstraints();
		gbc_lb_Voltage12V_val.insets = new Insets(0, 0, 5, 0);
		
		gbc_lb_Voltage12V_val.gridx = 1;
		gbc_lb_Voltage12V_val.gridy = 3;
		mainpanel.add(lb_Voltage12V_val, gbc_lb_Voltage12V_val);
		
		lb_CPUTemperature = new JLabel("CPUTemperature");
		GridBagConstraints gbc_lb_CPUTemperature = new GridBagConstraints();
		gbc_lb_CPUTemperature.insets = new Insets(0, 0, 5, 5);
		
		gbc_lb_CPUTemperature.gridx = 0;
		gbc_lb_CPUTemperature.gridy = 4;
		mainpanel.add(lb_CPUTemperature, gbc_lb_CPUTemperature);
		lb_CPUTemperature_val = new JLabel("0");
		GridBagConstraints gbc_lb_CPUTemperature_val = new GridBagConstraints();
		gbc_lb_CPUTemperature_val.insets = new Insets(0, 0, 5, 0);
		
		gbc_lb_CPUTemperature_val.gridx = 1;
		gbc_lb_CPUTemperature_val.gridy = 4;
		mainpanel.add(lb_CPUTemperature_val, gbc_lb_CPUTemperature_val);
		
		lb_AuxTemperature = new JLabel("AuxTemperature");
		GridBagConstraints gbc_lb_AuxTemperature = new GridBagConstraints();
		gbc_lb_AuxTemperature.insets = new Insets(0, 0, 5, 5);
		
		gbc_lb_AuxTemperature.gridx = 0;
		gbc_lb_AuxTemperature.gridy = 5;
		mainpanel.add(lb_AuxTemperature, gbc_lb_AuxTemperature);
		lb_AuxTemperature_val = new JLabel("0");
		GridBagConstraints gbc_lb_AuxTemperature_val = new GridBagConstraints();
		gbc_lb_AuxTemperature_val.insets = new Insets(0, 0, 5, 0);
		
		gbc_lb_AuxTemperature_val.gridx = 1;
		gbc_lb_AuxTemperature_val.gridy = 5;
		mainpanel.add(lb_AuxTemperature_val, gbc_lb_AuxTemperature_val);
		
		lb_ImgMoveDirection = new JLabel("ImgMoveDirection");
		GridBagConstraints gbc_lb_ImgMoveDirection = new GridBagConstraints();
		gbc_lb_ImgMoveDirection.insets = new Insets(0, 0, 0, 5);
		
		gbc_lb_ImgMoveDirection.gridx = 0;
		gbc_lb_ImgMoveDirection.gridy = 6;
		mainpanel.add(lb_ImgMoveDirection, gbc_lb_ImgMoveDirection);
		lb_ImgMoveDirection_val = new JLabel("0");
		GridBagConstraints gbc_lb_ImgMoveDirection_val = new GridBagConstraints();
		
		gbc_lb_ImgMoveDirection_val.gridx = 1;
		gbc_lb_ImgMoveDirection_val.gridy = 6;
		mainpanel.add(lb_ImgMoveDirection_val, gbc_lb_ImgMoveDirection_val);
		
		// ajout du panel à la fenetre
		getContentPane().add(mainpanel);
		
		btnRefresh = new JButton("Refresh");
		getContentPane().add(btnRefresh);
		
		
		
		
		
		
		btnRefresh.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnRefreshClick(e);
	
			}
		});
	}
	
	
	private void btnRefreshClick(ActionEvent e)
	{
		

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

}

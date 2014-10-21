package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

import protocol.RPK;
import data.Params;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManualCommandPanel extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -886491121265719757L;
	private JButton btnForward;
	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnBackward;
	private JButton btnStop;
	
	private enum Direction
	{
		forward,
		backward,
		left,
		right,
		stop
	}

	public ManualCommandPanel()
	{
		setResizable(false);
		setTitle("Manual Command");
		setSize(244, 118);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 70, 70, 0};
		gridBagLayout.rowHeights = new int[]{23, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		btnForward = new JButton("Forward");
		btnForward.setSize(100, 30);
		GridBagConstraints gbc_btnForward = new GridBagConstraints();
		gbc_btnForward.anchor = GridBagConstraints.NORTH;
		gbc_btnForward.insets = new Insets(0, 0, 5, 5);
		gbc_btnForward.gridx = 1;
		gbc_btnForward.gridy = 0;
		getContentPane().add(btnForward, gbc_btnForward);
		btnLeft = new JButton("Left");
		GridBagConstraints gbc_btnLeft = new GridBagConstraints();
		gbc_btnLeft.anchor = GridBagConstraints.NORTH;
		gbc_btnLeft.insets = new Insets(0, 0, 5, 5);
		gbc_btnLeft.gridx = 0;
		gbc_btnLeft.gridy = 1;
		getContentPane().add(btnLeft, gbc_btnLeft);
		btnStop = new JButton("Stop");
		
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop.gridx = 1;
		gbc_btnStop.gridy = 1;
		getContentPane().add(btnStop, gbc_btnStop);
		btnRight = new JButton("Right");
		GridBagConstraints gbc_btnRight = new GridBagConstraints();
		gbc_btnRight.anchor = GridBagConstraints.NORTH;
		gbc_btnRight.insets = new Insets(0, 0, 5, 0);
		gbc_btnRight.gridx = 2;
		gbc_btnRight.gridy = 1;
		getContentPane().add(btnRight, gbc_btnRight);
		btnBackward = new JButton("Backward");
		GridBagConstraints gbc_btnBackward = new GridBagConstraints();
		gbc_btnBackward.insets = new Insets(0, 0, 0, 5);
		gbc_btnBackward.anchor = GridBagConstraints.NORTH;
		gbc_btnBackward.gridx = 1;
		gbc_btnBackward.gridy = 2;
		getContentPane().add(btnBackward, gbc_btnBackward);
		
		
		
		
		btnForward.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnDirectionClick(e,Direction.forward);
			}
		});
		
		btnBackward.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnDirectionClick(e,Direction.backward);
			}
		});
		
		btnLeft.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnDirectionClick(e,Direction.left);
			}
		});
		
		btnRight.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnDirectionClick(e,Direction.right);
			}
		});
		
		btnStop.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnDirectionClick(e,Direction.stop);
			}
		});
		
		
		
	}
	
	private void btnDirectionClick(ActionEvent e,Direction dir)
	{
		
		RPK RPK_out = new RPK();
		RPK RPK_in = new RPK();
		Params p = new Params();
		RPK_in = RPK_out.Read(p.CommandReg.ParamID,p.CommandReg.Size);
		p.CommandReg.SetParam(RPK_in.getData());
		
		p.CommandReg.MoveDuration = 3000;
		switch(dir)
		{
			case forward:
				p.CommandReg.MoveDirection = 0;
				break;
			case backward:
				p.CommandReg.MoveDirection = 180;
				break;
			case left:
				p.CommandReg.MoveDirection = 90;
				break;
			case right:
				p.CommandReg.MoveDirection = -90;
				break;
			case stop:
			default:
				p.CommandReg.MoveDirection = 0;
				p.CommandReg.MoveDuration = 0;
				break;
				
		}
		RPK_out.Write(p.CommandReg.ParamID,p.CommandReg.Size,p.CommandReg.toBytes());

	}
}

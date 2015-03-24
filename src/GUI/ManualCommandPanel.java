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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ManualCommandPanel extends JFrame implements KeyListener
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

	private static boolean isopen = false;

	private enum Direction
	{
		forward, backward, left, right, stop
	}
	
	

	public ManualCommandPanel()
	{

		setResizable(false);
		setTitle("Manual Command");
		setSize(244, 118);
		
		setFocusable(true);
		addKeyListener(this);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 70, 70, 70, 0 };
		gridBagLayout.rowHeights = new int[] { 23, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		isopen = true;

		btnForward.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnDirectionClick(e, Direction.forward);
			}
		});

		btnBackward.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnDirectionClick(e, Direction.backward);
			}
		});

		btnLeft.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnDirectionClick(e, Direction.left);
			}
		});

		btnRight.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnDirectionClick(e, Direction.right);
			}
		});

		btnStop.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnDirectionClick(e, Direction.stop);
			}
		});

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosed(WindowEvent arg0)
			{
				whenwindowclosed(arg0);
			}
		});
		
		
	}
	
	public static boolean isIsopen()
	{
		return isopen;
	}

	private void whenwindowclosed(WindowEvent arg0)
	{
		isopen = false;
	}

	private void btnDirectionClick(ActionEvent e, Direction dir)
	{

		RPK RPK_out = new RPK();
		RPK RPK_in = new RPK();
		Params p = new Params();
		RPK_in = RPK_out.Read(p.CommandReg.ParamID, p.CommandReg.Size);
		p.CommandReg.SetParam(RPK_in.getData());

		p.CommandReg.MoveDuration = 1000;
		switch (dir)
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
		RPK_out.Write(p.CommandReg.ParamID, p.CommandReg.Size, p.CommandReg.toBytes());

	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		Integer touche = arg0.getKeyCode();
		
		if(touche == KeyEvent.VK_UP)
		{
			ActionEvent e = null;
			btnDirectionClick(e, Direction.forward);
			System.out.println("forward");
		}
		if(touche == KeyEvent.VK_DOWN)
		{
			ActionEvent e = null;
			btnDirectionClick(e, Direction.backward);
			System.out.println("backward");
		}
		if(touche == KeyEvent.VK_RIGHT)
		{
			ActionEvent e = null;
			btnDirectionClick(e, Direction.right);
			System.out.println("right");
		}
		if(touche == KeyEvent.VK_LEFT)
		{
			ActionEvent e = null;
			btnDirectionClick(e, Direction.left);
			System.out.println("left");
		}
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		Integer touche = arg0.getKeyCode();
		if((touche == KeyEvent.VK_UP)
				||(touche == KeyEvent.VK_DOWN)
				||(touche == KeyEvent.VK_RIGHT)
				||(touche == KeyEvent.VK_LEFT))
		{
			ActionEvent e = null;
			btnDirectionClick(e, Direction.stop);
			System.out.println("stop");
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		Integer touche = arg0.getKeyCode();
		System.out.println(touche.toString()+ " Typed");
	}
}

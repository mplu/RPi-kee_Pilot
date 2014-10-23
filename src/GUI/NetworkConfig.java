package GUI;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import network.Client;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NetworkConfig extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4746374842438477123L;
	private JTextField txtLocalhost;
	private JTextField txtPort;

	public NetworkConfig()
	{
		setResizable(false);
		setTitle("Network Configuration");
		setSize(264, 118);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 4, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblRpikeeIpAddress = new JLabel("RPi-kee IP Address");
		GridBagConstraints gbc_lblRpikeeIpAddress = new GridBagConstraints();
		gbc_lblRpikeeIpAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblRpikeeIpAddress.anchor = GridBagConstraints.EAST;
		gbc_lblRpikeeIpAddress.gridx = 1;
		gbc_lblRpikeeIpAddress.gridy = 0;
		getContentPane().add(lblRpikeeIpAddress, gbc_lblRpikeeIpAddress);

		txtLocalhost = new JTextField();
		txtLocalhost.setText("localhost");
		GridBagConstraints gbc_txtLocalhost = new GridBagConstraints();
		gbc_txtLocalhost.insets = new Insets(0, 0, 5, 0);
		gbc_txtLocalhost.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLocalhost.gridx = 2;
		gbc_txtLocalhost.gridy = 0;
		getContentPane().add(txtLocalhost, gbc_txtLocalhost);
		txtLocalhost.setColumns(10);

		JLabel lblConnectionPort = new JLabel("Connection Port");
		GridBagConstraints gbc_lblConnectionPort = new GridBagConstraints();
		gbc_lblConnectionPort.anchor = GridBagConstraints.EAST;
		gbc_lblConnectionPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblConnectionPort.gridx = 1;
		gbc_lblConnectionPort.gridy = 1;
		getContentPane().add(lblConnectionPort, gbc_lblConnectionPort);

		txtPort = new JTextField();
		txtPort.setText("6524");
		GridBagConstraints gbc_txtPort = new GridBagConstraints();
		gbc_txtPort.insets = new Insets(0, 0, 5, 0);
		gbc_txtPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPort.gridx = 2;
		gbc_txtPort.gridy = 1;
		getContentPane().add(txtPort, gbc_txtPort);
		txtPort.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 2;
		getContentPane().add(panel, gbc_panel);
		
		txtLocalhost.setText(Client.getIP_address());
		txtPort.setText(String.valueOf(Client.getConnection_port()));

		JButton btnOk = new JButton("OK");

		panel.add(btnOk);

		JButton btnCancel = new JButton("Cancel");

		panel.add(btnCancel);

		btnCancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnCancelClick(e);
			}
		});
		btnOk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnOkClick(e);
			}
		});
	}

	private void btnCancelClick(ActionEvent e)
	{
		this.dispose();
	}

	private void btnOkClick(ActionEvent e)
	{
		Client.setIP_address(txtLocalhost.getText());
		Client.setConnection_port(Integer.parseInt(txtPort.getText()));
		this.dispose();
	}
}

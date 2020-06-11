package com.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

import com.dao.addSubscriptionDAOImpl;
import com.modal.addSubscriptionImpl;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class createSubscriptionScreen {

	private JFrame frame;
	private JTextField SDate;
	private JTextField EDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createSubscriptionScreen window = new createSubscriptionScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public createSubscriptionScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 515, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateSubscription = new JLabel("Create Subscription");
		lblCreateSubscription.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCreateSubscription.setBounds(177, 11, 146, 27);
		frame.getContentPane().add(lblCreateSubscription);
		
		JLabel lblSubscriptionType = new JLabel("Subscription Type: ");
		lblSubscriptionType.setBounds(85, 108, 111, 14);
		frame.getContentPane().add(lblSubscriptionType);
		
		JComboBox subType = new JComboBox();
		subType.setModel(new DefaultComboBoxModel(new String[] {"Daily", "Weekly", "Monthly"}));
		subType.setBounds(245, 105, 104, 20);
		frame.getContentPane().add(subType);
		
		JLabel lblNewLabel = new JLabel("Start Date: ");
		lblNewLabel.setBounds(128, 177, 68, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEndDate = new JLabel("End Date: ");
		lblEndDate.setBounds(128, 244, 68, 14);
		frame.getContentPane().add(lblEndDate);
		
		SDate = new JTextField();
		SDate.setBounds(245, 174, 104, 20);
		frame.getContentPane().add(SDate);
		SDate.setColumns(10);
		
		EDate = new JTextField();
		EDate.setBounds(245, 241, 104, 20);
		frame.getContentPane().add(EDate);
		EDate.setColumns(10);
		
		JLabel errLbl = new JLabel("");
		errLbl.setBounds(185, 316, 245, 14);
		frame.getContentPane().add(errLbl);
		
		addSubscriptionImpl subVal = new addSubscriptionImpl();
		addSubscriptionDAOImpl subDao = new addSubscriptionDAOImpl();
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: Production Code
				if(SDate.getText().length()==0 || EDate.getText().length()==0) {
					errLbl.setText("Incomplete Fields");
				}
				else if(!subVal.validSubType(subType.getSelectedItem().toString())) {
					errLbl.setText("Please select valid type");
				}
				else if(!subVal.validDates(SDate.getText(), EDate.getText())) {
					errLbl.setText("Please enter valid dates");
				}
				else {
					if(subDao.addSubscription(subType.getSelectedItem().toString(), SDate.getText(), EDate.getText())) {
						errLbl.setText("Subscription Added");
					}
					else {
						errLbl.setText("System Error: For the moment system cannot add subscription");
					}
				}
			}
		});
		btnCreate.setBounds(197, 355, 89, 23);
		frame.getContentPane().add(btnCreate);
		
		JLabel lblFormatDdmmyyyy = new JLabel("Format: dd/mm/yyyy");
		lblFormatDdmmyyyy.setBounds(367, 177, 122, 14);
		frame.getContentPane().add(lblFormatDdmmyyyy);
		
		JLabel label = new JLabel("Format: dd/mm/yyyy");
		label.setBounds(367, 244, 122, 14);
		frame.getContentPane().add(label);
		
		
		
		
	}
}

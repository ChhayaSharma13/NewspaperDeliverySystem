package com.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.dao.readSubscriptionDao;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class readSubscriptionScreen {

	private JFrame frame;
	private JTextField idTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					readSubscriptionScreen window = new readSubscriptionScreen();
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
	public readSubscriptionScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(57, 52, 68, 13);
		frame.getContentPane().add(lblNewLabel);
		
		idTxt = new JTextField();
		idTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idTxt.setBounds(168, 51, 153, 19);
		frame.getContentPane().add(idTxt);
		idTxt.setColumns(10);
		
		readSubscriptionDao rSubDao = new readSubscriptionDao();
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBounds(121, 80, 85, 21);
		frame.getContentPane().add(btnSearch);
		
		JLabel typeLabel = new JLabel("");
		typeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		typeLabel.setBounds(57, 129, 264, 13);
		frame.getContentPane().add(typeLabel);
		
		JLabel startDateLabel = new JLabel("");
		startDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		startDateLabel.setBounds(57, 157, 264, 13);
		frame.getContentPane().add(startDateLabel);
		
		JLabel endDateLabel = new JLabel("");
		endDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		endDateLabel.setBounds(57, 185, 264, 13);
		frame.getContentPane().add(endDateLabel);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		errorLabel.setBounds(57, 211, 264, 13);
		frame.getContentPane().add(errorLabel);
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(idTxt.getText());
				if(idTxt.getText().length() == 0) {
					// throw error for entering invalid id
					errorLabel.setText("Please enter valid id !!");
				}
				else if(!rSubDao.readSusbcription(id)[0].equals("false")) {
					String[] res =rSubDao.readSusbcription(id);
					typeLabel.setText("Type = " + res[1]);
					startDateLabel.setText("Start date = "+ res[2]);
					endDateLabel.setText("End Date = " + res[3]);
				}
				else {
					// id not present
					errorLabel.setText("Id not found !");
				}
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("Read Subscription");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(120, 20, 201, 13);
		frame.getContentPane().add(lblNewLabel_1);
	}
}

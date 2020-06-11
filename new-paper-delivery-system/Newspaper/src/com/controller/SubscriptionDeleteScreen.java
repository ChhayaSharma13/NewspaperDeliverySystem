package com.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.dao.RegisterMethods;
import com.dao.SubscriptionDeleteMethod;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubscriptionDeleteScreen {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubscriptionDeleteScreen window = new SubscriptionDeleteScreen();
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
	public SubscriptionDeleteScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 708, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseInputThe = new JLabel("Please input the subscription id you want to delete:");
		lblPleaseInputThe.setFont(new Font("Arial Unicode MS", Font.BOLD, 25));
		lblPleaseInputThe.setBounds(15, 29, 656, 44);
		frame.getContentPane().add(lblPleaseInputThe);
		
		textField = new JTextField();
		textField.setBounds(15, 85, 135, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.valueOf(textField.getText());	
				
				try {
					
					SubscriptionDeleteMethod.delete(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		
		});
		btnNewButton.setBounds(15, 138, 123, 29);
		frame.getContentPane().add(btnNewButton);
	}
}

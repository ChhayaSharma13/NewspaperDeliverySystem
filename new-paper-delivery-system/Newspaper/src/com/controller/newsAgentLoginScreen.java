package com.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.dao.newsAgentLoginDAO;
import com.dao.newsAgentRegisterDAO;
import com.modal.newsAgentLoginImpl;
import com.modal.newsAgentRegistrationValidateImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class newsAgentLoginScreen {

	private JFrame frame;
	private JTextField usernameTxt;
	private JPasswordField pswdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newsAgentLoginScreen window = new newsAgentLoginScreen();
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
	public newsAgentLoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(205, 154, 46, 13);
		frame.getContentPane().add(label);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(75, 86, 75, 13);
		frame.getContentPane().add(lblUsername);
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(191, 85, 148, 19);
		frame.getContentPane().add(usernameTxt);
		usernameTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(75, 125, 75, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Newspaper Delivery System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(86, 37, 279, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setBounds(108, 212, 247, 13);
		frame.getContentPane().add(errorLabel);
		
		newsAgentLoginImpl validate1 = new newsAgentLoginImpl();
		newsAgentLoginDAO dao1 = new newsAgentLoginDAO();
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validate1.validateUsername(usernameTxt.getText()).equals("Please enter correct username!")) {
					errorLabel.setText("Please enter correct username!");
				}
				else if(validate1.validatePassword(pswdTxt.getText()).equals("Please enter correct password!")) {
					errorLabel.setText("Please enter correct password!");
				}
				else {
					if(dao1.Login(usernameTxt.getText(), pswdTxt.getText())) {
						errorLabel.setText("Login Successful");
					}
					else {
						errorLabel.setText("Username or Password does not match");
					}
				}
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginButton.setBounds(166, 173, 85, 21);
		frame.getContentPane().add(loginButton);
		
		pswdTxt = new JPasswordField();
		pswdTxt.setBounds(191, 124, 148, 19);
		frame.getContentPane().add(pswdTxt);
		
		
	}
}

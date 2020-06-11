package com.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dao.newsAgentRegisterDAO;
import com.modal.newsAgentRegistrationValidateImpl;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class newsAgentRegistrationScreen {

	private JFrame frame;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfPhone;
	private JPasswordField tfPass;
	private JPasswordField tfCPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newsAgentRegistrationScreen window = new newsAgentRegistrationScreen();
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
	public newsAgentRegistrationScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 523, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewsagentRegistration = new JLabel("Newsagent Registration");
		lblNewsagentRegistration.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewsagentRegistration.setBounds(178, 11, 159, 47);
		frame.getContentPane().add(lblNewsagentRegistration);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(75, 99, 62, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(75, 154, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(75, 212, 46, 14);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(75, 270, 62, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(75, 333, 107, 14);
		frame.getContentPane().add(lblConfirmPassword);
		
		tfName = new JTextField();
		tfName.setBounds(209, 96, 146, 20);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(209, 151, 146, 20);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		tfPhone = new JTextField();
		tfPhone.setBounds(209, 209, 146, 20);
		frame.getContentPane().add(tfPhone);
		tfPhone.setColumns(10);
		
		JLabel errLbl = new JLabel("");
		errLbl.setBounds(72, 371, 389, 14);
		frame.getContentPane().add(errLbl);
		
		newsAgentRegistrationValidateImpl validate = new newsAgentRegistrationValidateImpl();
		newsAgentRegisterDAO dao = new newsAgentRegisterDAO();
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: Production code for Registration
				long phNo = 0;
				if(tfPhone.getText().length() > 0) {
					phNo = Long.parseLong(tfPhone.getText());
				}
				
				if(tfName.getText().equals("") || tfEmail.getText().equals("") || tfPhone.getText().equals("") || tfPass.getText().equals("") || tfCPass.getText().equals("")) {
					errLbl.setText("Fields Incomplete");
				}
				else if(validate.validateUsername(tfName.getText()).equals("Please enter a valid username")) {
					errLbl.setText("Please enter a valid username");
				}
				else if(validate.validateEmail(tfEmail.getText()).equals("Invalid email format!")) {
					errLbl.setText("Invalid email format!");
				}
				else if(validate.validatePassword(tfPass.getText()).equals("Please enter a strong password")) {
					errLbl.setText("Please enter a strong password");
				}
				else if(!tfPass.getText().equals(tfCPass.getText())) {
					errLbl.setText("Password and Confirm Password are different");
				}
				else if(validate.validatePhone(phNo).equals("Invalid phone no")) {
					errLbl.setText("Invalid phone no");
				}
				else {
					if(dao.Register(tfName.getText(), tfEmail.getText(), phNo, tfPass.getText())) {
						errLbl.setText("Registration Successful");
					}
					else {
						errLbl.setText("System Error: For the moment system cannot register Newsagent");
					}
				}
			}
		});
		btnRegister.setBounds(208, 407, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(209, 267, 146, 20);
		frame.getContentPane().add(tfPass);
		
		tfCPass = new JPasswordField();
		tfCPass.setBounds(209, 330, 146, 20);
		frame.getContentPane().add(tfCPass);
		
		
	}
}

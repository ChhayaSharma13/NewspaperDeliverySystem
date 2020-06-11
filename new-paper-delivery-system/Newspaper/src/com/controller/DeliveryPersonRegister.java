package com.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.dao.RegisterMethods;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class DeliveryPersonRegister {

	private JFrame frmDeliverypersonregister;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel username_invaild;
	private JLabel lblPasswordIsInvaild;
	private JLabel lblWarningconfirmPasswordIs;
	private JLabel lblEmailsFormatIs;
	private JLabel lblNewLabel_4;
	private JLabel lblRegistSuccess;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryPersonRegister window = new DeliveryPersonRegister();
					window.frmDeliverypersonregister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeliveryPersonRegister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeliverypersonregister = new JFrame();
		frmDeliverypersonregister.setTitle("DeliveryPersonRegister");
		frmDeliverypersonregister.setBounds(100, 100, 712, 480);
		frmDeliverypersonregister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeliverypersonregister.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("name:");
		lblName.setFont(new Font("Arial Unicode MS", Font.PLAIN, 25));
		lblName.setBounds(30, 40, 81, 30);
		frmDeliverypersonregister.getContentPane().add(lblName);		

		username_invaild = new JLabel("username is invaild");
		username_invaild.setForeground(Color.RED);
		username_invaild.setBounds(280, 48, 234, 21);
		username_invaild.setVisible(false);
		frmDeliverypersonregister.getContentPane().add(username_invaild);
		
		JLabel lblNewLabel = new JLabel("password:");
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 25));
		lblNewLabel.setBounds(30, 94, 130, 38);
		frmDeliverypersonregister.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("email:");
		lblNewLabel_1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(30, 258, 81, 21);
		frmDeliverypersonregister.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("phone:");
		lblNewLabel_2.setFont(new Font("Arial Unicode MS", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(30, 325, 81, 38);
		frmDeliverypersonregister.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(110, 45, 140, 27);
		frmDeliverypersonregister.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(110, 258, 140, 27);
		frmDeliverypersonregister.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		lblPasswordIsInvaild = new JLabel("password is invaild");
		lblPasswordIsInvaild.setForeground(Color.RED);
		lblPasswordIsInvaild.setBounds(309, 109, 242, 21);
		lblPasswordIsInvaild.setVisible(false);
		frmDeliverypersonregister.getContentPane().add(lblPasswordIsInvaild);
		
		lblWarningconfirmPasswordIs = new JLabel("warning:confirm password is different with password");
		lblWarningconfirmPasswordIs.setForeground(Color.RED);
		lblWarningconfirmPasswordIs.setBounds(443, 185, 234, 30);
		lblWarningconfirmPasswordIs.setVisible(false);
		frmDeliverypersonregister.getContentPane().add(lblWarningconfirmPasswordIs);
		
		lblEmailsFormatIs = new JLabel("email's format is invaid");
		lblEmailsFormatIs.setForeground(Color.RED);
		lblEmailsFormatIs.setBounds(276, 261, 238, 21);
		lblEmailsFormatIs.setVisible(false);
		frmDeliverypersonregister.getContentPane().add(lblEmailsFormatIs);
		
		lblNewLabel_4 = new JLabel("phone number is invalid");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(311, 337, 240, 21);
		lblNewLabel_4.setVisible(false);
		frmDeliverypersonregister.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("confirm password:");
		lblNewLabel_3.setFont(new Font("Arial Unicode MS", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(30, 178, 220, 38);
		frmDeliverypersonregister.getContentPane().add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(126, 331, 180, 27);
		frmDeliverypersonregister.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		lblRegistSuccess = new JLabel("regist success!");
		lblRegistSuccess.setForeground(new Color(154, 205, 50));
		lblRegistSuccess.setBounds(280, 383, 202, 21);
		lblRegistSuccess.setVisible(false);
		frmDeliverypersonregister.getContentPane().add(lblRegistSuccess);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRegistSuccess.setVisible(false);
				String name = textField.getText();
				String pwd = passwordField.getText();
				String repwd = passwordField_1.getText();
				String email = textField_3.getText();
				String phone = textField_4.getText();
				if(name.equals("")) {
//					System.out.println("name is invaild");
					username_invaild.setVisible(true);
					return;
				} else {
//					System.out.println("name is vaild");
					username_invaild.setVisible(false);
				}
				if(pwd.equals("")) {
//					System.out.println("password is invaild");
					lblPasswordIsInvaild.setVisible(true);
					return;
				} else {
//					System.out.println("password is vaild");
					lblPasswordIsInvaild.setVisible(false);
				}
				if (!pwd.equals(repwd)|| repwd.equals("")) {
//					System.out.println("confirm password is different with password");
					lblWarningconfirmPasswordIs.setVisible(true);
					return;
				} else {
//					System.out.println("password correct");
					lblWarningconfirmPasswordIs.setVisible(false);
				}
				if (!email.contains("@")) {
					lblEmailsFormatIs.setVisible(true);
					return;
				} else {
					lblEmailsFormatIs.setVisible(false);
				}
				if (phone.length() != 9) {
					lblNewLabel_4.setVisible(true);
					return;
				} else {
					lblNewLabel_4.setVisible(false);
				}
				try {
					RegisterMethods.regist(name, pwd, email, phone);
					lblRegistSuccess.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Arial Unicode MS", Font.PLAIN, 25));
		btnNewButton.setBounds(127, 371, 123, 38);
		frmDeliverypersonregister.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(152, 101, 140, 30);
		frmDeliverypersonregister.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(248, 180, 148, 30);
		frmDeliverypersonregister.getContentPane().add(passwordField_1);
		
		
		
		
		
		
	}
}

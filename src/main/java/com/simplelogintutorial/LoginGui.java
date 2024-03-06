package com.simplelogintutorial;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jiro Mendador
 */
public class LoginGui implements ActionListener {
    //in this class we will set up out gui
    
    //declare variables here
    JFrame loginFrame; 
    JPanel loginPanel;
    JLabel loginTitleLabel, loginUsernameLabel, loginPasswordLabel;
    JTextField loginUsernameField;
    JPasswordField loginPasswordField;
    JButton loginButton;
    
    //create a constructor of the class
    //this is where you initialize the variables
    public LoginGui() {
        loginFrame = new JFrame();
        loginPanel = new JPanel();
        loginTitleLabel = new JLabel();
        loginUsernameLabel = new JLabel();
        loginPasswordLabel = new JLabel();
        loginUsernameField = new JTextField();
        loginPasswordField = new JPasswordField();
        loginButton = new JButton();
    }
    
    //create another function to set the properties of components
    public void setLoginGuiProperties() {
        //Labels
        loginTitleLabel.setText("LOGIN YOUR ACCOUNT");
        loginTitleLabel.setForeground(Color.white);
        loginTitleLabel.setFont(new Font("Dialogue", Font.BOLD, 20));
        loginTitleLabel.setBounds(130, 15, 300, 50);

        //to make coding faster you can just copy the properties then rename the variable
        //then adjust properties
        loginUsernameLabel.setText("USERNAME");
        loginUsernameLabel.setForeground(Color.white);
        loginUsernameLabel.setFont(new Font("Dialogue", Font.BOLD, 15));
        loginUsernameLabel.setBounds(100, 75, 300, 50);
        

        loginPasswordLabel.setText("PASSWORD");
        loginPasswordLabel.setForeground(Color.white);
        loginPasswordLabel.setFont(new Font("Dialogue", Font.BOLD, 15));
        loginPasswordLabel.setBounds(100, 125, 300, 50);
        
        //textfields
        loginUsernameField.setBounds(200, 90, 200, 25);
        
        //passwordfields
        loginPasswordField.setBounds(200, 135, 200, 25);
        loginPasswordField.setEchoChar('*');
        
        //buttons
        loginButton.setText("LOGIN");
        loginButton.setBackground(Color.ORANGE);
        loginButton.setForeground(Color.white);
        loginButton.setFont(new Font("Dialogue",Font.BOLD, 18));
        loginButton.setBounds(100, 170, 300, 40);
        loginButton.addActionListener(this);
        
        //panels
        loginPanel.setBackground(Color.BLACK);
        loginPanel.setLayout(null);
        
        //adding components to jpanel
        loginPanel.add(loginTitleLabel);
        loginPanel.add(loginUsernameLabel);
        loginPanel.add(loginPasswordLabel);
        loginPanel.add(loginUsernameField);
        loginPanel.add(loginPasswordField);
        loginPanel.add(loginButton);
        
        //adding jpanel to frame
        loginFrame.add(loginPanel);
        
        //frame
        loginFrame.setTitle("Simple Login Tutorial");
        loginFrame.setSize(500, 300);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            String enteredUsername = loginUsernameField.getText();
            String enteredPassword = new String(loginPasswordField.getPassword());
            
            if(enteredUsername.isBlank() || enteredPassword.isBlank()) {
                JOptionPane.showMessageDialog(loginPanel,"Please Enter A Username And Password",
                        "Empty Fields",0);
            } else {
                Validator validator = new Validator(enteredUsername, enteredPassword);
                if(validator.validate()) {
                    JOptionPane.showMessageDialog(loginPanel,"Login Success!!!");
                } else {
                     JOptionPane.showMessageDialog(loginPanel,"Incorrect Username Or Password",
                        "Invalid Login Credentials",0);
                }
            }
        }
    }
}

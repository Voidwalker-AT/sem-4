// Experiment 16: GUI Programming Using Swing
// 1. Design a login form with validation.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginForm extends JFrame implements ActionListener
{
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, resetButton;
    JLabel messageLabel;
    
    LoginForm()
    {
        setTitle("Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);
        
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(resetButton);
        add(messageLabel);
        
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == loginButton)
        {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            
            if(username.isEmpty() || password.isEmpty())
            {
                messageLabel.setText("All fields are required!");
            }
            else if(username.length() < 5)
            {
                messageLabel.setText("Username must be at least 5 characters!");
            }
            else if(password.length() < 6)
            {
                messageLabel.setText("Password must be at least 6 characters!");
            }
            else
            {
                messageLabel.setText("Login Successful!");
                messageLabel.setForeground(Color.GREEN);
            }
        }
        else if(e.getSource() == resetButton)
        {
            usernameField.setText("");
            passwordField.setText("");
            messageLabel.setText("");
        }
    }
}

public class exe10_1
{
    public static void main(String args[])
    {
        new LoginForm();
    }
}
//Observation: This program creates a login form using Swing with username and password fields. It validates that all fields are filled, username is at least 5 characters, and password is at least 6 characters. The form displays appropriate error messages using a label.

// Experiment 16: GUI Programming Using Swing
// 3. Develop a student registration form with event handling.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class StudentRegistrationForm extends JFrame implements ActionListener
{
    JTextField rollNoField, nameField, emailField;
    JComboBox<String> courseCombo;
    JCheckBox maleRadio, femaleRadio;
    JTextArea displayArea;
    JButton submitButton, clearButton;
    
    StudentRegistrationForm()
    {
        setTitle("Student Registration Form");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Roll Number
        formPanel.add(new JLabel("Roll Number:"));
        rollNoField = new JTextField();
        formPanel.add(rollNoField);
        
        // Name
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);
        
        // Course
        formPanel.add(new JLabel("Course:"));
        String[] courses = {"CSE", "ECE", "ME", "CE", "EE"};
        courseCombo = new JComboBox<>(courses);
        formPanel.add(courseCombo);
        
        // Gender
        formPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        maleRadio = new JCheckBox("Male");
        femaleRadio = new JCheckBox("Female");
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        formPanel.add(genderPanel);
        
        // Email
        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);
        
        // Buttons
        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        formPanel.add(buttonPanel);
        
        add(formPanel, BorderLayout.NORTH);
        
        // Display Area
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createTitledBorder("Registered Students"));
        
        displayArea = new JTextArea(15, 40);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        JScrollPane scrollPane = new JScrollPane(displayArea);
        displayPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(displayPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submitButton)
        {
            String rollNo = rollNoField.getText();
            String name = nameField.getText();
            String course = (String)courseCombo.getSelectedItem();
            String gender = maleRadio.isSelected() ? "Male" : (femaleRadio.isSelected() ? "Female" : "Not Selected");
            String email = emailField.getText();
            
            if(rollNo.isEmpty() || name.isEmpty() || email.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                String record = "Roll No: " + rollNo + " | Name: " + name + " | Course: " + course + 
                               " | Gender: " + gender + " | Email: " + email + "\n";
                displayArea.append(record);
                JOptionPane.showMessageDialog(this, "Student Registered Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(e.getSource() == clearButton)
        {
            rollNoField.setText("");
            nameField.setText("");
            emailField.setText("");
            maleRadio.setSelected(false);
            femaleRadio.setSelected(false);
            courseCombo.setSelectedIndex(0);
        }
    }
}

public class exe10_3
{
    public static void main(String args[])
    {
        new StudentRegistrationForm();
    }
}
//Observation: This program creates a student registration form with fields for roll number, name, course, gender, and email. It includes event handling for submit and clear buttons, validation of fields, and displays registered students in a text area with scrollable view.

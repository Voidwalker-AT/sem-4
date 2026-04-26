// Experiment 16: GUI Programming Using Swing
// 4. Implement a mini dashboard UI (menu + buttons).
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DashboardUI extends JFrame implements ActionListener
{
    JLabel statusLabel;
    JTextArea infoArea;
    
    DashboardUI()
    {
        setTitle("Mini Dashboard");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        exitItem.addActionListener(this);
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(this);
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        
        setJMenuBar(menuBar);
        
        // Top Panel with Status
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(70, 130, 180));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel titleLabel = new JLabel("Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel);
        
        add(topPanel, BorderLayout.NORTH);
        
        // Center Panel with Buttons
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2, 15, 15));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JButton studentsButton = new JButton("View Students");
        JButton coursesButton = new JButton("View Courses");
        JButton reportsButton = new JButton("View Reports");
        JButton settingsButton = new JButton("Settings");
        
        studentsButton.setFont(new Font("Arial", Font.PLAIN, 16));
        coursesButton.setFont(new Font("Arial", Font.PLAIN, 16));
        reportsButton.setFont(new Font("Arial", Font.PLAIN, 16));
        settingsButton.setFont(new Font("Arial", Font.PLAIN, 16));
        
        studentsButton.addActionListener(this);
        coursesButton.addActionListener(this);
        reportsButton.addActionListener(this);
        settingsButton.addActionListener(this);
        
        centerPanel.add(studentsButton);
        centerPanel.add(coursesButton);
        centerPanel.add(reportsButton);
        centerPanel.add(settingsButton);
        
        add(centerPanel, BorderLayout.CENTER);
        
        // Bottom Panel with Info Area and Status
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        infoArea = new JTextArea(8, 50);
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        infoArea.setText("Welcome to Dashboard!\n\nClick on buttons or use menu to navigate.");
        
        JScrollPane scrollPane = new JScrollPane(infoArea);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);
        
        statusLabel = new JLabel("Status: Ready");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        bottomPanel.add(statusLabel, BorderLayout.SOUTH);
        
        add(bottomPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        
        switch(command)
        {
            case "View Students":
                infoArea.setText("Viewing Students List:\n\n");
                infoArea.append("1. Anmol Thapliyal - CSE\n");
                infoArea.append("2. Rahul Singh - ECE\n");
                infoArea.append("3. Priya Sharma - ME\n");
                statusLabel.setText("Status: Students Loaded");
                break;
                
            case "View Courses":
                infoArea.setText("Available Courses:\n\n");
                infoArea.append("1. Computer Science and Engineering\n");
                infoArea.append("2. Electronics and Communication\n");
                infoArea.append("3. Mechanical Engineering\n");
                statusLabel.setText("Status: Courses Loaded");
                break;
                
            case "View Reports":
                infoArea.setText("Monthly Reports:\n\n");
                infoArea.append("January: 95% Attendance\n");
                infoArea.append("February: 92% Attendance\n");
                infoArea.append("March: 98% Attendance\n");
                statusLabel.setText("Status: Reports Loaded");
                break;
                
            case "Settings":
                infoArea.setText("System Settings:\n\n");
                infoArea.append("Theme: Dark\n");
                infoArea.append("Language: English\n");
                infoArea.append("Font Size: 12\n");
                statusLabel.setText("Status: Settings Opened");
                break;
                
            case "New":
                infoArea.setText("New item created.\n");
                statusLabel.setText("Status: New item created");
                break;
                
            case "Open":
                infoArea.setText("Open dialog would appear here.\n");
                statusLabel.setText("Status: Open dialog");
                break;
                
            case "Exit":
                System.exit(0);
                break;
                
            case "About":
                JOptionPane.showMessageDialog(this, "Dashboard v1.0\nEducational Management System", "About", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
}

public class exe10_4
{
    public static void main(String args[])
    {
        new DashboardUI();
    }
}
//Observation: This program creates a mini dashboard UI with a menu bar (File, Help), multiple buttons (Students, Courses, Reports, Settings), and an information area that displays content based on button clicks or menu selections. It includes a status bar and proper event handling.

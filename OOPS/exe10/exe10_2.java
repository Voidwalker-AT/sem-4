// Experiment 16: GUI Programming Using Swing
// 2. Create a calculator GUI application.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalculatorApp extends JFrame implements ActionListener
{
    JTextField equationDisplay;
    JTextField resultDisplay;
    JButton[] numberButtons = new JButton[10];
    JButton[] operationButtons = new JButton[4];
    JButton equalsButton, clearButton, deleteButton;
    
    double firstNumber = 0;
    String operation = "";
    String equation = "";
    boolean newNumber = true;
    
    CalculatorApp()
    {
        setTitle("Calculator");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Display Panel with two text fields
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(2, 1, 5, 5));
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel equationLabel = new JLabel("Equation:");
        equationDisplay = new JTextField();
        equationDisplay.setFont(new Font("Arial", Font.PLAIN, 18));
        equationDisplay.setEditable(false);
        equationDisplay.setText("0");
        
        JLabel resultLabel = new JLabel("Result:");
        resultDisplay = new JTextField();
        resultDisplay.setFont(new Font("Arial", Font.PLAIN, 24));
        resultDisplay.setEditable(false);
        resultDisplay.setText("0");
        resultDisplay.setBackground(Color.YELLOW);
        resultDisplay.setOpaque(true);
        
        displayPanel.add(equationLabel);
        displayPanel.add(equationDisplay);
        displayPanel.add(resultLabel);
        displayPanel.add(resultDisplay);
        
        add(displayPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        
        // Number buttons
        for(int i = 0; i < 10; i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
        }
        
        // Operation buttons
        String[] operations = {"+", "-", "*", "/"};
        for(int i = 0; i < 4; i++)
        {
            operationButtons[i] = new JButton(operations[i]);
            operationButtons[i].addActionListener(this);
            operationButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
        }
        
        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        
        clearButton = new JButton("C");
        clearButton.addActionListener(this);
        clearButton.setFont(new Font("Arial", Font.PLAIN, 18));
        
        deleteButton = new JButton("DEL");
        deleteButton.addActionListener(this);
        deleteButton.setFont(new Font("Arial", Font.PLAIN, 18));
        
        // Add buttons to panel
        buttonPanel.add(clearButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(operationButtons[0]); // +
        
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(operationButtons[1]); // -
        
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(operationButtons[2]); // *
        
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(equalsButton);
        buttonPanel.add(operationButtons[3]); // /
        
        add(buttonPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        
        for(int i = 0; i < 10; i++)
        {
            if(source == numberButtons[i])
            {
                if(newNumber)
                {
                    resultDisplay.setText(String.valueOf(i));
                    newNumber = false;
                }
                else
                {
                    resultDisplay.setText(resultDisplay.getText() + i);
                }
            }
        }
        
        for(int i = 0; i < 4; i++)
        {
            if(source == operationButtons[i])
            {
                firstNumber = Double.parseDouble(resultDisplay.getText());
                operation = String.valueOf(e.getActionCommand());
                equation = firstNumber + " " + operation;
                equationDisplay.setText(equation);
                resultDisplay.setText("");
                newNumber = true;
            }
        }
        
        if(source == equalsButton)
        {
            double secondNumber = Double.parseDouble(resultDisplay.getText());
            double result = 0;
            
            switch(operation)
            {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
            }
            
            equation = firstNumber + " " + operation + " " + secondNumber + " =";
            equationDisplay.setText(equation);
            resultDisplay.setText(String.valueOf(result));
            newNumber = true;
        }
        
        if(source == clearButton)
        {
            resultDisplay.setText("0");
            equationDisplay.setText("0");
            firstNumber = 0;
            operation = "";
            equation = "";
            newNumber = true;
        }
        
        if(source == deleteButton)
        {
            String text = resultDisplay.getText();
            if(text.length() > 0)
                resultDisplay.setText(text.substring(0, text.length() - 1));
        }
    }
}

public class exe10_2
{
    public static void main(String args[])
    {
        new CalculatorApp();
    }
}
//Observation: This program creates a calculator GUI using Swing with number buttons, operation buttons (+, -, *, /), equals button, clear button, and delete button. It performs basic arithmetic operations and displays the result on a text field.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculatorGUI extends JFrame {
    private JTextField[] marksFields;
    private JButton calculateButton;
    private JFrame resultFrame; // New JFrame for displaying the result

    public GradeCalculatorGUI(int numSubjects) {
        setTitle("Grade Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(numSubjects, 2));
        marksFields = new JTextField[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            JLabel label = new JLabel("Subject " + (i + 1) + " Marks (out of 100):");
            marksFields[i] = new JTextField(5);
            inputPanel.add(label);
            inputPanel.add(marksFields[i]);
        }

        add(inputPanel, BorderLayout.CENTER);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        add(calculateButton, BorderLayout.SOUTH);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int totalMarks = 0;
            int numSubjects = marksFields.length;

            for (int i = 0; i < numSubjects; i++) {
                try {
                    int marks = Integer.parseInt(marksFields[i].getText());
                    if (marks < 0 || marks > 100) {
                        JOptionPane.showMessageDialog(null, "Invalid marks! Marks should be between 0 and 100.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    totalMarks += marks;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            double averagePercentage = (double) totalMarks / numSubjects;
            char grade;

            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            // Create a new JFrame for displaying the result with a larger size
            resultFrame = new JFrame("Result");
            resultFrame.setSize(500, 150); // Adjust the size as needed
            resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            resultFrame.setLocationRelativeTo(null);

            JLabel resultLabel = new JLabel("Total Marks: " + totalMarks + " | Average Percentage: " + averagePercentage + "% | Grade: " + grade);
            resultLabel.setHorizontalAlignment(JLabel.CENTER);
            resultFrame.add(resultLabel);

            resultFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int numSubjects = 5; // Change this to the desired number of subjects
            GradeCalculatorGUI calculator = new GradeCalculatorGUI(numSubjects);
            calculator.setVisible(true);
        });
    }
}

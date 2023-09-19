import java.util.Scanner;

public class GradeCalculatorMenuBased {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Grade Calculator Menu:");
            System.out.println("1. Calculate Grades");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calculateGrades(scanner);
                    break;
                case 2:
                    System.out.println("CLOSING THE CALCULATOR");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void calculateGrades(Scanner scanner) {
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;
        double averagePercentage;
        char grade;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks (out of 100) for subject " + i + ": ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Marks should be between 0 and 100.");
                return;
            }

            totalMarks += marks;
        }

        averagePercentage = (double) totalMarks / numSubjects;

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

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        // Ask the user if they want to calculate grades for more sets of subjects
        System.out.print("Calculate grades for more subjects (yes/no): ");
        String choice = scanner.next().toLowerCase();

        if (!choice.equals("yes")) {
            System.out.println("Goodbye!");
            scanner.close();
            System.exit(0);
        }
    }
}

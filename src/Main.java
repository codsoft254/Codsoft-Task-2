import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // records
    record Subject(int marks) {

    }

    // Grade Enum
    enum Grade {
        A, B, C, D, E, F
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Input: Take marks obtained (out of 100) in each subject.
        //Calculate Total Marks: Sum up the marks obtained in all subjects.
        //Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
        //average percentage.
        //Grade Calculation: Assign grades based on the average percentage achieved.
        //Display Results: Show the total marks, average percentage, and the corresponding grade to the user



        //CODSOFT TASK 2.
        int totalSubjects;
        int totalMarks = 0;
        double averagePercentage;

        do {
            try {
                //feed in the number of subjects.
                System.out.print("Enter the number of subjects: ");
                totalSubjects = scanner.nextInt();

                if (totalSubjects <= 0) {
                    System.out.println("Hey! Enter The Correct Number Of Subjects!\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer for the number of subjects.");
                //clears the input buffer to avoid an infinite loop caused by the incorrect input.
                scanner.nextLine();
                //assigns zero to totalSubjects to reset the value
                totalSubjects = 0;
            }
        } while (totalSubjects <= 0);

        // Loop to input marks for each subject
        for (int i = 1; i <= totalSubjects; ++i) {
            int marks;


            do {
                try {
                    //input marks for each subject
                    System.out.print("Enter marks for subject " + i + ": ");
                    marks = scanner.nextInt();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Please enter the correct marks!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a correct integer for marks.");
                    //use the correct input
                    scanner.nextLine();
                    marks = -1;
                }
            } while (marks < 0 || marks > 100);

            // Create a Subject record and add marks to totalMarks
            totalMarks += new Subject(marks).marks();
        }

        // Average % calculation
        averagePercentage = (double) totalMarks / totalSubjects;

        // Display Results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");

        // Grading!
        Grade grade;
        if (averagePercentage >= 90) {
            grade = Grade.A;
        } else if (averagePercentage >= 80) {
            grade = Grade.B;
        } else if (averagePercentage >= 70) {
            grade = Grade.C;
        } else if (averagePercentage >= 60) {
            grade = Grade.D;
        } else if (averagePercentage >= 50) {
            grade= Grade.E;

        } else {
            grade = Grade.F;
        }

        // Grade Display!
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
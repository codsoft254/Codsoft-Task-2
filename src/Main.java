import java.util.Scanner;

public class Main {

    //ENUM DEFINED!
    enum Grade{
        A , B ,C , D , E , F
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

//        Input: Take marks obtained (out of 100) in each subject.
//        Calculate Total Marks: Sum up the marks obtained in all subjects.
//        Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
//        average percentage.
//        Grade Calculation: Assign grades based on the average percentage achieved.
//        Display Results: Show the total marks, average percentage, and the corresponding grade to the user


        //COD + SOFT TASK 2.
        int totalMarks = 0;


        System.out.println("Enter marks obtained in the following subjects:");

        //initializing an array of subjects
        String[] subjects = {"Math", "Physics", "Biology", "Chemistry", "Agriculture", "Business Studies", "Computer Studies"};

        for (int i = 0; i < subjects.length; i++) {
            //accessing each subject in the array during iteration
            System.out.print("Enter marks obtained in " + subjects[i] + ": ");
            try {
                int marks = scan.nextInt();
                //if the input is less than or greater than 100,
                //the loop will break
                if (marks < 0 || marks >100){
                    System.out.println("Please provide marks that are within the range of 1% to 100%.");
                    break;

                }else {

                    totalMarks += marks;
                }

            } catch (Exception e) {
                //System.out.println(e.getMessage());
                System.out.println("Invalid Marks!");
                break;
            }

        }

        double average = (double) totalMarks / subjects.length;
        System.out.println("\nResults:");
        System.out.println("Total Marks obtained: " + totalMarks);

        System.out.println("Average percentage = " + String.format( "%.2f",average) + "%");

        //grading!
        Grade grade;
        if (average > 90){
            grade = Grade.A;

        } else if (average > 80) {
            grade=Grade.B;
        } else if (average > 70) {
            grade=Grade.C;

        }else if (average > 60){
            grade=Grade.D;
        } else if (average > 50) {
            grade=Grade.E;

        }else {
            grade = Grade.F;
        }
        // Grade Display!
        System.out.println("Grade: " + grade);

        //scanner closed to avoid memory leak!
        scan.close();

    }
}
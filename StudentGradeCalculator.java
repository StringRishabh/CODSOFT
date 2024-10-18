import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello! How many subjects do you have? ");
        int numberOfSubjects = scanner.nextInt();
        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Please enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Oops! That seems incorrect. Please enter marks between 0 and 100: ");
                marks[i] = scanner.nextInt();
            }

            totalMarks += marks[i];
        }
        double averagePercentage = (double) totalMarks / numberOfSubjects;
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
        System.out.println("\nGreat job! Here are your results:");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numberOfSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Your Grade: " + grade);
        switch (grade) {
            case 'A':
                System.out.println("Fantastic work! Keep it up!");
                break;
            case 'B':
                System.out.println("Good job! You're doing well.");
                break;
            case 'C':
                System.out.println("You're on the right track! Keep pushing!");
                break;
            case 'D':
                System.out.println("You made it! A bit more effort can take you higher.");
                break;
            case 'F':
                System.out.println("Don't be discouraged! Every setback is a setup for a comeback. Keep trying!");
                break;
        }
        System.out.println("\nThanks for using the Student Grade Calculator. Have a great day!");

        scanner.close();
    }
}

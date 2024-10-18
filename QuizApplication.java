import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class QuizApplication {
    private static final int TIME_LIMIT = 10; // Time limit in seconds for each question
    private static final String[][] QUESTIONS = {
        {"What is the capital of France?", "A) Paris", "B) London", "C) Berlin", "D) Madrid", "A"},
        {"Which planet is known as the Red Planet?", "A) Earth", "B) Mars", "C) Jupiter", "D) Saturn", "B"},
        {"What is the largest mammal in the world?", "A) Elephant", "B) Blue Whale", "C) Giraffe", "D) Shark", "B"},
        {"What is the boiling point of water?", "A) 100°C", "B) 90°C", "C) 80°C", "D) 110°C", "A"},
        {"Who wrote 'Romeo and Juliet'?", "A) Charles Dickens", "B) Mark Twain", "C) William Shakespeare", "D) Jane Austen", "C"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You have " + TIME_LIMIT + " seconds to answer each question. Good luck!");

        for (String[] question : QUESTIONS) {
            System.out.println("\n" + question[0]);
            for (int i = 1; i <= 4; i++) {
                System.out.println(question[i]);
            }

            // Start the timer
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\n⏰ Time's up! Moving to the next question.");
                    scanner.nextLine();
                }
            };
            timer.schedule(task, TIME_LIMIT * 1000);
            System.out.print("Enter your answer (A/B/C/D): ");
            String userAnswer = scanner.nextLine();
            timer.cancel(); 
            if (userAnswer.equalsIgnoreCase(question[5])) {
                System.out.println("🎉 Correct! Well done.");
                score++;
            } else {
                System.out.println("❌ Incorrect! The correct answer was " + question[5] + ".");
            }
        }
        System.out.println("\nYour final score: " + score + " out of " + QUESTIONS.length);
        if (score == QUESTIONS.length) {
            System.out.println("🌟 Outstanding performance! You're a quiz master!");
        } else if (score >= QUESTIONS.length / 2) {
            System.out.println("👍 Good job! You have a solid understanding.");
        } else {
            System.out.println("Keep practicing! You'll get better with time.");
        }
        System.out.println("Thanks for playing the Quiz Application! Have a great day!");
        scanner.close();
    }
}

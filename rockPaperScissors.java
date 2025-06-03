import java.util.Random;
import java.util.Scanner;

public class rockPaperScissors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String[] options = {"rock", "paper", "scissors"};
        int userScore = 0, aiScore = 0;
        String userChoice;

        System.out.println("Welcome to Rock Paper Scissors!");

        while (true) {
            System.out.print("Enter your choice (rock/paper/scissors or 'q' to quit): ");
            userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("q")) {
                System.out.println("Thank you for playing!");
                break;
            }

            if (!userChoice.equals("rock") &&
                !userChoice.equals("paper") && 
                !userChoice.equals("scissors")) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            String userEmoji = switch (userChoice) {
                case "rock" -> "✊🏻";
                case "paper" -> "🫱🏻";
                case "scissors" -> "🤞🏻";
                default -> userChoice;
            };

            String aiChoice = options[rand.nextInt(options.length)];
            String aiEmoji = switch (aiChoice) {
                case "rock" -> "✊🏻";
                case "paper" -> "🫱🏻";
                case "scissors" -> "🤞🏻";
                default -> aiChoice;
            };

            System.out.println("\nYou Chose: " + userEmoji);
            System.out.println("AI Chose: " + aiEmoji);

            if (userChoice.equals(aiChoice)) {
                System.out.println("Draw! 😑\n");
            } else if (userChoice.equals("paper") && aiChoice.equals("rock") ||
                       userChoice.equals("scissors") && aiChoice.equals("paper") ||
                       userChoice.equals("rock") && aiChoice.equals("scissors")) {
                System.out.println("You win this round! 😉\n");
                userScore++;
            } else {
                System.out.println("AI wins this round! 😫\n");
                aiScore++;
            }
        }

        System.out.println("\n Final Scores");
        System.out.println("You: " + userScore + " | AI: " + aiScore);

        if (userScore > aiScore) {
            System.out.println(" You won! 😁");
        } else if (userScore == aiScore) {
            System.out.println("   Draw! 😑");
        } else {
            System.out.println(" You lost! 🥺");
        }

        scanner.close();
    }
}
import java.util.*;

class OnlineExamination {

    static Scanner sc = new Scanner(System.in);

    // User details
    static String username = "admin";
    static String password = "1234";

    // Questions and Answers
    static String[] questions = {
            "1. Which language is platform independent?",
            "2. Who invented Java?",
            "3. Which keyword is used for inheritance in Java?",
            "4. Which method is the entry point of Java program?",
            "5. Which package contains Scanner class?"
    };

    static String[][] options = {
            {"1) C", "2) C++", "3) Java", "4) Python"},
            {"1) James Gosling", "2) Dennis Ritchie", "3) Bjarne Stroustrup", "4) Guido van Rossum"},
            {"1) implements", "2) extends", "3) inherit", "4) super"},
            {"1) start()", "2) run()", "3) main()", "4) init()"},
            {"1) java.io", "2) java.lang", "3) java.util", "4) java.net"}
    };

    static int[] answers = {3, 1, 2, 3, 3};

    public static void main(String[] args) {

        System.out.println("===== ONLINE EXAMINATION SYSTEM =====");

        // Login
        if (login()) {

            int choice;

            do {
                System.out.println("\n----- MENU -----");
                System.out.println("1. Update Profile & Password");
                System.out.println("2. Start Exam");
                System.out.println("3. Logout");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        updateProfile();
                        break;

                    case 2:
                        startExam();
                        break;

                    case 3:
                        System.out.println("Logged out successfully!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 3);

        } else {
            System.out.println("Login Failed!");
        }

        sc.close();
    }

    // Login Method
    static boolean login() {

        System.out.print("Enter Username: ");
        String user = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        return user.equals(username) && pass.equals(password);
    }

    // Update Profile
    static void updateProfile() {

        System.out.print("Enter New Username: ");
        username = sc.next();

        System.out.print("Enter New Password: ");
        password = sc.next();

        System.out.println("Profile Updated Successfully!");
    }

    // Start Exam
    static void startExam() {

        int score = 0;

        System.out.println("\n===== EXAM STARTED =====");

        for (int i = 0; i < questions.length; i++) {

            System.out.println("\n" + questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter Answer (1-4): ");
            int userAnswer = sc.nextInt();

            if (userAnswer == answers[i]) {
                score++;
            }
        }

        System.out.println("\n===== EXAM COMPLETED =====");
        System.out.println("Your Score: " + score + "/" + questions.length);

        if (score >= 3) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}
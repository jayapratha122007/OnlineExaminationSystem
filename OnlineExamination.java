import java.util.*;

class OnlineExam {
    private String username = "Student";
    private String password = "1234";

    private Scanner sc = new Scanner(System.in);

    // Questions
    String[] questions = {
        "1. Java is?\nA) Language\nB) OS\nC) Hardware\nD) None",
        "2. JVM stands for?\nA) Java Virtual Machine\nB) Java Variable Method\nC) Just Virtual Machine\nD) None",
        "3. int size?\nA) 2 bytes\nB) 4 bytes\nC) 8 bytes\nD) 1 byte"
    };

    char[] answers = {'A', 'A', 'B'};

    // Login
    public boolean login() {
        System.out.print("Enter Username: ");
        String user = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Successful!");
            return true;
        } else {
            System.out.println("Invalid Login!");
            return false;
        }
    }

    // Update Profile
    public void updateProfile() {
        System.out.print("Enter new username: ");
        username = sc.next();

        System.out.print("Enter new password: ");
        password = sc.next();

        System.out.println("Profile Updated Successfully!");
    }

    // Exam
    public void startExam() {
        int score = 0;
        char[] userAns = new char[questions.length];

        System.out.println("\nExam Started! (You have limited time)");

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Enter answer (A/B/C/D): ");
            userAns[i] = sc.next().toUpperCase().charAt(0);
        }

        // Evaluation
        for (int i = 0; i < answers.length; i++) {
            if (userAns[i] == answers[i]) {
                score++;
            }
        }

        System.out.println("\nExam Submitted Automatically!");
        System.out.println("Your Score: " + score + "/" + questions.length);
    }

    // Menu
    public void menu() {
        int choice;
        do {
            System.out.println("\n===== ONLINE EXAM MENU =====");
            System.out.println("1. Start Exam");
            System.out.println("2. Update Profile");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    startExam();
                    break;
                case 2:
                    updateProfile();
                    break;
                case 3:
                    System.out.println("Logged out!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }
}

public class Main {
    public static void main(String[] args) {
        OnlineExam obj = new OnlineExam();

        if (obj.login()) {
            obj.menu();
        }
    }
}
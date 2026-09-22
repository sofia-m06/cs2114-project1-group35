import java.util.Scanner;

public class MainApp {
    private UserProfile userProfile;
    private ProgressionEngine progressionEngine;
    private InputValidator validator;
    private Scanner scanner;

    public MainApp() {
        this.scanner = new Scanner(System.in);
        this.validator = new InputValidator(scanner);
        this.progressionEngine = new ProgressionEngine();
    }

    public void run() {
        System.out.println("=== Fitness Tracker Setup ===");
        String username = validator.getValidStringInput("Enter your username: ");
        double startingWeight = validator.getValidDoubleInput("Enter your starting bodyweight (lbs): ");
        String goal = validator.getValidStringInput("Enter your goal (bulk/cut): ");

        this.userProfile = new UserProfile(username, startingWeight, goal);

        boolean running = true;
        while (running) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Log a Workout Session");
            System.out.println("2. View Current Target Weights");
            System.out.println("3. Exit");
            int choice = validator.getValidIntegerInput("Choose an option: ");

            switch (choice) {
                case 1:
                    logWorkout();
                    break;
                case 2:
                    viewLifts();
                    break;
                case 3:
                    System.out.println("Exiting app. Keep up the progress!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 3.");
            }
        }
    }

    private void logWorkout() {
        String category = validator.getValidStringInput("Enter session category (e.g., Push, Pull, Legs): ");
        String date = validator.getValidStringInput("Enter session date (e.g., 2026-09-22): ");

        WorkoutSession session = new WorkoutSession(category, date);

        int exerciseCount = validator.getValidIntegerInput("How many exercises did you complete? ");
        for (int i = 0; i < exerciseCount; i++) {
            System.out.println("\nExercise #" + (i + 1));
            String name = validator.getValidStringInput("Exercise name: ");
            double weight = validator.getValidDoubleInput("Weight used (lbs): ");
            int sets = validator.getValidIntegerInput("Sets completed: ");
            int reps = validator.getValidIntegerInput("Reps completed: ");

            ExerciseSet set = new ExerciseSet(name, weight, sets, reps);
            session.addExercise(set);

            double currentTarget = userProfile.getTargetWeight(name);
            if (currentTarget == 0.0) {
                currentTarget = weight;
            }

            double nextTarget = progressionEngine.calculateNextWeight(set, currentTarget);
            userProfile.updateLiftWeight(name, nextTarget);
            System.out.println("Target updated for " + name + ": " + nextTarget + " lbs");
        }

        session.displaySession();
    }

    private void viewLifts() {
        System.out.println("\n--- Current Lift Targets for " + userProfile.getUsername() + " ---");
        if (userProfile.getLiftWeights().isEmpty()) {
            System.out.println("No lift data recorded yet.");
            return;
        }
        userProfile.getLiftWeights().forEach((lift, weight) ->
            System.out.println(lift + ": " + weight + " lbs")
        );
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }
}

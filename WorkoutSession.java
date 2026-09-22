package project1;
import java.util.ArrayList;
import java.util.List;

public class WorkoutSession {
    private String category; // e.g., "Push", "Pull", "Legs"
    private String date;
    private List<ExerciseSet> exercises;

    public WorkoutSession(String category, String date) {
        this.category = category;
        this.date = date;
        this.exercises = new ArrayList<>();
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public List<ExerciseSet> getExercises() {
        return exercises;
    }

    public void addExercise(ExerciseSet exercise) {
        exercises.add(exercise);
    }

    public void displaySession() {
        System.out.println("\n--- Workout: " + category + " (" + date + ") ---");
        for (ExerciseSet exercise : exercises) {
            System.out.println("- " + exercise);
        }
    }
}

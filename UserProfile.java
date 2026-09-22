package project1;
import java.util.HashMap;
import java.util.Map;

public class UserProfile {
    private String username;
    private double startingWeight;
    private String goal; // e.g., "bulk" or "cut"
    private Map<String, Double> liftWeights;

    public UserProfile(String username, double startingWeight, String goal) {
        this.username = username;
        this.startingWeight = startingWeight;
        this.goal = goal;
        this.liftWeights = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public double getStartingWeight() {
        return startingWeight;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Map<String, Double> getLiftWeights() {
        return liftWeights;
    }

    public void updateLiftWeight(String exerciseName, double newWeight) {
        liftWeights.put(exerciseName, newWeight);
    }

    public double getTargetWeight(String exerciseName) {
        return liftWeights.getOrDefault(exerciseName, 0.0);
    }
}

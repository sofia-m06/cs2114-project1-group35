public class ExerciseSet {
    private String name;
    private double weight;
    private int sets;
    private int reps;

    public ExerciseSet(String name, double weight, int sets, int reps) {
        this.name = name;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    @Override
    public String toString() {
        return name + " - " + sets + " sets x " + reps + " reps @ " + weight + " lbs";
    }
}

package project1;

public class ProgressionEngine
{

    public
        double
        calculateNextWeight(ExerciseSet currentSet, double currentTargetWeight)
    {
        if (currentTargetWeight < 0 || currentSet.getWeight() < 0)
        {
            return -1.0;
        }

        int targetReps = 12;

        if (currentSet.getReps() >= targetReps)
        {
            return currentTargetWeight + 5.0;
        }

        return currentTargetWeight;
    }
}

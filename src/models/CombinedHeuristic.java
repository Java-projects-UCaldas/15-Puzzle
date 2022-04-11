package models;

public class CombinedHeuristic implements IHeuristic {

    private IHeuristic[] heuristics;
    private int[] weightings;

    public CombinedHeuristic(IHeuristic... heuristics) {
        this.heuristics = heuristics;
        this.weightings = new int[heuristics.length];
        for (int i=0; i<heuristics.length; i++)
            weightings[i] = 1;
    }

    public void setWeightings(int... weightings) {
        this.weightings = weightings;
    }

    public int calcHeuristic(Puzzle p) {
        int heuristic = 0;

        for (int i=0; i<heuristics.length; i++)
            heuristic += heuristics[i].calcHeuristic(p) * weightings[i];

        return heuristic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CombinedHeuristic ( ");
        for (int i=0; i<heuristics.length; i++)
            sb.append(weightings[i] + ": " + heuristics[i] + " ");
        sb.append(")");
        return sb.toString();
    }

}


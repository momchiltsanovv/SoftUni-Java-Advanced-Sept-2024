package _10_ExamPrep_1._03_SpaceCraft.spaceCrafts;

public class Spacecraft {

    private final String name;
    private final String missionType;
    private final String target;
    private final String objective;
    private final int weight;

    public Spacecraft(String name, String missionType, String target, String objective, int weight) {
        this.name = name;
        this.missionType = missionType;
        this.target = target;
        this.objective = objective;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getMissionType() {
        return missionType;
    }

    public String getTarget() {
        return target;
    }

    public String getObjective() {
        return objective;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return String.format("The mission of %s was to reach %s and to %s" , getName(), getTarget(), getObjective());
    }
}

package _10_ExamPrep._03_SpaceCraft.spaceCrafts;

import java.util.ArrayList;
import java.util.List;

public class LaunchPad {
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (this.spacecrafts.size() >= this.capacity) {
            System.out.println("This launchpad is at full capacity!");
            return;
        }
        this.spacecrafts.add(spacecraft);
    }

    public boolean removeSpacecraft(String name) {
        return this.spacecrafts.removeIf(spacecraft -> spacecraft.getName().equals(name));
    }

    public String getHeaviestSpacecraft() {
        int max = Integer.MIN_VALUE;
        String heaviestSpacecraft = null;
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getWeight() > max) {
                max = spacecraft.getWeight();
                heaviestSpacecraft = spacecraft.getName();
            }
        }
        return String.format("%s - %dkg", heaviestSpacecraft, max);
    }

    public Spacecraft getSpacecraft(String name) {
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getName().equals(name)) {
                return spacecraft;
            }
        }
        return null;
    }

    public int getCount() {
        return this.spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> spacecraftsByMissionType = new ArrayList<>();
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getMissionType().equals(missionType)) {
                spacecraftsByMissionType.add(spacecraft);
            }
        }
        return spacecraftsByMissionType;
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        if (!this.spacecrafts.isEmpty()) {
            statistics.append(String.format("Spacecrafts launched from %s:\n", this.name));
            int counter = 1;
            for (Spacecraft spacecraft : this.spacecrafts) {
                statistics.append(String.format("%d. %s\n", counter++, spacecraft.getName()));
            }
        } else {
            statistics.append(String.format("Spacecrafts launched from %s:\nnone", this.name));
        }
        return statistics.toString();
    }
}
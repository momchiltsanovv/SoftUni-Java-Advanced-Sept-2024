package _10_ExamPrep_1._03_SpaceCraft.spaceCrafts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LaunchPad {

    private final List<Spacecraft> spacecrafts;
    private final String name;
    private final int capacity;

    public LaunchPad(String name, int capacity) {
        this.spacecrafts = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addSpacecraft(Spacecraft spacecraft) {

        if (spacecrafts.size() < capacity) {
            if (spacecrafts.stream().noneMatch(s -> s.getName().equals(spacecraft.getName()))) {
                spacecrafts.add(spacecraft);
            } else {
                throw new RuntimeException("This spacecraft already exists!");
            }
        } else {
            System.out.println(("This launchpad is at full capacity!"));
        }
    }

    public Spacecraft getSpacecraft(String name) {
        return spacecrafts.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public boolean removeSpacecraft(String name) {
        Spacecraft spacecraft = this.getSpacecraft(name);
        spacecrafts.remove(spacecraft);
        return spacecraft != null;
    }

    public int getCount() {
        return spacecrafts.size();
    }

    public String getHeaviestSpacecraft() {
        Spacecraft heaviestSpacecraft = spacecrafts.stream().max(Comparator.comparing(Spacecraft::getWeight)).orElse(null);
        assert heaviestSpacecraft != null;
        return String.format(heaviestSpacecraft.getName() + " - " + heaviestSpacecraft.getWeight() + "kg.");
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {

        List<Spacecraft> suitableSpacecrafts = getSpacecrafts().stream().filter(spacecraft -> spacecraft.getMissionType().equals(missionType)).collect(Collectors.toList());
        if (suitableSpacecrafts.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return suitableSpacecrafts;
    }

    public List<Spacecraft> getSpacecrafts() {
        return spacecrafts;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStatistics() {

        LaunchPad launchPad = new LaunchPad(getName(), getCapacity());
        StringBuilder build = new StringBuilder();

        build.append("Spacecrafts launched from ").append(launchPad.getName()).append(":");
        if (spacecrafts.isEmpty()) {
            build.append(System.lineSeparator()).append("none");
        } else {
            build.append(System.lineSeparator());
            for (int i = 0; i < spacecrafts.size(); i++) {
                build.append(i + 1).append(". ").append(spacecrafts.get(i).getName()).append(System.lineSeparator());
            }
        }
//        spacecrafts.forEach(spacecraft -> build.append(spacecraft.getName()).append(System.lineSeparator()));
        return build.toString().trim();
    }
}

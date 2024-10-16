package surfers;

import java.util.ArrayList;
import java.util.List;

public class Beach {

    private final String name;
    private int surfboardsForRent;
    private final List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        this.surfers = new ArrayList<>();
    }

    public String addSurfer(Surfer surfer) {
        if (surfer.getOwnsASurfBoard()) {
            this.surfers.add(surfer);
            return String.format("Surfer %s added.", surfer.getName());
        } else { // rent a board
            if (surfer.getMoney() >= 50) {
                if (this.surfboardsForRent > 0) {
                    surfer.setMoney(surfer.getMoney() - 50);
                    this.surfers.add(surfer);
                    this.surfboardsForRent--;
                    return String.format("Surfer %s added.", surfer.getName());
                } else {
                    return "There are no free surfboards.";
                }
            } else {
                return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
            }
        }
    }


    public boolean removeSurfer(String name) {
        return surfers.removeIf(surfer -> surfer.getName().equals(name));
    }

    public String getMostExperiencedSurfer() {
        if (surfers.isEmpty()) {
            return "There are no surfers.";
        }

        Surfer mostExperienced = surfers.getFirst();
        for (Surfer surfer : surfers) {
            if (surfer.getExperience() > mostExperienced.getExperience()) {
                mostExperienced = surfer;
            }
        }

        return String.format("%s is most experienced surfer with %d years experience.",
                mostExperienced.getName(), mostExperienced.getExperience());
    }


    public Surfer getSurfer(String name) {
        for (Surfer surfer : surfers) {
            if (surfer.getName().equals(name)) {
                return surfer;
            }
        }
        return null;
    }


    public int getCount() {
        return surfers.size();
    }


    public String getSurfersWithPersonalSurfboards() {
        if (surfers.isEmpty()) {
            return "There are no surfers.";
        }

        StringBuilder sb = new StringBuilder("Surfers who have their own surfboards: ");
        boolean hasSurfersWithBoards = false;

        for (Surfer surfer : surfers) {
            if (surfer.getOwnsASurfBoard()) {
                sb.append(surfer.getName()).append(", ");
                hasSurfersWithBoards = true;
            }
        }

        if (hasSurfersWithBoards) {
            sb.setLength(sb.length() - 2); // Remove the last ", "
            return sb.toString();
        } else {
            return "There are no surfers with their own surfboards.";
        }
    }



    public String getReport() {
        if (surfers.isEmpty()) {
            return String.format("There are no surfers on %s beach.", name);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Beach ").append(name).append(" was visited by the following surfers:\n");
        int counter = 1;

        for (Surfer surfer : surfers) {
            sb.append(counter++).append(". ")
                    .append(surfer.getName()).append(" with ");
            if (surfer.getExperience() == 0) {
                sb.append("no experience.\n");
            } else {
                sb.append(surfer.getExperience()).append(" years experience.\n");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

}

package _12_ExamPrep_3._03_Halloween.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {

    private final List<Kid> data;
    private int capacity;


    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void addKid(Kid kid) {
        if (this.capacity > 0) {
            data.add(kid);
            capacity--; // decrease capacity after adding
        }
    }

    public boolean removeKid(String name) {
        boolean result = data.removeIf(kid -> kid.getName().equals(name));
        if (result) {
            this.capacity++; // increase capacity after removal
            return true;
        }
        return false;
    }

    public Kid getKid(String street) {
//        for (Kid kid : data) {
//            if (kid.getStreet().equals(street)) {
//                return kid;
//            }
//        }
//        return null;

        return data.stream()
                .filter(kid -> kid.getStreet().equals(street))
                .findFirst()
                .orElse(null);
    }

    public int getAllKids() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:\n");
        for (Kid kid : data) {
            sb.append(String.format("%s from %s street\n", kid.getName(), kid.getStreet()));
        }

        return sb.toString();
    }


}

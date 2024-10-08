package _09_IteratorsAndComparators.ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    List<String> elements;
    String command;
    int index = 0;

    public ListyIterator(String command, String... elements) {
        this.command = command;
        this.elements = new ArrayList<>(List.of(elements));
    }

    public boolean hasNext() {
        return this.index < this.elements.size() - 1;
    }

    public boolean move() {
        if (hasNext()) { //handling an edge case
            index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (elements.isEmpty() || index >= elements.size()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(elements.get(index));
        }
    }

    public Iterator<String> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<String> {
        int index = 0;

        public boolean hasNext() {
            return index < elements.size();
        }

        public String next() {
            String element = elements.get(index);
            index++;
            return element;
        }
    }
}

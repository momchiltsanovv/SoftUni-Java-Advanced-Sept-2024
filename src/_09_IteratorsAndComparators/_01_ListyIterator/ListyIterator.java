package _09_IteratorsAndComparators._01_ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private final List<String> elements;
    private int index = 0;

    public ListyIterator(String... elements) {
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

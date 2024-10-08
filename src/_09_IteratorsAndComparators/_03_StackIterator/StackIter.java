package _09_IteratorsAndComparators._03_StackIterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class StackIter implements Iterable<String> {

    private final Stack<String> stack;

    public StackIter(String... stack) {
        this.stack = new Stack<>();
        Collections.addAll(this.stack, stack);
    }

    public Iterator<String> iterator() {
        return new StackIterator();
    }

    public void pop() {
        if (this.stack.isEmpty()) {
            System.out.println("No elements");
        } else {
            this.stack.pop();
        }
    }

    public void push(String item) {
        this.stack.push(item);
    }

    public void forEachTwice() {
        int index = 0;
        for (int i = stack.size() - 1; i >= index; i--) {
            System.out.println(stack.get(i));
        }

        for (int i = stack.size() - 1; i >= index; i--) {
            System.out.println(stack.get(i));
        }
    }

    private class StackIterator implements Iterator<String> {
        int index = 0;

        public boolean hasNext() {
            return index < stack.size();
        }

        public String next() {
            return stack.get(index++);
        }
    }
}

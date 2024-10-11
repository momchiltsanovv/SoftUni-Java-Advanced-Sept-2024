package _09_IteratorsAndComparators._04_Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer>{

    private final int[] numbers;

    public Lake(int... numbers) {
        this.numbers = numbers;
    }

    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        private int evenIndex = 0; // Start at the first even index
        private int oddIndex = 1;   // Start at the first odd index
        private int state = 0;       // 0 for even, 1 for odd

        @Override
        public boolean hasNext() {
            // Check if there are more elements to return
            return evenIndex < numbers.length || oddIndex < numbers.length;
        }

        @Override
        public Integer next() {
            int value;
            if (state == 0) { // If it's time to return an even index
                value = numbers[evenIndex];
                evenIndex += 2; // Move to the next even index
                if (evenIndex >= numbers.length) {
                    state = 1; // Switch to odd indices if no more even indices
                }
            } else { // It's time to return an odd index
                value = numbers[oddIndex];
                oddIndex += 2; // Move to the next odd index
            }
            return value;
        }


    }

}

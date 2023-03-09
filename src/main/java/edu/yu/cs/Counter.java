package edu.yu.cs;

/**
 * Hello world!
 *
 */
public class Counter 
{
    public Counter() {
        //empty constructor
    }

    /**
     * Returns the sum of two non-negative numbers
     * @param first an int; must be non-negative and less than half of Integer.MAX_VALUE
     * @param second an int; must be non-negative and less than half of Integer.MAX_VALUE
     * @see Integer.MAX_VALUE
     * @return the sum of first and second
     */
    public int add(int first, int second) {
        if (first < 0 || second < 0) {
            throw new IllegalArgumentException("Arguments must be non-negative");
        }
        if (first >= Integer.MAX_VALUE/2 || second >= Integer.MAX_VALUE/2) {
            throw new IllegalArgumentException("Arguments must be less than half of Integer.MAX_VALUE to avoid an overflow");
        }
        return first + second;
    }
}

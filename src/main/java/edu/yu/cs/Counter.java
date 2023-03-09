package edu.yu.cs;

import edu.yu.cs.verification.Verifier;

/**
 * Hello world!
 *
 */
public class Counter 
{
    private Verifier verifier;
    public Counter() {
        this.verifier = new Verifier();
    }

    /**
     * Returns the sum of two non-negative numbers
     * @param first an int; must be non-negative and less than half of Integer.MAX_VALUE
     * @param second an int; must be non-negative and less than half of Integer.MAX_VALUE
     * @see Integer.MAX_VALUE
     * @return the sum of first and second
     */
    public int add(int first, int second) {
        verifier.verify(first);
        verifier.verify(second);
        return first + second;
    }
}

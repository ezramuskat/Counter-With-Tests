package edu.yu.cs.verification;

/**
 * Verifier
 */
public class Verifier {

	public Verifier() {}

	public void verify(int integer) {
		if (integer < 0) {
			throw new IllegalArgumentException("Arguments must be non-negative; argument " + integer + " is invalid");
		}
		if (integer >= Integer.MAX_VALUE/2) {
			throw new IllegalArgumentException("Arguments must be less than half of Integer.MAX_VALUE to avoid an overflow; argument " + integer + " is too large");
		}
	}
}
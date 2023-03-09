package edu.yu.cs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class CounterTest 
{
    private static Counter counter;

    /**
     * While not always necessary, or even useful, it can sometimes be helpful to perform some work
     * before your tests. This example uses JUnit's BeforeAll annotation, which can be useful for
     * setting up singletons you'll reuse across tests (e.g. loggers); if there's necessary 
     * boilerplate code that must be repeated each time, you may find BeforeEach to be more helpful
     */
    @BeforeAll
    public static void init() {
        counter = new Counter();
    }

    /**
     * Before you go through the effort of making sure your code works when it should,
     * it's often useful to make sure that your code doesn't work when it shouldn't. These
     * tests tend to be fairly simple to write, and can serve as an early canary for issues
     * with things like input handling.
     * <p>
     * As a nice side bonus, it can also be encouraging to have a set of tests that you can
     * knock out early and have working often, especially for those moments when you've been
     * banging your head against a wall for hours trying to figure out a bug.
     */
    @Test
    public void incorrectTests() {
        assertThrows(IllegalArgumentException.class, ()->counter.add(-1, -1));
        assertThrows(IllegalArgumentException.class, ()->counter.add(-1, 0));
        assertThrows(IllegalArgumentException.class, ()->counter.add(0, -1));
        assertThrows(IllegalArgumentException.class, ()->counter.add(-126134, -134613));
        assertThrows(IllegalArgumentException.class, ()->counter.add(-12, 134613));
        assertThrows(IllegalArgumentException.class, ()->counter.add(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertThrows(IllegalArgumentException.class, ()->counter.add(Integer.MAX_VALUE/2, Integer.MAX_VALUE/2));
        assertThrows(IllegalArgumentException.class, ()->counter.add(4, Integer.MAX_VALUE));
        assertThrows(IllegalArgumentException.class, ()->counter.add(Integer.MAX_VALUE/2, 17));
        assertThrows(IllegalArgumentException.class, ()->counter.add(Integer.MAX_VALUE, -5));
        assertThrows(IllegalArgumentException.class, ()->counter.add(-5, Integer.MAX_VALUE/2));
    }

    /**
     * Before getting into weird complicated cases, it's important to check that your code works for simple,
     * easily verifiable cases. The definition of "simple" can vary from problem to problem; for search or sort
     * problems, it may mean short inputs, whereas a simple graph problem may be a small or sparse graph. Whatever the
     * case, these are the kind of problems where you can easily figure out the solution on your own in your head. You may
     * also want to sprinkle in qualitatively different cases, such as cases at both the ends and middle in divide-and-conquer
     * algorithms; for larger or more complicated cases, though, you may want to spin those off into entirely different tests.
     */
    @Test
    public void simpleTests() {
        assertEquals(2, counter.add(1, 1));
        assertEquals(50, counter.add(25, 25));
        assertEquals(20, counter.add(3, 17));
        assertEquals(75, counter.add(42, 33));
        assertEquals(0, counter.add(0, 0));
        assertEquals(17, counter.add(0, 17));
    }

    /**
     * Once you've verified that your program works for simple cases, you'll want to move on to more complicated cases.
     * Many of the same rules as before apply; the definition of complicated can vary from case to case, from large numbers
     *  to large or highly connected graphs. A good rule of thumb to use is that simple cases can be easily worked out in your
     * head, whereas complicated cases will often require a calculator or a pen and paper.
     */
    @Test
    public void complicatedTests() {
        assertEquals(50000, counter.add(25000, 25000));
        assertEquals(104842, counter.add(11559, 93283));
        assertEquals(333333, counter.add(111111, 222222));
        assertEquals(4000, counter.add(3000, 1000));
    }

    /**
     * Some cases may not fit neatly into the categories of "complicated" or "simple". Not every problem will have cases of this nature;
     * if your program has only a few inputs, or only very simple kinds of input, you may not need a category like this. Our counter program,
     * for instance, is very simple, and doesn't have input classes that don't fall into the prior two categories. Examples of cases
     * where a test like this may be useful are cases that deliberately stress some aspect of your program, or violate assumptions
     * you might hold about "normal" inputs.
     */
    @Test
    public void edgeCases() {
        //insert cases here
    }

    /**
     * This type of test is both the most situational kind of test, and (in my experience) the most useful kind. You should only use a random
     * test if your program meets either of the following sets of criteria: it works for most arbitrary input and produces output that you can
     * easily verify given creation details, or produces an output state that is independently verifiable. Most cases will be the former. The approach
     * to take for these is to set up a loop of an appropriate-feeling size; in each iteration, randomly generate a set of inputs (or the bases for a 
     * set of inputs) for your program; and verify that the output is correct. You should print or log your generate inputs, as you may find it difficult to
     * randomly repeat a failing set of inputs.
     * <p>
     * The largest benefit by far of this type of test is it's ability to catch errors for cases that are weird, non-obvious, or just slipped your mind. This can
     * provide a useful check beyond your regular tests, giving you much broader test coverage for relatively little effort
     * <p>
     * One trap you want to be careful for when using this kind of test is bounds verification. Many problems you encounter will have limitations
     * on the range of valid inputs; methods taking integer arguments, for instance, may or may not be valid for values <= 0. On the flip side,
     * make sure that you don't accidentally exclude classes of valid input. Make sure to familiarize yourself with both the limitations of the 
     * problem, and the various methods in Java's {@link java.util.Random Random} class that can help you in these cases.
     * <p>
     * Examples of cases where this type of test can be useful include:
     * - Searching for some specific element or type of element
     * - Some simple classes of sorting
     * - Verifying that code that is meant to leave input in its original state actually does so
     * - Code that involves an assocation between two elements
     * Examples of cases where this type of test may not useful include:
     * - Most graph algorithms (though not all)
     * - Some complicated types of sorting
     * - 
     * @see java.util.Random
     */
    @Test
    public void randomTests() {
        Random random = new Random();
        int tests = 50;
        for (int i = 0; i < tests; i++) {
            int first = random.nextInt(Integer.MAX_VALUE/2);
            int second = random.nextInt(Integer.MAX_VALUE/2);
            assertEquals(first + second, counter.add(first, second));
        }
    }
}

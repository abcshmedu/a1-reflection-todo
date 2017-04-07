package edu.hm.cs.swa.todo.Aufgabe01;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * This class is used to test the Renderer Class.
 * @author Dominik Grenz & Tobias Kroiss
 */
@RunWith(Parameterized.class)
public class ParameterizedRendererTest {

    private Renderer renderer;
    public static final int[] INTS = { 0, 5, 10 };
    public static final int INTS_LEN = INTS.length;

    /**
     *  This method creates some string-representations of an Object[][]
     * (input object, expected string).
     * @return list of an Object[][]
     */
    @Parameters
    public static Collection<Object[]> data() {

        String expStrS = "Instance of edu.hm.cs.swa.todo.Aufgabe01.SomeClass:\n" + "foo (Type int): ";
        String expStrM = "\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\ngetDate (Returntype: class java.util.Date): Fri Jan 02 11:17:36 CET 1970\ngetFoo (Returntype: int): ";
        String expStrL = "\ngetIntArray (Returntype: int[]) [1, 2, 3, ]\n";

        Object[][] objArr = new Object[INTS_LEN][2];
        for (int i = 0; i < INTS_LEN; i++) {
            objArr[i][0] = new SomeClass(INTS[i]);
            objArr[i][1] = expStrS + INTS[i] + expStrM + INTS[i] + expStrL;
        }
        return Arrays.asList(objArr);
    }

    @Parameter(0)
    public Object inputObj;

    @Parameter(1)
    public String expected;

    /**
     * This method creates a renderer object for the test.
     */ 
    @Before
    public void initalize() {
        renderer = new Renderer(inputObj);
    }

    /**
     * This method tests the renderer object.
     */
    @Test
    public void testRendering() {
        assertEquals(expected, renderer.render());
    }

}

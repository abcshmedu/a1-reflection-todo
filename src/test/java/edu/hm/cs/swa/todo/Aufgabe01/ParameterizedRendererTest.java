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

@RunWith(Parameterized.class)
public class ParameterizedRendererTest {

    private Renderer renderer;
    public static final int[] INTS = { 0, 5, 10 };

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new SomeClass(INTS[0]),
                        "Instance of edu.hm.cs.swa.todo.Aufgabe01.SomeClass:\n" + "foo (Type int): " + INTS[0]
                                + "\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n" },
                { new SomeClass(INTS[1]),
                        "Instance of edu.hm.cs.swa.todo.Aufgabe01.SomeClass:\n" + "foo (Type int): " + INTS[1]
                                + "\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n" },
                { new SomeClass(INTS[2]), "Instance of edu.hm.cs.swa.todo.Aufgabe01.SomeClass:\n" + "foo (Type int): "
                        + INTS[2]
                        + "\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n" } });
    }

    @Parameter(0)
    public Object inputObj;

    @Parameter(1)
    public String expected;

    @Before
    public void initalize() {
        renderer = new Renderer(inputObj);
    }

    @Test
    public void testRendering() {
        assertEquals(expected, renderer.render());
    }

}

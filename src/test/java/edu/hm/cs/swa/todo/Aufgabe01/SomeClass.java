package edu.hm.cs.swa.todo.Aufgabe01;

import java.util.Date;

/**
 * This is an example class to test RenderMe Annotation.
 * @author Dominik Grenz & Tobias Kroiss
 */
public class SomeClass {

    @RenderMe
    private int foo;
    
    @RenderMe(with = "edu.hm.cs.swa.todo.Aufgabe01.ArrayRenderer")
    private int[] array = { 1, 2, 3, };
    
    @RenderMe
    private Date date = new Date(123456789);
    
    /**
     * Constructs a SomeClass Object.
     * @param foo integer for the annotation
     */
    public SomeClass(int foo) {
        this.foo = foo;
    }

    /**
     * Get the value of foo.
     * @return  value of foo
     */
    @RenderMe
    public int getFoo() {
        return foo;
    }
    
    /**
     * Get the value of array.
     * @return value of array
     */
    @RenderMe(with = "edu.hm.cs.swa.todo.Aufgabe01.ArrayRenderer")
    public int[] getIntArray() {
        return array;
    }
    
    /**
     * Get the value of date.
     * @return value of date
     */
    @RenderMe
    public Date getDate() {
        return date;
    }
}

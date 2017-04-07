package edu.hm.cs.swa.todo.Aufgabe01;

/**
 * This class is used to render an int[].
 * @author Dominik Grenz & Tobias Kroiss
 */
public class ArrayRenderer {

    /**
     * This method creates a string-representation of an int[]
     * (type & values).
     * @param array int[] that has to be rendered
     * @return string representation of the array's attributes
     */
    public String render(int[] array) {
        String result = "int[]) [";
        for (int index : array) {
            result += index + ", ";
        }
        result += "]\n";
        return result;
    }

}

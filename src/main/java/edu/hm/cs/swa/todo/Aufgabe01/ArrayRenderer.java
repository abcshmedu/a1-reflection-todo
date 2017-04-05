package edu.hm.cs.swa.todo.Aufgabe01;

/**
 * @author Dominik Grenz & Tobias Kroiss
 */
public class ArrayRenderer {

	public String render(int[] array) {
		String result = "int[]) [";
		for (int index : array) {
			result += index + ", ";
		}
		result += "]\n";
		return result;
	}

}

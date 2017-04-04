package edu.hm.cs.swa.todo.Aufgabe01;

import java.io.*;
import java.util.*;

/**
 * @author Dominik Grenz & Tobias Kroiss
 */
public class SomeClass {

	@RenderMe
	private int foo;
	@RenderMe(with = "edu.hm.cs.swa.todo.Aufgabe01.ArrayRenderer")
	int[] array = { 1, 2, 3, };
	@RenderMe
	private Date date = new Date(123456789);

	public SomeClass(int foo) {
		this.foo = foo;
	}

}

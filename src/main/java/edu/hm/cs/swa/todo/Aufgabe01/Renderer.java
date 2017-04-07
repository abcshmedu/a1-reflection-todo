package edu.hm.cs.swa.todo.Aufgabe01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * This class is used to render an object.
 * @author Dominik Grenz & Tobias Kroiss
 */
public class Renderer {

	private Object objToRender;
	private static final int VALUE = 5;

	/**
	 * Constructor which creates a new Renderer.
	 * @param objToRender the object to render
	 */
	public Renderer(Object objToRender) {
		this.objToRender = objToRender;
	}

	/**
	 * This method creates a string-representation of a object's fields and it's methods
	 * (if these have been annotated).
	 * @return a string which contains the object's fields followed by it's methods
	 */
	public String render() {
		String result = "";
		Class< ? > cls = objToRender.getClass();
		result = "Instance of " + cls.getName() + ":\n";
		Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			RenderMe annotation = f.getAnnotation(RenderMe.class);
			if (annotation != null) {
				f.setAccessible(true);
				result += f.getName() + " (Type ";
				if (annotation.with().equals("")) {
					try {
						result += f.getType().getName() + "): " + f.get(objToRender) + "\n";
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					try {
						Class< ? > array = Class.forName(annotation.with());
						Method method = array.getMethod("render", f.getType());
						result += method.invoke(array.newInstance(), f.get(objToRender));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		Method[] methods = cls.getDeclaredMethods();
		for (Method m : methods) {
			RenderMe annotation = m.getAnnotation(RenderMe.class);
			if (annotation != null) {
				m.setAccessible(true);
				result += m.getName() + " (Returntype: ";
				if (annotation.with().equals("")) {
					try {
						result += m.getReturnType() + "): " + m.invoke(objToRender) + "\n";
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					try {
						Class< ? > array = Class.forName(annotation.with());
						Method method = array.getMethod("render", m.getReturnType());
						result += method.invoke(array.newInstance(), m.invoke(objToRender));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}

	/**
	 * Main-Method of the project.
	 * @param strings the parameters of main
	 */
	public static void main(String... strings) {
		SomeClass toRender = new SomeClass(VALUE);
		Renderer renderer = new Renderer(toRender);
		System.out.println(renderer.render());
	}
}

package edu.hm.cs.swa.todo.Aufgabe01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Dominik Grenz & Tobias Kroiss
 */
public class Renderer {

	private Object obj_render;

	public Renderer(Object obj_render) {
		this.obj_render = obj_render;
	}

	public String render() {
		String result = "";
		Class<?> cls = obj_render.getClass();
		result = "Instance of " + cls.getName() + ":\n";
		Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			RenderMe annotation = f.getAnnotation(RenderMe.class);
			if (annotation != null) {
				f.setAccessible(true);
				result += f.getName() + " ";
				if (annotation.with().equals("")) {
					try {
						result += "(Type " + f.getType().getName() + "): " + f.get(obj_render) + "\n";

					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					try {
						Class<?> array = Class.forName(annotation.with());
						Method method = array.getMethod("render", f.getType());
						result += method.invoke(array.newInstance(), f.get(obj_render));

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
		}
		return result;
	}

	public static void main(String... strings) {
		SomeClass toRender = new SomeClass(5);
		Renderer renderer = new Renderer(toRender);
		System.out.println(renderer.render());

	}
}

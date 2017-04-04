package edu.hm.cs.swa.todo.Aufgabe01;

import java.lang.reflect.Field;

public class Renderer {

	private Object obj_render;

	public Renderer(Object obj_render) {
		this.obj_render = obj_render;
	}

	public String render() {
		String result = "";
		Class<?> cls = obj_render.getClass();
		result = "Class:" + cls.getName() + "\n";
		Field[] fields = cls.getDeclaredFields();
		for (Field f : fields) {
			RenderMe annotation = f.getAnnotation(RenderMe.class);
			if (annotation != null) {
				f.setAccessible(true);
				result += "Name:" + f.getName() + " ";
				if (annotation.with().equals("")) {
					try {
						result += "(Type " + f.getType().getName() + "): " + f.get(obj_render) + "\n";

					} catch (Exception e) {

					}
				} else {

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

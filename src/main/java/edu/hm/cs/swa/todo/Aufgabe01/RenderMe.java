package edu.hm.cs.swa.todo.Aufgabe01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to state that this field or method should be rendered.
 * It is used for fields and idempotent methods without parameters (like getters)
 * @author Dominik Grenz & Tobias Kroiss
 */
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RenderMe {

  /**
   * Annotation parameter.
   * @return a string with the presentation of the attributes of the render class
   */
  String with() default "";

}

package org.example.aop.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//specifies that this annotation can be applied to methods
@Retention(RetentionPolicy.RUNTIME)//specifies that this annotation will be available at runtime
public @interface TrackExecution {
    //custom annotation to track execution of methods
}
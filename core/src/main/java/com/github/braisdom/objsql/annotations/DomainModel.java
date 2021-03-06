package com.github.braisdom.objsql.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainModel {

    String tableName() default "";

    boolean fluent() default true;

    Class<?> primaryClass() default Integer.class;

    String primaryColumnName() default "id";

    String primaryFieldName() default "id";

    boolean skipNullValueOnUpdating() default true;

    boolean allFieldsPersistent() default true;
}

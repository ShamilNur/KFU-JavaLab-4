package ru.kpfu.itis.group903.nurkaev.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 01.03.2021
 * 01.Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Constraint(validatedBy = NamesValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidNames {
    public String name();

    public String surname();

    String message() default "invalid names";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        ValidNames value();
    }
}

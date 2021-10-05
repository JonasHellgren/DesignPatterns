package org.example.immutable_builder;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class TestBuilder {

    @Test
    public void TestBuildUser() {

        User user2 = User.UserBuilder.newInstance()
                .firstName("Albert")
                .email("ion@gmail.com")
                .build();

        System.out.println(user2);

        Assert.assertTrue(user2.firstName.equals("Albert"));
        //user2.firstname="2342";  //final => not possible

    }


    /***
     *

    @Test
    public void TestValidator() {

        User user;
        Validator validator
                = Validation.buildDefaultValidatorFactory().getValidator();

        User.UserBuilder userBuilder
                = new User.UserBuilder()
                .email("monika@gmail.com")
                .firstName("Monika").lastName("Gunther");

        user = userBuilder.build();

        System.out.println(user);

        final Set<ConstraintViolation<User.UserBuilder>> violations
                = validator.validate(userBuilder);
        if (violations.isEmpty()) {
            user = userBuilder.build();
            System.out.println("User successfully created on: "
                    + user);
        } else {
            System.out.println("UserBuilder Violations ");
        }
    }
     */

}

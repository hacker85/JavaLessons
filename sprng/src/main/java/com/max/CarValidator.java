package com.max;

import com.max.impl.Toyota;
import com.max.interfaces.Car;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CarValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return Car.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        Toyota car = (Toyota) target;
        if(car.getRadio() == null) {
            errors.rejectValue("radio", "radioIsNull");
        }
    }
}

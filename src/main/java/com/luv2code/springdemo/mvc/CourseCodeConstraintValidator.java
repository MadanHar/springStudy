package com.luv2code.springdemo.mvc;


import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;

    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();

    }

    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = StringUtils.stripToEmpty(theCode).startsWith(coursePrefix);
        return result;
    }
}

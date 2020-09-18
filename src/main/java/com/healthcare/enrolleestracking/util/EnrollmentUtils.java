package com.healthcare.enrolleestracking.util;

import com.healthcare.enrolleestracking.exception.ResourceNotFoundException;
import java.util.function.BiFunction;

public class EnrollmentUtils {
    public static final String BASE_PATH_V1 = "/registration/v1";
    public static final String RESOURCE_ENROLLEE = "Enrollee";
    public static final String RESOURCE_DEPENDENT = "Dependent";
    public static final BiFunction<String, Long, ResourceNotFoundException> NOT_FOUND_EXCEPTION_FX =
            (resource, id) -> new ResourceNotFoundException("Id not found");

    private EnrollmentUtils() {
        throw new IllegalStateException("Util class not intended for instantiation");
    }
}

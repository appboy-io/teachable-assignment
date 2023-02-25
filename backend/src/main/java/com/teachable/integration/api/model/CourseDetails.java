package com.teachable.integration.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CourseDetails {
    @JsonProperty("course")
    private Course course;
}

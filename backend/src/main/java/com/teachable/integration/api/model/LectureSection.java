package com.teachable.integration.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LectureSection implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("is_published")
    private boolean isPublished;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("lectures")
    private List<Lecture> lectures;
}

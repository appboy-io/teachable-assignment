package com.teachable.integration.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Course implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("description")
    private Integer description;
    @JsonProperty("name")
    private String name;
    @JsonProperty("heading")
    private String heading;
    @JsonProperty("is_published")
    private boolean isPublished;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("lecture_sections")
    private List<LectureSection> lectureSections;
    @JsonProperty("author_bio")
    private AuthorBio authorBio;
}

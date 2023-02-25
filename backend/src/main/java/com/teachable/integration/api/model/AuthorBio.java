package com.teachable.integration.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorBio implements Serializable {
    @JsonProperty("profile_image_url")
    private String profileImageUrl;
    @JsonProperty("bio")
    private String bio;
    @JsonProperty("name")
    private String name;
    @JsonProperty("user_id")
    private Long userId;
}

package com.teachable.integration.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Lecture implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("position")
    private Integer position;

}

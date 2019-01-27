package com.ikefukuro.hahaloss;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CommentForm {
    @NotNull
    @Size(min = 1, max = 255)
    private String body;

}
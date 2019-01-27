package com.ikefukuro.hahaloss;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PartialForm {
    @NotNull
    @Size(min = 1, max = 127)
    private String id;
}
package com.example.web4.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DotDTO {
    @Digits(integer = 1, fraction = 0)
    @Min(-5)
    @Max(3)
    @NotNull (message = "x не должен быть пустым")
    private double x;

    @Digits(integer = 1, fraction = 0)
    @Min(-5)
    @Max(3)
    @NotNull (message = "y не должен быть пустым")
    private double y;

    @Digits(integer = 1, fraction = 0)
    @Min(-5)
    @Max(3)
    @NotNull (message = "r не должен быть пустым")
    private double r;

}

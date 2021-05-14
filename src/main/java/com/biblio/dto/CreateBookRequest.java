package com.biblio.dto;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class CreateBookRequest {

    @Schema(example = "9781849518260")
    @NotBlank
    private String isbn;

    @Schema(example = "Spring Security 3.1")
    @NotBlank
    private String title;

    @Schema(example = "5")
    @Min(value=0)
    private Integer copies;
}

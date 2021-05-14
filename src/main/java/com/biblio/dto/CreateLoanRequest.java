package com.biblio.dto;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class CreateLoanRequest {

	@NotNull
    private Long userid;

	@NotNull
    private Long bookid;
}

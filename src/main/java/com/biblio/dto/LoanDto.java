package com.biblio.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LoanDto {

  private String user;
  private Long userid;
  private String book;
  private String isbn;
  private LocalDate date;
  private Boolean closed;

}
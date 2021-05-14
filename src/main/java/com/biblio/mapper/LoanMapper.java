package com.biblio.mapper;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

import com.biblio.domain.Book;
import com.biblio.domain.Loan;
import com.biblio.domain.User;
import com.biblio.dto.CreateLoanRequest;
import com.biblio.dto.LoanDto;

@Configuration
@Mapper(componentModel = "spring")
public interface LoanMapper {

  Loan toLoan(CreateLoanRequest createLoanRequest);

  LoanDto toLoanDto(Loan loan);
  
  String map(User value);
  
  String map(Book value);

}
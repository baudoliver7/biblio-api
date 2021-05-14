package com.biblio.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.biblio.domain.Loan;
import com.biblio.dto.CreateLoanRequest;
import com.biblio.dto.LoanDto;
import com.biblio.mapper.LoanMapper;
import com.biblio.service.LoanService;

import static com.biblio.config.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;
    private final LoanMapper loanMapper;

    @Operation(security = { @SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME) })
    @GetMapping
    public List<LoanDto> getLoans() {
        List<Loan> loans = loanService.getLoans();
        return loans.stream()
                .map(loanMapper::toLoanDto)
                .collect(Collectors.toList());
    }

    @Operation(security = { @SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME) })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LoanDto createLoan(@Valid @RequestBody CreateLoanRequest createLoanRequest) {
        Loan lean = loanMapper.toLoan(createLoanRequest);
        return loanMapper.toLoanDto(loanService.saveLoan(lean));
    }

    @Operation(security = { @SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME) })
    @DeleteMapping("/{id}")
    public LoanDto deleteBook(@PathVariable Long id) {
    	Loan loan = loanService.get(id);
        loanService.deleteLoan(loan);
        return loanMapper.toLoanDto(loan);
    }

}

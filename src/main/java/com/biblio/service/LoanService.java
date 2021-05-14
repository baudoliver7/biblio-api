package com.biblio.service;

import java.util.List;
import com.biblio.domain.Loan;

public interface LoanService {

	Loan get(Long id);
	
    List<Loan> getLoans();

    Loan saveLoan(Loan loan);

    void deleteLoan(Loan loan);
    
    void closeLoan(Loan loan);

}

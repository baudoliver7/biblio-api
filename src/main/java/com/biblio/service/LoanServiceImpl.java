package com.biblio.service;

import org.springframework.stereotype.Service;

import com.biblio.domain.Loan;
import com.biblio.repository.LoanRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

	@Override
	public List<Loan> getLoans() {
		return loanRepository.findAllByOrderByDate();
	}

	@Override
	public Loan saveLoan(Loan loan) {
		return loanRepository.save(loan);
	}

	@Override
	public void deleteLoan(Loan loan) {
		loanRepository.delete(loan);
	}

	@Override
	public void closeLoan(Loan loan) {
		loan.setClosed(true);
		this.saveLoan(loan);
	}

	@Override
	public Loan get(Long id) {
		return loanRepository.getOne(id);
	}
}

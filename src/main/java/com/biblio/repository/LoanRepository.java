package com.biblio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.biblio.domain.Book;
import com.biblio.domain.Loan;
import com.biblio.domain.User;

public interface LoanRepository extends JpaRepository<Loan, Long> {

  List<Loan> findAllByOrderByDate();

  List<Loan> findByUser(User user);

  List<Loan> findByBook(Book book);
}

package com.blackbucks.Splitwise.ExpenseRepositories;


import com.blackbucks.Splitwise.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {

}

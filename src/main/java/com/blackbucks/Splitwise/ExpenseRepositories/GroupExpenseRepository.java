package com.blackbucks.Splitwise.ExpenseRepositories;

import com.blackbucks.Splitwise.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense,Integer> {
    List<GroupExpense> findByGroup_Id(int groupId);
}

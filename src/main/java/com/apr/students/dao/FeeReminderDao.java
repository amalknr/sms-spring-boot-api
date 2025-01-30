package com.apr.students.dao;

import com.apr.students.model.FeeReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeReminderDao extends JpaRepository<FeeReminder, Integer> {
    // Custom query methods can be added here if needed
}

package com.apr.students.dao;

import com.apr.students.model.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableDao extends JpaRepository<TimeTable, Long> {
    // Add any custom query methods if needed
}

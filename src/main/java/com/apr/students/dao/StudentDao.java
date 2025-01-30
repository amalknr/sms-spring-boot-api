package com.apr.students.dao;

import com.apr.students.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Students, Integer> {
    // No additional methods are required at the moment
}

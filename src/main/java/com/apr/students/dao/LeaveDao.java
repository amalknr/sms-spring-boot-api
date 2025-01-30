package com.apr.students.dao;

import com.apr.students.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveDao extends JpaRepository<Leave, Long> {
    // Additional custom query methods can go here
}

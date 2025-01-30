package com.apr.students.dao;

import com.apr.students.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeDao extends JpaRepository<Notice, Integer> {
}

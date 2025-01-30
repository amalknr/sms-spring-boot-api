package com.apr.students.dao;

import com.apr.students.model.TodayClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends JpaRepository<TodayClass,Long> {

}

package com.apr.students.service;

import com.apr.students.dao.TimeTableDao;
import com.apr.students.model.TimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableService {

    @Autowired
    private TimeTableDao timeTableDao;

    // Add a new timetable
    public TimeTable addTimeTable(TimeTable timeTable) {
        return timeTableDao.save(timeTable);
    }

    // Retrieve all timetables
    public List<TimeTable> getAllTimeTables() {
        return timeTableDao.findAll();
    }

    // Retrieve a timetable by ID
    public TimeTable getTimeTableById(Long id) {
        return timeTableDao.findById(id).orElse(null);
    }

    // Update a timetable
    public TimeTable updateTimeTable(Long id, TimeTable timeTable) {
        timeTable.setId(id); // Ensure the ID is set
        return timeTableDao.save(timeTable);
    }

    // Delete a timetable
    public void deleteTimeTable(Long id) {
        timeTableDao.deleteById(id);
    }
}

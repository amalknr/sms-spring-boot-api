package com.apr.students.api;

import com.apr.students.model.TimeTable;
import com.apr.students.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timetables")
public class TimeTableResource {

    @Autowired
    private TimeTableService timeTableService;

    // Add a new timetable
    @PostMapping
    public TimeTable addTimeTable(@RequestBody TimeTable timeTable) {
        return timeTableService.addTimeTable(timeTable);
    }

    // Get all timetables
    @GetMapping
    public List<TimeTable> getAllTimeTables() {
        return timeTableService.getAllTimeTables();
    }

    // Get a specific timetable by ID
    @GetMapping("/{id}")
    public TimeTable getTimeTableById(@PathVariable Long id) {
        return timeTableService.getTimeTableById(id);
    }

    // Update a timetable
    @PutMapping("/{id}")
    public TimeTable updateTimeTable(@PathVariable Long id, @RequestBody TimeTable timeTable) {
        return timeTableService.updateTimeTable(id, timeTable);
    }

    // Delete a timetable
    @DeleteMapping("/{id}")
    public void deleteTimeTable(@PathVariable Long id) {
        timeTableService.deleteTimeTable(id);
    }
}

package com.apr.students.api;

import com.apr.students.model.TodayClass;
import com.apr.students.service.TodayClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class TodayClassResource {

    @Autowired
    private final TodayClassService todayClassService;

    public TodayClassResource(TodayClassService todayClassService) {
        this.todayClassService = todayClassService;
    }

    // Get all classes
    @GetMapping
    public List<TodayClass> getAllClasses() {
        return todayClassService.getAllClasses();
    }

    // Get class by ID
    @GetMapping("/{id}")
    public TodayClass getClassById(@PathVariable Long id) {
        return todayClassService.getClassById(id);
    }

    // Create a new class
    @PostMapping(consumes = "application/json")
    public TodayClass createClass(@RequestBody TodayClass todayClass) {
        return todayClassService.createClass(todayClass);
    }

    // Update an existing class (Retain existing fields)
    @PutMapping(value = "/{id}", consumes = "application/json")
    public TodayClass updateClass(
            @PathVariable("id") Long id,
            @RequestBody TodayClass updatedClass
    ) {
        // Fetch the existing class
        TodayClass existingClass = todayClassService.getClassById(id);
        if (existingClass == null) {
            throw new IllegalArgumentException("Class with ID " + id + " not found");
        }

        // Merge only non-null values
        if (updatedClass.getTeacherName() != null) {
            existingClass.setTeacherName(updatedClass.getTeacherName());
        }
        if (updatedClass.getTodaySubject() != null) {
            existingClass.setTodaySubject(updatedClass.getTodaySubject());
        }
        if (updatedClass.getClassTime() != null) {
            existingClass.setClassTime(updatedClass.getClassTime());
        }
        if (updatedClass.getClassStatus() != null) {
            existingClass.setClassStatus(updatedClass.getClassStatus());
        }

        // Save and return the updated class
        return todayClassService.updateClass(id, existingClass);
    }

    // Delete a class by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClass(@PathVariable Long id) {
        todayClassService.deleteClass(id);
    }
}

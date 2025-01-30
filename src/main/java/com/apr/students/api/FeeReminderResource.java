package com.apr.students.api;

import com.apr.students.model.FeeReminder;
import com.apr.students.service.FeeReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fee-reminders")
public class FeeReminderResource {

    @Autowired
    private FeeReminderService feeReminderService;

    // Add a new fee reminder
    @PostMapping
    public FeeReminder addFeeReminder(@RequestBody FeeReminder feeReminder) {
        return feeReminderService.addFeeReminder(feeReminder);
    }

    // Get all fee reminders
    @GetMapping
    public List<FeeReminder> getAllFeeReminders() {
        return feeReminderService.getAllFeeReminders();
    }

    // Get a specific fee reminder by ID
    @GetMapping("/{id}")
    public FeeReminder getFeeReminderById(@PathVariable int id) {
        return feeReminderService.getFeeReminderById(id);
    }

    // Update a fee reminder
    @PutMapping("/{id}")
    public FeeReminder updateFeeReminder(@PathVariable int id, @RequestBody FeeReminder feeReminder) {
        return feeReminderService.updateFeeReminder(id, feeReminder);
    }

    // Delete a fee reminder
    @DeleteMapping("/{id}")
    public void deleteFeeReminder(@PathVariable int id) {
        feeReminderService.deleteFeeReminder(id);
    }
}

package com.apr.students.service;

import com.apr.students.dao.FeeReminderDao;
import com.apr.students.model.FeeReminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeReminderService {

    @Autowired
    private FeeReminderDao feeReminderDao;

    // Add a new fee reminder
    public FeeReminder addFeeReminder(FeeReminder feeReminder) {
        return feeReminderDao.save(feeReminder);
    }

    // Retrieve all fee reminders
    public List<FeeReminder> getAllFeeReminders() {
        return feeReminderDao.findAll();
    }

    // Retrieve a fee reminder by ID
    public FeeReminder getFeeReminderById(int id) {
        return feeReminderDao.findById(id).orElse(null);
    }

    // Update a fee reminder
    public FeeReminder updateFeeReminder(int id, FeeReminder feeReminder) {
        feeReminder.setId(id); // Ensure the ID is set
        return feeReminderDao.save(feeReminder);
    }

    // Delete a fee reminder
    public void deleteFeeReminder(int id) {
        feeReminderDao.deleteById(id);
    }
}

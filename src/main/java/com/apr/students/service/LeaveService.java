package com.apr.students.service;
import com.apr.students.dao.LeaveDao;
import com.apr.students.model.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private LeaveDao leaveDao;

    // Add a new leave
    public Leave addLeave(Leave leave) {
        return leaveDao.save(leave);
    }

    // Retrieve all leave records
    public List<Leave> getAllLeaves() {
        return leaveDao.findAll();
    }

    // Retrieve a leave by ID
    public Leave getLeaveById(Long leaveId) {
        return leaveDao.findById(leaveId).orElse(null);
    }

    // Update leave details
    public Leave updateLeave(Long leaveId, Leave leave) {
        leave.setId(leaveId); // Ensure the leave ID is set
        return leaveDao.save(leave);
    }

    // Delete leave by ID
    public void deleteLeave(Long leaveId) {
        leaveDao.deleteById(leaveId);
    }
}
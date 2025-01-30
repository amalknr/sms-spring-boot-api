package com.apr.students.api;

import com.apr.students.model.Leave;
import com.apr.students.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveResource {

    @Autowired
    private LeaveService leaveService;

    // Add a new leave
    @PostMapping
    public Leave addLeave(@RequestBody Leave leave) {
        return leaveService.addLeave(leave);
    }

    // Get all leave records
    @GetMapping
    public List<Leave> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    // Get a specific leave by ID
    @GetMapping("/{leaveId}")
    public Leave getLeaveById(@PathVariable Long leaveId) {
        return leaveService.getLeaveById(leaveId);
    }

    // Update a leave record
    @PutMapping("/{leaveId}")
    public Leave updateLeave(@PathVariable Long leaveId, @RequestBody Leave leave) {
        return leaveService.updateLeave(leaveId, leave);
    }

    // Delete a leave record
    @DeleteMapping("/{leaveId}")
    public void deleteLeave(@PathVariable Long leaveId) {
        leaveService.deleteLeave(leaveId);
    }
}

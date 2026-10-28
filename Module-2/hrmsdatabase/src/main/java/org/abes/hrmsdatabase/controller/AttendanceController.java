package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.Model.Attendance;
import org.abes.hrmsdatabase.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/v1/user/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;
    public AttendanceController(AttendanceService attendanceService) { this.attendanceService = attendanceService; }

    @GetMapping("/employee/{empId}")
    public List<Attendance> getEmployeeAttendance(@PathVariable long empId) { return attendanceService.getEmployeeAttendance(empId); }

    @PostMapping({"/markattendance", "/checkin"})
    public ResponseEntity<String> checkIn(@RequestBody Attendance attendance) {
        String result = attendanceService.checkIn(attendance);
        return result.equals("Check-in recorded successfully") ? ResponseEntity.ok(result) : ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkOut(@RequestBody Attendance attendance) {
        String result = attendanceService.checkOut(attendance);
        return result.equals("Check-out recorded successfully") ? ResponseEntity.ok(result) : ResponseEntity.badRequest().body(result);
    }
}

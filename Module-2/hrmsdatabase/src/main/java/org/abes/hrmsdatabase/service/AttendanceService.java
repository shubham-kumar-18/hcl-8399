package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.Model.Attendance;
import org.abes.hrmsdatabase.Model.Employee;
import org.abes.hrmsdatabase.repository.AttendanceRepository;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, EmployeeRepository employeeRepository) {
        this.attendanceRepository = attendanceRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Attendance> getEmployeeAttendance(long empId) {
        return attendanceRepository.findAttendanceForEmployee(empId);
    }

    @Transactional
    public String checkIn(Attendance attendance) {
        if (attendance == null || attendance.getEmployee() == null || attendance.getAttendancedate() == null) return "Employee and attendance date are required";
        Employee employee = employeeRepository.findById(attendance.getEmployee().getEmp_id()).orElse(null);
        if (employee == null) return "Employee not found";
        if (attendanceRepository.existsByEmployeeAndAttendancedate(employee, attendance.getAttendancedate())) return "Attendance already marked for this employee on this date";
        attendance.setEmployee(employee);
        attendance.setInTime(LocalDateTime.now());
        attendance.setOutTime(null);
        attendanceRepository.save(attendance);
        return "Check-in recorded successfully";
    }

    @Transactional
    public String checkOut(Attendance attendance) {
        if (attendance == null || attendance.getEmployee() == null || attendance.getAttendancedate() == null) return "Employee and attendance date are required";
        Employee employee = employeeRepository.findById(attendance.getEmployee().getEmp_id()).orElse(null);
        if (employee == null) return "Employee not found";
        Attendance existing = attendanceRepository.findByEmployeeAndAttendancedate(employee, attendance.getAttendancedate()).orElse(null);
        if (existing == null || existing.getInTime() == null) return "Please check in before checking out";
        if (existing.getOutTime() != null) return "Check-out already recorded for today";
        existing.setOutTime(LocalDateTime.now());
        if (attendance.getComment() != null && !attendance.getComment().isBlank()) existing.setComment(attendance.getComment());
        attendanceRepository.save(existing);
        return "Check-out recorded successfully";
    }
}


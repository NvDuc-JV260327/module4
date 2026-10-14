package com.example.ex5.controller;

import com.example.ex5.model.dto.EmployeeFilter;
import com.example.ex5.model.entity.Employee;
import com.example.ex5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.getByName(name));
    }

    @GetMapping("/filter")
    public ResponseEntity<String> employeeFilter(@ModelAttribute EmployeeFilter employeeFilter) {
        return ResponseEntity.ok("Đang lọc theo tên: " + employeeFilter.getName() + " và phòng ban: " + employeeFilter.getDepartment());
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.editEmployee(id, employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        if(employeeService.deleteEmployee(id)) {
            return new ResponseEntity<String>("Xóa thành công", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<String>("Id không tồn tại!", HttpStatus.NOT_FOUND);
        }
    }
}

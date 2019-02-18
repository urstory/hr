package my.examples.hr.controller;

import lombok.RequiredArgsConstructor;
import my.examples.hr.domain.Employee;
import my.examples.hr.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeApiController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmploee(@PathVariable(name = "id")Long employeeId){
        return employeeService.getEmployee(employeeId);
    }
}

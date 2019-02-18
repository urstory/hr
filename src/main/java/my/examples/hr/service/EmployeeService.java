package my.examples.hr.service;

import my.examples.hr.domain.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();

    public Employee getEmployee(Long employeeId);
}

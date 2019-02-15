package my.examples.hr.repository.custom;

import my.examples.hr.domain.Employee;

import java.util.List;

public interface EmployeeRepositoryCustom {
    public List<Employee> getEmployees(EmployeeSearchType employeeSearchType, String searchStr);
}

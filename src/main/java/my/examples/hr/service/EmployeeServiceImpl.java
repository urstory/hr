package my.examples.hr.service;

import lombok.RequiredArgsConstructor;
import my.examples.hr.domain.Employee;
import my.examples.hr.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployeeAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployee(Long employeeId) {
        return employeeRepository.getEmployeeById(employeeId);
    }
}

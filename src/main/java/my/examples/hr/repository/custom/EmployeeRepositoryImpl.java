package my.examples.hr.repository.custom;

import com.querydsl.jpa.JPQLQuery;
import my.examples.hr.domain.Employee;
import my.examples.hr.domain.QEmployee;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class EmployeeRepositoryImpl extends QuerydslRepositorySupport implements EmployeeRepositoryCustom {
    public EmployeeRepositoryImpl(){
        super(Employee.class); // 사용할 Entity클래스를 지정.
    }

    @Override
    public List<Employee> getEmployees(EmployeeSearchType employeeSearchType, String searchStr) {
        // SELECT distinct e FROM Employee e INNER JOIN FETCH e.department INNERT JOIN FETCH e.job WHERE e.firstName = :searchStr
        // SELECT distinct e FROM Employee e INNER JOIN FETCH e.department INNERT JOIN FETCH e.job WHERE e.department.name = :searchStr
        // SELECT distinct e FROM Employee e INNER JOIN FETCH e.department INNERT JOIN FETCH e.job WHERE e.job.name = :searchStr

        QEmployee qEmployee = QEmployee.employee;
        JPQLQuery<Employee> query = from(qEmployee); // select e from Employee e
        query.innerJoin(qEmployee.department).fetchJoin(); // select e from Employee e inner join fetch e.department
        query.innerJoin(qEmployee.job).fetchJoin(); // select e from Employee e inner join fetch e.department inner join fetch e.job

        if(employeeSearchType == EmployeeSearchType.NAME){
            query.where(qEmployee.firstName.eq(searchStr));
        }else if(employeeSearchType == EmployeeSearchType.DEPARTMENT_NAME){
            query.where(qEmployee.department.departmentName.eq(searchStr));
        }else if(employeeSearchType == EmployeeSearchType.JOB_NAME){
            query.where(qEmployee.job.jobTitle.eq(searchStr));
        }

        query.orderBy(qEmployee.employeeId.asc());

        return query.fetch();
    }
}

// NAME, DEPARTMENT_NAME, JOB_NAME
package my.examples.hr.repository;

import my.examples.hr.domain.Employee;
import my.examples.hr.repository.custom.EmployeeRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

// JpaRepository<엔티티클래스명, Id타입> 를 상속받는 interface를 정의한다.
public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryCustom {
    // 사원의 이름(first, last), 이메일 정보
    @Query("SELECT e FROM Employee e inner join fetch e.job")
    List<Employee> getEmployeeAll();

    @Query("SELECT e FROM  Employee e left join fetch e.job where e.employeeId = :id")
    Employee getEmployeeById(@Param("id") Long id);

    // 특정부서(이름) 에 속한 사원의 이름을 출력하시오.
    @Query("SELECT e FROM Employee e join fetch e.department d WHERE d.departmentName = :name")
    List<Employee> getEmployeeJoinDepartment(@Param("name") String name);

    //사원의 이름(first_name, last_name)을 출력하세요. 1page가 3건씩 보여집니다.
    // 특정부서(이름) 에 속한 사원의 이름을 출력하시오.
    @Query("SELECT e FROM Employee e WHERE e.department.departmentName = :departmentName ORDER BY e.firstName")
    public Page<Employee> getEmployeeByDepartmentName(@Param("departmentName") String departmentName, Pageable pageable);

    //사원이름으로 like 검색한 검색결과 출력
    @Query("select e from Employee e WHERE e.firstName Like CONCAT(UPPER(:name),'%') ORDER BY e.firstName")
    public Page<Employee> getEmployeeByFirstName(@Param("name") String name, Pageable pageable);
}

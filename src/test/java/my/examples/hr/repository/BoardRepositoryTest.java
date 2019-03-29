package my.examples.hr.repository;

import my.examples.hr.domain.Department;
import my.examples.hr.domain.Employee;
import my.examples.hr.repository.custom.EmployeeSearchType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import org.springframework.data.domain.PageRequest;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository; // test할 대상

    @Test
    public void initTest(){
        // 아무런 코드가 없음. 에러가 안난다면 설정은 잘되어 있다는 뜻.
    }

    @Test
    public void search() throws Exception{
        List<Employee> all = employeeRepository.getEmployees(EmployeeSearchType.JOB_NAME, "Programmer");
        for(Employee e : all){
            System.out.println(e.getFirstName() + ", " + e.getLastName());
        }

    }

    @Test
    public void findBoss() throws Exception{
        Employee employee = employeeRepository.getEmployeeById(100L);
        int i = 1;
        Employee boss = employee.getManager();
        String bossName = "";
        if(boss != null){
            bossName = boss.getFirstName();
        }
        System.out.println(i + " - " + employee.getFirstName() + " , " + bossName);
        i++;

    }

    @Test
    public void findAll() throws Exception{
        List<Employee> all = employeeRepository.getEmployeeAll();
        int i = 1;
        for(Employee employee : all){
             System.out.println(i + "- Name : " + employee.getFirstName() + ", " + employee.getJob());
             i++;
        }
    }

    @Test
    public void employeeJoinDepartment() throws Exception{
        List<Employee> all = employeeRepository.getEmployeeJoinDepartment("IT");
        System.out.println("IT부서에 일하는 사람");
        for(Employee employee : all){
            System.out.println("Name : " + employee.getFirstName()+ " " + employee.getLastName());
            System.out.println("E-mail : " + employee.getEmail());
        }
    }

    @Test
    public void employeeJoinDepartmentPage() throws Exception{
        Pageable page = PageRequest.of(1, 3);
        Page<Employee> all = employeeRepository.getEmployeeByDepartmentName("Sales", page);
        System.out.println("Sales부서에 일하는 사람");
        System.out.println("전체 건수 : " + all.getTotalElements());
        for(Employee employee : all){
            System.out.println("Name : " + employee.getFirstName()+ " " + employee.getLastName());
            System.out.println("E-mail : " + employee.getEmail());
        }
    }

    @Test
    public void employeeByFirstName() throws Exception{
        Pageable page = PageRequest.of(1, 3);
        Page<Employee> all = employeeRepository.getEmployeeByFirstName("A", page);
        System.out.println("A로 시작하는 사람");
        System.out.println("전체 건수 : " + all.getTotalElements());
        System.out.println("페이지 : " + all.getTotalPages());
        System.out.println("현재 건수 : " + all.getNumberOfElements());
        for(Employee employee : all){
            System.out.println("Name : " + employee.getFirstName()+ " " + employee.getLastName());
            System.out.println("E-mail : " + employee.getEmail());
        }
    }
}

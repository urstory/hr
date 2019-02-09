package my.examples.hr.repository;

import my.examples.hr.domain.Department;
import my.examples.hr.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class DepartmentRepositoryTest {
    @Autowired
    DepartmentRepository departmentRepository; // test할 대상

    @Test
    public void initTest(){
        // 아무런 코드가 없음. 에러가 안난다면 설정은 잘되어 있다는 뜻.
    }

    @Test
    public void getDepartments() throws Exception{
        List<Department> all = departmentRepository.getDepartments2();
        for(Department department : all){
            System.out.println(department.getDepartmentName() );
        }
    }

    @Test
    public void getDepartmentsByName() throws Exception{
        List<Department> all = departmentRepository.getDepartmentsByName("Treasury");
        for(Department department : all){
            System.out.println(department.getDepartmentName() + ", " + department.getLocation().getCity() );
        }
    }

    @Test
    public void getDepartmentsWithPartOfName() throws Exception{
        List<Department> all = departmentRepository.getDepartmentsWithPartOfName("a");
        for(Department department : all){
            System.out.println(department.getDepartmentName() + ", " + department.getLocation().getCity() );
        }
    }

    @Test
    public void getDepartmentsByCityname() throws Exception{
        List<Department> all = departmentRepository.getDepartmentsByCityname("Seattle");
        for(Department department : all){
            System.out.println(department.getDepartmentName() + ", " + department.getLocation().getCity() );
        }
    }
}

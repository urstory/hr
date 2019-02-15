package my.examples.hr.repository;

import my.examples.hr.domain.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// JpaRepository<엔티티클래스명, Id타입> 를 상속받는 interface를 정의한다.
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    @Query("SELECT d FROM Department d")
    public List<Department> getDepartments();

    @Query(value = "SELECT distinct d FROM Department d inner join fetch d.employees WHERE d.departmentId = :id",
            countQuery = "SELECT count(d) FROM Department d WHERE d.departmentId = :id"
    )
    public Page<Department> getDepartmentById(@Param("id") Long id, Pageable pageable);

    @Query("SELECT d FROM Department d inner join fetch d.location")
    public List<Department> getDepartments2();

    @Query("SELECT d FROM Department d WHERE d.departmentName = :name")
    public List<Department> getDepartmentsByName(@Param("name") String name);

    @Query("SELECT d FROM Department d WHERE d.departmentName LIKE CONCAT('%',:name,'%')")
    public List<Department> getDepartmentsWithPartOfName(@Param("name") String name);

    @Query("SELECT d FROM Department d WHERE d.location.city = :cityname")
    public List<Department> getDepartmentsByCityname(@Param("cityname") String cityname);
}

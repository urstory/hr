package my.examples.hr.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Department")
@Table(name = "departments")
@Setter
@Getter
public class Department {
    @Id
    private Long departmentId;
    private String departmentName;
//    @ManyToOne
//    @JoinColumn(name = "manager_id")
//    private Employee manager;

//    @OneToMany(mappedBy = "department")
//    private Set<Employee> employees;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

//    public Department(){
//        employees = new HashSet<>();
//    }
}

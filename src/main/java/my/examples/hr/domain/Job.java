package my.examples.hr.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    private String jobId;
    private String jobTitle;
    private double minSalary;
    private double maxSalary;
    @OneToMany(mappedBy = "job")
    private Set<Employee> employees;
    @OneToMany(mappedBy = "job")
    private Set<JobHistory> jobHistories;

    public Job(){
        employees = new HashSet<>();
        jobHistories = new HashSet<>();
    }
}

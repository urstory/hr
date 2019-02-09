package my.examples.hr.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "job_history")
public class JobHistory {
    @EmbeddedId
    private JobHistoryId jobHistoryId;
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public JobHistory(){
        endDate = new Date();
    }
}

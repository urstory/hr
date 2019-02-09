package my.examples.hr.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Data
@Embeddable
public class JobHistoryId implements Serializable {
    private Long employeeId;
    private Date startDate;

    public JobHistoryId(){
        startDate = new Date();
    }
}

/*
| employee_id   | int(11) unsigned | NO   | PRI | NULL    |       |
| start_date    | date             | NO   | PRI | NULL    |       |
 */
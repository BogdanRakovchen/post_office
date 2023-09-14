package pro.sky.post_office.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "operation")
@Data
@AllArgsConstructor
public class OperationMailingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idMailing;
    private String operation;
    @Column(name = "dates")
    private String date;
    private int mailingPost;
    private int department;

    public OperationMailingEntity() {}

}

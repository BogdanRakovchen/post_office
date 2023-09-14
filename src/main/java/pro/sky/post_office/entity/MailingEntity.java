package pro.sky.post_office.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "mailing")
public class MailingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idMailing;
    private String mailingType;
    private String recipientIndex;
    @Column(name = "adress_recipient")
    private String addressRecipient;
    private String nameRecipient;
    private String status;
}

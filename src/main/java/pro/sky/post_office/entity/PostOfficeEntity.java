package pro.sky.post_office.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "post_department")
public class PostOfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idMailing;
    private int indexPost;
    private String title;
    @Column(name = "address_recipient")
    private String addressRecipient;
}

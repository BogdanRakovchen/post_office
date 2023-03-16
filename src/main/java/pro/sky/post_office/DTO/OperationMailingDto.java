package pro.sky.post_office.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationMailingDto {
 
    private Integer id;
    private Integer idMailing;
    private String operation;
    private String date;
    private Integer mailingPost;
    private Integer department;
    
}

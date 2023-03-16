package pro.sky.post_office.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * свойства почтового отправления:
 * идентификатор, тип, индекс, адрес, имя получателя
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailingDto {
    private Integer id;
    private Integer idMailing;
    private String mailingType;
    private String recipientIndex;
    private String addressRecipient;
    private String nameRecipient;
    private String status;
}

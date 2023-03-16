package pro.sky.post_office.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * свойства почтового отделения:
 * идентификатор, индекс, название почтового отделения, адрес получателя
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostOfficeDto {
    private Integer id;
    private Integer idMailing;
    private Integer indexPost;
    private String title;
    private String addressRecipient;
}

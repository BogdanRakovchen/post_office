package pro.sky.post_office.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pro.sky.post_office.repository.MailingRepository;
import pro.sky.post_office.repository.PostOfficeRepository;
import pro.sky.post_office.repository.OperationMailingRepository;

import pro.sky.post_office.DTO.MailingDto;
import pro.sky.post_office.DTO.OperationMailingDto;
import pro.sky.post_office.DTO.PostOfficeDto;
import pro.sky.post_office.entity.MailingEntity;
import pro.sky.post_office.entity.OperationMailingEntity;
import pro.sky.post_office.entity.PostOfficeEntity;
import pro.sky.post_office.mapping.MappersTo;

@Service
@AllArgsConstructor
public class PostOfficeOperationService {

    private final OperationMailingRepository operationMailingRepository;
    private final MailingRepository mailingRepository;
    private final PostOfficeRepository postOfficeRepository;
    
    /**
     * заносим данные о почтовом отправлении
     * @param mailing
     * @return через маппер дто почтового отправления
     */

    public MailingDto mailing(MailingDto mailing) {
        MailingEntity mailingEntity = new MailingEntity();
        mailingEntity.setIdMailing(mailing.getIdMailing());
        mailingEntity.setMailingType(mailing.getMailingType().toString());
        mailingEntity.setRecipientIndex(mailing.getRecipientIndex());
        mailingEntity.setAddressRecipient(mailing.getAddressRecipient());
        mailingEntity.setNameRecipient(mailing.getNameRecipient());
        mailingEntity.setStatus(mailing.getStatus());
        mailingRepository.save(mailingEntity);
        return MappersTo.INSTANCE.mailingEntityToMailingDto(mailingEntity);
    }

    /**
     * регистрационные данные почтового отправления
     * заносятся дата, идентификатор отправления, операция: отправлен, убыл, прибыл и т.д
     * индекс отделения почты где произошла операция
     * @param operationMailingDto
     * @return
     */

    public OperationMailingDto registrationPost(OperationMailingDto operationMailingDto) {
        OperationMailingEntity operationMailingEntity = new OperationMailingEntity();
        operationMailingEntity.setDate(LocalDateTime.now().toLocalDate().toString());
        operationMailingEntity.setIdMailing(mailingRepository.getMailingId());
        operationMailingEntity.setOperation(operationMailingDto.getOperation());
        operationMailingEntity.setMailingPost(mailingRepository.getMailingId());
        operationMailingEntity.setDepartment(postOfficeRepository.getIndexPostDepartment());
        operationMailingRepository.save(operationMailingEntity);
        return MappersTo.INSTANCE.operationMailingEntityToOperationMailingDto(operationMailingEntity);
    }

     /**
      * добавление информации о почтовом отправлении:
      * индекс отделения, идентификатор посылки, название отделения, 
      * адрес получателя
      * @param postOfficeDto
      * @return
      */
    public PostOfficeDto addDataAboutPostDepartment(PostOfficeDto postOfficeDto) {
      PostOfficeEntity postOfficeEntity = new PostOfficeEntity();
      postOfficeEntity.setIndexPost(postOfficeDto.getIndexPost());
      postOfficeEntity.setIdMailing(mailingRepository.getMailingId());
      postOfficeEntity.setTitle(postOfficeDto.getTitle());
      postOfficeEntity.setAddressRecipient(mailingRepository.getAddressRecipient());
      postOfficeRepository.save(postOfficeEntity);
      return MappersTo.INSTANCE.postOfficeEntityToPostOfficeDto(postOfficeEntity);
    }

    /**
     * изменение данных по операции: если было отправлено, а затем прибыло
     * здесь мы этот случай отрабатываем
     * @param operationMailingDto
     * @return
     */
  
      public OperationMailingDto updateOperation(OperationMailingDto operationMailingDto) {
        OperationMailingEntity operationMailingEntity = new OperationMailingEntity();
        operationMailingEntity.setDate(LocalDateTime.now().toLocalDate().toString());
        operationMailingEntity.setIdMailing(mailingRepository.getMailingId());
        operationMailingEntity.setOperation(operationMailingDto.getOperation());
        operationMailingEntity.setMailingPost(mailingRepository.getMailingId());
        operationMailingEntity.setDepartment(operationMailingDto.getDepartment());
        operationMailingRepository.save(operationMailingEntity);
        return MappersTo.INSTANCE.operationMailingEntityToOperationMailingDto(operationMailingEntity);
    }

    /**
     * получение всей информации, истории той или иной посылки
     * на основе идентификатора
     * @param id
     * @return
     */

    public Collection<Object> getAllChronology(String id) {
      int idx = Integer.parseInt(id);
      Collection<Object> collection = new ArrayList<>(List.of());
      collection.add(mailingRepository.getMailingDto(idx));
      collection.add(operationMailingRepository.getOperationMailingDto(idx));
      collection.add(postOfficeRepository.getPostOfficeDto(idx));
      return collection;
    }
}

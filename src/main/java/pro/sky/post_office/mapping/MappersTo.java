package pro.sky.post_office.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import pro.sky.post_office.DTO.MailingDto;
import pro.sky.post_office.DTO.OperationMailingDto;
import pro.sky.post_office.DTO.PostOfficeDto;

import pro.sky.post_office.entity.MailingEntity;
import pro.sky.post_office.entity.OperationMailingEntity;
import pro.sky.post_office.entity.PostOfficeEntity;

@Mapper
public interface MappersTo    {

    MappersTo INSTANCE = Mappers.getMapper(MappersTo.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "idMailing", target = "idMailing")
    @Mapping(source = "mailingType", target = "mailingType")
    @Mapping(source = "recipientIndex", target = "recipientIndex")
    @Mapping(source = "addressRecipient", target = "addressRecipient")
    @Mapping(source = "nameRecipient", target = "nameRecipient")
    @Mapping(source = "status", target = "status")
    MailingDto mailingEntityToMailingDto(MailingEntity mailingEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "idMailing", target = "idMailing")
    @Mapping(source = "operation", target = "operation")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "mailingPost", target = "mailingPost")
    @Mapping(source = "department", target = "department")
    OperationMailingDto operationMailingEntityToOperationMailingDto(OperationMailingEntity operationEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "idMailing", target = "idMailing")
    @Mapping(source = "indexPost", target = "indexPost")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "addressRecipient", target = "addressRecipient")
    PostOfficeDto postOfficeEntityToPostOfficeDto(PostOfficeEntity postOfficeEntity);
}

package pro.sky.post_office.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.Collection;


import lombok.AllArgsConstructor;
import pro.sky.post_office.DTO.MailingDto;
import pro.sky.post_office.DTO.PostOfficeDto;
import pro.sky.post_office.DTO.OperationMailingDto;

import pro.sky.post_office.service.PostOfficeOperationService;

@RestController
@RequestMapping("/mailing")
@AllArgsConstructor
public class PostOfficeOperationController {
    
    private final PostOfficeOperationService postOfficeOperationService;

    @PostMapping("/add")
    @Operation(summary = "добавление посылки")
    @ApiResponse(responseCode = "400", description = "плохой запрос") 
    @ApiResponse(responseCode = "200", description = "запрос выполнен")
    public MailingDto addMailing(@RequestBody MailingDto mailing) {
        return postOfficeOperationService.mailing(mailing);
    }

    @PostMapping("/registration")
    @Operation(summary = "регистрация посылки")
    @ApiResponse(responseCode = "400", description = "плохой запрос") 
    @ApiResponse(responseCode = "200", description = "запрос выполнен")
    public OperationMailingDto registrationMailing(@RequestBody OperationMailingDto operationMailingDto) {
        return postOfficeOperationService.registrationPost(operationMailingDto);
    }


    @PostMapping("/add-post-info")
    @Operation(summary = "добавление информации по почтовому отделению")
    @ApiResponse(responseCode = "400", description = "плохой запрос") 
    @ApiResponse(responseCode = "200", description = "запрос выполнен")
    public PostOfficeDto addDataAboutPostDepartment(@RequestBody PostOfficeDto postOfficeDto) {
        return postOfficeOperationService.addDataAboutPostDepartment(postOfficeDto);
    }

    @PatchMapping("/update-operation")
    @Operation(summary = "обновление информации о статусе посылки")
    @ApiResponse(responseCode = "400", description = "плохой запрос") 
    @ApiResponse(responseCode = "200", description = "запрос выполнен")
    public OperationMailingDto updateStatusMailing(@RequestBody OperationMailingDto operationMailingDto) {
        return postOfficeOperationService.updateOperation(operationMailingDto);
    }

    @GetMapping("/chronology/{id}")
    @Operation(summary = "получение всей информации о посылке")
    @ApiResponse(responseCode = "400", description = "плохой запрос") 
    @ApiResponse(responseCode = "200", description = "запрос выполнен")
    public Collection<Object> getAllChronology(@PathVariable String id) {
        return postOfficeOperationService.getAllChronology(id);
    }
    
}

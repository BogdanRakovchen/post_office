package pro.sky.post_office;

import static org.mockito.Mockito.lenient;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import pro.sky.post_office.DTO.MailingDto;
import pro.sky.post_office.DTO.OperationMailingDto;
import pro.sky.post_office.DTO.PostOfficeDto;
import pro.sky.post_office.repository.MailingRepository;

import pro.sky.post_office.service.PostOfficeOperationService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PostOfficeApplicationTests {

	@Mock
	private PostOfficeOperationService postOfficeOperationService;

	@Mock
	private MailingRepository mailingRepository;

	MailingDto mailingDto = new MailingDto();
	
	OperationMailingDto operationMailingDto = new OperationMailingDto();
	PostOfficeDto postOfficeDto = new PostOfficeDto();

	@BeforeEach
	public void init() {

		mailingDto.setId(1);
        mailingDto.setIdMailing(1);
        mailingDto.setMailingType("посылка");
        mailingDto.setRecipientIndex("120000");
        mailingDto.setAddressRecipient("Москва");
        mailingDto.setNameRecipient("Дмитрий");
        mailingDto.setStatus("отправлено");

		operationMailingDto.setId(1);
		operationMailingDto.setDate(LocalDateTime.now().toLocalDate().toString());
		operationMailingDto.setDepartment(120000);
		operationMailingDto.setIdMailing(1);
		operationMailingDto.setMailingPost(1);
		operationMailingDto.setOperation("отправлено");

		postOfficeDto.setId(1);
		postOfficeDto.setIdMailing(1);
		postOfficeDto.setIndexPost(120000);
		postOfficeDto.setTitle("Москва");
		postOfficeDto.setAddressRecipient("Москва");

		lenient().when(mailingRepository.getMailingId()).thenReturn(1);
		lenient().when(postOfficeOperationService.mailing(mailingDto)).thenReturn(
			new MailingDto(1, 1, "посылка", "120000", "Москва", "Дмитрий", "отправлено")
		);

		lenient().when(postOfficeOperationService.registrationPost(operationMailingDto)).thenReturn(
			new OperationMailingDto(1, 1, "отправлено", LocalDateTime.now().toLocalDate().toString(), 1, 120000)
		);

		lenient().when(postOfficeOperationService.addDataAboutPostDepartment(postOfficeDto)).thenReturn(
			new PostOfficeDto(1, 1, 120000, "Москва", "Москва")
		);

		lenient().when(postOfficeOperationService.updateOperation(operationMailingDto)).thenReturn(
			new OperationMailingDto(1, 1, "отправлено", LocalDateTime.now().toLocalDate().toString(), 1, 120000)
		);
		
	
	}

	@Test
	public void checkMailingDtoValues() {
		Assertions.assertEquals(mailingDto, postOfficeOperationService.mailing(mailingDto));
	}

	@Test
	public void checkTypesMailingDtoValues() {
		Assertions.assertTrue(mailingDto.getId() instanceof Integer);
		Assertions.assertTrue(mailingDto.getIdMailing() instanceof Integer);
		Assertions.assertTrue(mailingDto.getMailingType() instanceof String);
		Assertions.assertTrue(mailingDto.getRecipientIndex() instanceof String);
		Assertions.assertTrue(mailingDto.getAddressRecipient() instanceof String);
		Assertions.assertTrue(mailingDto.getNameRecipient() instanceof String);
		Assertions.assertTrue(mailingDto.getStatus() instanceof String);
	}

	@Test
	public void checkOperationMailingDtoValues() {
		Assertions.assertEquals(operationMailingDto, postOfficeOperationService.registrationPost(operationMailingDto));
	}

	@Test
	public void checkTypesOperationMailingDtoalues() {
		Assertions.assertTrue(operationMailingDto.getId() instanceof Integer);
		Assertions.assertTrue(operationMailingDto.getDepartment() instanceof Integer);
		Assertions.assertTrue(operationMailingDto.getIdMailing() instanceof Integer);
		Assertions.assertTrue(operationMailingDto.getMailingPost() instanceof Integer);
		Assertions.assertTrue(operationMailingDto.getOperation() instanceof String);
		Assertions.assertTrue(operationMailingDto.getDate() instanceof String);
	}

	

	@Test
	public void checkAboutPostOfficeDtoValues() {
		Assertions.assertEquals(postOfficeDto, postOfficeOperationService.addDataAboutPostDepartment(postOfficeDto));
	}

	@Test
	public void checkTypesPostOfficeDtoValues() {
		Assertions.assertTrue(postOfficeDto.getId() instanceof Integer);
		Assertions.assertTrue(postOfficeDto.getIdMailing() instanceof Integer);
		Assertions.assertTrue(postOfficeDto.getIndexPost() instanceof Integer);
		Assertions.assertTrue(postOfficeDto.getTitle() instanceof String);
		Assertions.assertTrue(postOfficeDto.getAddressRecipient() instanceof String);
	}


	@Test
	public void checkUpdateOperationMethod() {
		Assertions.assertEquals(operationMailingDto, postOfficeOperationService.updateOperation(operationMailingDto));
	}

	@Test
	public void checkTypesUpdateOperationMethod() {
		Assertions.assertTrue(operationMailingDto.getId() instanceof Integer);
		Assertions.assertTrue(operationMailingDto.getDepartment() instanceof Integer);
		Assertions.assertTrue(mailingRepository.getMailingId() instanceof Integer);
		Assertions.assertTrue(mailingRepository.getMailingId() instanceof Integer);
		Assertions.assertTrue(operationMailingDto.getOperation() instanceof String);
		Assertions.assertTrue(operationMailingDto.getDate() instanceof String);
	}


}

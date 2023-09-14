package pro.sky.post_office.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pro.sky.post_office.entity.MailingEntity;


@Repository
public interface MailingRepository extends JpaRepository<MailingEntity, Integer> {
 
    @Query(value = "SELECT id_mailing FROM mailing ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer getMailingId();

    @Query(value = "SELECT adress_recipient FROM mailing ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String getAddressRecipient();

    @Query(value = "SELECT * FROM mailing WHERE mailing.id_mailing = ?1 LIMIT 1", nativeQuery = true)
    MailingEntity getMailingDto(int id);

}

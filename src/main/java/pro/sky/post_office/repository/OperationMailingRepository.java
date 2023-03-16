package pro.sky.post_office.repository;

import org.springframework.stereotype.Repository;

import pro.sky.post_office.entity.OperationMailingEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Collection;


@Repository
public interface OperationMailingRepository extends JpaRepository<OperationMailingEntity, Integer> {
 
    @Query(value = "SELECT id FROM operation ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer getOperationMailingId();

    @Query(value = "SELECT * FROM operation WHERE operation.id_mailing = ?1", nativeQuery = true)
    Collection<OperationMailingEntity> getOperationMailingDto(int id);

}

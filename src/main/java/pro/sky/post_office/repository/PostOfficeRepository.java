package pro.sky.post_office.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pro.sky.post_office.entity.PostOfficeEntity;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOfficeEntity, Integer> {
 
    @Query(value = "SELECT index_post FROM post_department ORDER BY post_department.id DESC LIMIT 1", nativeQuery = true)
    int getIndexPostDepartment();

    @Query(value = "SELECT id FROM post_department ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer getDepartmentId();

     @Query(value = "SELECT * FROM post_department WHERE post_department.id_mailing = ?1 LIMIT 1", nativeQuery = true)
     PostOfficeEntity getPostOfficeDto(int id);
}

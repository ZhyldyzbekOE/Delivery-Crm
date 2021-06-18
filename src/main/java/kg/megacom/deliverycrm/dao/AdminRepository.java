package kg.megacom.deliverycrm.dao;
import kg.megacom.deliverycrm.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Override
    List<Admin> findAll();

    @Transactional
    @Modifying
    @Query("UPDATE Admin SET firstName=:name, lastName=:fam, login=:login, password=:password where id=:id")
    void update(@Param("id") Long id, @Param("name") String name, @Param("fam") String fam,
                @Param("login") String login, @Param("password") String password);

}

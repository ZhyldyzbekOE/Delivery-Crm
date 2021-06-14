package kg.megacom.deliverycrm.repository;
import kg.megacom.deliverycrm.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Override
    List<Admin> findAll();
}

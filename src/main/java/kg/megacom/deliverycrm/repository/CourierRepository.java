package kg.megacom.deliverycrm.repository;

import kg.megacom.deliverycrm.models.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourierRepository extends JpaRepository<Courier,Long> {

    List<Courier>findAll();
}

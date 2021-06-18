package kg.megacom.deliverycrm.repository;

import kg.megacom.deliverycrm.enums.CourierStatus;
import kg.megacom.deliverycrm.models.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface CourierRepository extends JpaRepository<Courier,Long> {

    @Override
    List<Courier> findAll();


    @Transactional
    @Modifying
    @Query("UPDATE Courier SET firstName=:fName, lastName=:lName, phoneNumber=:phone,courierStatus=:courStat where id=:id")
    void update(@Param("id") Long id, @Param("fName") String fName, @Param("lName") String lName,
                @Param("phone") int phone, CourierStatus courStat);


}


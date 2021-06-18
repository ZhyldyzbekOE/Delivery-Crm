package kg.megacom.deliverycrm.dao;

import kg.megacom.deliverycrm.enums.CouriersStatus;
import kg.megacom.deliverycrm.models.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Courier SET firstName=:fName, lastName=:lName, PhoneNumber=:phone,courierStatus=:courStat where id=:id")
    void update(@Param("id") Long id, @Param("fName") String fName, @Param("lName") String lName,
                @Param("phone") int phone, CouriersStatus courStat);
}

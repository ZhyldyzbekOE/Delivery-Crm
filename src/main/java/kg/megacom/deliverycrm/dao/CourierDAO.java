package kg.megacom.deliverycrm.dao;


import kg.megacom.deliverycrm.enums.CourierStatus;
import kg.megacom.deliverycrm.models.Courier;
import kg.megacom.deliverycrm.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CourierDAO {

    @Autowired
    private CourierRepository courierRepository;

    public void saveNewCourier(Courier courier) {

        courierRepository.saveAndFlush(courier);


    }
    public List<Courier> getAllCouriers(){
        return courierRepository.findAll();
    }
    public void deleteFromDbCourier(Long id){
        courierRepository.deleteById(id);
    }
    public Courier getCourierByIdForEdit(Long id){
        Optional<Courier> courierOptional = courierRepository.findById(id);
        return courierOptional.orElse(null);
    }

    public void update(Long id, Courier courier) {
        String fName = courier.getFirstName();
        String lName = courier.getLastName();
        int phone = courier.getPhoneNumber();
        CourierStatus courStat = courier.getCourierStatus();

        courierRepository.update(id, fName, lName, phone,courStat);
    }
}

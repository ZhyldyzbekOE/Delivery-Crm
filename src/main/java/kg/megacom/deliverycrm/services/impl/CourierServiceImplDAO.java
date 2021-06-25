package kg.megacom.deliverycrm.services.impl;

import kg.megacom.deliverycrm.dao.CourierRepository;
import kg.megacom.deliverycrm.enums.CouriersStatus;
import kg.megacom.deliverycrm.models.Courier;
import kg.megacom.deliverycrm.services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourierServiceImplDAO implements CourierService {

    @Autowired
    private CourierRepository courierRepository;

    @Override
    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    @Override
    public void saveCourier(Courier courier) {
        courierRepository.save(courier);
    }

    @Override
    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }


    @Override
    public void update(long id, Courier courier) {
        String fName = courier.getFirstName();
        String lName = courier.getLastName();
        String  phone = courier.getPhoneNumber();
        CouriersStatus courStat = courier.getCourierStatus();
        courierRepository.update(id, fName, lName, phone,courStat);
    }

    @Override
    public void updateStatusOnMyWay(String name, String fio) {
        Courier courier = courierRepository.findByFirstNameAndLastName(name, fio);
        courier.setCourierStatus(CouriersStatus.OnMyWay);
        courierRepository.save(courier);
    }

    @Override
    public void updateStatusCanceled(String name, String fio) {
        Courier courier = courierRepository.findByFirstNameAndLastName(name, fio);
        courier.setCourierStatus(CouriersStatus.Free);
        courierRepository.save(courier);
    }

    @Override
    public void updateStatusInProcess(String name, String fio) {
        Courier courier = courierRepository.findByFirstNameAndLastName(name, fio);
        courier.setCourierStatus(CouriersStatus.OnMyWay);
        courierRepository.save(courier);
    }

    @Override
    public Courier getCourierByIdForEdit(Long id) {
        Optional<Courier> courierOptional = courierRepository.findById(id);
        return courierOptional.orElse(null);

    }

}

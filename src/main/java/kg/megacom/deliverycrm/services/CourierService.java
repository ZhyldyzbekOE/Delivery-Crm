package kg.megacom.deliverycrm.services;

import kg.megacom.deliverycrm.models.Courier;

import java.util.List;

public interface CourierService {

    List<Courier> getAllCouriers();

    void saveCourier(Courier courier);

    void deleteCourier(Long id);

    void update(long id, Courier courier);

    Courier getCourierByIdForEdit(Long id);

}

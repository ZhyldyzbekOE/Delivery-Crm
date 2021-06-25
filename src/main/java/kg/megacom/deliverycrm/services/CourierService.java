package kg.megacom.deliverycrm.services;

import kg.megacom.deliverycrm.models.Courier;
import java.util.List;

public interface CourierService {

    List<Courier> getAllCouriers();

    void saveCourier(Courier courier);

    void deleteCourier(Long id);

    void update(long id, Courier courier);

    void updateStatusOnMyWay(String name, String fio);

    void updateStatusCanceled(String name, String fio);

    void updateStatusInProcess(String name, String fio);

    Courier getCourierByIdForEdit(Long id);

}

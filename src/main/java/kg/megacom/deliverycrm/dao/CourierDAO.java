package kg.megacom.deliverycrm.dao;

import kg.megacom.deliverycrm.models.Admin;
import kg.megacom.deliverycrm.models.Courier;
import kg.megacom.deliverycrm.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourierDAO {

    @Autowired
    private CourierRepository courierRepository;

//    public boolean findCourier(Courier courier){
//
//        List<Courier> courierArrayList =courierRepository.findAll(); // это select для бд
//
//        for (Courier item : courierArrayList) {
//            if (item == courierRepository.getById(1l)) {
//                courier = item;
//                return true;
//            }
//        }
//        return false;
//    }
//private static int COURIERS_COUNT;
//    private List<Courier> couriers;
//
//    {
//        couriers = new ArrayList<>();
//
//        couriers.add(new Courier((long) ++COURIERS_COUNT,"Mercedes", 118531886, Courier.CourierStatus.Free));
//        couriers.add(new Courier((long) ++COURIERS_COUNT,"BMW", 133251465, Courier.CourierStatus.OnHoliday));
////        couriers.add(new Courier((long)++COURIERS_COUNT,"Audi",0555443480, Courier.CourierStatus.OnMyWay));
////        couriers.add(new Courier(++COURIERS_COUNT,"Toyota",0770306068, Courier.CourierStatus.Free));
//    }
//    public List<Courier> index(){
//        return couriers;
//    }
//    public Courier show(int id){
//        return couriers.stream().filter(courier -> courier.getId()==id).findAny().orElse(null);
//
//    }
//    public void save(Courier courier){
//        courier.setId((long) ++COURIERS_COUNT);
//        couriers.add(courier);
//    }




}

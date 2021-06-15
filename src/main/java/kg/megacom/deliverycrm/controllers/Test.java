package kg.megacom.deliverycrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {

    @GetMapping("/courier")
    public String test(){
        return "test";
    }
}

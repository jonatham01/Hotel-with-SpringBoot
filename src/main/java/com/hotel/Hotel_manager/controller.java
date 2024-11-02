package com.hotel.Hotel_manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

    @GetMapping("roomcategories")
    public String loadPage(){
        return "roomcategory";
    }
}

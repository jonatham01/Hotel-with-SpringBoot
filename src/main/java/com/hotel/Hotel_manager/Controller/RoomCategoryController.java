package com.hotel.Hotel_manager.Controller;

import com.hotel.Hotel_manager.dto.NewRoomCategory;
import com.hotel.Hotel_manager.entity.RoomCategory;
import com.hotel.Hotel_manager.service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomCategoryController {

    @Autowired
    private RoomCategoryService roomCategoryService;

    @GetMapping("roomcategories")
    public String loadPage(Model model,
                           @RequestParam(required = false) Integer id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) Double price,
                           @RequestParam(required = false) String url
    ){
        model.addAttribute("roomCategories", roomCategoryService.getAll());
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("url", url);
        return "roomcategory";
    }

    @PostMapping("/roomcategories/save")
    public String saveRoomCategory(@ModelAttribute NewRoomCategory roomCategory) {
        roomCategoryService.save(roomCategory);
        return "redirect:/roomcategories";  // Redirige a la lista de categorías o a otra página
    }

    @PostMapping("/roomcategories/delete")
    public String saveRoomCategory(@RequestParam(required = false) int id, Model model) {
        if(roomCategoryService.delete(id)) {
            return "redirect:/roomcategories";
        }
        else{
            return "redirect:/roomcategories";
        }
    }

}

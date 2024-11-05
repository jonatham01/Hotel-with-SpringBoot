package com.hotel.Hotel_manager.Controller;

import com.hotel.Hotel_manager.dto.NewRoom;
import com.hotel.Hotel_manager.entity.Room;
import com.hotel.Hotel_manager.service.RoomCategoryService;
import com.hotel.Hotel_manager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomCategoryService roomCategoryService;

    @GetMapping("all")
    public String roomsModule(Model model,
                              @RequestParam(required = false) int floor,
                              @RequestParam(required = false) int category,
                              @RequestParam(required = false) int id,
                              @RequestParam(required = false) String message){
        model.addAttribute("rooms", roomService.getAllRooms() );
        model.addAttribute("room", roomService.getRoomById(id));
        model.addAttribute("roomByFloor",roomService.getRoomByFloor(floor));
        model.addAttribute("roomsByCategory", roomService.getRoomByCategoryId(category));
        model.addAttribute("message",message);
        model.addAttribute("categories",roomCategoryService.getAll());
        return "room";
    }

    @PostMapping("save")
    public String newRoom(@ModelAttribute NewRoom newRoom){
        if(roomService.saveRoom(newRoom) != null) return "redirect:/room";
        return "redirect:/roomcategories?message=error";
    }

    @PostMapping("delete")
    public String deleteRoom(@RequestParam int id){
        if(roomService.deleteRoom(id)) return "redirect:/room";
        return "redirect:/room?message=error";
    }

    @PostMapping("upload")
    public String uploadRoom(@ModelAttribute NewRoom room,@RequestParam int id){
        if(roomService.updateRoom(room,id).isPresent()) return "redirect:/room";
        return "redirect:/room?message=error";
    }


}

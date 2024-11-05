package com.hotel.Hotel_manager.Controller;

import com.hotel.Hotel_manager.dto.NewBed;
import com.hotel.Hotel_manager.entity.Bed;
import com.hotel.Hotel_manager.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("bed")
public class BedController {

    @Autowired
    private BedService service;

    @GetMapping("/module")
    public String module(Model model,
                         @RequestParam(required=false) int id,
                         @RequestParam(required=false) int category,
                         @RequestParam(required=false) String startdatestring,
                         @RequestParam(required=false) String enddatestring
    ) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); // Especifica el formato de la fecha
        try{
            Date date = format.parse(startdatestring);
            Date endDate = format.parse(enddatestring);
            model.addAttribute("bedByDate",service.getAllBedsByDate((java.sql.Date) date, (java.sql.Date) endDate));
            model.addAttribute("bedFiltered",service.getAllFiltered((java.sql.Date) date, (java.sql.Date) endDate,category));
        }finally {
            model.addAttribute("beds",service.getAllBeds() );
            model.addAttribute("bedByColor", service.getBedsByBedCategoryId(category));
            return "bed";
        }


    }

    @PostMapping("/create")
    public String create(@ModelAttribute NewBed bed){
        if(service.saveBed(bed) != null) return"redirect:/bed/module";
        return"redirect:/bed/module?message=error";
    }

    @PostMapping("/update")
    public String create(@ModelAttribute Bed bed, @RequestParam int id){
        if(service.updateBed(bed,id) != null) return"redirect:/bed/module";
        return"redirect:/bed/module?message=error";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        if(service.deleteBed(id)) return"redirect:/bed/module";
        return"redirect:/bed/module?message=error";
    }




}

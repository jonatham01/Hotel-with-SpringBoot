package com.hotel.Hotel_manager.mapper;

import com.hotel.Hotel_manager.dto.newBedCategory;
import com.hotel.Hotel_manager.entity.BedCategory;
import org.springframework.stereotype.Component;

@Component
public class BedCategoryMapper {

    public BedCategory dtoToCategoryMapper( newBedCategory bedCategory) {
        BedCategory category = new BedCategory();
        category.setUrl(bedCategory.getUrl());
        category.setColor(bedCategory.getColor());
        category.setKind(bedCategory.getKind());
        category.setMeasure(bedCategory.getMeasure());
        return category;
    }

}

package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.PictureDto;
import com.beapsmarket.webapp.model.entities.Picture;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface PictureMapper {

    Picture toEntity(PictureDto pictureDto);

    PictureDto toDto(Picture picture);

    void copy(PictureDto pictureDto, @MappingTarget Picture picture);
}

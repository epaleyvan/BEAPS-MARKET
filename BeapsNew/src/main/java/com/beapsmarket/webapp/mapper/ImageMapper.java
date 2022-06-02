package com.beapsmarket.webapp.mapper;

import com.beapsmarket.webapp.model.dto.ImageDto;
import com.beapsmarket.webapp.model.entities.Image;
import org.mapstruct.*;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface ImageMapper {

    @Mapping(source = "imageDto.productDto", target = "product")
    Image toEntity(ImageDto imageDto);

    @Mapping(source = "image.product", target = "productDto")
    ImageDto toDto(Image image);

    @Mapping(source = "imageDto.productDto", target = "product")
    void copy(ImageDto imageDto, @MappingTarget Image image);
}

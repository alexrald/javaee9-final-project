package com.javaee9.javaee9finalproject.converter;

public interface Converter<DTO, ENTITY> {

    ENTITY  dtoToEntity     (DTO dto);
    DTO     entityToDto     (ENTITY entity);

}

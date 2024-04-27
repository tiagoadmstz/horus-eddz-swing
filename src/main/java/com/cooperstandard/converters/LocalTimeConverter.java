/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.converters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author tiago.teixeira
 */
@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, String> {

    @Override
    public String convertToDatabaseColumn(LocalTime attribute) {
        if (attribute != null) {
            return attribute.format(DateTimeFormatter.ofPattern("HH:mm"));
        }
        return "";
    }

    @Override
    public LocalTime convertToEntityAttribute(String dbData) {
        if (!dbData.equals("")) {
            return LocalTime.parse(dbData, DateTimeFormatter.ofPattern("HH:mm"));
        }
        return null;
    }

}

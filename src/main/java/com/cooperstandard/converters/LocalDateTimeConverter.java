/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.converters;

//import br.com.fs.api.util.Datas;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author tiago.teixeira
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime attribute) {
        if (attribute != null) {
            try {
                return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.S").parse(attribute.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.S")));
            } catch (Exception e) {
                return null;
            }

        } else {
            return null;
        }
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date dbData) {
        //2018-07-05 16:02:46.000
        if (dbData != null) {
            try {
                return LocalDateTime.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.S").format(dbData), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.S"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

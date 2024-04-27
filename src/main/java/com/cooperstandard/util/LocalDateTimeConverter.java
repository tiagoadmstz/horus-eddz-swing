package com.cooperstandard.util;

import com.cooperstandard.util.Datas1;
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
            return Datas1.getDate(attribute.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.S")));
        } else {
            return null;
        }
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date dbData) {
        //2018-07-05 16:02:46.000
        if (dbData != null) {
            try {
                return LocalDateTime.parse(Datas1.getDateTimeString(dbData), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.S"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}

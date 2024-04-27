package com.cooperstandard.converters;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author tiago.teixeira
 */
@Converter(autoApply = true)
public class FileConverter implements AttributeConverter<File, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(File attribute) {
        try {
            return Files.readAllBytes(attribute.toPath());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public File convertToEntityAttribute(byte[] dbData) {
        try {
            File file = new File("imagem.png");
            try (FileOutputStream output = new FileOutputStream(file)) {
                output.write(dbData);
            }
            return file;
        } catch (Exception e) {
            return null;
        }
    }
}

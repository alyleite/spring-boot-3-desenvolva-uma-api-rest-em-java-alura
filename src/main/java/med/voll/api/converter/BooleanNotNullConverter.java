package med.voll.api.converter;


import jakarta.persistence.AttributeConverter;

public class BooleanNotNullConverter implements AttributeConverter<Boolean, Boolean> {

    public Boolean convertToDatabaseColumn(Boolean value) {
        return value != null && value;
    }

    public Boolean convertToEntityAttribute(Boolean value) {
        return value;
    }
}

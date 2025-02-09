package org.example.entity.service;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.entity.Rating;

@Converter(autoApply = true)
public class RatingAttributeConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating attribute) {
        return attribute.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(String dbData) {
        Rating[] values = Rating.values();
        for (Rating rating : values) {
            if (rating.getValue().equals(dbData)) {
                return rating;
            }
        }
        return null;
    }
}

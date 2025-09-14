package com.solution.mateo.infrastucture.configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import java.time.OffsetDateTime;
import java.util.Date;

@WritingConverter
public class OffsetDateTimeToDateConverter implements Converter<OffsetDateTime, Date> {

    @Override
    public Date convert(OffsetDateTime source) {
        if (source == null) {
            return null;
        }
        return Date.from(source.toInstant());
    }
}
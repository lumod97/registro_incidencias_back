package com.cpiura.catics.utils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public class Utils {
    public static Optional<LocalDateTime> convertToOptionalLocalDateTime(Date date) {
        return Optional.ofNullable(date)
                .map(d -> d.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
    }
}

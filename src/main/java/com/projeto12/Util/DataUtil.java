package com.projeto12.Util;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DataUtil {
    public String formatarDataLocal(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("yyyy-HH-dd HH:mm:ss").format(localDateTime);
    }
}

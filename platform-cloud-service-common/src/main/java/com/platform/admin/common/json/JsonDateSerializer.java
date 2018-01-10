package com.platform.admin.common.json;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateSerializer extends JsonSerializer<Date> implements DateFormat{
    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider arg2)
            throws IOException {
        String formattedDate =  new SimpleDateFormat(DEFAULT_FORMAT).format(date);
        gen.writeString(formattedDate);
    }

}

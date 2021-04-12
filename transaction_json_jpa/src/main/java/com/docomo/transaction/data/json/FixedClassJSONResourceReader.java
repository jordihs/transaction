package com.docomo.transaction.data.json;

import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.ResourceReader;
import org.springframework.util.Assert;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;

public class FixedClassJSONResourceReader implements ResourceReader {

    private final ObjectMapper mapper;

    private final Class<?> clazz;


    public FixedClassJSONResourceReader(Class<?> clazz, DateTimeFormatter dateFormatter) {
        this.clazz = clazz;
        JavaTimeModule module = new JavaTimeModule();
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateFormatter));
        this.mapper = new ObjectMapper();

        this.mapper.registerModule(module);
    }


    @Override
    public Object readFrom(Resource resource, ClassLoader classLoader) throws Exception {
        Assert.notNull(resource, "Resource must not be null!");
        InputStream stream = resource.getInputStream();

        JsonNode node = this.mapper.readerFor(JsonNode.class).readTree(stream);

        JsonNode element = node.elements().next();
        Object rets = this.mapper.readerFor(clazz).readValue(node);
        if(rets.getClass().isArray())
            return Arrays.asList(this.mapper.readerFor(clazz).readValue(node));
        else return rets;

    }

}

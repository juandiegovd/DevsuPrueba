package com.devsu.cliente;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;


public abstract class AbstractBaseJUnit5Test {

    public static String readJSON(String path) throws URISyntaxException, IOException {
        return new String(Files.readAllBytes(Paths.get(AbstractBaseJUnit5Test.class.getResource(path).toURI())));
    }

    public static  <T> T convertTo(String path, Class<T> clazz) throws Exception {
        String jsonRequest = readJSON(path);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());

        return mapper.readValue(jsonRequest, clazz);
    }

}

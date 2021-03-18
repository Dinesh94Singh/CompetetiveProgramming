package com.company.codingscales.java.concepts.service.Gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        // Serialize
        Gson gson = new GsonBuilder().disableHtmlEscaping().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().serializeNulls().create();
        MyObject myObject = new MyObject();
        myObject.setDate(Instant.now());
        String json = gson.toJson(myObject);
        System.out.println(json);

        // Deserialize
        System.out.println(gson.fromJson(json, MyObject.class));
    }
}

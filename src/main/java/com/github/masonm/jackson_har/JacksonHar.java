package com.github.masonm.jackson_har;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JacksonHar {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File(args[0]));
        JsonNode entries = root.path("log").path("entries");
        for (JsonNode entry : entries) {
            System.out.println("request:\n" + entry.get("request") + "\n");
            System.out.println("response:\n" + entry.get("response") + "\n\n");
        }
    }
}

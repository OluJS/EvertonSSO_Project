package com.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class ElementSelectorReader {

    public static JSONObject readElementSelectors() throws IOException, ParseException {
        JSONParser jsonparse = new JSONParser();

        JSONObject jsonobject = (JSONObject) jsonparse.parse(new FileReader("src/test/resources/element-selectors.json"));

        return jsonobject;
    }




}

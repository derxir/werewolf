package com.werewolf.model;

import java.util.HashMap;
import java.util.Map;

public class ResponseContext {

    private Map<String, String> fields;

    public ResponseContext(){
        fields = new HashMap<>();
    }

    public void add(String key, String value){
        fields.put(key,value);
    }
}

package com.react.spring;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    GetProperties properties = new GetProperties();


    @GetMapping("/api/array")
    public String apiJSONArray() {


        JSONArray arr = new JSONArray();

        try {

            JSONObject obj = new JSONObject();


            obj.put("hello", "world");
            obj.put("fake_api_key",properties.getPropValues());

            arr.put(obj);
        }catch(Exception e){

            System.out.println(e);
        }

        return arr.toString();

    }

    @GetMapping("/api/object")
    public String apiJSONObject() {


        JSONObject obj = new JSONObject();



        try {
            obj.put("hello", "world");

        }catch(Exception e){

            System.out.println(e);
        }

        return obj.toString();

    }

}

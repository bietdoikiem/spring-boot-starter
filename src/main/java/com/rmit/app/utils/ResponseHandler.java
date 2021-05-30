package com.rmit.app.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean error, String url, String message, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("timestamp", new Date());
            map.put("status", status.value());
            map.put("url", url);
            map.put("isSuccess", error);
            map.put("message", message);
            map.put("data", responseObj);

            return new ResponseEntity<Object>(map, status);
        } catch(NullPointerException e) {
            map.clear();
            map.put("timestamp", new Date());
            map.put("status", HttpStatus.NOT_FOUND);
            map.put("isSuccess", false);
            map.put("message", e.getMessage());
            map.put("data", null);
            System.out.println("NOT NULL ERROR");
            return new ResponseEntity<Object>(map, status);
        }
        catch (Exception e) {
            map.clear();
            map.put("timestamp", new Date());
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("isSuccess", false);
            map.put("message", e.getMessage());
            map.put("data", null);
            System.out.println("ERROR");
            return new ResponseEntity<Object>(map, status);
        }
    }
}

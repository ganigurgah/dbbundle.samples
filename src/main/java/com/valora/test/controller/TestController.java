package com.valora.test.controller;

import jakarta.annotation.Nullable;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ResourceBundle;

@RestController
public class TestController {

    @Autowired
    private ResourceBundle msg;


    @GetMapping("/msg/{key}")
    public String getMsg(@PathVariable String key, @Nullable @PathParam("lang") String lang) {
        try {
            return msg.getString(key);
        } catch (Exception e) {
            return "Anahtar bulunamadı: " + key + " (Hata: " + e.getMessage() + ")";
        }
    }
}
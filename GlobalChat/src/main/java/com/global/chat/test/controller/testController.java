package com.global.chat.test.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.chat.api.chatGpt;
import com.global.chat.api.papago;

@RestController
public class testController {

    @GetMapping("/api/hello")
    public String test() {
    	
        return "Hello, world!";
    }
    @ResponseBody
    @PostMapping("/api/translate")
    public String translate(@RequestBody Map<String, Object> paramMap) {
    	String gptres = chatGpt.generateText("i wonder about korea", 1.0f, 1000);
    	System.out.println(gptres);
    	return papago.translate((String) paramMap.get("message"));
    }
}
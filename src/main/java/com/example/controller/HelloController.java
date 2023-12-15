package com.example.controller;

import com.example.controller.pojo.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author 杨帆
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello World");
        return "Hello World";
    }

    /*//原始方法
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
        // 获取请求参数
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        int age = Integer.parseInt(ageStr);
        System.out.println(name + ":" + age);
        return "OK";
    }*/

    //基于springboot方式
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name = "name") String username, Integer age){
        System.out.println(username+ ":" +age);
        return "OK";
    }

    // 2.实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        System.out.println(user);
        return "OK";
    }

    // 3.数组集合参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "OK";
    }

    // 4.日期时间类型参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){  //指定格式
        System.out.println(updateTime);
        return "OK";
    }

    // 5.json类型参数
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        //使用json格式，需要加@Request
        System.out.println(user);
        return "OK";
    }

    // 6.路径参数
    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id,@PathVariable String name){
        System.out.println(name + ":" + id);
        return "OK";
    }

}




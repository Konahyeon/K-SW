package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController //  => @Controller + @ResponseBody
public class UrlMappingRestController {
    //@RestController는 View에 대한 처리 필요X(html 필요하지 않음). 자동으로 json으로 response. data를 내려주기 위함

    @RequestMapping("/hi") // value 생략
    public String m1() {
        System.out.println("/hi");
        return "/hi"; // No Circular view path [hello]
    }

    @RequestMapping("/hi/url") // value 생략
    public String m2() {
        System.out.println("/hi/url");
        return "/hi/url";
    }

    @RequestMapping(value="/method", method= RequestMethod.GET)
    public String m3() {
        System.out.println("/get");
        return "/get";
    }

    @RequestMapping(value="/method", method=RequestMethod.POST)
    public String m4() {
        System.out.println("/post");
        return "/post";
    }

    @RequestMapping(value="/method/{num}", method=RequestMethod.PUT)
    public String m5(@PathVariable int num) {
        System.out.println("/put");
        System.out.println("num : " + num);
        return "/method/{num}";
    }

    @RequestMapping(value="/method/{num}/and/{str}", method=RequestMethod.PUT)
    public String m6(@PathVariable int num, @PathVariable String str) {
        System.out.println("/put");
        System.out.println("num : " + num);
        System.out.println("str : " + str);
        return "/method/{num}/and/{str}";
    }

    @RequestMapping(value="/method/{num}", method=RequestMethod.DELETE)
    public String m7(@PathVariable int num) {
        System.out.println("/delete");
        System.out.println("num : " + num);
        return "/method/{num}";
    }

    @GetMapping(value="/getmapping")
    public String m8() {
        System.out.println("/getmapping");
        return "/getmapping";
    }

    @PostMapping(value="/postmapping")
    public String m9() {
        System.out.println("/postmapping");
        return "/postmapping";
    }
}

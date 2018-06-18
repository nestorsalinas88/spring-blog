/*
url	response
/add/3/and/4	7
/subtract/3/from/10	7
/multiply/4/and/5	20
/divide/6/by/3	2
 */
package com.codeup.blog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MathController {

    @GetMapping("/add/{x}/and/{y}")
    public @ResponseBody
    int addition(@PathVariable int x, @PathVariable int y){
        return x + y;
    }


    @GetMapping("/subtract/{x}/and/{y}")
    @ResponseBody
    public int subtract(@PathVariable int x, @PathVariable int y) {
        return x - y;
    }

    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public int multiply(@PathVariable int x, @PathVariable int y) {
        return x * y;
    }

    @GetMapping("/divide/{x}/by/{y}")
    @ResponseBody
    public int divide(@PathVariable int x, @PathVariable int y) {
        return x / y;
    }




}

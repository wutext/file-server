package com.myself.fileserver.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("")
    public String index() {
        return "/view/index";
    }
}

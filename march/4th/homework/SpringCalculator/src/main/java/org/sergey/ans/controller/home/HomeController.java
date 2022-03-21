package org.sergey.ans.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    public static final String PATH_HOME_TEMPLATE = "homepage/home";

    @GetMapping()
    public String getHomeTemplate() {
        return PATH_HOME_TEMPLATE;
    }
}

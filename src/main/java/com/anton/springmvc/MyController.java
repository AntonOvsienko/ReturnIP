package com.anton.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @GetMapping("/")
    public String startPage() {
        return "first-view";
    }

    @GetMapping("/get-ip")
    public String getIp(HttpServletRequest request, Model model) {

        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
            model.addAttribute("ip", remoteAddr);
            System.out.println(remoteAddr);
        }
        return "/get-ip";
    }
}

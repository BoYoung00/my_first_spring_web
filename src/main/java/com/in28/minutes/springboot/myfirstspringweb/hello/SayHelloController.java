package com.in28.minutes.springboot.myfirstspringweb.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    // say-hello
    @RequestMapping("say-hello")
    @ResponseBody // 리턴되는 값을 그대로 웹 페이지에 보이게 함
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody // 리턴되는 값을 그대로 웹 페이지에 보이게 함
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> title - Changed </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("Hello! What are you learning today?");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }
}

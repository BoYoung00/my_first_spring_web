package com.in28.minutes.springboot.myfirstspringweb.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // http://localhost:8080/login?name=Ranga
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name,
                                  @RequestParam String pw,
                                  ModelMap model) {
        if (authenticationService.authenticate(name, pw)) {
            model.put("name", name);
            model.put("pw", pw);

            return "welcome";
        }
        model.put("errorMessage", "Invalid Credentials! Please try again.");
        return "login";
    }
}

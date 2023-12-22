package com.in28.minutes.springboot.myfirstspringweb.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
//    private AuthenticationService authenticationService;
//
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }

    // http://localhost:8080/login?name=Ranga
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", getLoginUsername());
        return "welcome";
    }

    // 로그인 된 유저이름 가져오기
    private String getLoginUsername() {
        // 사용자 정보 가져오기
        // Authentication : 사용자의 인증 상태 및 권한 정보
        // SecurityContextHolder : 보안 정보 제공
        // getContext : 보안 컨텍스트 가져오기
        // getAuthentication : 현재 인증 객체 반환
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String gotoWelcomePage(@RequestParam String name,
//                                  @RequestParam String pw,
//                                  ModelMap model) {
//        if (authenticationService.authenticate(name, pw)) {
//            model.put("name", name);
//            model.put("pw", pw);
//
//            return "welcome";
//        }
//        model.put("errorMessage", "Invalid Credentials! Please try again.");
//        return "login";
//    }
}

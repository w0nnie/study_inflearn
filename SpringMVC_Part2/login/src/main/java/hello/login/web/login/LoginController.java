package hello.login.web.login;

import hello.login.domain.member.Member;
import hello.login.web.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {

        return "login/loginForm";
    }

//    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult, HttpServletResponse response) {

        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Optional<Member> login = loginService.login(form);
        if (!login.isPresent()) {
            log.info("login fail");
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "login/loginForm";
        }

        log.info("login = {}", login.get());
        Cookie cookie = new Cookie("memberId", String.valueOf(login.get().getId()));
        cookie.setMaxAge(100);
        response.addCookie(cookie);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginV2(@Validated @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Optional<Member> login = loginService.login(form);

        if (!login.isPresent()) {
            log.info("login fail");
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "login/loginForm";
        }
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, login.get());

        return "redirect:/";
    }

    public String logOut(HttpServletResponse response) {

        Cookie cookie = new Cookie("memberId", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logOutV2(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}

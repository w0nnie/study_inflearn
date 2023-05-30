package study.hellospring2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }


    /**
     * @ResponseBody 가 사용되면
     * Http프로토콜 Body부에 문자 내용을 직접 던져준다.
     * viesResolver 대신에 httpMessageConverter가 동작한다.
     * 기본 문자처리 : StringHttpMessageConverter
     * 기본 객체처리 : MappingJackSon2HttpMessageConverter (json)
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(name);

        return hello;
    }

     class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public Hello(String name) {
            this.name = name;
        }
    }
}

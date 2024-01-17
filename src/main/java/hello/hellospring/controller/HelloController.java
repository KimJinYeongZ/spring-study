package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model)
    {
        model.addAttribute("data","hello!!");
        return "hello";
    }


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http에서 헤더와 바디 부분이 나누어져 있는데 바디부분에 이 내용을 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name)
    {
        return "hello " + name; // hello spring 이런 식으로
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name)
    {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello
    {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

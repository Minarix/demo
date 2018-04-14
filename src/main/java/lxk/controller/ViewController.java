package lxk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/view")
public class ViewController {
	// 访问路径 http://localhost:8080/portal/view/home?name=long
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(String name,Model model) {
        model.addAttribute("message", "hello");
        model.addAttribute("name", name);
        return "/home";
    }
}
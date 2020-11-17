package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Translate;

@Controller
@RequestMapping("/translate")
public class homeController {

    @Autowired
    private Translate translate;

    @GetMapping
    public String greeting() {

        return "index";
    }

    @PostMapping("/test")
    public String indexPost(@RequestParam String text, Model model) {
        String trans = translate.trans(text);
        model.addAttribute("translate", trans);
        model.addAttribute("text", text);
        return "index";
    }
}
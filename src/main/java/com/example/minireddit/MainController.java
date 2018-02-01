package com.example.minireddit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    MiniRedditRepository miniRedditRepository;

    @RequestMapping("/")
    public String listRecords(Model model){
        model.addAttribute("reditrecs",miniRedditRepository.findAll());
        return "list";
    }

    @GetMapping
    public String reditRecForm(Model model){
        model.addAttribute("reditrec", new ReditRec());
        return "reditRecForm";
    }
}

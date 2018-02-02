package com.example.minireddit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    MiniRedditRepository miniRedditRepository;

    @RequestMapping("/")
    public String listRecords(Model model){
        model.addAttribute("reditrecs",miniRedditRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String reditRecForm(Model model){
        model.addAttribute("reditrec", new ReditRec());
        return "reditRecForm";
    }

    @PostMapping("/process")
//    public String processForm(@Valid  @ModelAttribute("reditrec") ReditRec reditrec, BindingResult result){
    public String processForm(@Valid ReditRec reditrec, BindingResult result){
        if (result.hasErrors()){
            return "reditRecForm";
        }
        miniRedditRepository.save(reditrec);
        return "redirect:/";
    }
}

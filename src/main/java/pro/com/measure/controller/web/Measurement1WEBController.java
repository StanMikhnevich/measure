package pro.com.measure.controller.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pro.com.measure.model.Measurement1;
import pro.com.measure.service.measurement1.impls.Measurement1ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/measure")
@Controller
public class Measurement1WEBController {

    private LocalDateTime point = LocalDateTime.now();

    @Autowired
    Measurement1ServiceImpl service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String showAll(Model model){

        model.addAttribute("measures", service.getAll());
        System.out.println("CALLED");
        return "list";
    }

    @RequestMapping(value = "/list/current/hour", method = RequestMethod.GET)

    String showCurrentHour(Model model){

        model.addAttribute("measures", service.getAllForLastHour());
        System.out.println("CALLED for the last hour");
        return "list";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    String index(Model model){

        model.addAttribute("measures", service.getAll());
        System.out.println("CALLED index2");
        return "index2";
    }

}

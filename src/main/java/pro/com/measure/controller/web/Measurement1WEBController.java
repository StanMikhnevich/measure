package pro.com.measure.controller.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pro.com.measure.form.InputHourForm;
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

    @RequestMapping(value = "/list/hour/current", method = RequestMethod.GET)
    String showCurrentHour(Model model){
        model.addAttribute("measures", service.getAllForTheCurrentHour());
        return "list";
    }
    @RequestMapping(value = "/list/hour/previous", method = RequestMethod.GET)
    String showPreviousHour(Model model){
        model.addAttribute("measures", service.getAllForPreviousHour());
        return "list";
    }

    @RequestMapping(value = "/list/hour/next", method = RequestMethod.GET)
    String showNextHour(Model model){
        model.addAttribute("measures", service.getAllForNextHour());
        return "list";
    }




    @RequestMapping(value = "/list/{year}/{month}/{day}/{hour}", method = RequestMethod.GET)
    String showForHour(Model model
                       ,@PathVariable(value = "year")int year
                       ,@PathVariable(value = "month")int month
                       ,@PathVariable(value = "day")int day
                       ,@PathVariable(value = "hour")int hour
                      ){
        LocalDateTime start = LocalDateTime.of(year,month,day,hour,0,0);
        LocalDateTime finish = LocalDateTime.of(year,month,day,hour + 1 ,0,0);
        model.addAttribute("measures", service.getAllForTheHour(start));
        return "list";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    String index(Model model){

        model.addAttribute("measures", service.getAll());
      //  System.out.println("CALLED index2");
        return "index2";
    }


    @RequestMapping(value = "/list/pick", method = RequestMethod.GET)
    public String pickHour(Model model)
    {
        InputHourForm inputHourForm = new InputHourForm(
                LocalDateTime.now().getYear(),
                LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getDayOfMonth(),
                LocalDateTime.now().getHour()
        );
        model.addAttribute("inputForm", inputHourForm);
        return "pickanhour";
    }



}

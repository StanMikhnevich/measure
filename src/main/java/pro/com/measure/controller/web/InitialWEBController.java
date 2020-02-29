package pro.com.measure.controller.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pro.com.measure.form.InputHourForm;
import pro.com.measure.model.Measurement1;
import pro.com.measure.service.measurement1.impls.Measurement1ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/web/measure")
@Controller
public class InitialWEBController {

    private LocalDateTime point = LocalDateTime.now();

    @Autowired
    Measurement1ServiceImpl service;


    @RequestMapping(value = "/list/hour/current", method = RequestMethod.GET)
    String showCurrentHour(Model model){
        model.addAttribute("measures", service.getAllForTheCurrentHour());
        String interval = this.service.getHourInterval();
        model.addAttribute("interval", interval);
        InputHourForm inputHourForm = new InputHourForm(
                service.getYear(),
                service.getMonth(),
                service.getDay(),
                service.getHour()
        );
        model.addAttribute("inputForm", inputHourForm);

        return "alltogether";
    }


    @RequestMapping(value = "/list/hour/previous", method = RequestMethod.GET)
    String showPreviousHour(Model model){
        model.addAttribute("measures", service.getAllForPreviousHour());

        String interval = this.service.getHourInterval();
        model.addAttribute("interval", interval);
        InputHourForm inputHourForm = new InputHourForm(
                service.getYear(),
                service.getMonth(),
                service.getDay(),
                service.getHour()
        );
        model.addAttribute("inputForm", inputHourForm);
        return "alltogether";
    }

    @RequestMapping(value = "/list/hour/previous", method = RequestMethod.POST)
    public String showPreviousHour(Model model,
                                 @ModelAttribute("inputForm") InputHourForm inputForm)
    {
        //System.out.println(inputForm);
        LocalDateTime time = LocalDateTime.of(
                inputForm.getYear(),
                inputForm.getMonth(),
                inputForm.getDay(),
                inputForm.getHour(),
                0,
                0
        );

        List<Measurement1> measures = this.service.getAllForTheHour(time);
        model.addAttribute("measures", measures);
        String interval = this.service.getHourInterval();
        model.addAttribute("interval", interval);
/*        InputHourForm inputHourForm = new InputHourForm(
                service.getYear(),
                service.getMonth(),
                service.getDay(),
                service.getHour()
        );
        */
        model.addAttribute("inputForm", inputForm);

        return "alltogether";
    }




    @RequestMapping(value = "/list/hour/next", method = RequestMethod.GET)
    String showNextHour(Model model){
        model.addAttribute("measures", service.getAllForNextHour());
        String interval = this.service.getHourInterval();
        model.addAttribute("interval", interval);
        InputHourForm inputHourForm = new InputHourForm(
                service.getYear(),
                service.getMonth(),
                service.getDay(),
                service.getHour()
        );
        model.addAttribute("inputForm", inputHourForm);

        return "alltogether";
    }


    @RequestMapping(value = "/list/hour/next", method = RequestMethod.POST)
    public String showNextHour(Model model,
                                   @ModelAttribute("inputForm") InputHourForm inputForm)
    {
        //System.out.println(inputForm);
        LocalDateTime time = LocalDateTime.of(
                inputForm.getYear(),
                inputForm.getMonth(),
                inputForm.getDay(),
                inputForm.getHour(),
                0,
                0
        );

        List<Measurement1> measures = this.service.getAllForTheHour(time);
        model.addAttribute("measures", measures);
        String interval = this.service.getHourInterval();
        model.addAttribute("interval", interval);
/*        InputHourForm inputHourForm = new InputHourForm(
                service.getYear(),
                service.getMonth(),
                service.getDay(),
                service.getHour()
        );
        */
        model.addAttribute("inputForm", inputForm);

        return "alltogether";
    }








    @RequestMapping(value = "/list/hour/current", method = RequestMethod.POST)
    public String getDataForHour(Model model,
                                 @ModelAttribute("inputForm") InputHourForm inputForm)
    {
        System.out.println(inputForm);
        LocalDateTime time = LocalDateTime.of(
                inputForm.getYear(),
                inputForm.getMonth(),
                inputForm.getDay(),
                inputForm.getHour(),
                0,
                0
        );

        List<Measurement1> measures = this.service.getAllForTheHour(time);
        model.addAttribute("measures", measures);
        String interval = this.service.getHourInterval();
        model.addAttribute("interval", interval);
        InputHourForm inputHourForm = new InputHourForm(
                service.getYear(),
                service.getMonth(),
                service.getDay(),
                service.getHour()
        );
        model.addAttribute("inputForm", inputHourForm);

        return "alltogether";
    }

    @RequestMapping(value = "/list/pick/minutes", method = RequestMethod.POST)
    public String getDataForHourMinutes(Model model,
                                        @ModelAttribute("inputForm") InputHourForm inputForm)
    {
        System.out.println(inputForm);
        LocalDateTime time = LocalDateTime.of(
                inputForm.getYear(),
                inputForm.getMonth(),
                inputForm.getDay(),
                inputForm.getHour(),
                0,
                0
        );
        List<Measurement1> measures = this.service.getAllForTheHourMinutes(time);
        model.addAttribute("measures", measures);
        String interval = this.service.getHourInterval();
        model.addAttribute("interval", interval);
        return "list";
    }



}

package pro.com.measure.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("/api/measure")
@RestController
public class Measurement1RESTController {

    @Autowired
    Measurement1ServiceImpl service;

    @RequestMapping("/list")
    List<Measurement1> showAll(){
        return service.getAll();
    }

    @RequestMapping("/create/{pick}")
    Measurement1 create(@PathVariable("pick") float pick){
        Measurement1 m1 = new Measurement1(LocalDateTime.now(),pick);
        return service.create(m1);
    }


    @RequestMapping(value = "/list/hour/current", method = RequestMethod.GET)
    List<Measurement1> showCurrentHour(){

        return service.getAllForTheCurrentHour();
    }

   ////   /api/measure/list/hour/current
}

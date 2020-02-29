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

    //  returns data for the given hour
    @RequestMapping(value = "/list/{year}/{month}/{day}/{hour}", method = RequestMethod.GET)
    List<Measurement1>  showForHour(
            @PathVariable(value = "year")int year
            , @PathVariable(value = "month")int month
            , @PathVariable(value = "day")int day
            , @PathVariable(value = "hour")int hour
    ){
        LocalDateTime start = LocalDateTime.of(year,month,day,hour,0,0);
        return service.getAllForTheHour(start);
    }

    // returns data  between  two  dates
    @RequestMapping(value = "/list/{fromyear}/{frommonth}/{fromday}/{fromhour}/{toyear}/{tomonth}/{today}/{tohour}", method = RequestMethod.GET)
    List<Measurement1>  showForPeriod(
            @PathVariable(value = "fromyear")int year
            , @PathVariable(value = "frommonth")int month
            , @PathVariable(value = "fromday")int day
            , @PathVariable(value = "fromhour")int hour
            , @PathVariable(value = "toyear")int toYear
            , @PathVariable(value = "tomonth")int toMonth
            , @PathVariable(value = "today")int toDay
            , @PathVariable(value = "tohour")int toHour
    ){
        LocalDateTime start = LocalDateTime.of(year,month,day,hour,0,0);
        LocalDateTime finish = LocalDateTime.of(toYear,toMonth,toDay,toHour ,0,0);
        return service.getAllForThePeriod(start,finish);
    }
}

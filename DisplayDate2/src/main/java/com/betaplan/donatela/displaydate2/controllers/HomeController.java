package com.betaplan.donatela.displaydate2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model){
        return "index.jsp";
    }

    @RequestMapping("/date")
    public String date(Model model){
        SimpleDateFormat dayName = new SimpleDateFormat("EEEE");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat month = new SimpleDateFormat("MMMM");
        SimpleDateFormat year = new SimpleDateFormat("Y");

        Date date = new Date();
        String dayNameString = dayName.format(date);
        String dayFormatString = dayFormat.format(date);
        String monthString = month.format(date);
        String yearString = year.format(date);

        String dateString = dayNameString + " " + dayFormatString + " " + monthString + " " + yearString;

        model.addAttribute("date", dateString);
        return "date.jsp";
    }

    @RequestMapping("/time")
    public String time(Model model){
        SimpleDateFormat format = new SimpleDateFormat("h:mm a");
        Date date = new Date();
        String timeString = format.format(date);
        model.addAttribute("time", timeString);

        return "time.jsp";
    }
}

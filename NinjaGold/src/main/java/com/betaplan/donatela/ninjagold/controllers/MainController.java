package com.betaplan.donatela.ninjagold.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/")
public class MainController {
    private final String gold = "gold";
    private final String activities = "activities";

    @GetMapping
    public String index(HttpSession session) {
        if (session.getAttribute(gold) == null) {
            session.setAttribute(gold, 0);
            session.setAttribute(activities, new ArrayList<String>());
        }
        return "index.jsp";
    }


    @PostMapping
    public String ninja(HttpSession session, @RequestParam(value = "place") Place place) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        ArrayList<String> allActivities = (ArrayList<String>) session.getAttribute(activities);
        Integer totalGold = (Integer) session.getAttribute(gold);

        switch (place) {
            case FARM:
                int farmEarnings = updateGold(session, totalGold, 10, 20, true);
                allActivities.add("You entered a farm and earned " + farmEarnings + " gold. (" + timeStamp + ")");
                break;
            case CAVE:
                int caveEarnings = updateGold(session, totalGold, 5, 10, true);
                allActivities.add("You entered a cave and earned " + caveEarnings + " gold. (" + timeStamp + ")");
                break;
            case HOUSE:
                int houseEarnings = updateGold(session, totalGold, 2, 5, true);
                allActivities.add("You entered a house and earned " + houseEarnings + " gold. (" + timeStamp + ")");
                break;
            case SPA:
                int spaEarnings = updateGold(session, totalGold, 5, 20, false);
                allActivities.add("You entered a SPA and lost " + spaEarnings + " gold. (" + timeStamp + ")");
                break;
            case QUEST:
                boolean addGold = getRandomBoolean();
                int questEarnings = updateGold(session, totalGold, 0, 50, addGold);
                allActivities.add("You entered a quest and " + (addGold ? "earned " : "lost ") + questEarnings + " gold. (" + timeStamp + ")");
                break;
            default:
                break;
        }

        return "redirect:/";
    }

    private int updateGold(HttpSession session, Integer totalGold, int min, int max, boolean addGold) {
        int number = getRandomNumber(min, max);
        int newTotal = addGold ? totalGold + number : totalGold - number;
        session.setAttribute(gold, newTotal);
        return number;
    }


    private int getRandomNumber(int min, int max) {
        return new Random().nextInt((max + 1) - min) + min;
    }

    private boolean getRandomBoolean() {
        return getRandomNumber(0, 1) == 1;
    }

    private enum Place {
        FARM, CAVE, HOUSE, QUEST, SPA
    }
}

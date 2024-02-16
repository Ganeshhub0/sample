package com.example.thyme.controller;

import com.example.thyme.entities.City;
import com.example.thyme.entities.Passenger;
import com.example.thyme.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pass")
public class PassengerController {
    @Autowired
    PassengerService passengerService;
    private Passenger p = new Passenger();
    private List<City> li = new ArrayList<>();

    @GetMapping("home")
    public String home() {
        return "home";
    }

    @GetMapping("/demo")
    public String demo(Model model) {
        model.addAttribute("add", new Passenger());
        return "add";
    }

//    @PostMapping("/insert")
//    public String insert(Passenger p) {
//        passengerService.insert(p);
//        return "home";
//    }

    @PostMapping("/add")
    public String city(@ModelAttribute("add") Passenger passenger, Model model) {
        p.setId(passenger.getId());
        p.setName(passenger.getName());
        p.setAge(passenger.getAge());
        model.addAttribute("city", new City());
        return "add-city";
    }

    @GetMapping("/addproject")
    public String project(@ModelAttribute("city") City city, Model model) {
        li.add(city);
        model.addAttribute("city", new City());
        return "add-city";
    }

    @GetMapping("/store")
    public String store() {
        p.setCities(li);
        li = new ArrayList<City>();
        passengerService.insert(p);
        p = new Passenger();
        return "redirect:/pass/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Passenger> list = passengerService.findall();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Passenger passenger = passengerService.findbyid(id);
        model.addAttribute("pass", passenger);
        return "update";
    }

    @GetMapping("/edit")
    public String edit(Passenger passenger, Model model) {
        passengerService.update(passenger);
        List<Passenger> list = passengerService.findall();
        model.addAttribute("list", list);
        return "redirect:/pass/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        passengerService.delete(id);
        List<Passenger> list = passengerService.findall();
        model.addAttribute("list", list);
        return "list";
    }
}

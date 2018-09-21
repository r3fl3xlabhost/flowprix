package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.model.CarModel;
import com.example.demo.service.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
class ProductController {

    private static List<Car> carList = new ArrayList<Car>();

    public ProductController() {
        carList.add(new Car("honda","civic"));
        carList.add(new Car("Renault","clio"));
    }

    //@RequestMapping(value = "/cars", method = RequestMethod.GET)
    @GetMapping("/cars")
    public String init(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("name", "test");
        model.addAttribute( "carList", carList);

        return "index";
    }

/*
    @GetMapping("/chart")
    public String getChart(@ModelAttribute("model") ModelMap model) {
        //model.addAttribute("name", "test");

        model.addAttribute( "carList", carList);

        return "chart";
    }
*/

    @GetMapping("/chart")
    public ModelAndView getChart(@ModelAttribute CarModel model) {

        model.setCarList(carList);
        model.setName("Mat");

        model.setDataValues(Arrays.asList(10000, 30162, 26263, 18394, 18287, 28682, 31274, 33259, 25849, 24159, 32651, 31984, 0));

        ModelAndView mav = new ModelAndView("chart");

        mav.addObject("model",model);

        return mav;
    }

    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute  CarModel model, String make, String modelCar) {
        //model.addAttribute("name", "test");
        carList.add(new Car(make, modelCar));
        model.setCarList(carList);
        model.setName("Mat");
        ModelAndView mav = new ModelAndView("chart");

        mav.addObject("model",model);

        return mav;
    }


    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("namer", "nom static");
        model.addAttribute("namez", "nom coucou");
        return "hello";
    }

}

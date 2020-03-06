package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {
    @Autowired
    CarService carService;
//    @Autowired
//    SessionFactory sessionFactory;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
   //     System.out.println(sessionFactory);
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String printCar(@RequestParam(defaultValue = "Empty") String local, ModelMap modelMap) {

        List<Car> cars = new ArrayList<>();
        cars = carService.findAll();
        String title = findTitle(local);
        modelMap.addAttribute("tittles", title);
        modelMap.addAttribute("carFromServer", cars);
        return "cars";
    }

    private String findTitle(String local) {
        if (local.equals("ru")) {
            return "Машины";
        }
        if (local.equals("en")) {
            return "CAR";
        }
        return "Empty";
    }
}
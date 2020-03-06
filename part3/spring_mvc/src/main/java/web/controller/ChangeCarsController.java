package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Car;
import web.service.CarService;

import javax.management.MalformedObjectNameException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
 *
 *@Data 06.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */
@Controller
public class ChangeCarsController {
    @Autowired
    CarService carService;

    @GetMapping(value = "changeCar")
    public String getChangeCar(ModelMap modelMap) {
        List<Car> cars = carService.findAll();
        modelMap.addAttribute("carsInJDBC", cars);
        return "crud";
    }

    @PostMapping(value = "addCar")
    public String addCar(HttpServletRequest req) {
        String model = req.getParameter("model");
        String color = req.getParameter("color");
        Car car = new Car().setModel(model).setColor(color);
        carService.add(car);
        return "redirect:/changeCar";
    }

    @PostMapping(value = "deleteCar")
    public String deleteCar(HttpServletRequest req) {
        String[] items = req.getParameterValues("Delete");
//assuming Order is your order class and orderList is your item list
        for (String str : items) {
            try {
                carService.delete(Long.parseLong(str));
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return "redirect:/changeCar";
    }

    @GetMapping(value = "updateUser")
    public String getUpdateUser(HttpServletRequest req, ModelMap model) {
        Long id = Long.parseLong(req.getParameter("id"));
        Car car = carService.findById(id);
        model.addAttribute("Car", car);
        return "change";
    }

    @PostMapping(value = "updateUser")
    public String postUpdateUser(HttpServletRequest req) {
        //?id=<c:out value='${Car.id}' />
        String model = req.getParameter("model");
        String color = req.getParameter("color");
        Long id = Long.parseLong(req.getParameter("id"));
        Car car = new Car().setModel(model).setColor(color).setId(id);
        System.out.println(car);
        carService.update(car);
        System.out.println(car);
        return "redirect:/changeCar";
    }
}

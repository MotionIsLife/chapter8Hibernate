package motionIsLife;

import motionIsLife.dao.CarService;
import motionIsLife.vo.Car;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

public class App {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-annotation.xml");
        ctx.refresh();
        CarService carService = ctx.getBean("carService", CarService.class);
        List<Car> cars = carService.findAll();
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

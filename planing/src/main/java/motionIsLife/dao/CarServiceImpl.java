package motionIsLife.dao;

import com.google.common.collect.Lists;
import motionIsLife.vo.Car;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("carService")
@Repository
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Car> findAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void updateCarAgeJob() {
        List<Car> cars = findAll();
        DateTime currentDate = DateTime.now();
        System.out.println("car age update job started");

        for (Car car : cars) {
            int years = Years.yearsBetween(car.getManufactureDate(), currentDate).getYears();
            car.setAge(years);
            save(car);
            System.out.println("car age update--- " + car);
        }
        System.out.println("car age update job completed successfully");
    }
}

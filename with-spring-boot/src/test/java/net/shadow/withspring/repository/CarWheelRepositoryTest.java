package net.shadow.withspring.repository;

import net.shadow.withspring.entity.Wheel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test")
public class CarWheelRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private WheelRepository wheelRepository;

    @Test
    public void persist() {
//        Car car = new Car();
//        Wheel wheel = new Wheel();
//        wheel.setBelongsTo(car);
//
//        Wheel wheel2 = new Wheel();
//        wheel2.setBelongsTo(car);
//        wheelRepository.save(newArrayList(wheel, wheel2));
//
//        wheelRepository.delete(wheel);
//        assertNotNull(carRepository.findOne(car.getId()));


//        Car car = new Car();
//        Wheel wheel = new Wheel();
//
//        wheel.setBelongsTo(car);
//        car.setWheels(newArrayList(wheel));
//
//        carRepository.saveAndFlush(car);
//        assertNotNull(car.getId());
//        assertNotNull(wheelRepository.getOne(wheel.getId()).getBelongsTo());

        Wheel wheel = new Wheel();
        wheelRepository.save(wheel);
        assertNotNull(wheel.getId());

        wheelRepository.findAll();
    }
}
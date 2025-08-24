package QU_1.IMP;

import QU_1.Model.Car;

import java.util.List;

public interface BaseRepository {

    Car add(Car car);
    void delete(int id);
    Car update (int id,String model,int year);
    List<Car> findAll();
    List<Car> findById(Car id);
    List<Car> findByBrand(Car brand);




}

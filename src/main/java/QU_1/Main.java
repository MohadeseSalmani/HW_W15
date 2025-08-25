package QU_1;

import QU_1.Model.Car;
import QU_1.Model.Truck;
import QU_1.Model.Vehicle;
import QU_1.Rep.RepositoryCar;
import QU_1.Rep.RepositoryVehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManagementSystem");
        EntityManager em = emf.createEntityManager();

        RepositoryCar repositoryCar =new RepositoryCar();
        RepositoryVehicle repositoryVehicle  =new RepositoryVehicle();


        em.getTransaction().begin();
        Car c1 = new Car();
        c1.setBrand("BMW");
        c1.setModel("x5");
        c1.setYear(2020);
        c1.setSeatingCapacity(2);
        c1.setFuelType("Petrol");

        Car c2 = new Car();
        c2.setBrand("Toyota");
        c2.setModel("Corolla");
        c2.setYear(2018);
        c2.setSeatingCapacity(4);
        c2.setFuelType("Benzin");

        Car c3 = new Car();
        c3.setBrand("Kia");
        c3.setModel("Rio");
        c3.setYear(2015);
        c3.setSeatingCapacity(5);
        c3.setFuelType("Petrol");

        Car c4 = new Car();
        c4.setBrand("BMW");
        c4.setModel("320i");
        c4.setYear(2019);
        c3.setSeatingCapacity(6);
        c4.setFuelType("Diesel");


        Truck t1 = new Truck();
        t1.setBrand("yamaha");
        t1.setModel("x5");
        t1.setYear(2020);
        t1.setLoadCapacity(15.1);
        t1.setNumberOfAxles(18);

        Truck t2 = new Truck();
        t2.setBrand("amot");
        t2.setModel("amot");
        t2.setYear(2024);
        t2.setLoadCapacity(14.1);
        t2.setNumberOfAxles(16);

        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(t1);
        em.persist(t2);

        Car car = em.find(Car.class, 1L);

        em.detach(car);
        car.setFuelType("Electric");

        Car mergedCar = em.merge(car);


        em.getTransaction().commit();

        em.close();
        emf.close();


        List<Vehicle> vehicles = repositoryVehicle.findAll();

        List<Car> capacCars = vehicles.stream()
                .filter(v -> v instanceof Car && ((Car) v).getSeatingCapacity() > 4)
                .map(v -> (Car) v)
                .collect(Collectors.toList());
        capacCars.forEach(c -> System.out.println(" Brand "+ car.getBrand()+" Model " +car.getModel() +" Year " + car.getYear()));


        List<Truck> heavyTrucks = vehicles.stream()
                .filter(v -> v instanceof Truck && ((Truck) v).getLoadCapacity() > 10)
                .map(v -> (Truck) v)
                .collect(Collectors.toList());
        heavyTrucks.forEach(truck -> System.out.println(" Brand "+ truck.getBrand()+" Model " +truck.getModel() +" Year " + truck.getYear()));



        double avgYear = vehicles.stream()
                .mapToInt(Vehicle::getYear)
                .average().orElse(0);
        System.out.println("Average Manufacturing Year: " +  (int) Math.round(avgYear));

        Map<String, Long> brandCount = vehicles.stream()
                .collect(Collectors.groupingBy(Vehicle::getBrand, Collectors.counting()));
        brandCount.forEach((brand, count) ->  System.out.println(brand + " → " + count + " vehicles"));



    }
}

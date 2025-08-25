package QU_1.Rep;

import QU_1.Service.BaseRepository;
import QU_1.Model.Car;
import QU_1.Util.EntityManagerProvider;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RepositoryCar implements BaseRepository {


    @Override
    public Car add(Car car) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();
        entityManager.close();
        return car;
    }

    @Override
    public void delete(int id) {

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Car car=entityManager.find(Car.class,id);
        if(car ==null){
            throw  new NullPointerException("item is null");
        }
        entityManager.remove(car);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Car update(int id,String model, int year) {

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Car car=entityManager.find(Car.class,id);
        if(car ==null){
            throw  new NullPointerException("item is null");
        }
        car.setYear(year);
        car.setModel(model);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null ;
    }

    @Override
    public List<Car> findAll() {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        return entityManager.createQuery("Select c from Car c", Car.class).getResultList();


    }

    @Override
    public List<Car> findById(Car id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        return entityManager.createQuery("Select c from Car c where  c.id=id", Car.class).getResultList();

    }

    @Override
    public List<Car> findByBrand(Car brand) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        return entityManager.createQuery("Select c from Car c where  c.brand=brand", Car.class).getResultList();
    }

}

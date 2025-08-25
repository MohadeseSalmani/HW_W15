package QU_1.Rep;

import QU_1.Model.Vehicle;
import QU_1.Service.BaseRepositoryVehicle;
import QU_1.Util.EntityManagerProvider;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RepositoryVehicle implements BaseRepositoryVehicle {

    @Override
    public List<Vehicle> findAll() {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        return entityManager.createQuery("Select v from Vehicle v", Vehicle.class).getResultList();    }
}

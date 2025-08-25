package Qu_2.Rep;

import QU_1.Model.Vehicle;
import QU_1.Service.BaseRepositoryVehicle;
import Qu_2.Model.Content;
import Qu_2.Util.EntityManagerProvider;
import Qu_2.service.ContentRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RepositoryContent implements ContentRepository {


    @Override
    public List<Content> findAll() {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        return entityManager.createQuery("Select c from Content c", Content.class).getResultList();
    }
}
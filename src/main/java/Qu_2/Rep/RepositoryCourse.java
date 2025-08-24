package Qu_2.Rep;


import QU_1.Util.EntityManagerProvider;
import Qu_2.service.Repository;
import Qu_2.Model.Course;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RepositoryCourse implements Repository {
    @Override
    public Course add(Course course) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Course course=entityManager.find(Course.class,id);
        if(course == null){
            throw  new NullPointerException("item is null");
        }
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Course update(int id, String author, int duration){
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Course Content=entityManager.find(Course.class,id);
        if(Content ==null){
            throw  new NullPointerException("item is null");
        }
        Content.setAuthor(author);
        Content.setDuration(duration);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null ;
    }

    @Override
    public List<Course> findAll() {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        return entityManager.createQuery("Select c from Course c", Course.class).getResultList();    }

    @Override
    public List<Course> findById(Course id) {
         EntityManager entityManager = EntityManagerProvider.getEntityManager();
            return entityManager.createQuery("Select c from Course c where  c.id=id", Course.class).getResultList();


    }

    @Override
    public List<Course> findByBrand(Course title) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        return entityManager.createQuery("Select c from Course c where  c.title=title", Course.class).getResultList();    }
}

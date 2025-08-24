package Qu_2.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("ManagementSystemEducation");

    public static final EntityManager getEntityManager (){
        if(emf==null &&! emf.isOpen()){
            throw new IllegalStateException("Entity Manager Factory is null");
        }

        return emf.createEntityManager();
    }
    public static void close(){
        if(emf !=null && emf.isOpen()){

            emf.close();
        }

    }


}

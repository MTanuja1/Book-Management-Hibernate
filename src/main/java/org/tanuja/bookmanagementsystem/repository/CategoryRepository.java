package org.tanuja.bookmanagementsystem.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.tanuja.bookmanagementsystem.model.Category;

import java.util.List;

public class CategoryRepository {
     EntityManager em = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
     EntityTransaction tx = em.getTransaction();

     public Category getCategoryById(int id) {
         try{
             return em.find(Category.class, id);
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
     }
     public Category getCategoryByName(String name) {
         try{
             Query query = em.createQuery("FROM category WHERE name=:name",Category.class);
             query.setParameter("name", name);
             return (Category) query.getResultList().stream().findFirst().orElse(null);
         }catch(Exception e){
             e.printStackTrace();
             return null;
         }

     }

    public Category addCategory(Category category) {
         try {
             tx.begin();
             em.persist(category);
             tx.commit();
             return category;
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
    }

    public List<Category> getAllCategories() {
         try{
             Query query = em.createQuery("FROM category",Category.class);
             return query.getResultList();
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
    }
}



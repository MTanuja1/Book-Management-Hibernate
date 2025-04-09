package org.tanuja.bookmanagementsystem.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.tanuja.bookmanagementsystem.model.Review;

public class ReviewRepository {
     EntityManager em= Persistence.createEntityManagerFactory("hibernate").createEntityManager();
     EntityTransaction tx = em.getTransaction();

     public Review getReviewById(int id) {
         try{
             return em.find(Review.class, id);
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
     }
     public Review saveReview(Review review) {
        try{
            tx.begin();
            em.persist(review);
            tx.commit();
         return review;
     }catch(Exception e){
         e.printStackTrace();
         return null;
    }
}}

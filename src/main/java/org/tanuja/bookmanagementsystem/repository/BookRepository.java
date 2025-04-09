package org.tanuja.bookmanagementsystem.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.tanuja.bookmanagementsystem.model.Book;

import java.util.List;

public class BookRepository {

    EntityManager em= Persistence.createEntityManagerFactory("hibernate").createEntityManager();
    EntityTransaction tx = em.getTransaction();

    public Book getBookById(long id) {
        try {
            return em.find(Book.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        public Book saveBook(Book book){
            try{
            tx.begin();
            em.persist(book);
            tx.commit();
            return book;
        }catch(Exception e){
           e.printStackTrace();
            return null;
        }
    }
    public List<Book> getAllBooks(){
       try{
           return  em.createQuery("from book", Book.class).getResultList();
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
    }
}

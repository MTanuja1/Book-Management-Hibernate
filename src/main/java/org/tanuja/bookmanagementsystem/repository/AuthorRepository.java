package org.tanuja.bookmanagementsystem.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.tanuja.bookmanagementsystem.model.Author;

import java.util.List;


public class AuthorRepository {
    EntityManager em= Persistence.createEntityManagerFactory("hibernate").createEntityManager();
    EntityTransaction tx = em.getTransaction();

    public Author addAuthor(Author author) {
        try{
            tx.begin();
            em.persist(author);
            tx.commit();
            return author;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Author findAuthorById(long id) {
        try{
            return em.find(Author.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Author> getAllAuthor()
    {
        try{
           Query query=em.createQuery("from author",Author.class);
           List<Author> authors=query.getResultList();
           return authors;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Author updateAuthor(Author author) {
        try{
            tx.begin();
            em.merge(author);
            tx.commit();
            return author;
        } catch (Exception e) {
           e.printStackTrace();
            return null;

        }
    }
}

package org.tanuja.bookmanagementsystem.service;

import org.tanuja.bookmanagementsystem.model.Author;
import org.tanuja.bookmanagementsystem.model.Book;
import org.tanuja.bookmanagementsystem.model.Category;
import org.tanuja.bookmanagementsystem.model.Review;
import org.tanuja.bookmanagementsystem.repository.AuthorRepository;
import org.tanuja.bookmanagementsystem.repository.BookRepository;
import org.tanuja.bookmanagementsystem.repository.CategoryRepository;

import java.util.List;
import java.util.Scanner;

public class BookService {
    final Scanner sc=new Scanner(System.in);
    final BookRepository bookRepo=new BookRepository();
    final AuthorRepository authorRepo=new AuthorRepository();
    final CategoryRepository categoryRepo=new CategoryRepository();

    public Book addBooks(){
        Book book=new Book();
        System.out.println("enter book details");
        System.out.println("Enter title");
        String title= sc.nextLine();
        book.setTitle(title);
        System.out.println("Enter book ISBN");
        String isbn=sc.nextLine();
        book.setIsbn(isbn);
        System.out.println("Is Author exist in databse:(Y?N):");
        String res=sc.nextLine();
         Author author=null;
         if(res.equalsIgnoreCase("Y")){
             System.out.println("Enter author ID");
             long authorID=sc.nextLong();
             sc.nextLine();
             author=authorRepo.findAuthorById(authorID);
             if(author==null) {
                 System.err.println("Author not found");
             } }else{
                 System.out.println("Enter author details");
                 System.out.println("Enter  Author Name");
                 String name=sc.nextLine();
                 System.out.println("Enter Author Email");
                 String email=sc.nextLine();
                  author=new Author();
                  author.setName(name);
                  author.setEmail(email);
                  authorRepo.addAuthor(author);
             }
             book.setAuthor(author);
             System.out.println("Enter category Name");
             String categoryName=sc.nextLine();
             Category category=categoryRepo.getCategoryByName(categoryName);
             if(category==null){
                 category=new Category();
                 category.setName(categoryName);
                 categoryRepo.addCategory(category);
                 System.out.println("New category added"+categoryName);
             }else{
                 System.out.println("Category already exist");
             }
             book.getCategory().add(category);
             return bookRepo.saveBook(book);
         }

    public void getAllBooks(){
        List<Book> books=bookRepo.getAllBooks();
        if(books!=null){
            for(Book book:books){
                System.out.println("BookId:"+book.getId()+"Book Title"+book.getTitle()+"book ISBN:"+book.getIsbn());
            }
        }else{
            System.out.println("No books found");
        }
    }
     public void displayBookById(){
         System.out.println("Enter Book ID");
         long bookID=sc.nextLong();
         sc.nextLine();
         Book book=bookRepo.getBookById(bookID);
         if(book==null){
             System.err.println("Book not found");
         }else{
             System.out.println("Book ID:"+book.getId()+"Book Title"+book.getTitle()+"book ISBN:"+book.getIsbn());
         }
     }

     public void getReviewOfBook(){
        System.out.println("Enter Book ID");
        long bookID=sc.nextLong();
        sc.nextLine();
        Book book=bookRepo.getBookById(bookID);
        if(book==null){
            System.err.println("Book not found");
            return;
        }
        List<Review> reviews=book.getReviews();
        if(reviews.size()<=0){
            System.err.println("No reviews found");
        }else{
            for(Review review:reviews){
                System.out.println("RviewsId:"+review.getId()+"Review content:"+review.getContent()+"Rating:"+review.getRating());
            }
        }
     }
}

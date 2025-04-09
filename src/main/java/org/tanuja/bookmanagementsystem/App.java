package org.tanuja.bookmanagementsystem;

import org.tanuja.bookmanagementsystem.model.Author;
import org.tanuja.bookmanagementsystem.model.Book;
import org.tanuja.bookmanagementsystem.model.Review;
import org.tanuja.bookmanagementsystem.service.AuthorService;
import org.tanuja.bookmanagementsystem.service.BookService;
import org.tanuja.bookmanagementsystem.service.CategoryService;
import org.tanuja.bookmanagementsystem.service.ReviewService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    final static AuthorService authorService = new AuthorService();
    final static BookService bookService = new BookService();
    final static CategoryService categoryService = new CategoryService();
    final static ReviewService  reviewService = new ReviewService();
    public static void main( String[] args )
    {

       Scanner sc=new Scanner(System.in);
       boolean flag=true;
       while(flag){
           System.out.println("1.ADD AUTHOR");
           System.out.println("2.RETRIEVE ALL AUTHOR");
           System.out.println("3.RETRIEVE ALL BOOKS BY AN AUTHOR ID");
           System.out.println("4.ADD BOOKS");
           System.out.println("5.RETRIEVE ALL BOOKS");
           System.out.println("6.RETRIEVE BOOK BY ID");
           System.out.println("7.SHOW ALL CATEGORIES");
           System.out.println("8.RETRIEVE ALL BOOKS BY CATEGORY");
           System.out.println("9.ADD REVIEW TO A BOOK");
           System.out.println("10.RETRIEVE ALL REVIEWS OF A BOOK");
           System.out.println("11.Exit");
           int op=sc.nextInt();
           switch(op){
               case 1:{
                   Author author=authorService.addAuthor();
                   if(author!=null){
                       System.out.println("Author added");
                   }else{
                       System.err.println("Author not added");
                   }
               }break;
               case 2:{
                   authorService.displayAllAuthor();
               }break;
               case 3:{
                   authorService.getAllBooksByAuthor();
               }break;
               case 4:{
                   Book book=bookService.addBooks();
                   if(book!=null){
                       System.out.println("Book"+book.getTitle()+"saved successfully");
                   }
                   else{
                       System.err.println("Book not saved");
                   }

               }break;
               case 5:{
                   bookService.getAllBooks();
               }break;
               case 6:{
                   bookService.displayBookById();
               }break;
               case 7:{
                   categoryService.displayAllCategories();
               }break;
               case 8:{
                   categoryService.displayBookByCategory();
               }break;
               case 9:{
                   Review review=reviewService.addReview();
                   if(review!=null){
                       System.out.println("Review added");
                   }else{
                       System.err.println("Review not added");
                   }
               }break;
               case 10:{
                   bookService.getReviewOfBook();
               }break;
               case 11:{
                   flag=false;
               }break;
           }

       }
    }
}

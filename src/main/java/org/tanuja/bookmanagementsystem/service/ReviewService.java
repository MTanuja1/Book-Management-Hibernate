package org.tanuja.bookmanagementsystem.service;

import org.tanuja.bookmanagementsystem.model.Book;
import org.tanuja.bookmanagementsystem.model.Review;
import org.tanuja.bookmanagementsystem.repository.BookRepository;
import org.tanuja.bookmanagementsystem.repository.ReviewRepository;

import java.util.Scanner;

public class ReviewService {
    Scanner sc=new Scanner(System.in);
    final private ReviewRepository reviewRepository=new ReviewRepository();
    final private BookRepository bookRepository=new BookRepository();

    public Review addReview(){
        System.out.println("Enter the book id of book you want to  give review: ");
        long bookId=sc.nextLong();
        sc.nextLine();
        Book book=bookRepository.getBookById(bookId);
        while(book==null){
            System.out.println("the given book does not exist ");
            return null;
        }
        System.out.println("Enter the review: ");
        String content=sc.nextLine();
        System.out.println("give the rating between 0-5");
        int rating=sc.nextInt();
        sc.nextLine();
        Review review=new Review();
        review.setContent(content);
        review.setRating(rating);
        review.setBook(book);
        return reviewRepository.saveReview(review);
    }
}

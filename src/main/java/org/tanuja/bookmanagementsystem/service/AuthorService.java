package org.tanuja.bookmanagementsystem.service;

import org.tanuja.bookmanagementsystem.model.Author;
import org.tanuja.bookmanagementsystem.model.Book;
import org.tanuja.bookmanagementsystem.model.Category;
import org.tanuja.bookmanagementsystem.repository.AuthorRepository;
import org.tanuja.bookmanagementsystem.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorService {


        Scanner sc;
        AuthorRepository repo;
        final CategoryRepository categoryRepository;

    public AuthorService() {
        this.sc = new Scanner(System.in);
        this.repo = new AuthorRepository();
        this.categoryRepository = new CategoryRepository();

    }

    public Author addAuthor() {
        System.out.println("Enter the name of the author: ");
        String name = sc.nextLine();
        System.out.println("Enter author email ");
        String email = sc.nextLine();
        Author author=new Author();
        author.setName(name);
        author.setEmail(email);

        List<Book> books=new ArrayList<>();
        String anotherBook;
        do{
            System.out.println("Enter the name of the book: ");
            String bookName = sc.nextLine();
            System.out.println("Enter book ISBN ");
            String bookISBN = sc.nextLine();

            Book book=new Book();
            book.setTitle(bookName);
            book.setIsbn(bookISBN);
            book.setAuthor(author);

            System.out.println("Enter Category name");
            String categoryName = sc.nextLine();

            Category category= categoryRepository.getCategoryByName(categoryName);
            if(category==null){
                category=new Category();
                category.setName(categoryName);
                categoryRepository.addCategory(category);
                System.out.println(" New Category added"+categoryName);
            }else{
                System.out.println("Category found"+categoryName);
            }
            book.getCategory().add(category);
            books.add(book);
        System.out.println("Enter anoter book?(Y/N):");
        anotherBook=sc.nextLine();
        }
        while(anotherBook.equalsIgnoreCase("y"));
        author.setBook(books);
        return repo.addAuthor(author);
    }

    public void displayAllAuthor(){
        List<Author> authors=repo.getAllAuthor();
        if(authors!=null){
            for(Author author:authors){
                System.out.println("Author Id:"+author.getId()+",Name:"+author.getName()+",Email:"+author.getName());
            }
        }else{
            System.out.println("No Author Found");
        }
    }

    public List<Book> getAllBooksByAuthor() {
        System.out.println("Enter auhtor ID");
        Long authorId = sc.nextLong();
        sc.nextLine();
        Author author = repo.findAuthorById(authorId);
        if (author == null) {
            System.err.println("Author not found" + authorId);
            return null;
        }
        List<Book> allBooks = author.getBook();
        if (allBooks != null && !allBooks.isEmpty()) {
            for (Book book : allBooks) {
                System.out.println("BookId"+book.getId()+"title:"+book.getTitle()+"ISBN:"+book.getIsbn()+book.getIsbn());
            }
        }else{
            System.out.println("No Book Found");
        }
        return allBooks;
    }
}

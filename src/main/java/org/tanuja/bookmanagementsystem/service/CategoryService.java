package org.tanuja.bookmanagementsystem.service;

import org.tanuja.bookmanagementsystem.model.Book;
import org.tanuja.bookmanagementsystem.model.Category;
import org.tanuja.bookmanagementsystem.repository.CategoryRepository;

import java.util.List;
import java.util.Scanner;

public class CategoryService {
    final CategoryRepository categoryRepository=new CategoryRepository();
    final Scanner scanner = new Scanner(System.in);

    public void displayAllCategories() {
        List<Category> categories=categoryRepository.getAllCategories();
        if(categories==null){
            System.err.println("No categories found");
        }else{
            for(Category category:categories){
                System.out.println("catrgory Id:"+category.getId()+"category Name-"+category.getName());

            }
        }
    }

    public void displayBookByCategory(){
        System.out.println("Enter Category Name");
        String categoryName=scanner.nextLine();
        Category category=categoryRepository.getCategoryByName(categoryName);
        if(category==null){
            System.err.println("Category not found");
            return;
        }
        List<Book> books=category.getBooks();
        if(books.isEmpty()){
            System.out.println("No books found in this category");

        }else{
            for(Book book:books){
                System.out.println("book Id"+book.getId()+"book title:"+book.getTitle());
            }
        }
    }
}

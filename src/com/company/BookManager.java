package com.company;

import java.nio.file.*;

import java.util.ArrayList;

import static java.nio.file.Paths.*;

public class BookManager {

    ArrayList<Book> listOfAllBooks;

    public BookManager() {

        listOfAllBooks = new ArrayList<>();
        //createNewBook();
        //System.out.println(showTitleDescription("fellow"));
        //showTitleDescription("aZ");
        //showAuthorCertainBook("cHa");
    }


    // Create new object in form of a book, add it to "listOfAllBooks"
    public void createNewBook() {

        // ---------------------------------- Harry Potter Trilogy ------------------------------------
        listOfAllBooks.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling",
                "Harry Potter, a young boy realizes he is not an ordinary child, but a wizard.", true));
        listOfAllBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling",
                "Harry Potter continues his adventures in Hogwarts, but another enemy lurks in the"
                        + " " + "chamber underneath the school.", true));
        listOfAllBooks.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling",
                "Harry Potter encounters his worst enemy so far, what or who is this mysterious creature.", true));

        // ---------------------------------- Lord of the Rings Trilogy --------------------------------
        listOfAllBooks.add(new Book("Lord of the Rings: Fellowship of the Ring", "J.R.R. Tolkien",
                "Frodo, a young hobbit living in peace, encounters a powerful object and" + " " +
                        "heads out on a great adventure", true));
        listOfAllBooks.add(new Book("Lord of the Rings: The Two Towers", "J.R.R. Tolkien",
                "Fordo and Sam continue their way towards Mordor, but get in the middle of the great war.", true));
        listOfAllBooks.add(new Book("Lord of the Rings: The Return of the King", "J.R.R. Tolkien",
                "As Smeagol leads the way, Frodo, Sam and the others stands before their greatest challenge yet.", true));
    }



    public void showAllBooksWithAllContent(){
        for (Book book : listOfAllBooks){
            System.out.println(book);
        }
    }


    public void showBookTitle(){
        for (Book book : listOfAllBooks){
            System.out.println(book.getTitle());
        }
    }


    // Show only description of a certain book
    public void showBookAuthor(){
    for (Book book : listOfAllBooks){
        System.out.println(book.getAuthor());
        }
    }


    public void showBookDescription(){ // This might be replaced with method "showTitleDescription"
        for (Book book : listOfAllBooks){
            System.out.println(book.getShortDescription());
        }
    }


    public void showAvailableBooks(){
        for (Book book : listOfAllBooks){
            if (book.isAvailable())
            System.out.println(book.getTitle());
        }
    }


    // Show author of a certain book, searched by title
    public void showAuthorCertainBook(String bookTitle) {
        boolean findMatch = false;
        for (Book book : listOfAllBooks){
            if (book.getTitle().toLowerCase().contains(bookTitle.toLowerCase())) {
                findMatch = true;
                System.out.println("You searched: " + bookTitle);
                System.out.println("Book found: " + book.getTitle());
                System.out.println("The author you're looking for is: " + book.getAuthor());
            }
        }
        if(!findMatch) { // if not true
            System.out.println("We're sorry, your search gave no results.");
        }
    }


        // Show Title of book and the Description while SEARCHING either of them.
    public void showTitleDescription(String bookTitlebookDescription){
        boolean findMatch = false;
        for (Book book : listOfAllBooks){
            if (book.getTitle().toLowerCase().contains(bookTitlebookDescription.toLowerCase()) ||
                book.getAuthor().contains(bookTitlebookDescription)) {
                    findMatch = true;
                    System.out.println("You searched: " + bookTitlebookDescription);
                    System.out.println("Book found: " + book.getTitle());
                    System.out.println("Author: " + book.getAuthor());

                }
            }
        if(!findMatch) { // if not true
            System.out.println("We're sorry, your search gave no results.");
        }
    }

    public void saveBooks(){
        FileUtils.saveObject("books.src", listOfAllBooks, StandardOpenOption.CREATE);
    }
    public void loadBooks(){

        Path path = Paths.get("books.src");
        if(Files.exists(path)) {
            listOfAllBooks = (ArrayList<Book>)FileUtils.loadObject("books.src");
        }
        else{
            listOfAllBooks = new ArrayList<>();
            createNewBook();
            saveBooks();
        }
    }
}

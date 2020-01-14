package com.company;

import java.util.ArrayList;

public class BookHandler {

    ArrayList<Book> listOfAllBooks = new ArrayList<>();

    public BookHandler(){
        createNewBook();
        showAllBooks();
    }


    // Create new object in form of a book, add it to "listOfAllBooks"
    public void createNewBook(){

        // ---------------------------------- Harry Potter Trilogy ------------------------------------
        listOfAllBooks.add(new Book("Harry Potter and the Philosopher's Stone", "J.K Rowling",
                "Harry Potter, a young boy realizes he is not an ordinary boy, but a wizard."));
        listOfAllBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J.K Rowling",
                "Harry Potter continues his adventures in Hogwarts, but another enemy lurks in the"
                        + " " + "chamber underneath the school."));
        listOfAllBooks.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K Rowling",
                "Harry Potter encounters his worst enemy so far, what or who is this mysterious creature."));

        // ---------------------------------- Lord of the Rings Trilogy --------------------------------
        listOfAllBooks.add(new Book("Lord of the Rings: Fellowship of the Ring", "J.R.R. Tolkien",
                "Frodo, a young hobbit living in peace, encounters a powerful object and" + " " +
                        "heads out on a great adventure"));
        listOfAllBooks.add(new Book("Lord of the Rings: The Two Towers", "J.R.R. Tolkien",
                "Fordo and Sam continue their way towards Mordor, but get in the middle of the great war."));
        listOfAllBooks.add(new Book("Lord of the Rings: The Return of the King", "J.R.R. Tolkien",
                "As Smeagol leads the way, Frodo, Sam and the others stands before their greatest challenge yet."));

    }

    public void showAllBooks(){
        for (Book book : listOfAllBooks){
            System.out.println(book);
        }
    }

}

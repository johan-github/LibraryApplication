package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class BookHandler {

    ArrayList<Book> listOfAllBooks = new ArrayList<>();

    //Scanner scanner = new Scanner(System.in);

    public BookHandler() {
        createNewBook();
        //System.out.println(showTitleDescription("fellow"));
        showTitleDescription("Tolk");
        //System.out.println(showAuthorCertainBook("Karin"));
    }


    // Create new object in form of a book, add it to "listOfAllBooks"
    public void createNewBook() {

        // ---------------------------------- Harry Potter Trilogy ------------------------------------
        listOfAllBooks.add(new Book("Harry Potter and the Philosopher's Stone", "J.K Rowling",
                "Harry Potter, a young boy realizes he is not an ordinary boy, but a wizard.", true));
        listOfAllBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J.K Rowling",
                "Harry Potter continues his adventures in Hogwarts, but another enemy lurks in the"
                        + " " + "chamber underneath the school.", true));
        listOfAllBooks.add(new Book("Harry Potter and the Prisoner of Azkaban", "J.K Rowling",
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



    public void showAllBooksWithContent(){
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


    // Show author of a certain book, searched by title
    public String showAuthorCertainBook(String bookTitle) {
        for (int i=0; i < listOfAllBooks.size(); i++) {
            if (listOfAllBooks.get(i).getTitle().contains(bookTitle)) {
                System.out.println("You searched: " + bookTitle);
                System.out.println("Book found: " + listOfAllBooks.get(i).getTitle());
                System.out.println("The author you're looking for is: " + listOfAllBooks.get(i).getAuthor());
                return "";
            }
        }
        System.out.println("We're sorry, your search gave no results.");
        return "";
        }


        // Show Title of book and the Description while SEARCHING either of them.
    public String showTitleDescription(String bookTitlebookDescription){
        /* for (int i = 0 ; i < listOfAllBooks.size(); i++) {
                if
                    (listOfAllBooks.get(i).getTitle().contains(bookTitlebookDescription) ||
                    (listOfAllBooks.get(i).getTitle().equalsIgnoreCase(bookTitlebookDescription) ||

                    (listOfAllBooks.get(i).getAuthor().contains(bookTitlebookDescription) ||
                    (listOfAllBooks.get(i).getAuthor().equalsIgnoreCase(bookTitlebookDescription))))) {
*/
        for (Book book : listOfAllBooks){
            if (book.getTitle().contains(bookTitlebookDescription) ||
                book.getTitle().equalsIgnoreCase(bookTitlebookDescription) ||
                book.getAuthor().contains(bookTitlebookDescription) ||
                book.getAuthor().equalsIgnoreCase(bookTitlebookDescription))
                    {
                    System.out.println("You searched: " + bookTitlebookDescription);
                    System.out.println("Book found: " + book.getTitle());
                    System.out.println("Author: " + book.getAuthor());
                    return bookTitlebookDescription;
                }
                    return null;
            }
        return "Your search gave no results. Please try again.";
    }
}

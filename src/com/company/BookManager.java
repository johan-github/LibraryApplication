package com.company;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {

    ArrayList<Book> listOfAllBooks = new ArrayList<>();

    public BookManager() {

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


    public void showAllBooksWithAllContent() {
        for (Book book : listOfAllBooks) {
            System.out.println(book);
        }
    }


    public void showBookTitle() {
        for (Book book : listOfAllBooks) {
            System.out.println(book.getTitle());
        }
    }


    // Show only Author of a certain book
    public void showBookAuthor() {
        for (Book book : listOfAllBooks) {
            System.out.println(book.getAuthor());
        }
    }


    public void showNotAvailableBooks(){
        for (Book book : listOfAllBooks){
            if (!book.isAvailable()){
                System.out.println();
            }
        }
    }


    public void showAvailableBooks() {
        for (Book book : listOfAllBooks) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle());
            }
        }
    }

    // Show author of a certain book, searched by title
    public void showAuthorCertainBook(String bookTitle) {
        boolean findMatch = false;
        for (Book book : listOfAllBooks) {
            if (book.getTitle().toLowerCase().contains(bookTitle.toLowerCase())) {
                findMatch = true;
                System.out.println("You searched: " + bookTitle);
                System.out.println("Book found: " + book.getTitle());
                System.out.println("The author you're looking for is: " + book.getAuthor());
            }
        }
        if (!findMatch) { // if not true
            System.out.println("We're sorry, your search gave no results.");
        }
    }


    // Show Title of book and the Description while SEARCHING either by Author or Title.
    public void searchTitleOrAuthor(String bookTitlebookAuthor) {
        boolean findMatch = false;
        if (bookTitlebookAuthor.equals("0")) {
            System.out.println("Returning to previous menu, please wait...");
            MainMenu.nextMenu();
        }
        for (Book book : listOfAllBooks) {
            if (book.getTitle().toLowerCase().contains(bookTitlebookAuthor.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(bookTitlebookAuthor.toLowerCase())) {
                findMatch = true;
                System.out.println("You searched: " + bookTitlebookAuthor);
                System.out.println("Book found: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Returning to menu");
            }
        }
        if (!findMatch) { // if not true
            System.out.println("We're sorry, your search gave no results.");
            System.out.println("Returning to menu");
        }
    }


    public void showTitleWithIndex(){
        for (int i = 0; i < listOfAllBooks.size(); i++){
            System.out.println((i+1) + ": " + listOfAllBooks.get(i).getTitle());
        }
    }


    public void bookChoiceDescription() {
        System.out.println();
        System.out.println("Choose book by entering the number next to the title");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        while (true) {

            while (!userInput.matches("[0-9]+") || userInput.matches("[a-zA-Z]+")) {
                System.out.println("Please enter a digit.");

                System.out.println("Choose a number between: " +
                        (listOfAllBooks.size() - listOfAllBooks.size() + 1) +
                        " and " + listOfAllBooks.size());
                try{
                    userInput = scanner.nextLine();
                }catch (Exception e){
                    System.out.println();
                }
            }
            try{
            while ((Integer.parseInt(userInput) - 1) >= 0 || (Integer.parseInt(userInput) - 1) <= listOfAllBooks.size()
                    && Integer.parseInt(userInput) <= listOfAllBooks.size()) {

                System.out.println(listOfAllBooks.get(Integer.parseInt(userInput) - 1));
                System.out.println("Returning to menu...");
                return;
            }
            }catch (Exception e){
                System.out.println("Number not valid, please try again.");
            }
            System.out.println("Choose a number between: " +
                    (listOfAllBooks.size() - listOfAllBooks.size() + 1) +
                    " and " + listOfAllBooks.size());
            userInput = scanner.nextLine();
        }
    }

        /*
        // TRYING TO GET INDEX APPEAR IN FRONT OF TITLE........
        public void showTitleWithIndex() {
            Scanner inputFromUser = new Scanner(System.in);
            for (int i = 1; i < listOfAllBooks.size(); i++) {
                System.out.println("\n" + i + ": " + listOfAllBooks.get(i-1).getTitle());
                if (i == parseInt(inputFromUser.next())) {
                    System.out.println((i) + " " + listOfAllBooks.get(i-1).getTitle());
                    //System.out.println("You chose: " + (i+1) + listOfAllBooks.get(i).getTitle() + ".");
                    //System.out.println("Adding book to your list.");
                    //activeUser.addBookToUser(listOfAllBooks.get(i));
                   // break;
                } else {
                    System.out.println("Nothing found, please try again");
                    showTitleWithIndex();
                    break;
                }
            }
        }
         */


    public void saveBooks() {
        FileUtils.saveObject("books.ser", listOfAllBooks, StandardOpenOption.CREATE);
    }

    public void loadBooks() {

        Path path = Paths.get("books.ser");

        if (Files.exists(path)) {
            listOfAllBooks = (ArrayList<Book>) FileUtils.loadObject("books.ser");
        } else {
            listOfAllBooks = new ArrayList<>();
            createNewBook();
            saveBooks();
        }
    }
}

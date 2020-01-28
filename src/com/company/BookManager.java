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

    public void createNewBookByAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the new book you would like to make:");
        String titleByAdmin = scanner.nextLine();
        System.out.println("Mhm, mhm. And who wrote it?");
        String authorByAdmin = scanner.nextLine();
        System.out.println("Ah, I see. And what is it about?");
        String shortDescriptionByAdmin = scanner.nextLine();
        System.out.println("Wow, this book sounds amazing!\n" +
                "The new book has been added to the library, if you want to double check" +
                ", just choose option [1] at the menu.");
        listOfAllBooks.add(new Book(titleByAdmin, authorByAdmin, shortDescriptionByAdmin, true));
        saveBooks();
        System.out.println("Returning to previous menu...");
    }

    public void removeBookByAdmin() {
        boolean checkIfTitleExist = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title of a book you wish to remove from the library.\n" +
                "Keep in mind that the book will be gone forever.");
        String inputByAdmin = scanner.nextLine();
        for (Book book : listOfAllBooks) {
            if (book.getTitle().equals(inputByAdmin)) {
                checkIfTitleExist = true;
                listOfAllBooks.remove(book);
                saveBooks();
                System.out.println("Successfully removed book: " + book.getTitle() + " from the system.\n" +
                        "Returning to previous menu...");
            }
        }
        if (!checkIfTitleExist) {
            System.out.println("The title you entered is not recognized.\n" +
                    "Returning to previous menu...");
        }
        saveBooks();
        System.out.println("Returning to previous menu...");
    }

    public void returnBookToLibrary(){
        boolean checkIfBookIsReturned = false;
        for (Book book : listOfAllBooks){
            if (book.getTitle().equals(UserManager.activeUser.getBorrowedBooks().toString())){
                checkIfBookIsReturned = true;
                book.setAvailable(true);
                System.out.println("Book has been returned. \n-LibrarySystem");
            }
        }
    }


    public void returnBookByIndex(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIf you wish to remove a book from your list, then enter the NUMBER of one of" +
                " the books (number next to title)." +
                "\nIf you wish NOT to remove a book from your list, just press [0] and <ENTER>.");
        String inputByUser = scanner.next();
        while (true) {

            while (!inputByUser.matches("[0-9]+")) {
                System.out.println("Please enter a digit.");
                System.out.println("Choose a number between: " +
                        (UserManager.activeUser.getBorrowedBooks().size() -
                                UserManager.activeUser.getBorrowedBooks().size() + 1) +
                        " and " + UserManager.activeUser.getBorrowedBooks().size());
                try{
                    inputByUser = scanner.next();
                }catch (Exception e){
                    System.out.println("Error... user wrote: " + inputByUser + "Returning...");
                }
            }
            try{
            while ((Integer.parseInt(inputByUser) - 1) >= 0 ||
                    (Integer.parseInt(inputByUser) - 1) <= UserManager.activeUser.getBorrowedBooks().size() &&
                    Integer.parseInt(inputByUser) <= UserManager.activeUser.getBorrowedBooks().size()) {

                UserManager.activeUser.getBorrowedBooks().remove(Integer.parseInt(inputByUser) - 1);
                UserManager.activeUser.getBorrowedBooks().get(Integer.parseInt(inputByUser) - 1).setAvailable(true);
                saveBooks();
                System.out.println("Successfully removed: " +
                        (UserManager.activeUser.getBorrowedBooks().get(Integer.parseInt(inputByUser)) +
                        " from your list of borrowed books.\nReturning to previous menu..."));
                return;
            }
            }catch (Exception e){
                System.out.println("Number not valid, please try again.");
            }
            System.out.println("Choose a number between: " +
                    (UserManager.activeUser.getBorrowedBooks().size() -
                            UserManager.activeUser.getBorrowedBooks().size() + 1) +
                    " and " + UserManager.activeUser.getBorrowedBooks().size());
            inputByUser = scanner.next();
        }
    }





    /*public void removeBookByCustomer(){
        boolean checkIfTitleExist = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIf you wish to remove a book from your list, then enter the TITLE of one of" +
                " the books.\nIf you wish NOT to remove a book from your list, just press [0] and <ENTER>.");
        String inputByCustomer = scanner.nextLine();

        for (Book book : UserManager.activeUser.getBorrowedBooks()) {
            if (inputByCustomer.equals("0")){
                System.out.println("Returning to previous menu...");
                break;
            }
            if (book.getTitle().equals(inputByCustomer)) {
                checkIfTitleExist = true;
                book.setAvailable(false);
                for (Book bookReturned : listOfAllBooks){
                    bookReturned.setAvailable(true);
                }
                saveBooks();
                System.out.println("Successfully removed book: " + book.getTitle() + " from your list.\n");
            }
        }
        if (!checkIfTitleExist){
            System.out.println("The title you entered is not recognized.\n");
        }
        saveBooks();
        System.out.println("Returning to previous menu...");
    } */


    public void showAvailableBooks(){
        System.out.println("All books available to loan:");
        int i = 1;
        for (Book book : listOfAllBooks){
            if (book.isAvailable()){
                System.out.println(i + ": " + book.getTitle());
                i++;
            }
        }
    }


    public void borrowBookByIndex(){
        Scanner scanner = new Scanner(System.in);
        String inputByUser = scanner.next();

        while (true) {

            if (inputByUser.equals("0")){
                System.out.println("Returning to previous menu...");
                break;
            }

            while (!inputByUser.matches("[0-9]+")) {
                System.out.println("Please enter a digit.");

                System.out.println("Choose a number between: " +
                        (listOfAllBooks.size() - listOfAllBooks.size() + 1) +
                        " and " + listOfAllBooks.size());
                try{
                    inputByUser = scanner.next();
                }catch (Exception e){
                    System.out.println("Error... user wrote: " + inputByUser);
                }
            }
            try{
            while ((Integer.parseInt(inputByUser) - 1) >= 0 ||
                    (Integer.parseInt(inputByUser) - 1) <= listOfAllBooks.size() &&
                    Integer.parseInt(inputByUser) <= listOfAllBooks.size()) {

                UserManager.activeUser.getBorrowedBooks().add(listOfAllBooks.get(Integer.parseInt(inputByUser) - 1));
                listOfAllBooks.get(Integer.parseInt(inputByUser) - 1).setAvailable(false);
                saveBooks();
                System.out.println("Successfully added: " + (listOfAllBooks.get(Integer.parseInt(inputByUser) - 1).getTitle()) +
                " to your list of borrowed books.\nReturning to previous menu...");
                return;
            }
            }catch (Exception e){
                System.out.println("Number not valid, please try again.");
            }
            System.out.println("Choose a number between: " +
                    (listOfAllBooks.size() - listOfAllBooks.size() + 1) +
                    " and " + listOfAllBooks.size());
            inputByUser = scanner.next();
        }
    }


    public void showUserBorrowedBooks(){
        if (UserManager.activeUser.getBorrowedBooks().size() <= 0){
            System.out.println("You currently loan no books.\nReturning to previous menu...");
        }
        for (int i = 0; i < UserManager.activeUser.getBorrowedBooks().size(); i++){
            if (UserManager.activeUser.getBorrowedBooks().size() > 0) {
                System.out.println("You currently loan following books:\n" + ((i + 1) + ": " +
                        UserManager.activeUser.getBorrowedBooks().get(i).getTitle()) + "\n");
            }
        }
    }

   /*
public void showUserBorrowedBooks(){
        if (UserManager.activeUser.getBorrowedBooks().size() <= 0){
            System.out.println("You currently loan no books.");
        }
        if (UserManager.activeUser.getBorrowedBooks().size() > 0)
        System.out.println("You currently loan following books:\n"
        + UserManager.activeUser.getBorrowedBooks().size());
        for (Book borrowedBook : UserManager.activeUser.getBorrowedBooks()){
            System.out.println(borrowedBook.getTitle());
        }
    }
 */


    // Show Title of book and the Description while SEARCHING either by Author or Title.
    public void searchTitleOrAuthor(String bookTitlebookAuthor) {
        System.out.println("You searched: " + bookTitlebookAuthor);
        boolean findMatch = false;
        if (bookTitlebookAuthor.equals("0")) {
            System.out.println("Returning to previous menu, please wait...");
            MainMenu.nextMenu();
        }
        for (Book book : listOfAllBooks) {
            if (book.getTitle().toLowerCase().contains(bookTitlebookAuthor.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(bookTitlebookAuthor.toLowerCase())) {
                findMatch = true;
                System.out.println("Book found: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
            }
        }
        if (!findMatch) { // if not true
            System.out.println("We're sorry, your search gave no results.");
            System.out.println("Returning to menu...");
        }
        System.out.println("Returning to menu...");
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

            if (userInput.equals("0")){
                System.out.println("Returning to previous menu...");
                break;
            }

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

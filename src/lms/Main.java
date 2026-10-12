package lms;

import lms.model.Book;
import lms.model.DVD;
import lms.model.Staff;
import lms.model.Student;
import lms.service.Library;

public class Main {
    public static void main(String[] args) {
        // 1. Create a Library
        Library library = new Library();

        // 2. Add at least two Books and one DVD
        library.addItem(new Book("B001", "Clean Code", "Robert C. Martin"));
        library.addItem(new Book("B002", "Effective Java", "Joshua Bloch"));
        library.addItem(new DVD("D001", "Introduction to Algorithms", 120));

        // 3. Add at least one Student and one Staff member
        library.addMember(new Student("M001", "Nadeesha Perera"));
        library.addMember(new Staff("M002", "Mr. Kasun Silva"));

        // 4. Call listItems(), listMembers(), and printAllLateFees(3)
        library.listItems();
        library.listMembers();
        library.printAllLateFees(3);

        // 5. Show validation working: try to create a Book with a blank title
        try {
            new Book("B003", "", "Unknown Author");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected invalid book: " + e.getMessage());
        }
    }
}
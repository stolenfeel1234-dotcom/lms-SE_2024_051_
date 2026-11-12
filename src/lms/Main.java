package lms;

import lms.model.Book;
import lms.model.DVD;
import lms.model.Magazine;
import lms.model.Student;
import lms.model.Staff;
import lms.service.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("B001", "Clean Code", "Robert C. Martin");
        DVD d1 = new DVD("D001", "Introduction to Algorithms", 120);
        Magazine m1 = new Magazine("M001", "Software Weekly", 42);

        library.addItem(b1);
        library.addItem(d1);
        library.addItem(m1);

        Student s1 = new Student("M001", "Nadeesha Perera");
        Staff staff1 = new Staff("M002", "Mr. Kasun Silva");

        library.addMember(s1);
        library.addMember(staff1);

        library.printAllLateFees(3);

        System.out.println("--- Loans ---");
        library.lend(b1, s1);
        library.lend(b1, staff1);
        library.lend(d1, staff1);
        library.lend(m1, staff1);

        System.out.println("--- Reservations ---");
        library.reserveIfPossible(b1, staff1);
        library.reserveIfPossible(d1, staff1);

        library.printMembersByActivity();
    }
}
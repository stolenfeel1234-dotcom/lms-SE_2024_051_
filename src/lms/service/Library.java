package lms.service;

import lms.model.LibraryItem;
import lms.model.Member;
import lms.model.Loanable;
import lms.model.Reservable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void listItems() {
        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    public void listMembers() {
        for (Member member : members) {
            System.out.println(member.getName());
        }
    }

    public void printAllLateFees(int daysLate) {
        System.out.println("--- Late fees if " + daysLate + " day(s) late ---");
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateLateFee(daysLate));
        }
    }

    public void lend(Loanable thing, Member member) {
        thing.loan(member);
    }

    public void reserveIfPossible(LibraryItem item, Member member) {
        if (item instanceof Reservable) {
            Reservable reservableItem = (Reservable) item;
            reservableItem.reserve(member);
        } else {
            System.out.println(item.getTitle() + " cannot be reserved.");
        }
    }

    public void printMembersByActivity() {
        System.out.println("--- Members ranked by activity ---");
        List<Member> sortedMembers = new ArrayList<>(members);
        Collections.sort(sortedMembers);
        for (Member m : sortedMembers) {
            System.out.println(m.getName() + " (" + m.getBorrowedCount() + " borrowed)");
        }
    }
}
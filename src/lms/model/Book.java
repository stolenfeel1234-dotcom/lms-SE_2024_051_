package lms.model;



public class Book extends LibraryItem implements Reservable {
    private String author;
    private Member reservedBy;

    public Book(String id, String title, String author) {
        super(id, title);
        setAuthor(author);
        this.reservedBy = null;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        this.author = author;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 10.0;
    }

    @Override
    public void reserve(Member m) {
        if (isReserved()) {
            System.out.println(getTitle() + " is already reserved.");
            return;
        }
        this.reservedBy = m;
        System.out.println(getTitle() + " reserved for " + m.getName());
    }

    @Override
    public void cancelReservation() {
        this.reservedBy = null;
    }

    @Override
    public boolean isReserved() {
        return this.reservedBy != null;
    }
}
package lms.model;

public class Member implements Comparable<Member> {
    private String memberId;
    private String name;
    private int borrowedCount;
    private int maxBorrowLimit;

    public Member(String memberId, String name, int maxBorrowLimit) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedCount = 0;
        this.maxBorrowLimit = maxBorrowLimit;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }

    public void incrementBorrowedCount() {
        this.borrowedCount++;
    }

    @Override
    public int compareTo(Member other) {
        return Integer.compare(other.borrowedCount, this.borrowedCount);
    }
}
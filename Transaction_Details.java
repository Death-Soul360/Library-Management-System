package Library_Management_App;

public class Transaction_Details {
    String bookId;
    String memberId;
    boolean status;
    String transactionId;

    public Transaction_Details(String bookId, String memberId, boolean status) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.status = status;
    }

    public String getBookId() {
        return bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String toString() {
        return "BookID: " + bookId + " | MemberID: " + memberId + " | Status: " + (status ? "Issued" : "Returned");
    }
}

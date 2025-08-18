package Library_Management_App;

import java.util.Map;
import java.util.TreeMap;

public class Library_Management_Process {
    Map<String, Book_Details> bookMap = new TreeMap<>();
    Map<String, MemberInfo> memberMap = new TreeMap<>();
    Map<String, Transaction_Details> transactionMap = new TreeMap<>();
    int transactionCounter = 1;

    // ---------------- Add Book ----------------
    void addBooks(Book_Details book) {
        bookMap.put(book.getId(), book);
        System.out.println("Book Added: " + book.getTitle());
    }

    // ---------------- View Books ----------------
    void viewBooks() {
        System.out.println("------ Book Inventory ------");
        if (bookMap.isEmpty()) {
            System.out.println("No books available!");
        } else {
            for (String key : bookMap.keySet()) {
                System.out.println(bookMap.get(key));
            }
        }
        System.out.println("--------------------------------");
    }

    // ---------------- Add Member ----------------
    void addMember(MemberInfo info) {
        memberMap.put(info.getMemberId(), info);
        System.out.println("Member Added: " + info.getMemberName());
    }

    // ---------------- View Members ----------------
    void viewMember() {
        System.out.println("------ Members List ------");
        if (memberMap.isEmpty()) {
            System.out.println("No member available!");
        } else {
            for (String key : memberMap.keySet()) {
                System.out.println(memberMap.get(key));
            }
        }
        System.out.println("--------------------------------");
    }

    // ---------------- Issue Book ----------------
    void issueBook(Transaction_Details trans) {
        if (!bookMap.containsKey(trans.getBookId())) {
            System.out.println("Book not available!");
            return;
        }
        if (!memberMap.containsKey(trans.getMemberId())) {
            System.out.println("Member not available!");
            return;
        }

        Book_Details book = bookMap.get(trans.getBookId());
        if (book != null && book.getQty() > 0) {
            book.setQty(book.getQty() - 1);

            String transactionId = "T" + String.format("%03d", transactionCounter++);
            trans.setTransactionId(transactionId);
            trans.setStatus(true); // issued
            transactionMap.put(transactionId, trans);

            System.out.println("Book issued successfully!");
            System.out.println("Transaction ID: " + transactionId);
            System.out.println("Issued Book: " + book.getTitle() + " to Member: "
                    + memberMap.get(trans.getMemberId()).getMemberName());
        } else {
            System.out.println("Book not available!");
        }
    }

    // ---------------- Return Book ----------------
    void returnBook(String transId) {
        if (transactionMap.isEmpty() || !transactionMap.containsKey(transId)) {
            System.out.println("Transaction does not exist!");
        } else {
            Transaction_Details trans = transactionMap.get(transId);

            if (trans.isStatus()) {
                trans.setStatus(false);

                Book_Details book = bookMap.get(trans.getBookId());
                if (book != null) {
                    book.setQty(book.getQty() + 1);
                }

                System.out.println("Book returned successfully!");
            } else {
                System.out.println("This book was already returned!");
            }
        }
    }

    // ---------------- View All Transactions ----------------
    void allTrans() {
        System.out.println("------ Transactions ------");
        if (transactionMap.isEmpty()) {
            System.out.println("Transactions not available!");
        } else {
            for (String key : transactionMap.keySet()) {
                System.out.println(transactionMap.get(key));
            }
        }
        System.out.println("--------------------------------");
    }
}
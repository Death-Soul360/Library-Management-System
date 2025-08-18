package Library_Management_App;

import java.util.Scanner;

public class Library_Management_System {
    public static void main(String[] args) {
        Library_Management_Process lmp = new Library_Management_Process();
        Scanner scr = new Scanner(System.in);

        System.out.println("========================================\n" +
                "     Welcome to Library Management\n" +
                "========================================");
        System.out.println("1. Add Book\n" +
                "2. View Books\n" +
                "3. Add Member\n" +
                "4. View Members\n" +
                "5. Issue Book\n" +
                "6. Return Book\n" +
                "7. View Transactions\n" +
                "8. Exit");

        while (true) {
            System.out.print("\nEnter your choice: ");
            int ch = scr.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = scr.next();
                    System.out.print("Enter Book Title:");
                    scr.nextLine();
                    String title = scr.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scr.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scr.nextInt();
                    lmp.addBooks(new Book_Details(id, title, author, qty));
                    break;
                case 2:
                    lmp.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter Member Id: ");
                    String memberId = scr.next();
                    System.out.print("Enter Member Name: ");
                    scr.nextLine();
                    String memberName = scr.nextLine();
                    System.out.print("Enter Contact number: ");
                    Long number = scr.nextLong();
                    lmp.addMember(new MemberInfo(memberId, memberName, number));
                    break;
                case 4:
                    lmp.viewMember();
                    break;
                case 5:
                    System.out.print("Enter Book Id to Issue: ");
                    String issueBookId = scr.next();
                    System.out.print("Enter Member Id: ");
                    scr.nextLine();
                    String issueMemberId = scr.nextLine();
                    lmp.issueBook(new Transaction_Details(issueBookId, issueMemberId, true));
                    break;
                case 6:
                    System.out.print("Enter Transaction ID to Return Book: ");
                    String transId = scr.next();
                    lmp.returnBook(transId);
                    break;
                case 7:
                    lmp.allTrans();
                    break;
                case 8:
                    System.out.println("Thank you for using Library Management System!");
                    System.exit(0);
                default:
                    throw new IllegalStateException("Unexpected value: " + ch);
            }
        }
    }
}

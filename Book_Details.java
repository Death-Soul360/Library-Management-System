package Library_Management_App;

class Book_Details{
    String id;
    String title;
    String author;
    int qty;

    public Book_Details(String id, String title, String author, int qty) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Author: " + author + " | Quantity: " + qty;
    }
}
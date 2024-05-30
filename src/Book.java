public class Book {
    private String bookCode, bookName, bookAuthor, bookPublishDate, bookGenre;

    public Book() {
    }

    public Book(String bookCode, String bookName, String bookAuthor, String bookPublishDate, String bookGenre) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublishDate = bookPublishDate;
        this.bookGenre = bookGenre;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublishDate() {
        return bookPublishDate;
    }

    public void setBookPublishDate(String bookPublishDate) {
        this.bookPublishDate = bookPublishDate;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
}
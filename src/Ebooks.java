public class Ebooks extends Book {

    private String fileType, fileSize;

    Ebooks(String bookCode, String bookName, String bookAuthor, String bookPublishDate, String bookGenre,
           String fileSize, String fileType) {
        super(bookCode, bookName, bookAuthor, bookPublishDate, bookGenre);
        this.fileSize = fileSize;
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "eBooks{ " +
                "Book Code = " + getBookCode() +
                ", Book Name = " + getBookName() +
                ", Book Author = '" + getBookAuthor() + '\'' +
                ", Book Publish Date = " + getBookPublishDate() +
                ", Book Genre = '" + getBookGenre() + '\'' +
                ", File Size = " + fileSize +
                ", File Type = '" + fileType + '\'' +
                '}';
    }
}
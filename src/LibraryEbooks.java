import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LibraryEbooks {
    final int max_limit = 10000;

    private final Ebooks[] eBooks = new Ebooks[max_limit];

    private int count = 0;

    public boolean addBook(Ebooks eBooks) {
        if (this.count >= max_limit)
            return false;
        for (int i = 0; i < count; i++) {
            if (this.eBooks[i].getBookCode().equalsIgnoreCase(eBooks.getBookCode())) {
                return false;
            }
        }
        this.eBooks[count++] = eBooks;
        return true;
    }

    public void menuEbooks() {
        System.out.println("\nMenu:");
        System.out.println("1. See library list.");
        System.out.println("2. Add book.");
        System.out.println("3. Update book.");
        System.out.println("4. Remote book.");
        System.out.println("5. Sort by book title.");
        System.out.println("6. Sort by author.");
        System.out.println("7. Sort by year of publication.");
        System.out.println("8. Find books by code.");
        System.out.println("9. Find books by title.");
        System.out.println("0. Exit.");
        System.out.println("Enter your selection : ");
        System.out.println("--------------------");
    }

    public void getListEbooks() {
        for (int i = 0; i < count; i++) {
            System.out.println(eBooks[i]);
        }
    }

    public void addNewEbooks() {

        Scanner input = new Scanner(System.in);

        System.out.println("book code:");
        String bookCode = input.nextLine();
        System.out.println("book name : ");
        String bookName = input.nextLine();
        System.out.println("Author : ");
        String bookAuthor = input.nextLine();
        System.out.println("publish date:");
        String bookPublishDate = input.nextLine();
        System.out.println("book genre:");
        String bookGenre = input.nextLine();
        System.out.println("File Size :");
        String fileSize = input.nextLine();
        System.out.println("File type:");
        String fileType = input.nextLine();
        System.out.println("----------------------");

        boolean hoa_le = this.addBook(new Ebooks(bookCode, bookName, bookAuthor, bookPublishDate, bookGenre, fileSize, fileType));
        if (hoa_le) {
            System.out.println("Book added successfully!");
        } else {
            System.out.println("The book code already exists and cannot be added!");
        }
    }

    public void updateEbooks() {
        Scanner input = new Scanner(System.in);

        System.out.println("book code:");
        String bookCode = input.nextLine();
        System.out.println("book name :");
        String bookName = input.nextLine();
        System.out.println("Author : ");
        String bookAuthor = input.nextLine();
        System.out.println("publish date:");
        String bookPublishDate = input.nextLine();
        System.out.println("book genre:");
        String bookGenre = input.nextLine();
        System.out.println("File size :");
        String fileSize = input.nextLine();
        System.out.println("File type:");
        String fileType = input.nextLine();
        System.out.println("----------------------");

        boolean Update = this.moduleUpdateEbooks(bookCode, bookName, bookAuthor, bookPublishDate, bookGenre, fileSize, fileType);

        if (Update) {
            System.out.println("Update successful!");
        } else {
            System.out.println("Book code not found!");
        }
    }

    public boolean moduleUpdateEbooks(String bookCode, String bookName, String bookAuthor, String bookPublishDate,
                                      String bookGenre, String fileSize, String fileType) {
        for (int i = 0; i < this.count; i++) {
            if (eBooks[i] != null && eBooks[i].getBookCode().equalsIgnoreCase(bookCode)) {
                eBooks[i].setBookCode(bookCode);
                eBooks[i].setBookName(bookName);
                eBooks[i].setBookAuthor(bookAuthor);
                eBooks[i].setBookPublishDate(bookPublishDate);
                eBooks[i].setBookGenre(bookGenre);
                eBooks[i].setFileSize(fileSize);
                eBooks[i].setFileType(fileType);
                return true;
            }
        }
        return false;
    }

    public void delEbooks() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the book code : ");
        String Code = input.nextLine();
        boolean delEbook = this.moduleDelEbook(Code);
        if (delEbook) {
            System.out.println("Removed from library!");
        } else {
            System.out.println("There are no books in the library!");
        }
    }

    public boolean moduleDelEbook(String book) {
        if (this.count <= 0) {
            return false;
        } else {
            for (int i = 0; i < eBooks.length; i++) {
                if (eBooks[i] != null && eBooks[i].getBookCode().equalsIgnoreCase(book)) {
                    for (int j = i; j < this.count - 1; j++) {
                        eBooks[j] = eBooks[j + 1];
                    }
                    this.count--;
                    return true;
                }
            }
            return false;
        }
    }


    public void sortEbookByName(boolean ascending) {


        Comparator<Book> comparator = Comparator.comparing(Book::getBookName);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        Arrays.sort(eBooks, 0, count, comparator);

    }

    public void sortEbookByAuthor(boolean ascending) {
        Comparator<Book> comparator = Comparator.comparing(Book::getBookAuthor);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        Arrays.sort(eBooks, 0, count, comparator);
    }

    public void sortEbookByPublishDate(boolean ascending) {
        Comparator<Book> comparator = Comparator.comparing(Book::getBookPublishDate);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        Arrays.sort(eBooks, 0, count, comparator);
    }

    public void SearchByBookCode() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the book code:");
        String maSach2 = input.nextLine();
        if (this.moduleSearchEbookByBookCode(maSach2) == null) {
            System.out.println("Book code does not exist!");
        } else {
            System.out.println(this.moduleSearchEbookByBookCode(maSach2));
        }
    }

    public Ebooks moduleSearchEbookByBookCode(String keyword) {
        for (int i = 0; i < this.count; i++) {
            if (this.eBooks[i].getBookCode().equalsIgnoreCase(keyword)) {
                return eBooks[i];
            }
        }
        return null;
    }

    public void searchEbookByBookName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please fill in the book title : ");
        String tieuDeSach2 = input.nextLine();

        if (this.moduleSearchEBooksByBookName(tieuDeSach2) == null) {
            System.out.println("Title does not exist!");
        } else {
            System.out.println(this.moduleSearchEBooksByBookName(tieuDeSach2));
        }
    }

    public Ebooks moduleSearchEBooksByBookName(String keyword) {
        for (int i = 0; i < this.count; i++) {
            if (this.eBooks[i].getBookName().equalsIgnoreCase(keyword)) {
                return eBooks[i];
            }
        }
        return null;
    }


}
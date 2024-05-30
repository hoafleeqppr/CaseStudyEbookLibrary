import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LibraryEbooks libraryAdmin = new LibraryEbooks();
        libraryAdmin.addBook(new Ebooks("1a", "English", "NXB GD",
                "10/04/1997", "Education", "100.0", ".pdf"));
        libraryAdmin.addBook(new Ebooks("2b", "Math", "NXB GD", "23/03/2001", "Education", "200", "docx"));

        Scanner input = new Scanner(System.in);

        while (true) {
            libraryAdmin.menuEbooks();
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    libraryAdmin.getListEbooks();
                    break;
                case 2:
                    libraryAdmin.addNewEbooks();
                    break;
                case 3:
                    libraryAdmin.updateEbooks();
                    break;
                case 4:
                    libraryAdmin.delEbooks();
                    break;
                case 5:
                    libraryAdmin.sortEbookByName(false);
                    libraryAdmin.getListEbooks();
                    break;
                case 6:
                    libraryAdmin.sortEbookByAuthor(false);
                    libraryAdmin.getListEbooks();
                    break;
                case 7:
                    libraryAdmin.sortEbookByPublishDate(true);
                    libraryAdmin.getListEbooks();
                    break;
                case 8:
                    libraryAdmin.SearchByBookCode();
                    break;
                case 9:
                    libraryAdmin.searchEbookByBookName();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}
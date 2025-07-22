 public class Library {

        public static void main(String[] args) {
            Book book1 = new Book("The Alchemist", "Paulo Coelho", 200);
            Book book2 = new Book("1984", "George Orwell", 300);
            Textbook textbook = new Textbook("Physics", "Halliday", 800, "Science", 10);

            book1.borrowBook();
            book1.returnBook();

            book1.displayInfo();
            book2.displayInfo();
            textbook.displayInfo();
        }
    }



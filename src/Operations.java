import java.util.Arrays;
import java.util.List;

public class Operations extends Thread {

	Library lib;
	void create_library(int num) {
		lib = new Library(num);
		
	}
	
	private void add_book(int id, String title, List<String> authors, List<String> publishers,
			List<String> bookcopy) {
		// TODO Auto-generated method stub
		lib.addBook(id,title,authors,publishers,bookcopy);
	}
	
	private void remove_book_copy(String bookCopyID) {
		// TODO Auto-generated method stub
		lib.removeBookCopy(bookCopyID);
	}
	
	private void search(String type, String value) {
		// TODO Auto-generated method stub
		switch(type) {
		case "book_id":
			lib.searchById(Integer.parseInt(value));
			break;
		case "author_id":
			lib.searchByAuthor(value);
			break;
		}
	}
	public void run()
    {
		add_book(1,"book1",Arrays.asList("author1","author2"), Arrays.asList("publisher1","publisher2","publisher3"),
				Arrays.asList("book_copy3"));
        System.out.println("Run method executed by child Thread");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Operations op = new Operations();
		op.create_library(10);
		op.add_book(1,"book1",Arrays.asList("author1","author2"), Arrays.asList("publisher1","publisher2","publisher3"),
				Arrays.asList("book_copy1","book_copy2","book_copy3"));
		System.out.println("book2");
		op.add_book(2,"book2",Arrays.asList("author2","author3"), Arrays.asList("publisher2","publisher3","publisher4"),
				Arrays.asList("book_copy4","book_copy5","book_copy6","book_copy7","book_copy8","book_copy9","book_copy10"));
		System.out.println("");
		op.add_book(3,"book3",Arrays.asList("author2"), Arrays.asList("publisher2"),
				Arrays.asList("book_copy11","book_copy12","book_copy13"));
		
		System.out.println();
		op.search("book_id", "1");
		op.search("book_id","3");
		op.search("author_id", "author2");
		System.out.println("varnita");
		Operations t1 = new Operations();
		Operations t2 = new Operations();
		t1.run();
		op.remove_book_copy("book_copy3");
		op.remove_book_copy("book_copy13");
		System.out.println();
		op.add_book(3, "book3", Arrays.asList("author2"), Arrays.asList("publisher2"), Arrays.asList("book_copy13"));
		System.out.println();
		op.search("book_id", "2");
		System.out.println();
		op.addUser("user1");
		op.print_borrowed("user1");
		System.out.println();
		op.borrow_book_copy(1, "user1", "2020-12-31");
		op.borrow_book_copy(1, "user1", "2020-12-31");
		op.borrow_book_copy(1, "user1", "2020-12-31");
		op.borrow_book_copy(1, "user1", "2020-12-31");
		op.print_borrowed("user1");

		
		op.return_book_copy(1,"user1");
		op.print_borrowed("user1");
		op.return_book_copy(1,"user1");
		op.borrow_book_copy(2, "user1", "2020-12-32");
		op.borrow_book_copy(2, "user1", "2020-12-32");
		op.borrow_book_copy(2, "user1", "2020-12-32");
		op.print_borrowed("user1");
		op.return_book_copy(2,"user1");
		op.print_borrowed("user1");
	}

	private void addUser(String string) {
		// TODO Auto-generated method stub
		lib.add_borrowedUser(string);
	}

	private void return_book_copy(int bookID,String user) {
		// TODO Auto-generated method stub
		lib.return_book_copy(bookID,user);
	}

	private void borrow_book_copy(int bookID, String userid, String dueDate) {
		// TODO Auto-generated method stub
		lib.borrow_book_copy(bookID, userid, dueDate);
	}

	private void print_borrowed(String string) {
		// TODO Auto-generated method stub
		lib.print_borrowed(string);
	}

	
	

	

}

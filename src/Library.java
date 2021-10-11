import java.util.*;
import java.util.Map.Entry;
public class Library {

	int totalRacks;
	HashMap<Integer, Rack> racksInfo;
	HashMap<String,User> usersList;
	HashMap<String, Integer> borrowedDetails;
	Rack rack;
	Library(int num){
		this.totalRacks = num;
		this.racksInfo = new HashMap<>();
		this.usersList = new HashMap<>();
		this.borrowedDetails = new HashMap();
		rack = new Rack(num);
		System.out.println("Created library with "+num+" racks");
	}
	
	void addBook(int bookid, String title, List<String> authors, List<String> publishers,
			List<String> bookcopy) {
		if(!rack.sortedAvailableRackNo.isEmpty()) {
			System.out.print("Added Book to racks:");
			for(String s:bookcopy) {
				int racknum = rack.findRackToAddBook(bookid,title,authors,publishers,s);
			}
		}else {
			System.out.println("Rack not available");
			return;
		}
	}

	public void searchById(int bookID) {
		// TODO Auto-generated method stub
		this.rack.searchBookByID(bookID);
	}

	public void searchByAuthor(String authorID) {
		// TODO Auto-generated method stub
		this.rack.searchBookByAuthorID(authorID);
	}

	public void removeBookCopy(String bookCopyID) {
		// TODO Auto-generated method stub
		this.rack.removeBookCopy(bookCopyID);
	}

	public void add_borrowedUser(String userID) {
		// TODO Auto-generated method stub
		this.usersList.put(userID,	new User(userID));
	}

	public void print_borrowed(String userId) {
		// TODO Auto-generated method stub
		if(this.usersList.containsKey(userId)) {
			User u = this.usersList.get(userId);
			for(int i=0;i<u.borrowedbooks.size();i++) {
				System.out.println("Book Copy: "+u.borrowedbooks.get(i).bookCopyID+" "+u.borrowedbooks.get(i).dueDate);
			}
		}
	}

	public void borrow_book_copy(int bookID, String userid, String dueDate) {
		// TODO Auto-generated method stub
		if(this.usersList.get(userid).borrowedbooks.size()< Constants.maxBooksBorrowedByUser) {
			if(this.rack.borrow_book_copy(bookID, userid,dueDate)) {
//				this.usersList.get(userid).borrowedbooks.add(new BorrowBook(bookID, dueDate));
				User u = this.usersList.get(userid);
				u.borrowedbooks.add(new BorrowBook(bookID, dueDate));
				this.usersList.put(userid, u);
			}
		}
		
		else {
			System.out.println("Cant");
		}
	}

	public void return_book_copy(int bookID,String userID) {
		// TODO Auto-generated method stub
		boolean entered=false;
		User u = this.usersList.get(userID);
		BorrowBook bbook=null;
		for(BorrowBook b: u.borrowedbooks) {
			if(b.bookCopyID == bookID) {
				entered=true;
				bbook = b;
				rack.returnBookCopy(bookID);
				break;
			}
		}
		if(bbook != null) {
			u.borrowedbooks.remove(bbook);
		}
		if(!entered) {
			System.out.println("Invalid Book Copy ID");
		}
	}

	
}

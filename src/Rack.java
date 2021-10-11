import java.util.*;
import java.util.Map.Entry;
public class Rack {
	int racksNo;
	HashMap<Integer, Book> racks;
	List<Integer> sortedAvailableRackNo = new ArrayList<>();
	
	Rack(int racksNo){
		this.racksNo =racksNo;
		this.racks = new HashMap<>();
		for(int i=1;i<=racksNo;i++) {
			this.sortedAvailableRackNo.add(i);
		}
	}
	
	int findRackToAddBook(int bookid, String title, List<String> authors, List<String> publishers, String copyId) {
		if(!this.sortedAvailableRackNo.isEmpty()) {
			Collections.sort(this.sortedAvailableRackNo);
			Book book = new Book(bookid, title, authors, publishers, copyId);
			int rackNum= this.sortedAvailableRackNo.get(0);
			this.sortedAvailableRackNo.remove(0);
			this.racks.put(rackNum, book);
			System.out.print(" "+rackNum);
			return rackNum;
		}else {
			System.out.println();
			System.out.println("Rack not available");
			return 0;
		}
	}

	public void searchBookByID(int bookID) {
		// TODO Auto-generated method stub
		boolean found=false;
		Iterator<Book> books = this.racks.values().iterator();
		while(books.hasNext()) {
			Book book = books.next();
			if(book.id == bookID) {
				found=true;
				System.out.println("Book Copy: "+book.copyID+" "+book.id+" "+book.authors
						+" "+book.publishers);
				
			}
		}
		if(!found)
			System.out.println("Invalid Book Copy ID");
	}

	public void searchBookByAuthorID(String authorID) {
		// TODO Auto-generated method stub
		boolean found=false;
		Iterator<Book> books = this.racks.values().iterator();
		while(books.hasNext()) {
			Book book = books.next();
			Iterator<String> authors = book.authors.iterator();
			while(authors.hasNext()) {
				String author = authors.next();
				if(author == authorID) {
					found=true;
					System.out.println("Book Copy: "+book.copyID+" "+book.id+" "+book.authors
							+" "+book.publishers);
					
				}
			}
		}
		if(!found)
			System.out.println("Invalid Author ID");
	}

	public void removeBookCopy(String bookCopyID) {
		// TODO Auto-generated method stub
		for(Entry<Integer, Book> e: this.racks.entrySet()) {
			if(e.getValue().copyID == bookCopyID) {
				System.out.println("Removed book copy: "+bookCopyID+" from rack: "+e.getKey());
				this.sortedAvailableRackNo.add(e.getKey());
				this.racks.remove(e);
				return;
			}
		}
		System.out.println("Invalid Book Copy ID");
	}

	public boolean borrow_book_copy(int bookID, String userid, String dueDate) {
		// TODO Auto-generated method stub
		for(Entry<Integer, Book> e: this.racks.entrySet()) {
			if(e.getValue().id == bookID && !e.getValue().isEmpty) {
				e.getValue().isEmpty = true;
				System.out.println("Borrowed Book Copy from rack: "+e.getKey());
				return true;
			}
		}
		System.out.println("Overlimit");
		return false;
	}

	public void returnBookCopy(int bookID) {
		// TODO Auto-generated method stub
		for(Entry<Integer, Book> e: this.racks.entrySet()) {
			if(e.getValue().id == bookID && e.getValue().isEmpty) {
				e.getValue().isEmpty = false;
				System.out.println("Returned book copy "+bookID+" and added to rack: "+e.getKey());
				return;
			}
		}
	}
}

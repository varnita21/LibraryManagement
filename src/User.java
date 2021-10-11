import java.util.*;
public class User {

	String userId;
	List<BorrowBook> borrowedbooks;
	
	User(String id){
		this.userId = id;
		this.borrowedbooks = new ArrayList<>();
	}
}

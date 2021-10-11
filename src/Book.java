import java.util.*;
public class Book {
	int id;
	String title;
	List<String> authors;
	List<String> publishers;
	String copyID;
	boolean isEmpty;
	Book(int id,String t,List<String> authors,List<String> publishers, String copyID){
		this.id = id;
		this.title =t;
		this.authors = authors;
		this.publishers = publishers;
		this.copyID = copyID;
		isEmpty=false;
	}
}

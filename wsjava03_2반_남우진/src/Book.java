
public class Book {
	String isbn = "";
	String title = "";
	String author = "";
	String publisher = "";
	int price = 0;
	String desc = "";
	
	public Book(String isbn,String title, String author,String publisher,int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author =author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		
	}
	public String toString() {
		int size =10;
		int isbnNum = size + (isbn.getBytes().length - isbn.length()>0 ? isbn.getBytes().length - isbn.length()+2 : 0); 
		int titleNum = size + (title.getBytes().length - title.length()>0 ? title.getBytes().length - title.length()+2 : 0); 
		int authorNum = size + (author.getBytes().length - author.length()>0 ? author.getBytes().length - author.length()+2 : 0); 
		int publisherNum = size + (publisher.getBytes().length - publisher.length()>0 ? publisher.getBytes().length - publisher.length()+2 : 0) ; 
		int descNum = size + (desc.getBytes().length - desc.length()>0 ? desc.getBytes().length - desc.length()+2 : 0); 
	
		
		String returnString = String.format("%-"+isbnNum+"s |", isbn)+
				String.format("%-"+titleNum+"s |", title)+
				String.format("%-"+authorNum+"s |", author)+
				String.format("%-"+publisherNum+"s |", publisher)+
				String.format("%-"+size+"s |", price)+
				String.format("%-"+descNum+"s ", desc);
		return returnString;
	}
	
	

}

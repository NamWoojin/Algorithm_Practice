
public class BookTest {

	public static void main(String[] args) {
		Book book1 = new Book("21414","Java Pro","김하나","Jaen.kr",15000,"Java 기본문법");
		Book book2 = new Book("35355","분석설계","소나무","Jaen.kr",30000,"SW 모델링");
		Magazine magazine1 = new Magazine("35535","Java World","편집부","java.com",2018,2,7000,"첫걸음");
	
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		System.out.println(magazine1.toString());
	}

}

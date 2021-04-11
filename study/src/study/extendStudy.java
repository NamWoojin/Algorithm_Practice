package study;

public class extendStudy {
	        
	public static void main(String[] args) {
		//부모만 자식을 담을 수 있다
		Human em = new Students1();
		//Override를 해제하든 넣든 자식의 것이 출력되는 같은 결과
        em.getInfo();
        //Human을 상속받는 다른 클래스로 대체할 수 있음
        em = new Employee();
        em.getInfo();
        
        Human stu = new Human();
        stu.getInfo();
	}
}


class Human {
	String name;
	int age;

	public void getInfo() {
		System.out.println("이름:" + name + "\n 나이" + age);
	}
}

class Employee extends Human {
	
}

class Students1 extends Human {
	public void getInfo() {
		System.out.println("이름!!:" + name + "\n 나이" + age);
	}
}
package com.ssafy;

public class ProductTest {

	public static void main(String[] args) {
		TV SamsungTV = new TV(11111,"SamsungTV",1000000,10,60,"QLED");
		TV LGTV = new TV(22222,"LGTV",900000,20,58,"QLED");
		Refrigerator Samsungfridge = new Refrigerator(33333,"Samsungfridge",3000000,30,900);
		Refrigerator DIOSfridge = new Refrigerator(44444,"DIOSfridge",2500000,25,800);
		
		System.out.println(SamsungTV.toString());
		System.out.println(LGTV.toString());
		System.out.println(Samsungfridge.toString());
		System.out.println(DIOSfridge.toString()+"\n\n");
		
		SamsungTV.setCount(SamsungTV.getCount()-5);	//삼성TV 5대 판매
		LGTV.setPrice((int)(LGTV.getPrice()*0.9));  //LGTV 10퍼센트 세일
		Samsungfridge.setName("SamsungPremiumfridge");	//삼성 냉장고 프리미엄
		Samsungfridge.setPrice((int)(Samsungfridge.getPrice()*1.2));	//삼성 냉장고 가격 상승
		DIOSfridge.setCount(DIOSfridge.getCount()-3);	//디오스 냉장고 3대 판매
		
		System.out.println(SamsungTV.toString());
		System.out.println(LGTV.toString());
		System.out.println(Samsungfridge.toString());
		System.out.println(DIOSfridge.toString()+"\n\n");
		
		
	}

}

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
		
		SamsungTV.setCount(SamsungTV.getCount()-5);	//�ＺTV 5�� �Ǹ�
		LGTV.setPrice((int)(LGTV.getPrice()*0.9));  //LGTV 10�ۼ�Ʈ ����
		Samsungfridge.setName("SamsungPremiumfridge");	//�Ｚ ����� �����̾�
		Samsungfridge.setPrice((int)(Samsungfridge.getPrice()*1.2));	//�Ｚ ����� ���� ���
		DIOSfridge.setCount(DIOSfridge.getCount()-3);	//����� ����� 3�� �Ǹ�
		
		System.out.println(SamsungTV.toString());
		System.out.println(LGTV.toString());
		System.out.println(Samsungfridge.toString());
		System.out.println(DIOSfridge.toString()+"\n\n");
		
		
	}

}

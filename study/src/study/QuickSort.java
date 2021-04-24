package study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuickSort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(2);
		list.add(7);
		list.add(3);
		list.add(1);
		list.add(8);
		list.add(9);
		list.add(4);
		
		list = QuickSort(list);
		System.out.println(list.toString());
	}
	
	private static List<Integer> QuickSort(List<Integer> list) {
		if(list.size() <= 1) {
			return list;
		}
		int pivot = list.get(list.size()/2);
		
		List<Integer> lessList = new ArrayList<>();
		List<Integer> equalList = new ArrayList<>();
		List<Integer> moreList = new ArrayList<>();
		
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			int num = iter.next();
			if(num < pivot) {
				lessList.add(num);
			}else if(num == pivot) {
				equalList.add(num);
			}else {
				moreList.add(num);
			}
		}
		
		lessList = QuickSort(lessList);
		moreList = QuickSort(moreList);
		
		lessList.addAll(equalList);
		lessList.addAll(moreList);
		
		return lessList;
	}
}

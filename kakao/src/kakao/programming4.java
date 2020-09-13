package kakao;

import java.util.ArrayList;

public class programming4 {
	static class list {
		int endNum, value;
		boolean aUse, bUse;

		list(int endNum, int value) {
			this.endNum = endNum;
			this.value = value;
		}
	}

	static ArrayList<list>[] lists;
	static int aa, bb, ss;
	static long min = Long.MAX_VALUE;
	public long solution(int n, int s, int a, int b, int[][] fares) {
	    lists = new ArrayList[n];
	    for(int i =0; i<n;++i)
			lists[i] = new ArrayList<>();
		aa = a-1;
		bb = b-1;
		ss = s-1;
	    
		for (int i = 0; i < fares.length; ++i) {
			int start = fares[i][0] - 1;
			int end = fares[i][1] - 1;
			int value = fares[i][2];

			lists[start].add(new list(end, value));
			lists[end].add(new list(start, value));
		}
		dfsA(ss,0);
	    long answer = min;
	    return answer;
	}
	private static void dfsA(int start, long cost) {
		if (start == aa) {
			dfsB(ss,cost);
	        return;
		}
	    
	    if(cost > min)
	        return;

		for (int i = 0; i < lists[start].size(); ++i) {
			list l = lists[start].get(i);
			if (l.aUse)
				continue;

			lists[start].get(i).aUse = true;
			int endIdx = findReverse(start,l.endNum);
			lists[l.endNum].get(endIdx).aUse= true;
			dfsA(l.endNum, cost + l.value);
			lists[start].get(i).aUse = false;
			lists[l.endNum].get(endIdx).aUse= false;
		}
	}

	private static void dfsB(int start, long cost) {
		if (start == bb) {
			min = Math.min(cost, min);
			return;
		}

	    if(cost > min)
	        return;
	    
		for (int i = 0; i < lists[start].size(); ++i) {
			list l =lists[start].get(i);
			if (l.bUse)
	            continue;
				

			lists[start].get(i).bUse = true;
			int endIdx = findReverse(start,l.endNum);
			lists[l.endNum].get(endIdx).bUse= true;
			if(lists[start].get(i).aUse) {
				dfsB(l.endNum, cost );
			}else {
	            System.out.println(l.value);
				dfsB(l.endNum, cost + l.value);
			}
			lists[start].get(i).bUse = false;
			lists[l.endNum].get(endIdx).bUse= false;
		}

	}

	private static int findReverse(int start, int end) {
		for(int i = 0; i<lists[end].size();++i) {
			if(lists[end].get(i).endNum == start)
				return i;
		}
		return -1;
	}

}


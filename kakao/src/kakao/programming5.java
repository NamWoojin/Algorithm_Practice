package kakao;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class programming5 {
	static class times implements Comparable<times>{
		int num, time;
		boolean start;
		times(int num, boolean start, int time){
			this.num = num;
			this.start = start;
			this.time = time;
		}
		@Override
		public int compareTo(times o) {
			// TODO Auto-generated method stub
			return this.time - o.time;
		}
	}
	static class count{
		int num;
		int time;
		count(int num, int time){
			this.num = num;
			this.time = time;
		}
	}
	
	public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        String[] splitPlayTime = play_time.split(":");
        int playTime = Integer.parseInt(splitPlayTime[0]) * 3600 + Integer.parseInt(splitPlayTime[1]) *60 + Integer.parseInt(splitPlayTime[2]);
        String[] splitAdvTime = adv_time.split(":");
        int advTime = Integer.parseInt(splitAdvTime[0]) * 3600 + Integer.parseInt(splitAdvTime[1]) *60 + Integer.parseInt(splitAdvTime[2]);
        
        PriorityQueue<times> pQueue = new PriorityQueue<>();
        for(int i = 0; i<logs.length;++i) {
        	String[] term = logs[i].split("-");
        	String[] startTime = term[0].split(":");
        	String[] endTime = term[1].split(":");
        	int start = Integer.parseInt(startTime[0]) * 3600 + Integer.parseInt(startTime[1]) *60 + Integer.parseInt(startTime[2]);
        	int end = Integer.parseInt(endTime[0]) * 3600 + Integer.parseInt(endTime[1]) *60 + Integer.parseInt(endTime[2]);
        	
        	pQueue.offer(new times(i,true,start));
        	pQueue.offer(new times(i,false,end));
        }
        
        ArrayList<count> array = new ArrayList<>();
        array.add(new count(0,0));
        int count = 0;
        int maxIdx = 0;
        int maxNum = 0;
        while(!pQueue.isEmpty()) {
        	times t = pQueue.poll();
        	if(t.start)
        		++count;
        	else
        		--count;
        	array.add(new count(count,t.time));
        	if(maxNum < count) {
        		maxIdx = array.size()-1;
        		maxNum = count;
        	}
        }
        array.add(new count(0,playTime));
        
        
        
        return answer;
    }
}

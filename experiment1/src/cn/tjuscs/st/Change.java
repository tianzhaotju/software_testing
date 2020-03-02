package cn.tjuscs.st;

public class Change {
	
	private int[] money = {50, 20, 10, 5, 5, 1, 1, 1};
	
	public boolean makeChange(int sum){
		
		for(int i=0; i<money.length; i++) {
			if(sum >= money[i]) {
				sum -= money[i];
			}
			if(sum == 0) {
				break;
			}
		}
		
		if(sum == 0)
			return true;
		else
			return false;
	}
}

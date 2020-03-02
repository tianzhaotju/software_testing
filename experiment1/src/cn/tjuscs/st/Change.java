package cn.tjuscs.st;

public class Change {
	
	private int[] money = {50, 20, 10, 5, 5, 1, 1, 1};
	
	public boolean makeChange(int sum){
		
		System.out.println("Test case : ");
		System.out.println(sum);
		
		for(int i=0; i<money.length; i++) {
			if(sum >= money[i]) {
				sum -= money[i];
			}
			if(sum == 0) {
				break;
			}
		}
		
		if(sum == 0) {
			System.out.println("Test result : True");
			return true;
		}
		else {
			System.out.println("Test result : True");
			return false;
		}
	}
}

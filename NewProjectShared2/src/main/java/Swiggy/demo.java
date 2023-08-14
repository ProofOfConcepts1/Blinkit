package Swiggy;

import java.util.HashSet;
import java.util.Set;

public class demo {
	
	public static void main(String[] args) {
		
		Set<String> duplicateChecker = new HashSet<String>();
		
		for (int i = 0; i < 10; i++) {
			
			boolean IsDuplicate = duplicateChecker.add("E");
			
			System.out.println(IsDuplicate);
			
		}
		

		
	}

}

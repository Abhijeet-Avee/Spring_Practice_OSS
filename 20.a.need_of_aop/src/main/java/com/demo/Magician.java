package com.demo;

import org.springframework.stereotype.Component;

@Component(value = "magician")
 public class Magician {

	public void doMagic() {	
		System.out.println("abra ka dabra....");
		//throw new RuntimeException();
	}
	
	public void doEat() {	
		System.out.println("eating the food....");
	}
}

package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {

	public String name;
	private int age;
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok();
		helloLombok.setName("asdfg");
		
		System.out.println("name = " + helloLombok.getName());
	}
	
}

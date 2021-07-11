package org.opentutorials.javatutorials.eclipes;

public class Helloworld {
	
	public static void main(String[] args) {
		String hello = "Hello world";
		String[] hi = {"H", "e", "l", "l", "o"};
		
		System.out.println("Hello world");
		System.out.println("Hello" + " worl" + 'd');
		System.out.println("\"Hello world\"");
		System.out.println(hello);
		
		String world = "";
		for(int i = 0; i < hi.length; i++) {
			world += hi[i];
		}
		System.out.println(world + " world");
	}

}

package langpackagelearning;

import entity.UFOEnemyShip;

public class TestingReflectiion {
	
   public static void main(String[] args) {
	Class reflectClass = UFOEnemyShip.class;
	String className =reflectClass.getName();
	System.out.println(className);
}
}

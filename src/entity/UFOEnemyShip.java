package entity;

public class UFOEnemyShip  extends EnemyShip{
	private String idcode="100";
	public UFOEnemyShip() {
		// TODO Auto-generated constructor stub
	}
	
	private String getPrivate() {
		return "how do you get this";
	}
	
	private String getOtherPrivate(int thisInt , String thatString) {
		return "how do you get here "+thisInt + "  " +thatString;
	}
	
	public UFOEnemyShip(int nubmer,String randString) {
		System.out.println("you sent"+nubmer+"   "+randString);
	}
 private EnemyShipFactory shipFactory;

public UFOEnemyShip(EnemyShipFactory shipFactory) {
	super();
	this.shipFactory = shipFactory;
}

public String getIdcode() {
	return idcode;
}

public void setIdcode(String idcode) {
	this.idcode = idcode;
}

public EnemyShipFactory getShipFactory() {
	return shipFactory;
}

public void setShipFactory(EnemyShipFactory shipFactory) {
	this.shipFactory = shipFactory;
}
 
 
}

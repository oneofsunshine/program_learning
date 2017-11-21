package SinktheTank;

import java.util.ArrayList;

public class Ship {
	private String name;
	private ArrayList<Square> ship = new ArrayList<Square>();
	private int randomAbscissa;
	private int randomOrdinate;
	private int direction;
	int count = 3;
	
	public Ship(SquareCube sc){
		do{
		this.randomAbscissa = (int)(Math.random()*7);
		this.randomOrdinate = (int)(Math.random()*7);
		this.directionDecide();
		}while(this.directionDecide());
		this.creatNewShip(sc);
	}
		
	public void creatNewShip(SquareCube sc){
		if(direction == 0){
			ship.add(sc.getSquare(this.randomAbscissa, this.randomOrdinate));
			ship.add(sc.getSquare(this.randomAbscissa-1, this.randomOrdinate));
			ship.add(sc.getSquare(this.randomAbscissa+1, this.randomOrdinate));
		}
		else{
			ship.add(sc.getSquare(this.randomAbscissa, this.randomOrdinate));
			ship.add(sc.getSquare(this.randomAbscissa, this.randomOrdinate-1));
			ship.add(sc.getSquare(this.randomAbscissa, this.randomOrdinate+1));
		}
	}
	
	public boolean directionDecide(){
		if(this.randomAbscissa != 0 & this.randomAbscissa != 6 &this.randomOrdinate != 0 & this.randomOrdinate != 6){
			this.direction = (int)(Math.random()*2);
			return false;
		}
		else if((this.randomAbscissa == 0|this.randomAbscissa == 6)&this.randomOrdinate != 0&this.randomOrdinate !=6){
			this.direction = 1;
			return false;
		}
		else if(this.randomAbscissa != 0&this.randomAbscissa != 6&(this.randomOrdinate == 0|this.randomOrdinate ==6)){
			this.direction = 0;
			return false;
		}
		else
			return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Square> getShip() {
		return ship;
	}

	public void setShip(ArrayList<Square> ship) {
		this.ship = ship;
	}

	public int getRandomAbscissa() {
		return randomAbscissa;
	}

	public void setRandomAbscissa(int randomAbscissa) {
		this.randomAbscissa = randomAbscissa;
	}

	public int getRandomOrdinate() {
		return randomOrdinate;
	}

	public void setRandomOrdinate(int randomOrdinate) {
		this.randomOrdinate = randomOrdinate;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public boolean overlapped(Ship anothership){
		boolean abc = false;
		for(int i = 0;i < 3;i++){
			if(this.ship.contains(anothership.ship.get(i)))
				abc = true|abc;
			else
				abc = false|abc;
		}
		if(abc)
			return true;
		else
			return false;
	}
}

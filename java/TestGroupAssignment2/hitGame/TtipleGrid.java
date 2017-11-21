package hitGame;

import java.util.Random;

/**
 * 三个连续格子类
 *
 */

public class TtipleGrid {
	private Grid[] grid = new Grid[3];// 三个连续格子数组
	private String name;// 三个连续格子网站标签

	public TtipleGrid(String name) {
		randomGrid();
		this.setName(name);
	}

	/**
	 * 产生随机三个连续的格子
	 *
	 */

	public void randomGrid() {
		int rows;
		int columns;
		Random random = new Random();
		char character;
		int choice = random.nextInt(2);
		if (choice == 0) {
			rows = random.nextInt(6);
			columns = random.nextInt(4);
			for (int i = 0; i < getGrid().length; i++) {
				character = (char) (rows + 65);// 根据坐标值转换为char型字母
				getGrid()[i] = new Grid(character + Integer.toString(columns + 1 + i), rows, columns + i);
			}
		} else {
			columns = random.nextInt(6);
			rows = random.nextInt(4);
			for (int i = 0; i < getGrid().length; i++) {
				character = (char) (rows + 65 + i);
				getGrid()[i] = new Grid(character + Integer.toString(columns + 1), rows + i, columns);
			}
		}

	}

	/**
	 * 判断是否被击沉
	 *
	 */
	public boolean isSunk() {
		for (int i = 0; i < 3; i++) {
			if (getGrid()[i].getValue() != "命中")
				return false;
		}
		return true;
	}

	/*
	 * 判断连续三个格子是否相等
	 */
	@Override
	public boolean equals(Object obj) {

		TtipleGrid other = (TtipleGrid) obj;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
			if(getGrid()[i].equals(other.getGrid()[j]))
				return true;
			}
		}
		if (getName().equals(other.getName()))
			return true;
		return false;

	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < 3; i++) {
			result += "grid" + (i + 1) + ":  " + getGrid()[i].toString() + "\t";
		}
		return result;
	}

	public Grid[] getGrid() {
		return grid;
	}

	public void setGrid(Grid[] grid) {
		this.grid = grid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

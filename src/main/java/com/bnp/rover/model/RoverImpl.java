package com.bnp.rover.model;

import com.bnp.rover.util.RoverConstant;

public class RoverImpl implements Rover {
	
	private int x;
	private int y;
	private char orientation;
	
	public RoverImpl(int x, int y, char orientation) {
		super();
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getOrientation() {
		return orientation;
	}

	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}

	@Override
	public void rotate(char dir) {
		this.orientation = RoverConstant.DIRECTIONS_MAP.get(dir).get(this.orientation);
		
	}

	@Override
	public void move(Plateau plateau) {
		switch(this.orientation) {
		case 'W':
			this.x = (plateau.getBorderLeft() <= (this.x - 1)) ? this.x - 1 : this.x;
			break;
		case 'E':
			this.x = (plateau.getBorderRight() >= (this.x + 1)) ? this.x + 1 : this.x;
			break;
		case 'N':
			this.y = (plateau.getBorderTop() >= (this.y + 1)) ? this.y + 1 : this.y;
			break;
		case 'S':
			this.y = (plateau.getBorderBot() <= (this.y - 1)) ? this.y - 1 : this.y;
			break;
		}
	}

	@Override
	public String toString() {
		return x + " " + y + " " + orientation + "\n";
	}

}

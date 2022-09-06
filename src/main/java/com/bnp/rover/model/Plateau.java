package com.bnp.rover.model;

public class Plateau {
	
	private int borderBot = 0;
	private int borderLeft = 0;
	private int borderTop = 0;
	private int borderRight = 0;
	
	public Plateau(int borderTop, int borderRight ) {
		this.borderTop = borderTop;
		this.borderRight = borderRight;
	}
	
	public int getBorderBot() {
		return borderBot;
	}
	public void setBorderBot(int borderBot) {
		this.borderBot = borderBot;
	}
	public int getBorderLeft() {
		return borderLeft;
	}
	public void setBorderLeft(int borderLeft) {
		this.borderLeft = borderLeft;
	}
	public int getBorderTop() {
		return borderTop;
	}
	public void setBorderTop(int borderTop) {
		this.borderTop = borderTop;
	}
	public int getBorderRight() {
		return borderRight;
	}
	public void setBorderRight(int borderRight) {
		this.borderRight = borderRight;
	}
	
}

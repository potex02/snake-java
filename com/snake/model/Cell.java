package com.snake.model;

public class Cell {
	
	private int x;
	private int y;
	
	public Cell(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	public Cell(Cell cell, int x, int y) {
		
		this.x = cell.getX() + x;
		this.y = cell.getY() + y;
		
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
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	public void move(int x, int y) {
		
		this.x += x;
		this.y += y;
		
	}
	@Override
	public boolean equals(Object obj) {
		
		Cell other;
		
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		other = (Cell) obj;
		return this.x == other.x && this.y == other.y;
		
	}
	@Override
	public String toString() {
		return "Cell [x=" + x + ", y=" + y + ", getX()=" + getX() + ", getY()=" + getY() + "]";
	}
	
}

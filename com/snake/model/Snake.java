package com.snake.model;

import java.awt.*;
import java.util.*;
import com.snake.view.*;

public class Snake {
	
	private ArrayList<Cell> cells;
	private int x;
	private int y;
	private boolean hasEaten;
	
	public Snake() {
		
		this.cells = new ArrayList<Cell>();
		this.cells.add(new Cell(10, 10));
		this.x = 0;
		this.y = 1;
		this.hasEaten = false;
		
	}
	public int size() {
		return this.cells.size();
	}
	public ArrayList<Cell> getCells() {
		return cells;
	}
	public void setDirection(int x, int y) {
		
		if(GamePanel.pause || this.x == -x || this.y == -y) {
			
			return;
			
		}
		this.x = x;
		this.y = y;
		
	}
	public void eat() {
		
		this.hasEaten = true;
		
	}
	public boolean gameOver() {
		
		if(this.cells.get(0).getX() < 0 || this.cells.get(0).getX() > 20 || this.cells.get(0).getY() < 0 || this.cells.get(0).getY() >= 20) {
			
			return true;
			
		}
		for(int i = 1; i != this.cells.size(); i++) {
			
			if(this.cells.get(i).equals(this.cells.get(0))) {
				
				return true;
				
			}
			
		}
		return false;
		
	}
	public void update() {
		
		this.cells.add(0, new Cell(this.cells.get(0), this.x, this.y));
		this.cells.remove(this.cells.size() - 1);
		if(this.hasEaten) {
			
			this.addCell();
			this.hasEaten = false;
			
		}
		
	}
	public void render(Graphics2D g, Dimension cellSize) {
		
		int width = (int)cellSize.getWidth(), height = (int)cellSize.getHeight();
		
		for(Cell c: this.cells) {
			
			g.setColor(Color.RED);
			g.fillRect(c.getX() * width, c.getY() * height, width, height);
			
		}
		
	}
	private int[] getCellDirection(int i) {
		
		if(i == 0) {
			
			return new int[]{this.x, this.y};
			
		}
		return new int[]{this.cells.get(i - 1).getX() - this.cells.get(i).getX(), this.cells.get(i - 1).getY() - this.cells.get(i).getY()};
		
	}
	private void addCell() {
		
		Cell cell = this.cells.get(this.cells.size() - 1);
		int[] direction = this.getCellDirection(this.cells.size() - 1);
		
		this.cells.add(new Cell(cell, -direction[0], -direction[1]));
		
	}
	
}

package com.snake.model;

import java.awt.*;
import java.util.*;

public class Food {
	
	private Cell cell;
	private Snake snake;
	
	public Food(Snake snake) {
		
		this.snake = snake;
		this.cell = new Cell(0, 0);
		this.move();
		
	}
	private void move() {
		
		Random random = new Random();
		
		this.cell.setX(random.nextInt(20));
		this.cell.setY(random.nextInt(20));
		while(!this.checkPosition()) {
			
			this.cell.setX(random.nextInt(20));
			this.cell.setY(random.nextInt(20));
			
		}
		
	}
	private boolean checkPosition() {
		
		for(Cell i : this.snake.getCells()) {
			
			if(this.cell.equals(i)) {
				
				return false;
				
			}
			
		}
		return true;
		
	}
	public void update() {
		
		if(this.snake.getCells().get(0).equals(this.cell)) {

			this.snake.eat();
			this.move();
			
		}
		
	}
	public void render(Graphics2D g, Dimension cellSize) {
		
		int width = (int)cellSize.getWidth(), height = (int)cellSize.getHeight();
		
		g.setColor(Color.GREEN);
		g.fillRect(this.cell.getX() * width, this.cell.getY() * height, width, height);
		
	}
	
}

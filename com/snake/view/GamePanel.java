package com.snake.view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import com.snake.model.*;

public class GamePanel extends JPanel implements Runnable{
	
	private Window window;
	private BufferedImage image;
	private Graphics2D g;
	private Thread thread;
	private boolean running;
	private Snake snake;
	private Food food;
	private static int FPS = 8;
	public static int CELLS = 21;
	public static boolean pause = false;
	
	public GamePanel(Window window) {
		
		this.window = window;
		this.thread = new Thread(this);
		this.snake = new Snake();
		this.food = new Food(this.snake);
		this.running = true;
		thread.start();
		
	}
	@Override
	public void run() {
		
		while(this.running) {
			
			long time = System.currentTimeMillis();
			
			this.update();
			this.render();
			this.draw();
			try {
				
				Thread.sleep((1000 / GamePanel.FPS) - (System.currentTimeMillis() - time));
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	public void changeDirection(int keyCode) {
		
		switch(keyCode) {
			
			case KeyEvent.VK_UP:
				this.snake.setDirection(0, -1);
				break;
			case KeyEvent.VK_DOWN:
				this.snake.setDirection(0, 1);
				break;
			case KeyEvent.VK_RIGHT:
				this.snake.setDirection(1, 0);
				break;
			case KeyEvent.VK_LEFT:
				this.snake.setDirection(-1, 0);
				break;
			case KeyEvent.VK_ESCAPE:
				if(this.snake.gameOver()) {
					
					this.snake = new Snake();
					this.food = new Food(this.snake);
					return;
					
				}
				GamePanel.pause = !GamePanel.pause;
				break;
			
		}
		
	}
	private void update() {
		
		if(this.snake.gameOver() || GamePanel.pause) {
			
			return;
			
		}
		this.snake.update();
		this.food.update();
		
	}
	private void render() {

		final Rectangle DIM = this.window.getBounds();
		final Dimension CELL_SIZE = new Dimension((int)DIM.getWidth() / CELLS, (int)DIM.getHeight() / CELLS);
		
		this.image = new BufferedImage((int)DIM.getWidth(), (int)DIM.getHeight(), BufferedImage.TYPE_INT_RGB);
		this.g = (Graphics2D)this.image.getGraphics();
		this.g.setColor(Color.BLUE);
		this.g.fillRect(0, 0, (int)DIM.getWidth(), (int)DIM.getHeight());
		this.snake.render(this.g, CELL_SIZE);
		this.food.render(this.g, CELL_SIZE);
		this.g.setColor(Color.WHITE);
		this.g.drawString("Score: " + (this.snake.size() - 1), 50, 50);
		if(this.snake.gameOver()) {
			
			String gameOver = "Game Over", restart = "Press Esc to restart";
			
			this.g.setColor(new Color(255, 255, 255, 128));
			this.g.fillRect(0, 0, (int)DIM.getWidth(), (int)DIM.getHeight());
			this.g.setColor(Color.WHITE);
			this.g.drawString(gameOver, DIM.width / 2 - g.getFontMetrics(g.getFont()).stringWidth(gameOver) / 2, DIM.height / 2);
			this.g.drawString(restart, DIM.width / 2 - g.getFontMetrics(g.getFont()).stringWidth(restart) / 2, DIM.height / 2 + 20);
			return;
			
		}
		if(GamePanel.pause) {
			
			String pause = "Pause";
			
			this.g.setColor(new Color(255, 255, 255, 128));
			this.g.fillRect(0, 0, (int)DIM.getWidth(), (int)DIM.getHeight());
			this.g.setColor(Color.WHITE);
			this.g.drawString(pause, DIM.width / 2 - g.getFontMetrics(g.getFont()).stringWidth(pause) / 2, DIM.height / 2);
			
		}
		
	}
	private void draw() {
		
		Graphics2D g2 = (Graphics2D)this.getGraphics();
		
		if(g2 == null) {
			
			return;
			
		}
		g2.drawImage(this.image, 0, 0, null);
		g2.dispose();
		
	}
	
}

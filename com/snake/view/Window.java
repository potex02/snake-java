package com.snake.view;

import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame {
	
	public Window() {
		
		super("Snake");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new TitlePanel(this));
		this.setVisible(true);
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(getContentPane() instanceof GamePanel) {
					
					((GamePanel)getContentPane()).changeDirection(e.getKeyCode());
					
				}
				
			}
			
		});
		
	}
	public void startGame() {
		
		this.setContentPane(new GamePanel(this));
		this.revalidate();
		this.repaint();
		this.requestFocus();
		
	}
	
}

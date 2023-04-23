package com.snake.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitlePanel extends JPanel {
	
	private Window window;
	private JLabel title;
	private JButton button;
	private GridBagConstraints gbc;
	
	public TitlePanel(Window window) {
		
		this.window = window;
		this.title = new JLabel("Snake");
		this.button = new JButton("Play");
		this.gbc = new GridBagConstraints();
		this.title.setFont(new Font(this.title.getFont().getName(), Font.BOLD, 40));
		this.title.setForeground(Color.RED);
		this.setLayout(new GridBagLayout());
		this.gbc.insets = new Insets(20, 20, 20, 20);
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
		this.add(this.title, this.gbc);
		for(int i = 0; i != 2; i++) {
			
			this.gbc.gridy++;
			this.add(new JLabel(), this.gbc);
			
		}
		this.gbc.gridy++;
		this.add(this.button, this.gbc);
		for(int i = 0; i != 4; i++) {
			
			this.gbc.gridy++;
			this.add(new JLabel(), this.gbc);
			
		}
		this.button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				window.startGame();
				
			}
			
		});
		
	}
	
}

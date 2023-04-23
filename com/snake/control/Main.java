package com.snake.control;

import javax.swing.*;
import com.snake.view.*;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		new Window();
		
	}
	
}

package tw.luna.pretty;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.luna.apis.GamePanel;

public class MyGame extends JFrame {
	private GamePanel panel;

	public MyGame() {

		setLayout(new BorderLayout());
		panel = new GamePanel();
		add(panel, BorderLayout.CENTER);

		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] arg) {
		new MyGame();
	}
}

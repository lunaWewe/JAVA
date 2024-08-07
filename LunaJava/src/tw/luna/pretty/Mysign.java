package tw.luna.pretty;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;

import tw.luna.apis.MyPanel;
import tw.luna.apis.MyPanel2;

public class Mysign extends JFrame {
	private MyPanel2 myPanel;
	private JButton clear, undo, redo, color;
	private JSlider slider;


	public Mysign() {
		super("Sign App");

		myPanel = new MyPanel2();
		setLayout(new BorderLayout());
		add(myPanel, BorderLayout.CENTER);

		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
		
		
		JPanel top = new JPanel(new FlowLayout());
		JSlider slider = new JSlider(1,20);
		
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(color);
		top.add(color);
		top.add(slider);
		
		add(top, BorderLayout.NORTH);

		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initEvent();
	}

	private void initEvent() {
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.clear();

			}
		});
		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.undo();

			}
		});
		redo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.redo();

			}
		});
		color.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();

			}
		});
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

	private void changeColor() {
		Color newColor = JColorChooser.showDialog(null, "Change Color", myPanel.getcolor());
		if (newColor != null) {
			myPanel.setColor(newColor);
		}
	}

	public static void main(String[] args) {
		new Mysign();

	}

}

package tw.luna.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JPanel;

import tw.luna.pretty.Line;
import tw.luna.pretty.Point;
import tw.luna.pretty.if04;

public class MyPanel2 extends JPanel {
	private LinkedList<Line> lines, recycle;
	private Color nowColor;

	public MyPanel2() {
		setBackground(Color.yellow);

		lines = new LinkedList<>();
		recycle = new LinkedList<>();

		nowColor = Color.black;
		MyListener myListener = new MyListener();

		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}

	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			recycle.clear();

			Line line = new Line(nowColor, 4);
			Point point = new Point(e.getX(), e.getY());
			line.addPoint(point);

			lines.add(line);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			Point point = new Point(e.getX(), e.getY());
			lines.getLast().addPoint(point);

			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g;

//		g2D.drawLine(0, 0, 100, 100);  // 看線的粗細

		for (Line line : lines) {

			g2D.setColor(line.getColor());
			g2D.setStroke(new BasicStroke(line.getWidth()));

			for (int i = 1; i < line.size(); i++) {
				Point p0 = line.getPoint(i - 1);
				Point p1 = line.getPoint(i);
				g2D.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			}
		}

	}

	public void clear() {
		lines.clear();
		repaint();
	}

	public void undo() {
		if (lines.size() > 0) {
			recycle.add(lines.removeLast());
			repaint();
		}

	}

	public void redo() {
		if (recycle.size() > 0) {
			lines.add(recycle.removeLast());
			repaint();
		}

	}

	public Color getcolor() {
		return nowColor;
	}

	public void setColor(Color color) {
		nowColor = color;
	}

}

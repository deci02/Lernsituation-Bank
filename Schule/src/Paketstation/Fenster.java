package Paketstation;

import java.awt.*;

import javax.swing.BoxLayout;

public class Fenster {

	public static void main(String[] args) {
		Frame fenster = new Frame();
//		fenster.setBounds(1000, 1000, 1000, 1000);
		fenster.setSize(1920, 1080);
		fenster.setTitle("Test");
		fenster.setLayout(new BorderLayout());

		Panel northGross = new Panel(new BorderLayout());
		Panel northField1 = new Panel(new GridLayout(3, 1));

		northGross.setSize(1900, 100);
		northGross.setBackground(Color.RED);

		northField1.setSize(1000, 50);
		northField1.setBackground(Color.yellow);

		northField1.add(new Button());

		northGross.add(northField1);


		Panel panel = new Panel();
		panel.setLayout(new FlowLayout());

		panel.setBackground(Color.BLUE);
		Dimension dim = new Dimension();
		dim.setSize(80, 80);
		panel.setSize(dim);

		fenster.add(northGross);
		fenster.add(panel);

		Button button1 = new Button("Button 1");
		button1.setSize(20, 20);
		panel.add(button1);

		fenster.setVisible(true);
	}
}

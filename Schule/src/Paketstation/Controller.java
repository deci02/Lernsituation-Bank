package Paketstation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controller implements ActionListener, KeyListener, MouseListener, WindowListener {

	public Paketstation myStation;
	public Fenster myFenster;

	public static void main(String[] args) {
		Controller cont = new Controller();
	}

	public Controller() {
		myFenster = new Fenster();
		myStation = new Paketstation(10);
		myFenster.myButtonEinfuegen.addActionListener(this);
		myFenster.myButtonEnde.addActionListener(this);
		myFenster.myButtonEntnehmen.addActionListener(this);
		myFenster.myButtonListen.addActionListener(this);
		myFenster.myTextField.addKeyListener(this);
		myFenster.myFrame.addWindowListener(this);
		myFenster.myTextField.addMouseListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Einfuegen")) {
			einfuegen();
		}
		if (e.getActionCommand().equals("Ende")) {
			beenden();
		}
		if (e.getActionCommand().equals("Entnehmen")) {
			entnehmen();
		}
		if (e.getActionCommand().equals("Listen")) {
			auflisten();
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource().equals(myFenster.myTextField) && e.getKeyChar() == e.VK_ENTER) {
			einfuegen();
		}
	}

	public void windowActivated(WindowEvent e) {
		this.myFenster.myTextField.requestFocus();
	}

	public void windowClosed(WindowEvent e) {
		System.out.println("Programm wurde ordnungsgemäß beendet.");
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(myFenster.myTextField) && e.getButton() == MouseEvent.BUTTON1) {
			myFenster.myTextField.setText("");
		}
	}

	public void einfuegen() {
		myFenster.myLabelMeldung.setText(myStation.einlagern(new Paket(myFenster.myTextField.getText())));
		myFenster.myTextField.setText("");
	}

	public void entnehmen() {
		String input = myFenster.myTextField.getText();
		try {
			int i = Integer.parseInt(input);
			myFenster.myLabelMeldung.setText(myStation.entnehmen(i));
		} catch (NumberFormatException e) {
			myFenster.myLabelMeldung.setText(myStation.entnehmen(input));
		}
		myFenster.myTextField.setText("");
	}

	public void auflisten() {
		myFenster.myTextArea.setText(myStation.listenPakete());
	}

	public void beenden() {
		myFenster.myFrame.dispose();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

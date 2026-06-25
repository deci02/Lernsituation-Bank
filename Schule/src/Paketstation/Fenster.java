package Paketstation;

import java.awt.*;

public class Fenster {

	public Frame myFrame;
	public Panel myPanelNorthGross;
	public Panel myPanelButton;
	public Label myLabelEmpfaenger;
	public Label myLabelMeldung;
	public TextArea myTextArea;
	public TextField myTextField;
	public Button myButtonEinfuegen;
	public Button myButtonEntnehmen;
	public Button myButtonListen;
	public Button myButtonEnde;

	public Fenster() {
		this.myFrame = new Frame();
		myFrame.setSize(1000, 600);
		myFrame.setLayout(new BorderLayout());

		myPanelNorthGross = new Panel(new BorderLayout());
		myPanelButton = new Panel(new GridLayout(4, 1));
		myLabelEmpfaenger = new Label();
		myLabelMeldung = new Label();
		myTextArea = new TextArea();
		myTextField = new TextField();
		myButtonEinfuegen = new Button();
		myButtonEntnehmen = new Button();
		myButtonListen = new Button();
		myButtonEnde = new Button();

		myLabelEmpfaenger.setBackground(Color.GRAY);
		myLabelEmpfaenger.setText("Empfänger");
		myTextField.setBackground(Color.YELLOW);

		myButtonEinfuegen.setBackground(Color.LIGHT_GRAY);
		myButtonEinfuegen.setLabel("Einfügen");
		myButtonEinfuegen.setActionCommand("Einfuegen");
		myButtonEntnehmen.setBackground(Color.LIGHT_GRAY);
		myButtonEntnehmen.setLabel("Entnehmen");
		myButtonEntnehmen.setActionCommand("Entnehmen");
		myButtonListen.setBackground(Color.LIGHT_GRAY);
		myButtonListen.setLabel("Listen");
		myButtonListen.setActionCommand("Listen");
		myButtonEnde.setBackground(Color.LIGHT_GRAY);
		myButtonEnde.setLabel("Ende");
		myButtonEnde.setActionCommand("Ende");

		myPanelButton.add(myButtonEinfuegen);
		myPanelButton.add(myButtonEntnehmen);
		myPanelButton.add(myButtonListen);
		myPanelButton.add(myButtonEnde);

		myPanelNorthGross.add(myLabelEmpfaenger, BorderLayout.WEST);
		myPanelNorthGross.add(myTextField, BorderLayout.CENTER);
		myPanelNorthGross.add(myPanelButton, BorderLayout.EAST);

		myTextArea.setBackground(Color.WHITE);

		myFrame.add(myPanelNorthGross, BorderLayout.NORTH);
		myFrame.add(myTextArea, BorderLayout.CENTER);
		myFrame.add(myLabelMeldung, BorderLayout.SOUTH);

		myFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new Fenster();
	}
}

package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.PersonDTO;

import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AddDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField yearField;
	private PersonDTO be;

	public PersonDTO getBe() {
		return be;
	}

	public void setBe(PersonDTO be) {
		this.be = be;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddDialog dialog = new AddDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddDialog(PersonDTO b) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			nomField = new JTextField();
			nomField.setBounds(113, 47, 86, 20);
			contentPanel.add(nomField);
			nomField.setColumns(10);
		}

		prenomField = new JTextField();
		prenomField.setBounds(113, 86, 86, 20);
		contentPanel.add(prenomField);
		prenomField.setColumns(10);
		yearField = new JTextField();
		yearField.setBounds(113, 122, 86, 20);
		contentPanel.add(yearField);
		yearField.setColumns(10);

		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setBounds(57, 50, 46, 14);
		contentPanel.add(lblPrenom);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(57, 89, 46, 14);
		contentPanel.add(lblNom);

		JLabel lblYear = new JLabel("Age");
		lblYear.setBounds(57, 125, 46, 14);
		contentPanel.add(lblYear);
		if (b == null) {
			be = new PersonDTO();
			nomField.setText("");
			prenomField.setText("");
			yearField.setText("");
		} else {
			setBe(b);
			nomField.setText(be.getLastName().toString());
			prenomField.setText(be.getFirstName().toString());
			yearField.setText(be.getAge() + "");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(nomField.getText() == "" || prenomField.getText() == "" || yearField.getText() == "") {
							dispose();
						}
						be.setLastName(nomField.getText());
						be.setFirstName(prenomField.getText());
						be.setAge(Integer.parseInt(yearField.getText()));
						dispose();
					}

				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dispose();
					}

				});
			}
		}
	}
}

package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conf.Config;

import javax.swing.JComboBox;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class BDDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//private File f = new File("file/conf");
	private String choice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BDDialog dialog = new BDDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public BDDialog() throws IOException {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		Config.getInstance().getText();
		{
			String[] tabChoice = {Config.getInstance().getFirstLineText(), Config.getInstance().getSecondLineText()};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			JComboBox comboBox = new JComboBox(tabChoice);
			comboBox.setBounds(76, 76, 235, 20);
			contentPanel.add(comboBox);
			comboBox.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(comboBox.getSelectedItem().equals(Config.getInstance().getFirstLineText())) {
						Config.getInstance().setChoice(Config.getInstance().getFirstLineClass());
					}else {
						Config.getInstance().setChoice(Config.getInstance().getSecondLineClass());
					}
					dispose();
				}
				
			});
		}
		
		JLabel lblVeuillezSlectionnerUne = new JLabel("Veuillez sélectionner une Base de données");
		lblVeuillezSlectionnerUne.setBounds(76, 35, 281, 14);
		contentPanel.add(lblVeuillezSlectionnerUne);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
		}
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
}

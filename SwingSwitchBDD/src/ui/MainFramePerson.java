package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import entities.PersonDTO;
import factor.MyFactory;
import ui.model.PersonModeleList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class MainFramePerson {

	private JFrame frame;
	PersonModeleList vml;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFramePerson window = new MainFramePerson();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFramePerson() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() throws Exception {
		
		BDDialog bdd = new BDDialog();
		bdd.setModal(true);
		bdd.setVisible(true);
		vml = new PersonModeleList(MyFactory.getInstance().getService().list());
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(256, 64, 99, 23);
		panel.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(256, 99, 99, 23);
		panel.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(256, 133, 99, 23);
		panel.add(btnDelete);

		JList listPerson = new JList();
		listPerson.setBounds(25, 11, 203, 197);
		listPerson.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(listPerson);
		listPerson.setModel(vml);
		listPerson.setVisible(true);

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddDialog ad = new AddDialog(null);
				ad.setModal(true);
				ad.setVisible(true);
				try {
					MyFactory.getInstance().getService().add(ad.getBe());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					listPerson.setModel(new PersonModeleList(MyFactory.getInstance().getService().list()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddDialog ad = new AddDialog((PersonDTO)listPerson.getModel().getElementAt(listPerson.getSelectedIndex()));
				ad.setModal(true);
				ad.setVisible(true);
				try {
					MyFactory.getInstance().getService().replace(ad.getBe());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					listPerson.setModel(new PersonModeleList(MyFactory.getInstance().getService().list()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir détruire cet élément ?", "Suppresion",
						JOptionPane.YES_NO_OPTION) == 0) {
					try {
						PersonDTO b = vml.getElementAt(listPerson.getSelectedIndex());
						MyFactory.getInstance().getService().delete(b.getId());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						listPerson.setModel(new PersonModeleList(MyFactory.getInstance().getService().list()));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
	}
}

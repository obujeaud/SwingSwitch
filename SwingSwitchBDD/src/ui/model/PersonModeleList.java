package ui.model;

import java.util.List;

import javax.swing.AbstractListModel;

import entities.PersonDTO;

@SuppressWarnings("serial")
public class PersonModeleList extends AbstractListModel<PersonDTO> {
	private int size = 0;
	private List<PersonDTO> list = null;

	public PersonModeleList(List<PersonDTO> ll) {
		// TODO Auto-generated constructor stub
		list = ll;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		try {
			size = list.size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return size;
	}

	@Override
	public PersonDTO getElementAt(int index) {
		// TODO Auto-generated method stub
		PersonDTO pdto = null;
		if (index == -1) {
			return null;
		}
		try {
			pdto = list.get(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pdto;
	}

}

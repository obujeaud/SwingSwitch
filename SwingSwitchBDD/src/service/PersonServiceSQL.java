package service;

import java.util.ArrayList;
import java.util.List;

import business.entities.Person;
import entities.PersonDTO;
import persistance.dao.j22.PersonDAO;

public class PersonServiceSQL implements IService {
	PersonDAO bdao = new PersonDAO();

	public PersonDTO personToDTO(Person p) {
		PersonDTO pdto = new PersonDTO();
		pdto.setId(p.getId() + "");
		pdto.setFirstName(p.getPrenom());
		pdto.setLastName(p.getName());
		pdto.setAge(p.getAge());
		return pdto;
	}

	public Person dtoToPerson(PersonDTO pdto) {
		Person p = new Person();
		p.setPrenom(pdto.getFirstName());
		p.setName(pdto.getLastName());
		p.setAge(pdto.getAge());
		return p;
	}

	public List<PersonDTO> list() throws Exception {
		List<PersonDTO> ldto = new ArrayList<>();
		List<Person> list = bdao.findList();
		for (Person p : list) {
			ldto.add(personToDTO(p));
		}
		return ldto;
	}

	public PersonDTO getById(long id) throws Exception {
		return personToDTO(bdao.findById(id));
	}

	public void add(PersonDTO b) throws Exception {
		bdao.create(dtoToPerson(b));
	}

	public void replace(PersonDTO be) throws Exception {
		bdao.updateById(dtoToPerson(be));
	}

	public void delete(String s) throws Exception {
		bdao.deleteById(Long.parseLong(s));
	}

}

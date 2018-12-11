package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import business.entities.Person;
import entities.PersonDTO;
import persistance.dao.PersonDAO;

public class PersonServiceNoSQL implements IService {
	PersonDAO bdao = new PersonDAO();

	@Override
	public PersonDTO personToDTO(Person p) {
		// TODO Auto-generated method stub
		PersonDTO pdto = new PersonDTO();
		pdto.setId(p.getId()+"");
		pdto.setFirstName(p.getPrenom());
		pdto.setLastName(p.getName());
		pdto.setAge(p.getAge());
		return pdto;
	}
	
	public Map<String, Object> personToMap(PersonDTO p){
		Map<String, Object> lp = new HashMap<>();
		if(p.getId() != null) {
			lp.put("_id", new ObjectId(p.getId()));
		}
		lp.put("Prenom", p.getFirstName());
		lp.put("Nom", p.getLastName());
		lp.put("Age", p.getAge());
		return lp;
	}
	
	public PersonDTO mapToPerson(Map<String, Object> p) {
		PersonDTO pe = new PersonDTO();
		pe.setId(p.get("_id").toString());
		pe.setFirstName(p.get("Prenom").toString());
		pe.setLastName(p.get("Nom").toString());
		if(p.get("Age").toString().contains(".")) {
			pe.setAge(Integer.parseInt(p.get("Age").toString().substring(0, p.get("Age").toString().indexOf("."))));
		}else {
			pe.setAge(Integer.parseInt(p.get("Age").toString()));
		}
		return pe;
	}

	@Override
	public Person dtoToPerson(PersonDTO pdto) {
		// TODO Auto-generated method stub
		Person p = new Person();
		p.setId(Long.parseLong(pdto.getId()));
		p.setPrenom(pdto.getFirstName());
		p.setName(pdto.getLastName());
		p.setAge(pdto.getAge());
		return p;
	}

	@Override
	public List<PersonDTO> list() throws Exception {
		// TODO Auto-generated method stub
		List<PersonDTO> ldto = new ArrayList<>();
		List<Map<String, Object>> list = bdao.list();
		for (Map<String, Object> p : list) {
			PersonDTO pdto = mapToPerson(p);
			ldto.add(pdto);
		}
		return ldto;
	}

	@Override
	public PersonDTO getById(long id) throws Exception {
		// TODO Auto-generated method stub
		return personToDTO((Person) bdao.getById(id+""));
	}

	@Override
	public void add(PersonDTO b) throws Exception {
		// TODO Auto-generated method stub
		bdao.create(personToMap(b));
	}

	@Override
	public void replace(PersonDTO be) throws Exception {
		// TODO Auto-generated method stub
		bdao.updateById(personToMap(be));
	}

	@Override
	public void delete(String s) throws Exception {
		// TODO Auto-generated method stub
		bdao.deleteById(s);
	}

}

package service;

import java.util.List;

import business.entities.Person;
import entities.PersonDTO;

public interface IService {

	public PersonDTO personToDTO(Person p);

	public Person dtoToPerson(PersonDTO pdto);

	public List<PersonDTO> list() throws Exception;

	public PersonDTO getById(long id) throws Exception;

	public void add(PersonDTO b) throws Exception;

	public void replace(PersonDTO be) throws Exception;

	public void delete(String s) throws Exception;

}

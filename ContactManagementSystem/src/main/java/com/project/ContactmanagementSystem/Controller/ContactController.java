package com.project.ContactmanagementSystem.Controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.project.ContactmanagementSystem.Service.ContactService;
import com.project.ContactmanagementSystem.bean.Person;





@RestController

@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactservice;
	
@PostMapping("/save")
public ResponseEntity<Person> save(@RequestBody @Validated Person person){
	Person save = contactservice.save(person);
return new ResponseEntity<Person>(save, HttpStatus.CREATED);
}

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidIdFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InvalidIdFound(String message) {
		super(message);
	}
}

@ResponseStatus(value = HttpStatus.OK)
@GetMapping("/retrieve/{id}")
public Person retrieve(@PathVariable Integer id){
	if(!contactservice.value(id)) {
		throw new InvalidIdFound("Couldnt able find ID"+id);
	}
	return contactservice.retrieve(id);

}

@GetMapping("/show")
public List<Person> getAll(){
	return contactservice.getAll();
}
@GetMapping("/name/{name}")
public List<Person> findByName(@PathVariable String name){
	return contactservice.getByname(name);
}
}

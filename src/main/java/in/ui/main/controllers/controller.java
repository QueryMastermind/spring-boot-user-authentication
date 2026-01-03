package in.ui.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ui.main.entities.Users;
import in.ui.main.services.UserService;

@RestController
public class controller {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/AddUser")
	public Users AddNewUser(@RequestBody Users user) {
		 return userservice.addNewUser(user);
	}
	
	@GetMapping("/ShowUsers")
	public List<Users> showAllUsers(){
		return userservice.ShowAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Users> showuserbyid(@PathVariable int id){
		Users ValidUser= userservice.showUserById(id).orElse(null);
		if(ValidUser != null) {
			return ResponseEntity.ok().body(ValidUser);
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Users> updateUserByid(@PathVariable int id, @RequestBody Users user){
		Users UpdatedUser=userservice.updateUser(id, user);
		if(UpdatedUser != null) {
			return ResponseEntity.ok(UpdatedUser);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteuser(@PathVariable int id){
		userservice.deleteuser(id);
		return ResponseEntity.noContent().build();
	}
	

}

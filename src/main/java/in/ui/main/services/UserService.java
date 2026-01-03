package in.ui.main.services;

import java.util.List;
import java.util.Optional;

import in.ui.main.entities.Users;

public interface UserService {
	
	public Users addNewUser(Users user);
	public List<Users> ShowAllUsers();
	public Optional<Users> showUserById(int id);
	public Users updateUser(int id,Users user);
	public void deleteuser(int id);
}

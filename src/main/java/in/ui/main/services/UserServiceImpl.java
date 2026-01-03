package in.ui.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ui.main.entities.Users;
import in.ui.main.repositories.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository userRepo;

	@Override
	public Users addNewUser(Users user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public List<Users> ShowAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Optional<Users> showUserById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public Users updateUser(int id, Users NewUser) {
	    Users validuser=userRepo.findById(id).orElse(null);
	    if(validuser != null) {
	    	return userRepo.save(NewUser);
	    }else {
	    	 throw new RuntimeException("The User does not exist with id " +id);
	    }
		
	}

	@Override
	public void deleteuser(int id) {
		userRepo.deleteById(id);
		
	}

}

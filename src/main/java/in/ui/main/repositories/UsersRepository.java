package in.ui.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ui.main.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}

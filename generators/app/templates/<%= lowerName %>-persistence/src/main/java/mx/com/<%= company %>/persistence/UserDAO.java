package mx.com.<%= company %>.persistence;

import mx.com.<%= company %>.model.UserDO;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserDAO extends CrudRepository<UserDO, Long> {

    List<UserDO> findByLastName(String lastName);
}

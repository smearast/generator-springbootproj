package mx.com.<%= company %>.services.facade;

import mx.com.<%= company %>.commons.to.UserTO;

import java.util.List;

public interface I<%= titleName %>Facade {

    List<UserTO> getAllUsers();

}

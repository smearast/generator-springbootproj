package mx.com.<%= company %>.services.service;

import mx.com.<%= company %>.commons.to.UserTO;
import java.util.List;

public interface I<%= titleName %>Service {

    List<UserTO> getUsers();
}

package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.I<%= titleName %>Facade;
import mx.com.axity.services.service.I<%= titleName %>Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class <%= titleName %>Facade implements I<%= titleName %>Facade {

    @Autowired
    private I<%= titleName %>Service <%= lowerName %>Service;

    public List<UserTO> getAllUsers() {
        return this.<%= lowerName %>Service.getUsers();
    }
}

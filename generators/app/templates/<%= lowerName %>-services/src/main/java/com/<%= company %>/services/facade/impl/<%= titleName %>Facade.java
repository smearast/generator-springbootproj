package com.<%= company %>.services.facade.impl;

import com.<%= company %>.commons.to.UserTO;
import com.<%= company %>.services.facade.I<%= titleName %>Facade;
import com.<%= company %>.services.service.I<%= titleName %>Service;
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

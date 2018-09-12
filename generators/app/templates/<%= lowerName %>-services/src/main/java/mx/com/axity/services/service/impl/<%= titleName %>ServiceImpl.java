package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.persistence.UserDAO;
import mx.com.axity.services.service.I<%= titleName %>Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class <%= titleName %>ServiceImpl implements I<%= titleName %>Service {

    static final Logger LOG = LogManager.getLogger(<%= titleName %>ServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserTO> getUsers() {

        LOG.info("Consultando usuarios");
        var usersDO = this.userDAO.findByLastName("Rodriguez");

        Type userDAOType = new TypeToken<List<UserDO>>() {}.getType();
        var usersTO = (List<UserTO>)this.modelMapper.map(usersDO, userDAOType);
        LOG.info("Se retornan {} elementos", usersTO.size());

        return usersTO;
    }
}

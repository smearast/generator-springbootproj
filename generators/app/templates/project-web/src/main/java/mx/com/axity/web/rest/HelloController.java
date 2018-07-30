package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.I<%= titleName %>Facade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("<%= lowerName %>")
@Api(value="<%= lowerName %>", description="Operaciones con <%= lowerName %>")
public class HelloController {

    final static Logger log = Logger.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    I<%= titleName %>Facade I<%= titleName %>Facade;

    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        log.info("Se invoca /find");
        var users = this.I<%= titleName %>Facade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}

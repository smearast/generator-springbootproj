package mx.com.<%= company %>.services.service;

import mx.com.<%= company %>.commons.to.UserTO;
import mx.com.<%= company %>.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class <%= titleName %>ServiceTest extends BaseTest {

    @Test
    public void exampleTest() {

        List<UserTO> users = this.<%= lowerName %>Service.getUsers();

        Assert.assertEquals(1, users.size());
    }
}

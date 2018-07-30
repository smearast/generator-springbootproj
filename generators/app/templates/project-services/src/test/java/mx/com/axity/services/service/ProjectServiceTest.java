package mx.com.axity.services.service;

import mx.com.axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class <%= titleName %>ServiceTest extends BaseTest {

    @Test
    public void exampleTest() {

        var users = this.<%= lowerName %>Service.getUsers();

        Assert.assertEquals(1, users.size());
    }
}

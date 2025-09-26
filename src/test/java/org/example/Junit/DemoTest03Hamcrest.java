package org.example.Junit;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.*;


//now check if bean has the property
public class DemoTest03Hamcrest {
    @Test
    void method01() {
        Customer customer = new Customer("john", "Abraham");
        assertThat(customer, hasProperty("Lname"));
    }
}

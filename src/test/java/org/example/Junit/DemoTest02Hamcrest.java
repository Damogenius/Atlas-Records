package org.example.Junit;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;//Object Matcher:
import static org.hamcrest.Matchers.hasToString;
// we  are given a bean ... string correctness
public class DemoTest02Hamcrest {
    @Test
    public void method1() {
        Customer customer = new Customer("John", "Abraham");
        String str = customer.toString();
        assertThat(customer, hasToString(str));
    }
}

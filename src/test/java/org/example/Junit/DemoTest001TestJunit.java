package org.example.Junit;
import org.testng.annotations.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class DemoTest001TestJunit {
    @Test
    public void Testcase1() {
        String str = "Damo";
        assertEquals("Damo", str);
    }
}

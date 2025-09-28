package org.example.Junit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
public class junitTest01 {

    String msg = "running test01 ";

    MessageUtil msgUtilobj = new MessageUtil(msg);
    //MessageUtil is a utility class
    //store a message
    @Test
    public void msgTest() {
        System.out.println("we are inside the msgtest()");

        assertEquals(msg, msgUtilobj.printMessage());
    }
}


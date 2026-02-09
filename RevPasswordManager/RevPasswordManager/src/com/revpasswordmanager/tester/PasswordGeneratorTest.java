//package com.revpasswordmanager.tester;
//import com.revpasswordmanager.util.PasswordGenerator;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class PasswordGeneratorTest {
//
//    @Test
//    public void testLength() {
//        assertEquals(12, PasswordGenerator.generate(12).length());
//    }
//}


package com.revpasswordmanager.tester;

import com.revpasswordmanager.util.PasswordGenerator;
import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordGeneratorTest {

    @Test
    public void testLength() {
        String pwd = PasswordGenerator.generate(
                12,     // length
                true,   // uppercase
                true,   // lowercase
                true,   // digits
                true    // symbols
        );

        assertEquals(12, pwd.length());
    }
}


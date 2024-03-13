import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompteTest {

    @Test
    void testComprobarIBAN() {
        Compte c = new Compte();
        assertEquals(true, c.compruebaIBAN("ES6621000418401234567891"));
    }

}
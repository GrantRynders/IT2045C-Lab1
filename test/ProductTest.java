import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1, p2, p3, p4, p5, p6;
    @BeforeEach
    void setUp()
    {
        p1 = new Product("00000A", "Xenoblade", "JRPG", 60.0);
        p2 = new Product("00000B", "Zelda", "RPG", 70.0);//burn me at the stake for calling Zelda an RPG
        Person.setIDSeed(0);
        p3 = new Product("Metroid", "Metroidvania", 50.0);
        p4 = new Product( "Elden Ring", "Soulslike", 60.0);
        p5 = new Product( "Mario", "Platformer", 60.0);
        p6 = new Product( "Celeste", "Platformer", 20.0);
    }

    @Test
    void getID()
    {
        assertEquals("00000A", p1.getID());
    }

    @Test
    void setID()
    {
        p1.setID("00000B");
        assertEquals("00000B", p1.getID());
    }

    @Test
    void getName()
    {
        assertEquals("Xenoblade", p1.getName());
    }

    @Test
    void setName()
    {
        p1.setName("Zelda");
        assertEquals("Zelda", p1.getName());
    }

    @Test
    void getDescription()
    {
        assertEquals("JRPG", p1.getDescription());
    }

    @Test
    void setDescription()
    {
        p1.setDescription("RPG");
        assertEquals("RPG", p1.getDescription());
    }

    @Test
    void getCost()
    {
        assertEquals(60.0, p1.getCost());
    }

    @Test
    void setCost()
    {
        p1.setCost(70.0);
        assertEquals(70.0, p1.getCost());
    }
}
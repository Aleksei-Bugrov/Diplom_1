package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getNameBun() {
        Bun bun = new Bun("bulo4ka", 101.5f);
        String expected = bun.getName();
        assertEquals("Булочка для бургера не создалась, ошибка в имени", expected, "bulo4ka");
        System.out.println(bun.name);
    }

    @Test
    public void getPriceBun() {
        Bun bun = new Bun("bublik", 101.5f);
        float expected = bun.getPrice();
        assertEquals("Булочка для бургера не создалась, ошибка в цене", 101.5, expected, 0);
        System.out.println(bun.price);
    }
}
package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
        assertNull(svatky.kdyMaSvatek("Eva"));
        assertNull(svatky.kdyMaSvatek("xxx"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {

        Svatky svatky = new Svatky();
        assertTrue(svatky.jeVSeznamu("Nataša"));
        assertFalse(svatky.jeVSeznamu("Eva"));
        assertFalse(svatky.jeVSeznamu("xxx"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {

        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {

        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getSeznamJmen().size());
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {

        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Ivana", 5, 4);
        assertEquals(38, svatky.getPocetJmen());
        assertTrue(svatky.jeVSeznamu("Ivana"));
        assertEquals(MonthDay.of(4, 5), svatky.kdyMaSvatek("Ivana"));
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {

        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Eva", 24, Month.DECEMBER);
        assertEquals(38, svatky.getPocetJmen());
        assertTrue(svatky.jeVSeznamu("Eva"));
        assertEquals(MonthDay.of(12, 24), svatky.kdyMaSvatek("Eva"));

    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {

        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Eva", MonthDay.of(12, 24));

        assertEquals(38, svatky.getPocetJmen());
        assertTrue(svatky.jeVSeznamu("Eva"));
        assertEquals(MonthDay.of(12, 24), svatky.kdyMaSvatek("Eva"));

    }

    /**
     * Testuje metodu {@link Svatky#smazatSvatek(String)}
     */
    @Test
    void smazatSvatek() {

        Svatky svatky = new Svatky();
        svatky.smazatSvatek("Monika");
        assertEquals(36, svatky.getPocetJmen());
        svatky.smazatSvatek("Eva");
        assertFalse(svatky.jeVSeznamu("Eva"));
    }
}

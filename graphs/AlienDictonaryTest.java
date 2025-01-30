package graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AlienDictonaryTest {

    @Test
    void testFindOrderSimple() {
        String[] dict = {"baa","abcd","abca","cab","cad"};
        String order = AlienDictonary.findOrder(dict, 5, 4);
        assertEquals("bdac", order);
    }
    @Test
    void testFindOrderSimple2() {
        String[] dict = {"caa","aaa","aab"};
        String order = AlienDictonary.findOrder(dict, 3, 3);
        assertEquals("cab", order);
    }

    @Test
    void testFindOrderSingleCharacter() {
        String[] dict = {"z", "x", "z"};
        String order = AlienDictonary.findOrder(dict, 3, 2);
        assertEquals("zx", order);
    }

    @Test
    void testFindOrderEmptyDict() {
        String[] dict = {};
        String order = AlienDictonary.findOrder(dict, 0, 0);
        assertEquals("", order);
    }

    @Test
    void testFindOrderNoOrder() {
        String[] dict = {"abc", "abc", "abc"};
        String order = AlienDictonary.findOrder(dict, 3, 3);
        assertEquals("abc", order);
    }
}
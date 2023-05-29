package com.kenzie.freshfruit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FreshFruitTest {

    @Test
    public void testFreshFruitEquals_NotEqual() {
        FreshFruit fruit1 = new FreshFruit("Apple", false, 5);
        FreshFruit fruit2 = new FreshFruit("Orange", true, 3);
        assertNotEquals(fruit1, fruit2);
    }

    @Test
    public void testFreshFruitEquals_SameFruit() {
        FreshFruit fruit1 = new FreshFruit("Apple", false, 5);
        FreshFruit fruit2 = new FreshFruit("Apple", false, 5);
        assertEquals(fruit1, fruit2);
    }

    @Test
    public void testFreshFruitEquals_SameFruitDifferentPurchaseCount() {
        FreshFruit fruit1 = new FreshFruit("Apple", false, 5);
        FreshFruit fruit2 = new FreshFruit("Apple", false, 3);
        assertEquals(fruit1, fruit2);
    }

    @Test
    public void testFreshFruitEquals_DifferentName() {
        FreshFruit fruit1 = new FreshFruit("Apple", true, 3);
        FreshFruit fruit2 = new FreshFruit("Orange", true, 3);
        assertNotEquals(fruit1, fruit2);
    }

    @Test
    public void testFreshFruitEquals_DifferentSeedlessStatus() {
        FreshFruit fruit1 = new FreshFruit("Apple", false, 5);
        FreshFruit fruit2 = new FreshFruit("Apple", true, 5);
        assertNotEquals(fruit1, fruit2);
    }
}

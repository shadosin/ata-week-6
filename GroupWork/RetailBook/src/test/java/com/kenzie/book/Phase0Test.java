package com.kenzie.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Phase0Test {

    @Test
    public void phase0_dependencyHasBeenUpdated_canCreateProductInformation() {
        assertNotNull(new ProductInformation(), "It appears you don't have the updates in a package your Snippets " +
                "package depends on. Be sure to update your version set metadata and try again.");

    }
}

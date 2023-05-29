package com.kenzie.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ExtensionTest {
    private static final String ASIN = "B0192CTMYG";
    private static final String TITLE = "Harry Potter and the Sorcerer’s Stone";
    private static final String AUTHOR = "J.K. Rowling";
    private static final String DESCRIPTION = "Harry Potter has never even heard of Hogwarts when the letters start...";
    private static final Set<String> IMAGE_URLS = Collections.singleton(
            "https://m.media-amazon.com/images/I/413lxIe20jL.jpg");
    private static final BigDecimal LENGTH = new BigDecimal("345");
    private static final double SIMILARITY = 0.5;

    @Mock
    private ProductInformation productInformation;

    private ProductInformation otherProductInformation = new ProductInformation();

    private BookWrapper book;

    @BeforeEach
    public void setup() {
        initMocks(this);
        this.book = BookWrapper.create(productInformation, AUTHOR, LENGTH);

        when(productInformation.getAsin()).thenReturn(ASIN);
        when(productInformation.getDisplayName()).thenReturn(TITLE);
        when(productInformation.getDescription()).thenReturn(DESCRIPTION);
        when(productInformation.getImageUrls()).thenReturn(IMAGE_URLS);
        when(productInformation.calculateSimilarity(otherProductInformation)).thenReturn(SIMILARITY);
    }

    @Test
    public void hashCode_equalClasses_equalHashCode() {
        // GIVEN - equal class
        BookWrapper other = BookWrapper.create(new ProductInformation(ASIN, null, null, null), "", BigDecimal.ZERO);

        // WHEN - hashCode
        int hashCode = other.hashCode();

        // THEN - equal hashCodes
        assertEquals(book.hashCode(), hashCode);
    }

    @Test
    public void equals_nullObject_returnsFalse() {
        // GIVEN - null other
        Object other = null;

        // WHEN - equals
        boolean isEqual = book.equals(other);

        // THEN - returns false
        assertFalse(isEqual);
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        // GIVEN - same object
        Object other = book;

        // WHEN - equals
        boolean isEqual = book.equals(book.getWrappedInstance());

        // THEN - returns true
        assertTrue(isEqual);
    }

    @Test
    public void equals_differentType_returnsFalse() {
        // GIVEN - different type
        Object other = "Book";

        // WHEN - equals
        boolean isEqual = book.equals(other);

        // THEN - returns false
        assertFalse(isEqual);
    }

    @Test
    public void equals_differentAsin_returnsFalse() {
        // GIVEN - different ASIN
        Object other = BookWrapper.create(new ProductInformation("12345", TITLE, DESCRIPTION, IMAGE_URLS), AUTHOR, LENGTH).getWrappedInstance();

        // WHEN - equals
        boolean isEqual = book.equals(other);

        // THEN - returns false
        assertFalse(isEqual);
    }

    @Test
    public void equals_sameAsin_returnsTrue() {
        // GIVEN - Same ASIN
        Object other = BookWrapper.create(new ProductInformation(ASIN, null, null, null), "", BigDecimal.ZERO).getWrappedInstance();

        // WHEN - equals
        boolean isEqual = book.equals(other);

        // THEN - returns true
        assertTrue(isEqual);
    }
}
package com.kenzie.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class Phase1Test {
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
    public void getAsin_givenBook_returnsAsin() {
        // GIVEN - book
        // WHEN - getAsin
        String asin = book.getAsin();

        // THEN - matching asin returned
        assertEquals(ASIN, asin);
        verify(productInformation).getAsin();
    }

    @Test
    public void getTitle_givenBook_returnsTitle() {
        // GIVEN - book
        // WHEN - getTitle
        String title = book.getTitle();

        // THEN - matching title returned
        assertEquals(TITLE, title);
        verify(productInformation).getDisplayName();
    }

    @Test
    public void getAuthor_givenBook_returnsAuthor() {
        // GIVEN - book
        // WHEN - getAuthor
        String author = book.getAuthor();

        // THEN - matching author returned
        assertEquals(AUTHOR, author);
        verifyZeroInteractions(productInformation);
    }

    @Test
    public void getDescription_givenBook_returnsDescription() {
        // GIVEN - book
        // WHEN - getDescription
        String description = book.getDescription();

        // THEN - matching description returned
        assertEquals(DESCRIPTION, description);
        verify(productInformation).getDescription();
    }

    @Test
    public void getImageUrls_givenBook_returnsImageUrls() {
        // GIVEN - book
        // WHEN - getImageUrls
        Set<String> imageUrls = book.getImageUrls();

        // THEN - matching imageUrls returned
        assertEquals(IMAGE_URLS, imageUrls);
        verify(productInformation).getImageUrls();
    }

    @Test
    public void getLength_givenBook_returnsLength() {
        // GIVEN - book
        // WHEN - getLength
        BigDecimal length = book.getLength();

        // THEN - matching length returned
        assertEquals(LENGTH, length);
        verifyZeroInteractions(productInformation);
    }

    @Test
    public void calculateSimilarity_otherBook_usesProductInformationSimilarity() {
        // GIVEN - other book
        BookWrapper otherBook = BookWrapper.create(otherProductInformation, "", BigDecimal.ZERO);

        // WHEN - calculateSimilarity
        double similarity = book.calculateSimilarity(otherBook.getWrappedInstance());

        // THEN - uses Product information similarity
        assertEquals(SIMILARITY, similarity);
        verify(productInformation).calculateSimilarity(any(ProductInformation.class));
    }
}
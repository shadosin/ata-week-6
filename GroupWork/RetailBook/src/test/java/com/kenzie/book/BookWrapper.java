package com.kenzie.book;

import com.kenzie.test.infrastructure.reflect.ClassQuery;
import com.kenzie.test.infrastructure.reflect.MethodInvoker;
import com.kenzie.test.infrastructure.wrapper.WrapperBase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Set;

public class BookWrapper extends WrapperBase {
    private static final String BOOK_PACKAGE = "com.kenzie.book";
    private static final String BOOK_CLASS = "Book";
    private static Class<?> wrappedClass = null;

    /**
     * Saves the wrapped class instance and type, ensuring the wrapped instance looks like the right type for the given
     * wrapper class.
     * @param wrappedInstance the instance to be wrapped.
     */
    protected BookWrapper(Object wrappedInstance) {
        super(wrappedInstance);
    }

    public static BookWrapper create(ProductInformation productInformation, String author, BigDecimal length) {
        Class<?> bookWrapperClass = ClassQuery.inExactPackage(BOOK_PACKAGE)
                .withExactSimpleName(BOOK_CLASS)
                .findClassOrFail();

        Constructor<?> constructor = getConstructor(bookWrapperClass,
                ProductInformation.class, String.class, BigDecimal.class);

        Object bookObject = MethodInvoker.invokeConstructor(constructor, productInformation, author, length);
        return new BookWrapper(bookObject);
    }

    public String getAsin() {
        Method getAsin = getMethod("getAsin");
        return (String) invokeInstanceMethodWithReturnValue(getAsin);
    }

    public String getTitle() {
        Method getTitle = getMethod("getTitle");
        return (String) invokeInstanceMethodWithReturnValue(getTitle);
    }

    public String getAuthor() {
        Method getAuthor = getMethod("getAuthor");
        return (String) invokeInstanceMethodWithReturnValue(getAuthor);
    }

    public String getDescription() {
        Method getDescription = getMethod("getDescription");
        return (String) invokeInstanceMethodWithReturnValue(getDescription);
    }

    public Set<String> getImageUrls() {
        Method getImageUrls = getMethod("getImageUrls");
        return (Set<String>) invokeInstanceMethodWithReturnValue(getImageUrls);
    }

    public BigDecimal getLength() {
        Method getLength = getMethod("getLength");
        return (BigDecimal) invokeInstanceMethodWithReturnValue(getLength);
    }

    public double calculateSimilarity(Object o) {
        Method calculateSimilarity = getMethod("calculateSimilarity");
        return (double) invokeInstanceMethodWithReturnValue(calculateSimilarity, o);
    }

    @Override
    public int hashCode() {
        Method hashCode = null;

        try {
            hashCode = customGetMethodForClass(BOOK_PACKAGE, BOOK_CLASS, "hashCode");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (int) invokeInstanceMethodWithReturnValue(hashCode);
    }

    @Override
    public boolean equals(Object o) {
        Method equals = null;

        try {
            equals = customGetMethodForClass(BOOK_PACKAGE, BOOK_CLASS, "equals");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (boolean) invokeInstanceMethodWithReturnValue(equals, o);
    }

    @Override
    public Class<?> getWrappedClass() {
        if (null != wrappedClass) {
            return wrappedClass;
        }
        wrappedClass = ClassQuery.inExactPackage(BOOK_PACKAGE)
                .withExactSimpleName(BOOK_CLASS)
                .findClassOrFail();

        return wrappedClass;
    }

    private Method customGetMethodForClass(String packageName, String className, String methodName) throws Exception {

        Method methodToFind = null;

        try {
            Class<?> classToFind = Class.forName(packageName + "." + className);

            boolean hasMethod = false;

            try {
                Method[] methods = classToFind.getMethods();

                for (Method m : methods) {
                    if (m.getName().equals(methodName)) {
                        methodToFind = m;
                        hasMethod = true;
                        break;
                    }
                }

                if(!hasMethod) {
                    throw new Exception("No methods named " + methodName + "exist on the class provided.");
                }
            }
            catch(Exception E) {
                throw new Exception("No methods exist on the class provided.", E);
            }
        } catch(ClassNotFoundException exception) {
            //my class isn't there!
            exception.printStackTrace();
        }

        return methodToFind;
    }
}
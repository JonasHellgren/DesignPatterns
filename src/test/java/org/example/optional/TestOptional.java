package org.example.optional;

import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class TestOptional {

    @Getter
    public class Modem {
        private Double price;

        public Modem(Double price) {
            this.price = price;
        }
        // standard getters and setters
    }

    @Test
    public void givenOptional_whenIsPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("Baeldung");
        Assert.assertTrue(opt.isPresent());

        opt = Optional.ofNullable(null);
        Assert.assertFalse(opt.isPresent());
    }

    @Test
    public void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected() {
        Optional<String> opt = Optional.of("Baeldung");
        Assert.assertFalse(opt.isEmpty());

        opt = Optional.ofNullable(null);
        Assert.assertTrue(opt.isEmpty());
    }

    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("baeldung");
        opt.ifPresent(name -> System.out.println(name.length()));
    }

    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("john");
        Assert.assertEquals("john", name);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoArgOrElseThrowWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow();
    }

    @Test
    public void whenFiltersWithoutOptional_thenCorrect() {
        Assert.assertTrue(priceIsInRange1(new Modem(10.0)));
        Assert.assertFalse(priceIsInRange1(new Modem(9.9)));
        Assert.assertFalse(priceIsInRange1(new Modem(null)));
        Assert.assertFalse(priceIsInRange1(new Modem(15.5)));
        Assert.assertFalse(priceIsInRange1(null));
    }

    @Test
    public void  OrElseEmpty()
    {
        List<String> listOfBooks= new ArrayList<>();
        Optional<String> book =
                listOfBooks.stream().findFirst();
        String foundBook = book.orElse("Not Found");
        Assert.assertEquals("Not Found",foundBook);
    }

    @Test
    public void  OrElseBook()
    {
        List<String> listOfBooks= Arrays.asList("3d");
        Optional<String> book =
                listOfBooks.stream() .filter(b -> b.startsWith("4d")) .findFirst();
        String foundBook = book.orElse("Not Found");
        Assert.assertEquals("Not Found",foundBook);
    }

    public boolean priceIsInRange1(Modem modem2) {
        return Optional.ofNullable(modem2)
                .map(Modem::getPrice)
                .filter(p -> p >= 10)
                .filter(p -> p <= 15)
                .isPresent();
    }

}

package com.sakruthi.CreditCard;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardFactoryTest {

    @Test
    public void test_CreditCardFactory_DiscoverCreditCard() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard creditcard = factory.getCreditCard("6011111100007756");
        assertTrue(creditcard instanceof DiscoverCC);
        assertEquals("Discover", creditcard.toString());
    }

    //Testing the Visa Credit Card
    @Test
    public void test_CreditCardFactory_VisaCreditCard() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard creditcard = factory.getCreditCard("4123456789123");
        assertTrue(creditcard instanceof VisaCC);
        assertEquals("Visa", creditcard.toString());
    }

    //Testing the Amex CreditCard Number
    @Test
    public void test_CreditCardFactory_AmexCreditCard() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard cc = factory.getCreditCard("347856341908126");
        assertTrue(cc instanceof AmExCC);
        assertEquals("AmericanExpress", cc.toString());
    }

    //Testing the Master Credit Card number.
    @Test
    public void test_CreditCardFactory_MasterCreditCard() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard cc = factory.getCreditCard("5367894523129089");
        assertTrue(cc instanceof MasterCC);
        assertEquals("MasterCard", cc.toString());

    }

    //Testing the invalid credit card
    @Test
    public void test_CreditCardFactory_invalidCreditCardNumber() {
        CreditCardFactory factory = new CreditCardFactory();
        assertThrows(UnsupportedOperationException.class, () -> factory.getCreditCard("000"));
    }

}

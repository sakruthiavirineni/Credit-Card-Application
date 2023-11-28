package com.sakruthi.CreditCard;

public class DiscoverCC extends CreditCard {

    @Override
    public String toString() {
        return "Discover";
    }

    public static boolean isValid(String cardNumber) {
        return cardNumber.length() == 16 &&
                cardNumber.startsWith("6011");
    }
}

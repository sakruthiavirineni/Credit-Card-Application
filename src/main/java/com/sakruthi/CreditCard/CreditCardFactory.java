package com.sakruthi.CreditCard;

public class CreditCardFactory {
    public CreditCard getCreditCard(String cardNumber) {
        if (cardNumber.contains("*")) {
            throw new UnsupportedOperationException("Invalid: non numeric characters");
        } else if (cardNumber.length() > 19) {
            throw new UnsupportedOperationException("Invalid: more than 19 digits");
        } else if (cardNumber.isEmpty()) {
            throw new UnsupportedOperationException("Invalid: empty/null card number");
        } else if (MasterCC.isValid(cardNumber)) {
            return new MasterCC();
        } else if (VisaCC.isValid(cardNumber)) {
            return new VisaCC();
        } else if (AmExCC.isValid(cardNumber)) {
            return new AmExCC();
        } else if (DiscoverCC.isValid(cardNumber)) {
            return new DiscoverCC();
        } else {
            throw new UnsupportedOperationException("Invalid: not a possible card number");
        }
    }
}
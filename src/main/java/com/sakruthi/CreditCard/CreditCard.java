package com.sakruthi.CreditCard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAlias;

public class CreditCard {

    @JsonProperty("cardNumber")
    @JsonAlias({"CARD_NUMBER","CardNumber"})
    private String cardNumber;

    @JsonProperty("EXPIRATION_DATE")
    @JsonAlias({"expirationDate","ExpirationDate"})
    private String expirationDate;

    @JsonProperty("CARD_HOLDER_NAME")
    @JsonAlias({"cardHolderName","NameOfCardHolder"})
    private String nameOfCardholder;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getNameOfCardholder() {
        return nameOfCardholder;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setNameOfCardholder(String nameOfCardholder) {
        this.nameOfCardholder = nameOfCardholder;
    }
}
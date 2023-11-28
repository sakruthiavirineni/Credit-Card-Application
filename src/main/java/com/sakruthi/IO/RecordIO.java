package com.sakruthi.IO;

import com.sakruthi.CreditCard.CreditCard;

import java.util.List;

public interface RecordIO {
    List<CreditCard> read(String filename);

    boolean write(String filename, List<CreditCard> records);
}
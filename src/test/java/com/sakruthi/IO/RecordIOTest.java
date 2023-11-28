package com.sakruthi.IO;

import com.sakruthi.CreditCard.CreditCard;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecordIOTest {

    @Test
    public void test_readFromCsv() {
        String filename = "src/main/resources/input.csv";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5567894523129089", firstRecord.getCardNumber());
        assertEquals("08/26", firstRecord.getExpirationDate());
        assertEquals("John DoE", firstRecord.getNameOfCardholder());
    }

    @Test
    public void test_readFromXml() {
        String filename = "src/main/resources/input.xml";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5567894523129089", firstRecord.getCardNumber());
        assertEquals("08/26", firstRecord.getExpirationDate());
        assertEquals("John DoE", firstRecord.getNameOfCardholder());
    }

    @Test
    public void test_readFromJson() {
        String filename = "src/main/resources/input.json";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5567894523129089", firstRecord.getCardNumber());
        assertEquals("08/26", firstRecord.getExpirationDate());
        assertEquals("John DoE", firstRecord.getNameOfCardholder());
    }
}

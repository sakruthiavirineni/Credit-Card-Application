package com.sakruthi.IO;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sakruthi.CreditCard.CreditCard;
import com.sakruthi.CreditCard.CreditCardFactory;
import com.sakruthi.CreditCard.OutputRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//this class reads the input xml file.
public class XmlRecordIO implements RecordIO {

    @Override
    public List<CreditCard> read(String filename) {
        List<CreditCard> recordsList = new ArrayList<>();
        File file = new File(filename);
        try (Reader reader = new FileReader(file)) {
            MappingIterator<CreditCard> map = getXmlReader().readValues(reader);
            while (map.hasNext()) {
                CreditCard currentCC = map.next();
                recordsList.add(currentCC);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordsList;
    }

    // this class writes the output to the output.xml file.
    @Override
    public boolean write(String filename, List<CreditCard> inputRecords) {
        File file = new File(filename);
        List<OutputRecord> outputRecordList = get_Output_Records(inputRecords);
        try {
            getXmlMapper().writeValue(file, outputRecordList);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private XmlMapper getXmlMapper() {
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return mapper;
    }

    private ObjectReader getXmlReader() {
        return getXmlMapper().readerFor(CreditCard.class);
    }

    private List<OutputRecord> get_Output_Records(List<CreditCard> creditCards) {
        return creditCards
                .stream()
                .map(record -> {
                    String cardNumber = record.getCardNumber();
                    try {
                        return new OutputRecord(
                                cardNumber,
                                new CreditCardFactory().getCreditCard(cardNumber).toString());
                    } catch (UnsupportedOperationException e) {
                        return new OutputRecord(
                                cardNumber,
                                e.getMessage()
                        );
                    }
                })
                .collect(Collectors.toList());
    }
}
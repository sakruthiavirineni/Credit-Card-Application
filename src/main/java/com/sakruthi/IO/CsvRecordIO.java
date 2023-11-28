package com.sakruthi.IO;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

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

public class CsvRecordIO implements RecordIO {

    @Override
    public List<CreditCard> read(String filename) {
        List<CreditCard> recordsList = new ArrayList<>();
        File file = new File(filename);
        try (Reader reader = new FileReader(file)) {
            MappingIterator<CreditCard> map = getCsvReader().readValues(reader);
            while (map.hasNext()) {
                CreditCard current = map.next();
                recordsList.add(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordsList;
    }

    @Override
    public boolean write(String filename, List<CreditCard> records) {
        File file = new File(filename);
        List<OutputRecord> outputRecordList = getOutputRecords(records);
        try {
            ObjectWriter writer = getCsvMapper().writer(getOutputSchema());
            writer.writeValue(file, outputRecordList);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private ObjectReader getCsvReader() {
        CsvMapper mapper = getCsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        return mapper.readerFor(CreditCard.class).with(schema);
    }

    private CsvSchema getOutputSchema() {
        return CsvSchema.builder()
                .addColumn("CardNumber")
                .addColumn("CardType")
                .build()
                .withHeader();
    }

    private CsvMapper getCsvMapper() {
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return csvMapper;
    }

    private List<OutputRecord> getOutputRecords(List<CreditCard> creditCards) {
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
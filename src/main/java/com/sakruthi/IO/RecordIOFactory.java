package com.sakruthi.IO;

public class RecordIOFactory {
    public RecordIO getRecordIO(String fileName) {
        if (fileName.endsWith(".csv")) {
            return new CsvRecordIO();
        } else if (fileName.endsWith(".json")) {
            return new JsonRecordIO();
        } else if (fileName.endsWith(".xml")) {
            return new XmlRecordIO();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
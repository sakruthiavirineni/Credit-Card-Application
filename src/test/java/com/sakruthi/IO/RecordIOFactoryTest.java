package com.sakruthi.IO;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class RecordIOFactoryTest {

    @Test
    public void test_recordIOFactory_CSV() {
        RecordIOFactory factory = new RecordIOFactory();
        assert (factory.getRecordIO("file.csv") instanceof CsvRecordIO);
    }

    @Test
    public void test_recordIOFactory_XML() {
        RecordIOFactory factory = new RecordIOFactory();
        assert (factory.getRecordIO("file.xml") instanceof XmlRecordIO);
    }

    @Test
    public void test_recordIOFactory_JSON() {
        RecordIOFactory factory = new RecordIOFactory();
        assert (factory.getRecordIO("file.json") instanceof JsonRecordIO);
    }

    @Test
    public void test_recordIOFactory_unsupported() {
        RecordIOFactory factory = new RecordIOFactory();
        assertThrows(UnsupportedOperationException.class, () -> factory.getRecordIO("file.proto"));
    }

}


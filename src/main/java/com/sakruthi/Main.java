package com.sakruthi;

import com.sakruthi.CreditCard.CreditCard;
import com.sakruthi.IO.RecordIO;
import com.sakruthi.IO.RecordIOFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Invalid syntax. Usage: java Main <input filename> <output filename>");
            System.exit(1);
        }

        String inputFileName = args[0];
        String outputFileName = args[1];
        Utils.validatePaths(inputFileName, outputFileName);
        RecordIO io = new RecordIOFactory().getRecordIO(inputFileName);
        List<CreditCard> creditCards = io.read(inputFileName);
        boolean flag = io.write(outputFileName, creditCards);
        if (flag) {
            System.out.println("Compiled successfully and returned the output to " + outputFileName);
        } else {
            System.out.println("Failed to run, can't write the output");
        }
    }
}
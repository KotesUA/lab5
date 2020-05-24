package com.company;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class ReadSortWriteTest {
    static String inPath = "C:\\Users\\Kotes\\Desktop\\java_labs_kotes\\lab5\\in.txt";
    static String outPath = "C:\\Users\\Kotes\\Desktop\\java_labs_kotes\\lab5\\in.txt";
    static String[] expected = {"abcdef", "abcd", "ab"};

    @Test
    void testReadSortWrite() throws IOException {
        ReadSortWrite rsw = new ReadSortWrite(inPath, outPath);

        assertEquals(expected, getStringArrayFromFile(outPath));
    }

    private static String[] getStringArrayFromFile(String path){
        ArrayList<String> inData = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            String s;
            while((s = reader.readLine()) != null)
            {
                s = s.trim();
                if(!s.isEmpty()) inData.add(s);
            }
        }
        catch (IOException ex){ System.out.println(ex.getMessage()); }
        return inData.toArray(new String[inData.size()]);
    }
}
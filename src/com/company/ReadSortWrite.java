package com.company;

import java.io.*;
import java.util.ArrayList;

public class ReadSortWrite {
    private String inPath = "";
    private String outPath = "";

    public ReadSortWrite(String inpath, String outpath) throws IOException {
        this.inPath = inpath;
        this.outPath = outpath;
        work();
    };

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

    private static String[] sortStringArray(String[] array){
        String[] newArray = array.clone();
        for(int i = 0; i < newArray.length; ++i)
        {
            for(int j = 0; j < newArray.length; ++j)
            {
                if(newArray[i].length() < newArray[j].length()){
                    String s = newArray[j];
                    newArray[j] = newArray[i];
                    newArray[i] = s;
                }
            }
        }
        return newArray;
    }

    private static void writeToFile(String path, String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(text);
    }

    private static String arrayToString(String[] array){
        StringBuilder info = new StringBuilder();
        for (String s: array)
        {
            info.append(s).append("\r\n");
        }
        return info.toString();
    }

    private void work() throws IOException {
        writeToFile(this.outPath, arrayToString(sortStringArray(getStringArrayFromFile(this.inPath))));
    }
}

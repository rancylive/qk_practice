package com.xeuj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        fileReader("");
    }

    public static void fileReader(String file) {
        String fileName=file.equals("")?"/Users/ranjanchoudhury/old_bak/my/repo/glpdata/data/glp_1.xlsx":file;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

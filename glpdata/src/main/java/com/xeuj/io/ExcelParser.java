package com.xeuj.io;

import com.xeuj.vo.AssetLiabilityVO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelParser {
    private static final int ROW_HEADER_INDEX = 1;
    private static final int CHINA_INDEX = 2;
    private static final int JAPAN_INDEX = 3;
    private static final int BRAZIL_INDEX = 4;
    private static final int US_INDEX = 5;
    private static final int EUROPE_INDEX = 6;
    private static final int INDIA_INDEX = 7;
    private static final int OTHERS_INDEX = 8;
    private static final int TOTAL_ASSETS_ROW = 31;
    private static final int TOTAL_LIABILITY_ROW = 60;
    private static final double DOLLAR_TO_INR_RATE = 68.86;

    public static void main(String[] args) {
        ExcelParser parser = new ExcelParser();
        List<AssetLiabilityVO> voList = new LinkedList<>();
        parser.read("/Users/ranjanchoudhury/old_bak/my/repo/glpdata/data/glp_1.xlsx", voList);
        parser.write("/Users/ranjanchoudhury/old_bak/my/repo/glpdata/data/glp_1_parsed.xlsx", voList);
    }

    public void read(String file, List<AssetLiabilityVO> voList) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(1);
            Iterator<Row> rowIterator = sheet.iterator();
            int rowNum=0;
            while (rowIterator.hasNext()) {
                int colNum = 0;
                Row row = rowIterator.next();
                if (rowNum == TOTAL_ASSETS_ROW || rowNum == TOTAL_LIABILITY_ROW)
                {
                    AssetLiabilityVO assetLiability = new AssetLiabilityVO();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        if(colNum>8) {
                            break;
                        }
                        System.out.print(rowNum + "," + colNum + "\t");
                        Cell cell = cellIterator.next();
                        switch (colNum) {
                            case ROW_HEADER_INDEX:
                                assetLiability.setRowHeader(cell.getStringCellValue());
                                break;
                            case CHINA_INDEX:
                                assetLiability.setChina(cell.getNumericCellValue()*DOLLAR_TO_INR_RATE);
                                break;
                            case JAPAN_INDEX:
                                assetLiability.setJapan(cell.getNumericCellValue()*DOLLAR_TO_INR_RATE);
                                break;
                            case BRAZIL_INDEX:
                                assetLiability.setBrazil(cell.getNumericCellValue()*DOLLAR_TO_INR_RATE);
                                break;
                            case US_INDEX:
                                assetLiability.setOthers(assetLiability.getOthers()+cell.getNumericCellValue()*DOLLAR_TO_INR_RATE);
                                break;
                            case EUROPE_INDEX:
                                assetLiability.setOthers(assetLiability.getOthers()+cell.getNumericCellValue()*DOLLAR_TO_INR_RATE);
                                break;
                            case INDIA_INDEX:
                                assetLiability.setOthers(assetLiability.getOthers()+cell.getNumericCellValue()*DOLLAR_TO_INR_RATE);
                                break;
                            case OTHERS_INDEX:
                                assetLiability.setOthers(assetLiability.getOthers()+cell.getNumericCellValue()*DOLLAR_TO_INR_RATE);
                                break;
                        }
                        colNum++;
                    }
                    voList.add(assetLiability);
                }
                rowNum++;
            }
            System.out.println("VOLIST: "+voList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String file, List<AssetLiabilityVO> data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("1_GLP_Parsed");
        int rowNum = 0;
        XSSFRow header = sheet.createRow(rowNum);
        XSSFCell heading = header.createCell(0);
        heading.setCellValue("");
        XSSFCell chinaheading = header.createCell(1);
        chinaheading.setCellValue("China");
        XSSFCell japanheading = header.createCell(2);
        japanheading.setCellValue("Japan");
        XSSFCell brazilheading = header.createCell(3);
        brazilheading.setCellValue("Brazil");
        XSSFCell otherheading = header.createCell(4);
        otherheading.setCellValue("Others");
        for(AssetLiabilityVO vo:data) {
            rowNum++;
            XSSFRow row = sheet.createRow(rowNum);
            XSSFCell rowHeader = row.createCell(0);
            rowHeader.setCellValue(vo.getRowHeader());
            XSSFCell china = row.createCell(1);
            china.setCellValue(vo.getChina());
            XSSFCell japan = row.createCell(2);
            japan.setCellValue(vo.getJapan());
            XSSFCell brazil = row.createCell(3);
            brazil.setCellValue(vo.getBrazil());
            XSSFCell other = row.createCell(4);
            other.setCellValue(vo.getOthers());
        }
        try {
            workbook.write(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

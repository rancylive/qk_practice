package com.xeuj.vo;

public class AssetLiabilityVO {
    private String rowHeader;
    private double china;
    private double japan;
    private double brazil;
    private double others;

    public String getRowHeader() {
        return rowHeader;
    }

    public void setRowHeader(String rowHeader) {
        this.rowHeader = rowHeader;
    }

    public double getChina() {
        return china;
    }

    public void setChina(double china) {
        this.china = china;
    }

    public double getJapan() {
        return japan;
    }

    public void setJapan(double japan) {
        this.japan = japan;
    }

    public double getBrazil() {
        return brazil;
    }

    public void setBrazil(double brazil) {
        this.brazil = brazil;
    }

    public double getOthers() {
        return others;
    }

    public void setOthers(double others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "AssetLiabilityVO{" +
                "rowHeader='" + rowHeader + '\'' +
                ", china=" + china +
                ", japan=" + japan +
                ", brazil=" + brazil +
                ", others=" + others +
                '}';
    }
}

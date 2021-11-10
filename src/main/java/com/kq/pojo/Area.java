package com.kq.pojo;

public class Area {

    private String address;
    private int sums;

    public Area() {
    }

    public Area(String address, int sums) {
        this.address = address;
        this.sums = sums;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSums() {
        return sums;
    }

    public void setSums(int sums) {
        this.sums = sums;
    }

    @Override
    public String toString() {
        return "Area{" +
                "address='" + address + '\'' +
                ", sums=" + sums +
                '}';
    }
}

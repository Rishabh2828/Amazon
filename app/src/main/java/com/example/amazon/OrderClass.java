package com.example.amazon;

public class OrderClass {

    String Address, MobileNumber, Quanity;

    public OrderClass(String address, String mobileNumber, String quanity) {
        Address = address;
        MobileNumber = mobileNumber;
        Quanity = quanity;
    }

    public OrderClass() {
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getQuanity() {
        return Quanity;
    }

    public void setQuanity(String quanity) {
        Quanity = quanity;
    }
}

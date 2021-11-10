package com.gakubia.assignment5;

public class Fees {
    String Paid;
    String IDNumber;
    String ExpectedAmount;
    String Status;

    public Fees() {
    }

    public Fees(String paid, String IDNumber, String expectedAmount, String status) {
        this.Paid = paid;
        this.IDNumber = IDNumber;
        this.ExpectedAmount = expectedAmount;
        this.Status = status;
    }

    public String getPaid() {
        return Paid;
    }

    public void setPaid(String paid) {
        Paid = paid;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getExpectedAmount() {
        return ExpectedAmount;
    }

    public String setExpectedAmount(String expectedAmount) {
        return ExpectedAmount = expectedAmount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}

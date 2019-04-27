package com.example.a1606020003_nguyenhoangbao;

public class PhoneModel {
    private  int ID;
    private String Product_Name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDesrciption() {
        return Desrciption;
    }

    public void setDesrciption(String desrciption) {
        Desrciption = desrciption;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    private  int Price;
    private  String Desrciption;
    private  String Producer;
}

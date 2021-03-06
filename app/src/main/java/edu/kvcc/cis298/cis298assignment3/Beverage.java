package edu.kvcc.cis298.cis298assignment3;

import java.math.BigDecimal;

/**
 * Created by jmartin5229 on 11/12/2015.
 */
public class Beverage {  // CLASS TO HOLD ONE BEVERAGE (Example data: 75981,1805 Merlot,750 ml,48.32,True)
    private int mId;
    private String mName;
    private String mPack;
    private Double mPrice;
    private Boolean mActive;

    //5 PARAMETER CONSTRUCTOR TO MAKE A NEW BEVERAGE
    public  Beverage(int id, String name, String pack, double price, boolean active){
        mId = id;
        mName =name;
        mPack =pack;
        mPrice = price;
        mActive = active;
    }

    //GETTERS AND SETTERS

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPack() {
        return mPack;
    }

    public void setPack(String pack) {
        mPack = pack;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public Boolean getActive() {
        return mActive;
    }

    public void setActive(Boolean active) {
        mActive = active;
    }
}

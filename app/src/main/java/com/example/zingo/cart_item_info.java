package com.example.zingo;

public class cart_item_info {

    private  String mreturnid;
    private String mretailerid;
    private String mproductname;
    private String mreason;
    private String mbarcode;
    private String mbatchno;
    private String mmfgdate;
    private String mexpdate;
    private String mmrp;

    public cart_item_info(String rid,String reid,String pid,String rea,String bar,String batch,String mfg,String exp,String mrp){
        mreturnid = rid;
        mretailerid = reid;
        mproductname = pid;
        mreason = rea;
        mbarcode = bar;
        mbatchno = batch;
        mmfgdate = mfg;
        mexpdate = exp;
        mmrp = mrp;
    }

    public String getMreturnid() {
        return mreturnid;
    }

    public String getMretailerid() {
        return mretailerid;
    }

    public String getMreason() {
        return mreason;
    }

    public String getMproductname() {
        return mproductname;
    }

    public String getMmfgdate() {
        return mmfgdate;
    }

    public String getMexpdate() {
        return mexpdate;
    }

    public String getMbatchno() {
        return mbatchno;
    }

    public String getMbarcode() {
        return mbarcode;
    }

    public String getMmrp() {
        return mmrp;
    }
}

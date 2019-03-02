package com.example.zingo;

public class reatiler_info {

    private String mretailer_id;
    private String mretailer_name;
    private String mretailer_number;
    private String mretailer_address;

    public reatiler_info(String uid,String name,String number,String address){
        mretailer_id = uid;
        mretailer_name = name;
        mretailer_number = number;
        mretailer_address = address;

    }

    public String getMretailer_id() {
        return mretailer_id;
    }

    public String getMretailer_name() {
        return mretailer_name;
    }

    public String getMretailer_number() {
        return mretailer_number;
    }

    public String getMretailer_address() {
        return mretailer_address;
    }
}

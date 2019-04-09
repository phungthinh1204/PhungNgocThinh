package com.example.admin.docbaoonline.Link;

public class Links {

    final String localhost = "192.168.0.118";

    public String link24h(){
        String link = "http://"+localhost+"/nam/dulieuappdocbao/jsonBaoMoi.php";
        return link;
    }

    public String dantri(){
        String link = "http://"+localhost+"/nam/dulieuappdocbao/json24h.php";
        return link;
    }

}

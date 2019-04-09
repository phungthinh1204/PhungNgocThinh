package com.example.admin.docbaoonline;

import com.example.admin.docbaoonline.ClassObject.Bao;

import java.util.ArrayList;

/**
 * Created by Admin on 8/2/2018.
 */

public class ArrayDanhMucBao {

    public ArrayList<Bao> danhMucBaos(){
        ArrayList<Bao> DMBao = new ArrayList<>();
        DMBao.add(new Bao(R.drawable.vnexpress,"VNExpress"));
        DMBao.add(new Bao(R.drawable.dantrri,"DanTri"));
        DMBao.add(new Bao(R.drawable.haitugio,"DanTri"));
        return DMBao;
    }

}

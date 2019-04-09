package com.example.admin.docbaoonline.ClassObject;

import com.example.admin.docbaoonline.ClassObject.Bao;
import com.example.admin.docbaoonline.R;

import java.util.ArrayList;

/**
 * Created by Admin on 8/2/2018.
 */

// Dùng để hiển thị danh sách tin tức

public class DanhSachBao {

    public ArrayList<Bao> LayDanhSachBao(){
        ArrayList<Bao> DanhSachBao = new ArrayList<>();
        DanhSachBao.add(new Bao(R.drawable.vnexpress,"VNExpress"));
        DanhSachBao.add(new Bao(R.drawable.dantrri,"DanTri"));
        DanhSachBao.add(new Bao(R.drawable.haitugio,"24H"));
        DanhSachBao.add(new Bao(R.drawable.tuoitre,"Tuổi Trẻ"));
        DanhSachBao.add(new Bao(R.drawable.vietnamnet,"Vietnamnet"));
        return DanhSachBao;
    }

}

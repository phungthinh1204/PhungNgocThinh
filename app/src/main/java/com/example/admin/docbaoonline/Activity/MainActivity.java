package com.example.admin.docbaoonline.Activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.admin.docbaoonline.ClassObject.DanhSachBao;
import com.example.admin.docbaoonline.ClassObject.Bao;
import com.example.admin.docbaoonline.ClassObject.DanhMucBao;
import com.example.admin.docbaoonline.CustomView.CustomDanhMucBao;
import com.example.admin.docbaoonline.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar nToolbar;
    DrawerLayout drawer;
    GridView grvDanhSachBao;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        actionToolbar();
        ActionDanhMucBao();
    }

    private void ActionDanhMucBao() {
        DanhSachBao arrayDanhSachBaoBao = new DanhSachBao();
        ArrayList<Bao> baos = arrayDanhSachBaoBao.LayDanhSachBao();
        CustomDanhMucBao customDanhMucBao = new CustomDanhMucBao(this,R.layout.item_listview_dsbao,baos);
        grvDanhSachBao.setAdapter(customDanhMucBao);
        grvDanhSachBao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    Intent intent = new Intent(MainActivity.this, ScreenSlideActivity.class);
                    ArrayList<DanhMucBao> arrDanhMucBao = new ArrayList<>();
                    arrDanhMucBao.add(new DanhMucBao("Trang Chủ", StaticDataVNExpress.urlTrangChu));
                    arrDanhMucBao.add(new DanhMucBao("Cộng Đồng",StaticDataVNExpress.urlCongDong));
                    arrDanhMucBao.add(new DanhMucBao("Giải Trí",StaticDataVNExpress.urlGiaiTri));
                    arrDanhMucBao.add(new DanhMucBao("Thời Sự",StaticDataVNExpress.urlThoiSu));
                    arrDanhMucBao.add(new DanhMucBao("Giáo Dục",StaticDataVNExpress.urlGiaoDuc));
                    arrDanhMucBao.add(new DanhMucBao("Du Lịch",StaticDataVNExpress.urlDuLich));
                    arrDanhMucBao.add(new DanhMucBao("Khoa Học",StaticDataVNExpress.urlKhoaHoc));
                    arrDanhMucBao.add(new DanhMucBao("Gia Đình",StaticDataVNExpress.urlGiaDinh));
                    arrDanhMucBao.add(new DanhMucBao("Kinh Doanh",StaticDataVNExpress.urlKinhDoanh));
                    arrDanhMucBao.add(new DanhMucBao("Pháp Luật",StaticDataVNExpress.urlPhapLuat));
                    arrDanhMucBao.add(new DanhMucBao("Số Hóa",StaticDataVNExpress.urlSoHoa));
                    arrDanhMucBao.add(new DanhMucBao("Startup",StaticDataVNExpress.urlStartUp));
                    arrDanhMucBao.add(new DanhMucBao("Sức Khỏe",StaticDataVNExpress.urlSucKhoe));
                    arrDanhMucBao.add(new DanhMucBao("Tâm Sự",StaticDataVNExpress.urlTamSu));
                    arrDanhMucBao.add(new DanhMucBao("Thế Giới",StaticDataVNExpress.urlTheGioi));
                    arrDanhMucBao.add(new DanhMucBao("Thể Thao",StaticDataVNExpress.urlTheThao));
                    arrDanhMucBao.add(new DanhMucBao("Xe",StaticDataVNExpress.urlXe));
                    arrDanhMucBao.add(new DanhMucBao("Cười",StaticDataVNExpress.urlCuoi));
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("DANHMUCBAOBUNDLE",arrDanhMucBao);
                    intent.putExtra("LISTDANHMUCBAO",bundle);
                    startActivity(intent);
                }else if (i == 1){
//                    Intent intent = new Intent(MainActivity.this, ScreenSlideActivity.class);
//                    ArrayList<DanhMucBao> arrDanhMucBao = new ArrayList<>();
//                    arrDanhMucBao.add(new DanhMucBao("Trang Chủ", "http://dantri.com.vn/trangchu.rss"));
//                    arrDanhMucBao.add(new DanhMucBao("Xã Hội","http://dantri.com.vn/xa-hoi.rss"));
//                    arrDanhMucBao.add(new DanhMucBao("Giải Trí","http://dantri.com.vn/giai-tri.rss"));
//                    arrDanhMucBao.add(new DanhMucBao("Thể thao","http://dantri.com.vn/the-thao.rss"));
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("DANHMUCBAOBUNDLE",arrDanhMucBao);
//                    intent.putExtra("LISTDANHMUCBAO",bundle);
//                    startActivity(intent);

                    Intent intent = new Intent(MainActivity.this, MyPost.class);
                    startActivity(intent);

                }
                else if (i == 2){
//                    Intent intent = new Intent(MainActivity.this, ScreenSlideActivity.class);
//                    ArrayList<DanhMucBao> arrDanhMucBao = new ArrayList<>();
//                    arrDanhMucBao.add(new DanhMucBao("Trang Chủ", "http://24h.com.vn/upload/rss/trangchu24h.rss"));
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("DANHMUCBAOBUNDLE",arrDanhMucBao);
//                    intent.putExtra("LISTDANHMUCBAO",bundle);
//                    startActivity(intent);

                    Intent intent = new Intent(MainActivity.this, Post24hActivity.class);
                    startActivity(intent);

                }
                else if (i == 3){
//                    Intent intent = new Intent(MainActivity.this, ScreenSlideActivity.class);
//                    ArrayList<DanhMucBao> arrDanhMucBao = new ArrayList<>();
//                    arrDanhMucBao.add(new DanhMucBao("Trang Chủ", "https://tuoitre.vn/rss/tin-moi-nhat.rss"));
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("DANHMUCBAOBUNDLE",arrDanhMucBao);
//                    intent.putExtra("LISTDANHMUCBAO",bundle);
//                    startActivity(intent);

                    Intent intent = new Intent(MainActivity.this, PostsTuoiTreActivity.class);
                    startActivity(intent);

                }
                else if (i == 4){
//                    Intent intent = new Intent(MainActivity.this, ScreenSlideActivity.class);
//                    ArrayList<DanhMucBao> arrDanhMucBao = new ArrayList<>();
//                    arrDanhMucBao.add(new DanhMucBao("Trang Chủ", "http://vietnamnet.vn/rss/home.rss"));
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("DANHMUCBAOBUNDLE",arrDanhMucBao);
//                    intent.putExtra("LISTDANHMUCBAO",bundle);
//                    startActivity(intent);

                    Intent intent = new Intent(MainActivity.this, PostVNNetActivity.class);
                    startActivity(intent);

                }
            }
        });
    }

    private void actionToolbar() {
        setSupportActionBar(nToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nToolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        nToolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        drawer.openDrawer(GravityCompat.START);
                    }
                }
        );

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        switch (menuItem.getItemId())
                        {
                            case R.id.menuDocTrucTuyen:
                                break;
                            case R.id.menuTinDaLuu:
                                Intent intent = new Intent(MainActivity.this,DocBaoOfflineActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menuTuyChinh:
                                Intent intent1 = new Intent(MainActivity.this,SettingActivity.class);
                                startActivity(intent1);
                                break;
                        }
                        drawer.closeDrawers();
                        return true;
                    }
                });
    }

    private void anhXa() {
        nToolbar = findViewById(R.id.toolbar_trangchu);
        drawer = findViewById(R.id.drawer);
        grvDanhSachBao = findViewById(R.id.grvDanhSachBao);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
    }
}

package com.example.admin.docbaoonline.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.docbaoonline.ClassObject.OfflineRSSItem;
import com.example.admin.docbaoonline.ClassObject.Post;
import com.example.admin.docbaoonline.CustomView.AdapterListBaiBaoOffline;
import com.example.admin.docbaoonline.Database.DBOfflineRSSItem;
import com.example.admin.docbaoonline.Database.DBPosts;
import com.example.admin.docbaoonline.R;

import java.util.ArrayList;
import java.util.List;


public class DocBaoOfflineActivity extends AppCompatActivity {

    ListView lvDanhSachBaiBaoOffline;
    DBOfflineRSSItem dbOfflineRSSItem;
    Toolbar nToolbar;
    DrawerLayout drawer;
    List<OfflineRSSItem> offlineRSSItems = new ArrayList<>();
    AdapterListBaiBaoOffline adapterListBaiBaoOffline;
    NavigationView navigationView;


    DBPosts dbPosts;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docbaooffline);
        nToolbar = findViewById(R.id.toolbar_trangchu);
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationview);
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
                                Intent intent = new Intent(DocBaoOfflineActivity.this,MainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menuTinDaLuu:
                                break;
                            case R.id.menuTuyChinh:
                                Intent intent1 = new Intent(DocBaoOfflineActivity.this,SettingActivity.class);
                                startActivity(intent1);
                                break;
                        }
                        drawer.closeDrawers();
                        return true;
                    }
                });
        lvDanhSachBaiBaoOffline = findViewById(R.id.lvDSBaiBaoOffLine);
        registerForContextMenu(lvDanhSachBaiBaoOffline);

        dbOfflineRSSItem = new DBOfflineRSSItem(DocBaoOfflineActivity.this);
        dbPosts = new DBPosts(DocBaoOfflineActivity.this);

        offlineRSSItems = dbOfflineRSSItem.getAlLOffLineItemRss();
//        for (int i = 0; i<dbPosts.getAllPosts().size(); i++){
//
//            String title = dbPosts.getAllPosts().get(i).getPost_title();
//            String description = dbPosts.getAllPosts().get(i).getPost_desc();
//            String content = dbPosts.getAllPosts().get(i).getPost_content();
//            String urlImg = dbPosts.getAllPosts().get(i).getPost_thumb();
//
//
//        }


        Toast.makeText(this,offlineRSSItems.size() + "",Toast.LENGTH_SHORT).show();
        adapterListBaiBaoOffline = new AdapterListBaiBaoOffline(DocBaoOfflineActivity.this,R.layout.item_listview_dsbaibao,offlineRSSItems);
        lvDanhSachBaiBaoOffline.setAdapter(adapterListBaiBaoOffline);

        lvDanhSachBaiBaoOffline.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DocBaoOfflineActivity.this,NoiDungBao.class);
                intent.putExtra("ndBaiBao",offlineRSSItems.get(i).getContent());
                startActivity(intent);
            }
        });

        lvDanhSachBaiBaoOffline.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int positon = i;

                Toast.makeText(DocBaoOfflineActivity.this, "Xoasss", Toast.LENGTH_SHORT).show();

                final AlertDialog.Builder builder = new AlertDialog.Builder(DocBaoOfflineActivity.this);
                builder.setTitle("Alert!!");
                builder.setMessage("Bạn có muốn xóa!!!");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbOfflineRSSItem.delete(offlineRSSItems.get(positon));
                        offlineRSSItems.clear();
                        offlineRSSItems.addAll(dbOfflineRSSItem.getAlLOffLineItemRss());
                        adapterListBaiBaoOffline.notifyDataSetChanged();

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
                return false;
            }
        });

    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        menu.add(0,v.getId(),0,"Xóa");
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
//        if(item.getTitle()=="Xóa"){
//           dbOfflineRSSItem.delete(offlineRSSItems.get(info.position));
//           offlineRSSItems.clear();
//           offlineRSSItems.addAll(dbOfflineRSSItem.getAlLOffLineItemRss());
//           adapterListBaiBaoOffline.notifyDataSetChanged();
//        }
//        return super.onContextItemSelected(item);
//    }

}

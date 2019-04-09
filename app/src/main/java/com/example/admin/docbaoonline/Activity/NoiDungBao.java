package com.example.admin.docbaoonline.Activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.admin.docbaoonline.ClassObject.ItemsRss;
import com.example.admin.docbaoonline.ClassObject.OfflineRSSItem;
import com.example.admin.docbaoonline.Database.DBOfflineRSSItem;
import com.example.admin.docbaoonline.R;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class NoiDungBao extends AppCompatActivity {

    WebView noiDungBaiBao;
    ProgressBar progressBar;
    Toolbar nToolbar;
    private OfflineRSSItem offlineRSSItem;
    AppCompatImageView imgSave,imgShare;
    DBOfflineRSSItem itemRssController;
    ShareLinkContent shareLinkContent;
    ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noidungbao_activity);
        anhXa();
        shareDialog = new ShareDialog(this);
        Actions();
        itemRssController = new DBOfflineRSSItem(NoiDungBao.this);
        offlineRSSItem = (OfflineRSSItem) getIntent().getSerializableExtra("OfflineRSSItem");
    }


    private void Actions() {
        Intent intent = getIntent();
        String noidunglayduoc = intent.getStringExtra("ndBaiBao");
        final String url = intent.getStringExtra("URL");
        noiDungBaiBao.loadData("<html><head><style>img{display: inline; height: auto; max-width: 100%;}</style></head><body>" + noidunglayduoc + "</body></html>", "text/html", "UTF-8");

        noiDungBaiBao.setVisibility(View.VISIBLE);
        noiDungBaiBao.getSettings().setJavaScriptEnabled(true);
        noiDungBaiBao.setWebViewClient(new WebViewClient(){
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Toast.makeText(NoiDungBao.this,"Đang tải dữ liệu",Toast.LENGTH_SHORT).show();
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                noiDungBaiBao.setVisibility(View.VISIBLE);
                Toast.makeText(NoiDungBao.this,"Tải dữ liệu thành công",Toast.LENGTH_SHORT).show();
            }
        });

        imgSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(NoiDungBao.this);
                builder.setTitle("Bạn muốn lưu tin?");
                builder.setMessage("Tin sẽ được lưu lại để đọc khi không có mạng");
                builder.setNegativeButton("Thôi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        long ok = itemRssController.Insert(offlineRSSItem);
                        if (ok > 0) {
                            Toast.makeText(NoiDungBao.this, "Đã lưu!" , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.create().show();
            }
        });

        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ShareDialog.canShow(ShareLinkContent.class)){
                    shareLinkContent = new ShareLinkContent.Builder()
                            .setContentUrl(Uri.parse(url)).build();
                }
                shareDialog.show(shareLinkContent);
            }
        });
    }

    private void anhXa() {
        noiDungBaiBao = findViewById(R.id.webviewbaibao);
        progressBar = findViewById(R.id.progressbar);
        nToolbar = findViewById(R.id.toolbar_noidungbao);
        imgSave = findViewById(R.id.imgSave);
        imgShare = findViewById(R.id.imgShare);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}

package com.example.admin.docbaoonline.CustomView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.docbaoonline.ClassObject.Bao;
import com.example.admin.docbaoonline.R;

import java.util.List;

/**
 * Created by Admin on 8/2/2018.
 */

public class CustomDanhMucBao extends ArrayAdapter<Bao> {

    Context context;
    int resource;
    List<Bao> objects;

    public CustomDanhMucBao(@NonNull Context context, int resource, @NonNull List<Bao> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Viewholder viewholder;
        if (convertView == null){
            viewholder = new Viewholder();

            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_dsbao,parent,false);
            viewholder.mIcon = convertView.findViewById(R.id.imageview_icon);
            viewholder.tenDanhMuc = convertView.findViewById(R.id.textview_tendanhmuc);

            convertView.setTag(viewholder);

        }else {
            viewholder = (Viewholder) convertView.getTag();
        }

        Bao danhMucBao = objects.get(position);
        viewholder.mIcon.setImageResource(danhMucBao.getIcon());
        viewholder.tenDanhMuc.setText(danhMucBao.getTenBao());
        return convertView;
    }

    public class Viewholder{
        ImageView mIcon;
        TextView tenDanhMuc;
    }

}

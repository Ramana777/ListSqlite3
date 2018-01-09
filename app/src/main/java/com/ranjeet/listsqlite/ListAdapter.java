package com.ranjeet.listsqlite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.provider.ContactsContract.CommonDataKinds.Organization.DEPARTMENT;

/**
 * Created by admin on 1/3/2018.
 */

public class ListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Listitems> deptlist;

    public ListAdapter(Context context, int layout, ArrayList<Listitems> deptlist) {
        this.context = context;
        this.layout = layout;
        this.deptlist = deptlist;
    }

    @Override
    public int getCount() {
        return deptlist.size();
    }

    @Override
    public Object getItem(int position) {
        return deptlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textname, textdept, textmobile;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
            View row = view;
            ViewHolder holder = new ViewHolder();
            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(layout, null);
                holder.textname = (TextView) row.findViewById(R.id.name);
                holder.textdept = (TextView) row.findViewById(R.id.dept);
                holder.textmobile = (TextView) row.findViewById(R.id.mobileno);
                holder.imageView = (ImageView) row.findViewById(R.id.image);
                row.setTag(holder);
            } else {
                holder = (ViewHolder) row.getTag();
            }
            Listitems department = deptlist.get(position);
            holder.textname.setText(department.getName());
            holder.textdept.setText(department.getDept());
            holder.textmobile.setText(department.getMobileno());
            byte[] foodimage = department.getImage();
            Bitmap bitmap = BitmapFactory.decodeByteArray(foodimage, 0, foodimage.length);
            holder.imageView.setImageBitmap(bitmap);
            return row;
        }
    }


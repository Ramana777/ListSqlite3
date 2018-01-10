package com.ranjeet.listsqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.provider.ContactsContract.CommonDataKinds.Organization.DEPARTMENT;

/**
 * Created by admin on 1/3/2018.
 */

public class Itemlists extends AppCompatActivity {
    ListView listView;
    ListAdapter adapter = null;
    ArrayList<Listitems> list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list);
        listView = (ListView) findViewById(R.id.list);
        list = new ArrayList();
        adapter = new ListAdapter(this, R.layout.alldata_list, list);
        listView.setAdapter(adapter);
        //get all data from sqlite database
        Cursor cursor = MainActivity.mydb.getData("SELECT * FROM DEPARTMENT");
        list.clear();
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            String dept = cursor.getString(2);
            String mobileno = cursor.getString(3);
            byte[] image = cursor.getBlob(4);
            list.add(new Listitems(name, dept, mobileno, image));
        }
        adapter.notifyDataSetChanged();

    }
}

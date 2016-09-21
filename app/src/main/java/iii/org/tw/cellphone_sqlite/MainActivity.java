package iii.org.tw.cellphone_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView showtxt;
    private MyDBHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showtxt = (TextView) findViewById(R.id.showtxt);

        dbHelper = new MyDBHelper(this,"Abner",null,1);
        db = dbHelper.getReadableDatabase();
    }

    public void Insert(View v) {
        // INSERT INTO cust (cname,tel,birthday) VALUES ('brad','123','1999-01-02');
        ContentValues data = new ContentValues();
        data.put("cname", "Abner");
        data.put("tel", "456");
        data.put("birthday","2000-11-22");
        db.insert("customer",null,data);
        Search(null);
    }

    public void Search(View v) {
//        //----- Select * From customer
//        showtxt.setText("");
//        Cursor c = db.query("customer",null,null,null,null,null,null);
//        while (c.moveToNext()){
//            String id = c.getString(c.getColumnIndex("id"));
//            String cname = c.getString(c.getColumnIndex("cname"));
//            String tel = c.getString(c.getColumnIndex("tel"));
//            String birthday = c.getString(c.getColumnIndex("birthday"));
//            showtxt.append(id+":"+cname+":"+tel+":"+birthday+"\n");
//        }
        //-----Select cname,tel,birthday From customer
        showtxt.setText("");
        Cursor c = db.query("customer",null,null,null,null,null,null);
        while (c.moveToNext()){
            String id = c.getString(c.getColumnIndex("id"));
            String cname = c.getString(c.getColumnIndex("cname"));
            String tel = c.getString(c.getColumnIndex("tel"));
            String birthday = c.getString(c.getColumnIndex("birthday"));
            showtxt.append(id+":"+cname+":"+tel+":"+birthday+"\n");
        }
    }

    public void Update(View v) {
        ContentValues data = new ContentValues();
        data.put("cname","Kevin");
        data.put("tel","789456");
        db.update("customer",data,"id = ?",new String[]{"2"});
        Search(null);
    }

    public void Delete(View v) {
        //-----DELETE FROM customer WHERE id = 3 and cname = Abner;
        db.delete("customer","id = ? and cname = ?",new String[]{"3","Abner"});
        Search(null);
    }
}

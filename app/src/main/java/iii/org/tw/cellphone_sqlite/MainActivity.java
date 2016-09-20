package iii.org.tw.cellphone_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView showtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showtxt = (TextView) findViewById(R.id.showtxt);
    }

    public void Insert(View v) {

    }

    public void Search(View v) {

    }

    public void Update(View v) {

    }

    public void Delete(View v) {

    }
}

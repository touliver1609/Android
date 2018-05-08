package vn.edu.ou.gridviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtMsg;
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = (TextView) findViewById(R.id.txtMsg);
        gv = (GridView) findViewById(R.id.mygrid);

        ArrayAdapter aa = ArrayAdapter.createFromResource(this, R.array.data, android.R.layout.simple_list_item_1);
        gv.setAdapter(aa);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtview = (TextView) view;
                txtMsg.setText(txtview.getText().toString());
            }
        });
    }
}

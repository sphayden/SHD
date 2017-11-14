package test.studenthelpdesk;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class Work_Orders extends AppCompatActivity {

    private ArrayAdapter WO;
    private String[] arraySpinner;
    MainActivity m = new MainActivity();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work__orders);
        Bundle bundle = getIntent().getExtras();
        String gname = bundle.getString("gname");


       // EditText filter = (EditText) findViewById(R.id.searchFilter);
        String[] loc = {"Boone, Missouri", "Hancock, Indiana", "New York, New York", "Stone, Missouri", "Slums, Arkansas",
                "Franklin, Massachusetts", "Giles, Virginia", "Hillsdale, Michigan", "Meade, Kentucky", "Harper, Kansas",
                "Linn, Iowa", "Newton, Indiana","DuPage, Illinois","Worth, Georgia","Kalawao, Hawaii"};
        WO = new customAdapter(this, loc);
        ListView AwareView = (ListView) findViewById(R.id.AwareView);
        AwareView.setAdapter(WO);
        TextView t = (TextView) findViewById(R.id.searchFilter);
        t.setText(this.getIntent().getStringExtra(gname));



      /*  filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (Work_Orders.this).WO.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });*/

        this.arraySpinner = new String[] {
                "1", "2", "3", "4", "5"
        };

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });
    }
}

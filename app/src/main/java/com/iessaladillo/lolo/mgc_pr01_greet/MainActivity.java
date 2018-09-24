package com.iessaladillo.lolo.mgc_pr01_greet;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private EditText txtName;
    private EditText txtSirName;
    private String fullName;
    private CheckBox cbPolitely;
    private Button btnGreet;
    private Button btnReset;
    private TextView greet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        txtName = findViewById(R.id.txtName);
        txtSirName = findViewById(R.id.txtSirName);
        cbPolitely = findViewById(R.id.cb_politely);
        btnGreet = findViewById(R.id.btnGreet);
        btnReset = findViewById(R.id.btnReset);
        greet = findViewById(R.id.Greet);
        btnGreet.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        fullName = String.format(" %s %s.", txtName.getText(), txtSirName.getText());
        int id = v.getId();
        if (id == R.id.btnGreet) {
            if (cbPolitely.isChecked()) {
                //greet.setText(getString(R.string.politemsg, txtName.getText()));
                greet.setText(getString(R.string.politemsg) + fullName);
            } else
                greet.setText(getString(R.string.unpolitemsg) + fullName);

        }
        else if (id == R.id.btnReset){
            txtName.setText(R.string.emptyText);
            txtSirName.setText(R.string.emptyText);
            greet.setText(R.string.emptyText);
            cbPolitely.setChecked(false);
        }
    }


}

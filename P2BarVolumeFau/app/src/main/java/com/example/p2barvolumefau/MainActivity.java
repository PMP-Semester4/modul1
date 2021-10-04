package com.example.p2barvolumefau;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtWidth, edtHeight, edtLength;
    private Button btnCalculate;
    private TextView tvResult;
    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, tvResult.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidth = (EditText)findViewById(R.id.edtWidth);
        edtHeight = (EditText)findViewById(R.id.edtHeight);
        edtLength = (EditText)findViewById(R.id.edtLength);
        Button btnCalculate = (Button) findViewById(R.id.btnCalculate);
        tvResult = (TextView)findViewById(R.id.tvResult);
        btnCalculate.setOnClickListener(this);
        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculate){
            String length = edtLength.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            String height = edtHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(length)){
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(width)){
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(height)){
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l * w * h;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}
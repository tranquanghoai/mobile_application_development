package com.currencyconverter.quanghoai.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnConvert;
    private EditText edtInput;
    private TextView tvResult;
    private Spinner spnFrom;
    private Spinner spnTo;
    private TextView tvInput;
    private TextView tvOuput;
    //private String typeInput,typeOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayout);
        btnConvert=(Button)findViewById(R.id.btn_convert);
        edtInput=(EditText)findViewById(R.id.edt_input);
        tvResult=(TextView)findViewById(R.id.tv_result);
        spnFrom=(Spinner) findViewById(R.id.spn_from);
        spnTo=(Spinner)findViewById(R.id.spn_to);
        tvInput=(TextView)findViewById(R.id.tv_input);
        tvOuput=(TextView)findViewById(R.id.tv_output);
        List <String> list = new ArrayList<>();
        list.add("VND");
        list.add("USD");
        list.add("EUR");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
        spnFrom.setAdapter(adapter);
        spnTo.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvInput.setText(spnFrom.getSelectedItem().toString());
                tvResult.setText("0");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spnTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvOuput.setText(spnTo.getSelectedItem().toString());
                tvResult.setText("0");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tvResult.setText(edtInput.getText().toString());
                if(tvInput.getText().toString()=="VND"){
                    if(tvOuput.getText().toString()=="VND"){
                        tvResult.setText(edtInput.getText().toString());
                    }
                    if(tvOuput.getText().toString()=="USD"){
                        Float vnd= Float.parseFloat(edtInput.getText().toString());
                        Float usd=vnd/22800;
                        tvResult.setText(usd.toString());
                    }
                    if(tvOuput.getText().toString()=="EUR"){
                        Float vnd= Float.parseFloat(edtInput.getText().toString());
                        Float eur=vnd/28000;
                        tvResult.setText(eur.toString());
                    }
                }
                if(tvInput.getText().toString()=="USD"){
                    if(tvOuput.getText().toString()=="VND"){
                        Float usd= Float.parseFloat(edtInput.getText().toString());
                        Float vnd=usd*22800;
                        tvResult.setText(vnd.toString());
                    }
                    if(tvOuput.getText().toString()=="USD"){
                        tvResult.setText(edtInput.getText().toString());
                    }
                    if(tvOuput.getText().toString()=="EUR"){
                        Float usd= Float.parseFloat(edtInput.getText().toString());
                        Float eur=usd*22800/28000;
                        tvResult.setText(eur.toString());
                    }
                }
                if(tvInput.getText().toString()=="EUR"){
                    if(tvOuput.getText().toString()=="VND"){
                        Float eur= Float.parseFloat(edtInput.getText().toString());
                        Float vnd=eur/28000;
                        tvResult.setText(vnd.toString());
                    }
                    if(tvOuput.getText().toString()=="USD"){
                        Float eur= Float.parseFloat(edtInput.getText().toString());
                        Float usd=eur*28000/22800;
                        tvResult.setText(usd.toString());
                    }
                    if(tvOuput.getText().toString()=="EUR"){
                        tvResult.setText(edtInput.getText().toString());
                    }
                }
            }
        });






    }
}

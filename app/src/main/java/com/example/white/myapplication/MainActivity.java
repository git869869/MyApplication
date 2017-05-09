package com.example.white.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvScreen;
    private List<Item> items=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvScreen=(TextView)findViewById(R.id.tvScreen);

        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSup).setOnClickListener(this);
        findViewById(R.id.btnX).setOnClickListener(this);
        findViewById(R.id.btnDel).setOnClickListener(this);
        findViewById(R.id.btnDian).setOnClickListener(this);
        findViewById(R.id.btnRe).setOnClickListener(this);
        findViewById(R.id.btnCL).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.btn0:
                tvScreen.append("0");
                break;
            case  R.id.btn1:
                tvScreen.append("1");
                break;
            case  R.id.btn2:
                tvScreen.append("2");
                break;
            case  R.id.btn3:
                tvScreen.append("3");
                break;
            case  R.id.btn4:
                tvScreen.append("4");
                break;
            case  R.id.btn5:
                tvScreen.append("5");
                break;
            case  R.id.btn6:
                tvScreen.append("6");
                break;
            case  R.id.btn7:
                tvScreen.append("7");
                break;
            case  R.id.btn8:
                tvScreen.append("8");
                break;
            case  R.id.btn9:
                tvScreen.append("9");
                break;
            case  R.id.btnAdd:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()),type.NUM));
                check();
                items.add(new Item(0,type.ADD));
                tvScreen.setText("");
                break;
            case  R.id.btnDel:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()),type.NUM));
                check();
                items.add(new Item(0,type.DEL));
                tvScreen.setText("");
                break;
            case  R.id.btnSup:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()),type.NUM));
                check();
                items.add(new Item(0,type.SUP));
                tvScreen.setText("");
                break;
            case  R.id.btnX:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()),type.NUM));
                check();
                items.add(new Item(0,type.X));
                tvScreen.setText("");
                break;
            case  R.id.btnCL:
                tvScreen.setText("");
                items.clear();
                break;
            case  R.id.btnRe:
                items.add(new Item(Double.parseDouble(tvScreen.getText().toString()),type.NUM));
                check();
                tvScreen.setText(items.get(0).value+"");
                items.clear();
                break;
            case  R.id.btnDian:

                break;
        }
    }
    public void check(){
        if (items.size()>=3){
            double a=items.get(0).value;
            double b=items.get(2).value;
            int opt=items.get(1).type;
            items.clear();
            switch (opt){
                case type.ADD:
                    items.add(new Item(a+b,type.NUM));
                    break;
                case type.DEL:
                    items.add(new Item(a/b,type.NUM));
                    break;
                case type.SUP:
                    items.add(new Item(a-b,type.NUM));
                    break;
                case type.X:
                    items.add(new Item(a*b,type.NUM));
                    break;

            }
        }
    }
}

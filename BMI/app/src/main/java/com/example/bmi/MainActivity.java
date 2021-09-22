
package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnClickListener {
    RadioButton rb1;
    RadioButton rb2;
    TextView tvResult;
    EditText txt1;
    EditText txt2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    public void setViews() {
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);//判断男女
        tvResult = (TextView) findViewById(R.id.tvResult);
        txt1 = (EditText) findViewById(R.id.edX);
        txt2 = (EditText) findViewById(R.id.edY);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        double x = Double.parseDouble(txt1.getText().toString());//身高
        double y = Double.parseDouble(txt2.getText().toString());//体重//体重除以身高的平方
        double res;
        String str = "你的BMI是：";
        x = x / 100;
        res = y / (x * x);
        String str1 = String.format("%1$.2f", res);
        str = str + str1;
        if (rb1.isChecked())
            res -= 1;
        str += "体型:";
        if (res < 19)
            str += "轻";
        else if (res < 24)
            str += "中";
        else if (res < 29)
            str += "重";
        else if (res < 34)
            str += "胖";
        else
            str += "严重肥胖";
        tvResult.setText(str);
    }
}



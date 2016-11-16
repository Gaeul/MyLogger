package com.example.mylogger2;

/**
 * Created by Gaeul on 2016-11-16.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * 적은 코드로 스피너를 사용하는 방법에 대해 알 수 있습니다.
 *
 * @author Mike
 *
 */
public class SubmainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /**
     * 선택된 값을 표시할 텍스트뷰
     */
    TextView textView1;
    TextView textView2;

    /**
     * 스피너를 위한 아이템 정의
     */
    String[] items = { "놀기", "먹기", "자기", "근로", "수업", "공부", "운동", "쉬기" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submain);

        // 텍스트뷰 객체 참조
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        //텍스트뷰2 에 경도와 위도 띄우기
        Intent intent = getIntent();

        double latitude = intent.getExtras().getDouble("Latitude");
        double longitude = intent.getExtras().getDouble("Longitude");
        textView2.setText("장소는 경도 : "+ latitude + " 위도 : " + longitude + " 에서");

        // 스피너 객체 참조
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        // 어댑터 객체 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 어댑터 설정
        spinner.setAdapter(adapter);
    }

    /**
     * 아이템이 선택되었을 때 처리
     */
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        textView1.setText(items[position]);
    }

    /**
     * 아무것도 선택되지 않았을 때 처리
     */
    public void onNothingSelected(AdapterView<?> parent) {
        textView1.setText("");
    }

}

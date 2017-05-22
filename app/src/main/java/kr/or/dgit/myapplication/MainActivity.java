package kr.or.dgit.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 내용물을 보여주겠다.
        Button btnSecond = (Button) findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Toast.makeText(getApplicationContext(), ((Button)v).getText(), Toast.LENGTH_LONG).show();
                                         }
                                     }
        );
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(myListener);

        findViewById(R.id.btnNewActivity).setOnClickListener(new ClickListener());
        findViewById(R.id.btnThirdAct).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivity(intent);
    }

    private class ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent);
        }
    }
    View.OnClickListener myListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
          Uri uri = Uri.parse("tel:010-2535-0787");
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(intent);
        }
    };

    public void mBtnClick(View view) {
        String str = ((Button) view).getText().toString();
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }

    public void mNaverBtnClicked(View view) {
        Uri uri = Uri.parse("http://m.naver.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}

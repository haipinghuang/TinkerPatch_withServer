package com.tinkertest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);
        tv.setText(getTvContent(2, 3));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "patch.apk");
                Toast.makeText(MainActivity.this, "this is the patch apk with patch file exist=" + file.exists(), Toast.LENGTH_SHORT).show();
                if (file.exists()) {
                    TinkerInstaller.onReceiveUpgradePatch(MainActivity.this, file.getAbsolutePath());
                }
            }
        });
    }


    String getTvContent(int a, int c) {
        return "patch2 apk";
    }
}

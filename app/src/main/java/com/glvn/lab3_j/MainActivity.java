package com.glvn.lab3_j;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.content.pm.ActivityInfo;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ConstraintLayout layout = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.layt);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_color:
                layout.setBackgroundColor(Color.parseColor("#3498DB"));
                return true;
            case R.id.action_goto:
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                return true;
            case R.id.action_info:
                Toast.makeText(getApplicationContext(),
                        "Розробив Павлюк Віталій, ІПЗ-17-1", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_exit:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String getScreenOrientation() {
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT)
            return "Портретна орієнтація";
        else if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE)
            return "Альбомна орієнтація";
        else
            return "";

    }

    public class OrientationActivity extends Activity {
        Button btn;
        static final String ORIENTATION_PORTRAIT = "Портретний режим";
        static final String ORIENTATION_LANDSCAPE = "Альбомний режим";
        // визначаємо зміну орієнтації екрану
        boolean mState = false;
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            btn = (Button) findViewById(R.id.button1);
// set default text display
            btn.setText(ORIENTATION_LANDSCAPE);
        }
        public void onClick(View v) {
// state FALSE: переключаємося на LANDSCAPE
            if (!mState) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                btn.setText(ORIENTATION_PORTRAIT);
            }
// state TRUE: переключаємося в PORTRAIT
            else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                btn.setText(ORIENTATION_LANDSCAPE);
            }
// змінюємо state на протилежне значення
            mState = !mState;
        }
    }

}



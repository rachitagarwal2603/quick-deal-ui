package app.racdeveloper.com.quickdeal.mockActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import app.racdeveloper.com.quickdeal.R;

/**
 * Created by Rachit on 4/19/2017.
 */

public class PostActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock);

        tv= (TextView) findViewById(R.id.tvActivity);
        tv.setText("Post Requirements Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

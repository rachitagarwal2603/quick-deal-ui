package app.racdeveloper.com.quickdeal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Rachit on 4/19/2017.
 */

public class SplashActivity extends AppCompatActivity {

    private Handler delay;
    private Runnable runnable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        delay= new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent i = getIntent();
                String user = i.getExtras().getString("user");
                if(user.equals("buyer"))
                    startActivity(new Intent(SplashActivity.this, UserActivity.class).putExtra("user", "buyer"));
                else if(user.equals("seller"))
                    startActivity(new Intent(SplashActivity.this, UserActivity.class).putExtra("user", "seller"));
            }
        };
        delay.postDelayed(runnable, 2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        delay.removeCallbacks(runnable);
        finish();
    }
}

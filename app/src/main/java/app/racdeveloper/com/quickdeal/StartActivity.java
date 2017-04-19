package app.racdeveloper.com.quickdeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Rachit on 4/19/2017.
 */

public class StartActivity extends AppCompatActivity {

    private Button bBuyer, bSeller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        bBuyer= (Button) findViewById(R.id.bBuyer);
        bSeller= (Button) findViewById(R.id.bSeller);

        bBuyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, SplashActivity.class).putExtra("user", "buyer"));
            }
        });

        bSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, SplashActivity.class).putExtra("user", "seller"));
            }
        });
    }
}

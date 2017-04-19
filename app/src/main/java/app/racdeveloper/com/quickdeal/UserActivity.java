package app.racdeveloper.com.quickdeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import app.racdeveloper.com.quickdeal.mockActivities.ConversationActivity;
import app.racdeveloper.com.quickdeal.mockActivities.HomeActivity;
import app.racdeveloper.com.quickdeal.mockActivities.PostActivity;
import app.racdeveloper.com.quickdeal.mockActivities.ProfileActivity;
import app.racdeveloper.com.quickdeal.mockActivities.SupportActivity;

public class UserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent i = getIntent();
        String user = i.getExtras().getString("user");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);
        tvUser = (TextView) header.findViewById(R.id.tvUser);
        tvUser.setText("RAKESH PATEL");

        if(user.equals("seller")) {
            tvUser.setText("KRISHNA ELECTRONICS");
            Menu nav_menu = navigationView.getMenu();
            nav_menu.findItem(R.id.nav_post).setVisible(false);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(UserActivity.this, HomeActivity.class));
        } else if (id == R.id.nav_convo) {
            startActivity(new Intent(UserActivity.this, ConversationActivity.class));
        } else if (id == R.id.nav_profile) {
            startActivity(new Intent(UserActivity.this, ProfileActivity.class));
        } else if (id == R.id.nav_post) {
            startActivity(new Intent(UserActivity.this, PostActivity.class));
        } else if (id == R.id.nav_support) {
            startActivity(new Intent(UserActivity.this, SupportActivity.class));
        } else if (id == R.id.nav_logout) {
            finish();
        }

        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

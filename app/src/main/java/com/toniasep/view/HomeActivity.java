/**
 * TONI App.
 * Tanggal Pengerjaan: 22 Mei 2019
 * NIM: 10116308
 * Nama: Asep Toni
 * Kelas: IF-7
 */

package com.toniasep.view;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.toniasep.R;
import com.toniasep.presenter.ContactFragment;
import com.toniasep.presenter.FriendsFragment;
import com.toniasep.presenter.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    RelativeLayout profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        profile = findViewById(R.id.profile);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_pprofile:
                            profile.setVisibility(View.INVISIBLE);
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.nav_contact:
                            profile.setVisibility(View.INVISIBLE);
                            selectedFragment = new ContactFragment();
                            break;
                        case R.id.nav_friends:
                            profile.setVisibility(View.INVISIBLE);
                            selectedFragment = new FriendsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    public void Call(View view){
        Intent telepon = new Intent(Intent.ACTION_DIAL);
        telepon.setData(Uri.parse("tel:08228329336"));
        startActivity(telepon);

    }
    public void ig(View view){
        Intent ig = new Intent(Intent.ACTION_VIEW);
        ig.setData(Uri.parse("https://instagram.com/toniiasep"));
        startActivity(ig);

    }
    public void fb(View view){
        Intent fb = new Intent(Intent.ACTION_VIEW);
        fb.setData(Uri.parse("https://facebook.com/toniiasep"));
        startActivity(fb);

    }
    public void yt(View view){
        Intent yt = new Intent(Intent.ACTION_VIEW);
        yt.setData(Uri.parse("https://youtube.com/tonichannel"));
        startActivity(yt);

    }
    public void in(View view){
        Intent in = new Intent(Intent.ACTION_VIEW);
        in.setData(Uri.parse("https://www.linkedin.com/in/toniasep/"));
        startActivity(in);

    }

    public void email(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"toniiasep@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hai Developer");
        intent.putExtra(Intent.EXTRA_TEXT,"isi pesan email ini dari aplikasi TONI App");
        intent.setType("message/rfc822");
        startActivity(intent);
    }

    public void buka_line(View view){
        Uri uri = Uri.parse("line://ti/p/vpa");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}

/**
 * TONI App.
 * Tanggal Pengerjaan: 21 Mei 2019
 * NIM: 10116308
 * Nama: Asep Toni
 * Kelas: IF-7
 */

package com.toniasep.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.toniasep.MainActivity;
import com.toniasep.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread(){
            public void run() {
                try{
                    sleep(3000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}

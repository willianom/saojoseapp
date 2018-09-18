package womsoft.saojosefcapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.SupportActivity;

/**
 * Created by Willian.Matos on 22/05/2017.
 */

public class SplashScreenSJFC extends SupportActivity {

    // Timer da splash screen
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        setContentView(R.layout.splash_screen_sjfc_app);

        //getSupportActionBar ().setHomeButtonEnabled (true);


        new Handler().postDelayed(new Runnable() {
            /*
             * Exibindo splash com um timer.
             */
            @Override
            public void run() {
                // Esse método será executado sempre que o timer acabar
                // E inicia a activity principal
                Intent i = new Intent (SplashScreenSJFC.this, MainActivitySJFC.class);
                startActivity(i);

                // Fecha esta activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}

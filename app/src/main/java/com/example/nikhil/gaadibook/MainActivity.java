package com.example.nikhil.gaadibook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.core.auth.Scope;
import com.uber.sdk.rides.client.SessionConfiguration;
import java.util.Arrays;
import com.uber.sdk.android.rides.RideRequestButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SessionConfiguration config = new SessionConfiguration.Builder()
                // mandatory
                .setClientId("UGe-98UOwUEXTmFAKrrBpTC6AE9OpDas")
                // required for enhanced button features
                .setServerToken("Z-m78X26L0FXfmmJji8suI_O8O1sFN5csQlRFJg6")
                // required for implicit grant authentication
                //.setRedirectUri("<REDIRECT_URI>")
                // required scope for Ride Request Widget features
                .setScopes(Arrays.asList(Scope.RIDE_WIDGETS))
                // optional: set Sandbox as operating environment
                .setEnvironment(SessionConfiguration.Environment.SANDBOX)
                .build();



        UberSdk.initialize(config);

        //Context context = this.getApplicationContext();

        RideRequestButton requestButton = new RideRequestButton(MainActivity.this);


        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main);
        layout.addView(requestButton);

    }
}

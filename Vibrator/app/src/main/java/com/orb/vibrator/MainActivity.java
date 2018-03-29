package com.orb.vibrator;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Vibrator v;
    Button btnOn;
    EditText timeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        timeText = (EditText) findViewById(R.id.time);
        btnOn = (Button) findViewById(R.id.btnOn);
        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = "";
                Long y;
                x = timeText.getText().toString();
                if(x.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Time not given",Toast.LENGTH_SHORT).show();
                }else{
                    y=Long.valueOf(x);
                    vibrate(y);
                }



        }
    });


}

    private void vibrate(long m) {
        v.vibrate(m);
    }


    public void clearText(View view) {
        timeText.setText("");
        timeText.requestFocus();

    }


    public void goToFb(View view){
        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/bappyrahsan"));
        startActivity(i);
    }



    public void showAbout(View view) {
        final Dialog dialog = new Dialog(this, R.style.AppTheme);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.about);
        getWindow().setLayout(-1, -1);
        ((ImageButton) dialog.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}

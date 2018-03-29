package com.orb.torch;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    //declaring required vars
    Button tbtn;
    ImageView imageView;
    private Camera camera;
    private Parameters params;
    private boolean isFlashOn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.img);

        tbtn = (Button) findViewById(R.id.btn);
        isFlashOn = false;
        tbtn.setText("ON");
        getCamera();

    }


    public void torch(View view) {
        if (!isFlashOn) {
            //switch on flash
            if (camera == null || params == null) {
                return;
            }
            params = camera.getParameters();
            params.setFlashMode(Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOn = true;
            tbtn.setText("OFF");
            imageView.setImageResource(R.drawable.light_off);

        } else if (isFlashOn) {
            //switch off flash
            if (camera == null || params == null) {
                return;
            }
            params = camera.getParameters();
            params.setFlashMode(Parameters.ANTIBANDING_OFF);
            camera.setParameters(params);
            camera.stopPreview();
            isFlashOn = false;
            tbtn.setText("ON");
            imageView.setImageResource(R.drawable.light_on);
        } else {
            Toast.makeText(this, "Wrong Command", Toast.LENGTH_SHORT).show();
        }

    }


    private void getCamera() {
        if (camera == null) {
            try {
                camera = Camera.open();
                params = camera.getParameters();
            } catch (Exception e) {

            }
        }


    }

    // method to check if device support camera flash
    private boolean hasFlash() {
        boolean hFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if (!hFlash) {
            return false;
        } else {
            return true;
        }
    }
}

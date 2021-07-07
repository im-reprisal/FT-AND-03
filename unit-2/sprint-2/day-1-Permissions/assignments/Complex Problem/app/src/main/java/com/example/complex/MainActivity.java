package com.example.complex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE = 1;
    private Button mBtnRequestPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnRequestPermissions = findViewById(R.id.btnBoth);

        mBtnRequestPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQ_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQ_CODE:
                if (grantResults.length >= 2) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                        showToast("Camera and Location Storage granted");
                    }


                    else if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_DENIED) {
                        showToast("Camera granted and Location denied");
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[1])) {
                            showToast("Permission denied");
                        } else {
                            showToast("Camera granted , storage denied by selecting do not show again.");
                        }
                    }


                    else if (grantResults[0] == PackageManager.PERMISSION_DENIED && (grantResults[1] == PackageManager.PERMISSION_GRANTED)) {
                        showToast("Camera denied and Storage permission granted");
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[1])) {
                            showToast("Permission denied");
                        } else {
                            showToast("Storage granted, camera denied by selecting do not show again.");
                        }
                    }


                    else {
                        showToast("Both the permissions denied");
                    }
                }
        }
    }

    private void showToast(String permission_granted) {
        Toast.makeText(this,permission_granted, Toast.LENGTH_SHORT).show();
    }
}
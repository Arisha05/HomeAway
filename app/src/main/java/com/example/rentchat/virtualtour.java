package com.example.rentchat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;


public class virtualtour extends AppCompatActivity {

    private VrPanoramaView mVrPanoramaView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtualtour);
        mVrPanoramaView=(VrPanoramaView) findViewById(R.id.vrPanoramaView);
        loadPhotoSphere();
    }
    private void loadPhotoSphere(){
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        InputStream inputStream = null;
        AssetManager assetManager = getAssets();

        try{
            inputStream = assetManager.open("tour.jpeg");
            options.inputType = VrPanoramaView.Options.TYPE_MONO;
            mVrPanoramaView.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream),options);
            inputStream.close();
        }catch (IOException e){
            Log.e("Rentchat","Exception in LoadPhotoSphere"+e.getMessage());
        }
    }

    @Override
    protected void onPause(){
        mVrPanoramaView.pauseRendering();
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        mVrPanoramaView.resumeRendering();
    }

    @Override
    protected void onDestroy(){
        mVrPanoramaView.shutdown();
        super.onDestroy();
    }


}

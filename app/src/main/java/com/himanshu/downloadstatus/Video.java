package com.himanshu.downloadstatus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;

public class Video extends AppCompatActivity {

    ImageView download,mychatapp,share;
    VideoView mparticularvideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        getSupportActionBar().setTitle("Video");
        mparticularvideo=findViewById(R.id.particulrvideo);
        download=findViewById(R.id.downloada);
        mychatapp=findViewById(R.id.chatapp);
        share=findViewById(R.id.share);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Video.this, "Shared", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent =getIntent();
        String destpath = intent.getStringExtra("DEST_PATH_VIDEO");
        String file = intent.getStringExtra("FILE_VIDEO");
        String uri = intent.getStringExtra("URI_VIDEO");
        String filename = intent.getStringExtra("FILENAME_VIDEo");

        File destpath2 = new File(destpath);
        File file1 = new File(file);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mediaController);
        Uri uri1 =Uri.parse(uri);
        mparticularvideo.setMediaController(mediaController);
        mparticularvideo.setVideoURI(uri1);
        mparticularvideo.requestFocus();
        mparticularvideo.start();

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    org.apache.commons.io.FileUtils.copyFileToDirectory(file1, destpath2);
                }

                catch (IOException e)
                {

                    e.printStackTrace();
                }
                MediaScannerConnection.scanFile(getApplicationContext(),
                        new String[]{destpath + filename}, new String[]{"*/*"}, new MediaScannerConnection.MediaScannerConnectionClient() {
                            @Override
                            public void onMediaScannerConnected() {

                            }

                            @Override
                            public void onScanCompleted(String path, Uri uri) {

                            }
                        });


                Dialog dialog = new Dialog(Video.this);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.show();


                android.widget.Button button;
                button =findViewById(R.id.ok);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        });

    }
}
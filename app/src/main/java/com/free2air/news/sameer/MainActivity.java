package com.free2air.news.sameer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
 TextView m ;
 public static String videoID;
 public  FirebaseDatabase database;
 public   DatabaseReference myRef;
 public CardView aajtak,ndtv,news24,abpnews,zeenews,jantatv;
    public static String getvideoID()
 {
     return  videoID;

 }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   m = (TextView)findViewById(R.id.text);
       database = FirebaseDatabase.getInstance();
       myRef = database.getReference("Channel");
       aajtak = findViewById(R.id.aajtak);
       ndtv = findViewById(R.id.ndtv);
       news24 = findViewById(R.id.news24);
       abpnews = findViewById(R.id.abpnews);
       zeenews = findViewById(R.id.zeenews);
       jantatv = findViewById(R.id.jantatv);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
              String crawled = datasnapshot.child("Intro").getValue(String.class);
                System.out.println(crawled);
             // m.setText(crawled);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        aajtak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        videoID = snapshot.child("aajtak").getValue(String.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }) ;
                startActivity(new Intent(MainActivity.this,NewspanelActivity.class));
            }
        });
        ndtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        videoID = snapshot.child("ndtv").getValue(String.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }) ;
                startActivity(new Intent(MainActivity.this,NewspanelActivity.class));
            }
        });
        jantatv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        videoID = snapshot.child("jantatv").getValue(String.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }) ;
                startActivity(new Intent(MainActivity.this,NewspanelActivity.class));
            }
        });
        abpnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        videoID = snapshot.child("abp").getValue(String.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }) ;
                startActivity(new Intent(MainActivity.this,NewspanelActivity.class));
            }
        });
        zeenews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        videoID = snapshot.child("zee").getValue(String.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }) ;
                startActivity(new Intent(MainActivity.this,NewspanelActivity.class));
            }
        });
        news24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        videoID = snapshot.child("news24").getValue(String.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }) ;
                startActivity(new Intent(MainActivity.this,NewspanelActivity.class));
            }
        });

    }










}
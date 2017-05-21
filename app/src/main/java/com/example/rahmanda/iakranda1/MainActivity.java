package com.example.rahmanda.iakranda1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //deklarasi variable yang akan digunakan untuk menampung komponen pada xml
    ImageView foto, logo;
    TextView judul, tv1, tv2;
    Button btn_hotel, btn_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //deklarasi semua komponen yang ada pada tampilan xml
        foto = (ImageView) findViewById(R.id.imageView1);
        logo = (ImageView) findViewById(R.id.imageView2);
        judul = (TextView)findViewById(R.id.textView1);
        tv1 = (TextView) findViewById(R.id.textView2);
        tv2 = (TextView) findViewById(R.id.textView3);
        btn_hotel = (Button) findViewById(R.id.button1);
        btn_code = (Button) findViewById(R.id.button2);

        //mengubah data sesuai yang diinginkan
        judul.setText("CODE MARGONDA");
        tv1.setText("Location");
        tv2.setText("Depok");
        btn_hotel.setText("HOTEL ?");
        btn_code.setText("IAK");


        btn_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Hotel.class); //pindah dari halaman ini ke halaman Hotel
                startActivity(i);
                finish();
            }
        });


        btn_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judul.setText("Indonesia Android Kejar");
                logo.setImageResource(R.drawable.logo_sekolah1);  //mengubah gambar
            }
        });

        }

}

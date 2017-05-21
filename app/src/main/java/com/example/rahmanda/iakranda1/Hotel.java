package com.example.rahmanda.iakranda1;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

public class Hotel extends AppCompatActivity {


    int quantity = 0; //Nilai awal banyak hari
    int extra_price;  //variabel untuk menyimpan harga tambahan pada tipe -tipe kamar hotel

    private RadioGroup radioGroup;  //membbuat variabel RadioGroup dengan nama radioGroup
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup); //variabel yang di deklarasikan diatas diberi nilai berupa radioGroup di tampilan xml
    }

    public void increment(View view) { //nama disesuaikan dengan xml onClick pada button +
        quantity = quantity + 1;
        display(quantity);    // memanggil method display dengan parameter quantity
        displayPrice(quantity * 100000); //memanggil method displayPrice dengan parameter jumlah dari perkalian banyak nya hari menginap dengan harga setiap hari nya

    }

    public void decrement(View view) { //nama disesuaikan dengan onClick pada button -
        quantity = quantity - 1;
        display(quantity);
        displayPrice(quantity * 100000);
    }

    public void display(int number) { //membuat method display dengan tipe data public
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view); //R.id nya disesuaikan dengan id quantity.
        quantityTextView.setText("" + number); //mengganti text yang ada pada text quantity menjadi nilai yang sesuai dengan parameter yang ditentukan
    }

    public void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view); //R.id nya disesuaikan dengan id harga.
        priceTextView.setText("Rp. " + number);  //mengganti text yang ada pada text harga menjadi nilai yang sesuai dengan parameter yang ditentukan
    }

    public void submitOrder(View view) { //submitOrder adalah nama onClick pada button pesan sekarang di xml , perintah ini berfungsi untuk menjalan kan sebuah program apabila button tersebut di klik
        createOrderSummary();  //memanggil method createOrderSummary
    }

    private void createOrderSummary() { //membuat method createOrderSummary
        int selectedId = radioGroup.getCheckedRadioButtonId();         //pilih radio buton yang ada di radio button group
        radioButton = (RadioButton) findViewById(selectedId);   //mencari radio button

        //kondisi untuk memberi nilai harga tambahan sesuai dengan tipe kamar hotel
        if(radioButton.getText().equals("Standard")){
            extra_price = 50000;
        } else if(radioButton.getText().equals("Superior")){
            extra_price = 100000;
        } else{
            extra_price = 150000;
        }


        TextView orderTextView = (TextView) findViewById(R.id.order_text_view);

        //membuat variable order_message yang fungsi nya sebagai menampung hasil output yang diinginkan
        String order_message = "Kamar hotel : "+radioButton.getText()+"\nJumlah hari : "
                + quantity + "\nTotal harga : Rp. "+((quantity * 100000)+extra_price);

        orderTextView.setText(order_message);  // memanggil method orderTextView dengan parameter order_message
    }

    public void back (View view) {  //fungsi untuk button kembali
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
}

package com.opama.ditha.opamacollection;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class JerapahActivity extends AppCompatActivity {

    int jumlah = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jerapah);
    }

    public void decrement(View view) {
        if(jumlah == 0) {
            Toast.makeText(JerapahActivity.this, "Tidak bisa kurang dari 0",
                    Toast.LENGTH_SHORT).show();
        } else {
            jumlah -= 1;
            displayJumlah(jumlah);
        }
    }

    public void increment(View view) {
        jumlah += 1;
        displayJumlah(jumlah);
    }

    /**
     *
     * @param wisuda new price to calculate when add the wisuda
     * @param kado new price to calculate when add the kado
     * @return total price
     */
    private int calculatePrice(boolean wisuda, boolean kado){
        //price of 1 doll
        int basePrice = 50000;

        //add 30000 when the user wants wisuda accessories
        if(wisuda){
            basePrice = basePrice + 30000;
        }

        //add 10000 when the user wants wrap present
        if(kado){
            basePrice = basePrice + 10000;
        }


        // calculate the total price by multiplying the quantity with the base price
        return jumlah * basePrice;
    }

    /**
     * @param name for input name
     * @param price for price of dolls
     * @param wisuda for wisuda accessories
     * @param kado for wrap present
     * @return price message
     */
    private String createOrderSummary(String name, String alamat, String hp, int price, String wisuda, String kado){
        String priceMessage = "Nama : " + name ;
        priceMessage += "\nAlamat : " + alamat;
        priceMessage += "\nNo. Handphone : " + hp;
        priceMessage += "\nApakah mau di tambah aksesoris wisuda ? " + wisuda;
        priceMessage += "\nApakah mau di bungkus  kado ? " + kado;
        priceMessage += "\nJumlah : " +  jumlah;
        priceMessage += "\nTotal : IDR " + price;
        priceMessage += "\n\nThank you!!";
        return  priceMessage;
    }

    public void submitOrder(View view) {

        String optionWisuda = " ";
        String optionKado = " ";

        //find the user's name
        EditText text = (EditText) findViewById(R.id.input_nama);
        String name = text.getText().toString();

        //find the user's address
        EditText address = (EditText) findViewById(R.id.input_alamat);
        String alamat = address.getText().toString();

        //find the user's hp
        EditText phone = (EditText) findViewById(R.id.input_hp);
        String hp = phone.getText().toString();

        //figure out if the user wants whipped cream topping
        CheckBox wisudaCheck = (CheckBox) findViewById(R.id.check_wisuda);
        boolean hasWisuda = wisudaCheck.isChecked();

        //figure out if the user wants chocolate topping
        CheckBox kadoCheck = (CheckBox) findViewById(R.id.check_kado);
        boolean hasKado = kadoCheck.isChecked();

        if(hasWisuda) {
            //Menghasilkan nilai true or false
            optionWisuda = "Ya";
        } else {
            optionWisuda = "Tidak";
        }
        if(hasKado) {
            //Menghasilkan nilai true or false
            optionKado = "Ya";
        } else {
            optionKado = "Tidak";
        }

        //call calculateprice Method
        int jerapahPrice = calculatePrice(hasWisuda, hasKado);
        //call createOrderSummary method
        String priceMessage = createOrderSummary(name, alamat, hp, jerapahPrice, optionWisuda, optionKado);

        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setData(Uri.parse("mailto")); //only email app should handle this
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Boneka dipesan oleh " + name);
        sendIntent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if(sendIntent.resolveActivity(getPackageManager()) != null){
            startActivity(sendIntent);
        }
    }

    private void displayJumlah(int jumlahBoneka) {
        TextView jumlahTextView = (TextView) findViewById(R.id.quantity_text_view);
        jumlahTextView.setText("" + jumlahBoneka);
    }
}

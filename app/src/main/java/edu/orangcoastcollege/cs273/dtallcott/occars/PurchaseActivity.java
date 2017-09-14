package edu.orangcoastcollege.cs273.dtallcott.occars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * This car loan calculator allows the user to input the price of the vehicle,
 * down payment, and how many years the loan will be paid over. Program will then
 * calculate and display the tax, total cost, borrowed amount, interest amount, and
 * a monthly payment.
 *
 * @author Devon Tallcott
 * @version 1.0
 *
 * 09/14/2017
 */

public class PurchaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
    }
}

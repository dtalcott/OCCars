package edu.orangcoastcollege.cs273.dtallcott.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

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

    //Connections to the VIEW
    private EditText mPriceEditText;
    private EditText mDownPaymentEditText;
    private RadioButton mThreeYearRadioButton;
    private RadioButton mFourYearRadioButton;
    private RadioButton mFiveYearRadioButton;

    //Connections to the MODEL
    private CarLoan mCarLoan = new CarLoan();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        //Use findViewById to connect to controller to each view
        mPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        mDownPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        mThreeYearRadioButton = (RadioButton) findViewById(R.id.threeYearRadioButton);
        mFourYearRadioButton = (RadioButton) findViewById(R.id.fourYearRadioButton);
        mFiveYearRadioButton = (RadioButton) findViewById(R.id.fiveYearRadioButton);

    }

    private void collectCarLoanData()
    {
        mCarLoan.setPrice(Double.parseDouble(mPriceEditText.getText().toString()));
        mCarLoan.setDownPayment(Double.parseDouble(mDownPaymentEditText.getText().toString()));

        if (mThreeYearRadioButton.isChecked())
            mCarLoan.setTerm(3);
        else if (mFourYearRadioButton.isChecked())
            mCarLoan.setTerm(4);
        else
            mCarLoan.setTerm(5);
    }

    protected void reportSummary(View v)
    {
        collectCarLoanData();
        String report = "Monthly Payment: $" + mCarLoan.monthlyPayment();
        //keep reporting

        //Intents Start New Activities and Share new Data With Them
        Intent launchLoanSummary = new Intent(this, LoanSummaryActivity.class);
        //put data into the Intent for Loan Summary to receive
        launchLoanSummary.putExtra("loanReport", report);
        //Start the Second Activity
        startActivity(launchLoanSummary);
    }
}

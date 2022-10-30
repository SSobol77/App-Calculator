package com.yios.claculator;
/**
 * @SSobolewski
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // input variable:
    EditText editText;
    Boolean delZero = true;
    String oldNumber;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    //method push on number :
    public void clickNumber(View view) {
        if (delZero)
            editText.setText("");
        delZero = false;

        String number = editText.getText().toString();
        switch (view.getId()) {

            case R.id.but1:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);  // 012345 -> substring 12345 from 1 index and beyond
                }
                number = number + "1";
                break;

            case R.id.but2:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);  // 012345 -> substring 12345 from 1 index and beyond
                }
                number = number + "2";
                break;
            case R.id.but3:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);  // 012345 -> substring 12345 from 1 index and beyond
                }
                number = number + "3";
                break;

            case R.id.but4:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);  // 012345 -> substring 12345 from 1 index and beyond
                }
                number = number + "4";
                break;

            case R.id.but5:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);  // 012345 -> substring 12345 from 1 index and beyond
                }
                number = number + "5";
                break;

            case R.id.but6:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);  // 012345 -> substring 12345 from 1 index and beyond
                }
                number = number + "6";
                break;

            case R.id.but7:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);  // 012345 -> substring 12345 from 1 index and beyond
                }
                number = number + "7";
                break;

            case R.id.but8:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);  // 012345 -> substring 12345 from 1 index and beyond
                }
                number = number + "8";
                break;

            case R.id.but9:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = number.substring(1);  // 012345 -> substring 12345 from 1 index and beyond
                }
                number = number + "9";
                break;

            case R.id.but0:
                if (zeroIsFirst(number) && number.length() == 1) {
                    number = "0";
                } else {
                    number = number + "0";
                }
                break;


            case R.id.butDot:
                if (dotIsPresent(number)) {
                }
                if (zeroIsFirst(number)) {
                    number = "0.";
                }

                else {
                    number = number + ".";
                }
                break;

            // exchange position number and ("-") - minus:   number = "-" + number
            case R.id.butSign:

                if (numberIsZero(number)) {
                    number = "0";
                } else {
                    if (minusIsPresent(number)) {
                        number = number.substring(1);
                    } else {
                        number = "-" + number;
                    }
                }
                break;
        }
        editText.setText(number);
    }

    private boolean zeroIsFirst(String number) {
        if (number.equals("")) {
            return true;
        }
        if (number.charAt(0) == '0') {
            return true;
        } else {
            return false;
        }
    }

    private boolean numberIsZero(String number) {
        if (number.equals("0") || number.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean minusIsPresent(String number) {
        if (number.charAt(0) == '-') {
            return true;
        } else {
            return false;
        }
    }

    public void operation(View view) {
        delZero = true;
        oldNumber = editText.getText().toString();
        switch (view.getId()) {
            case R.id.butPlus:
                operator = "+";
                break;
            case R.id.butMinus:
                operator = "-";
                break;
            case R.id.butMultiply:
                operator = "*";
                break;
            case R.id.butDivide:
                operator = "/";
                break;
        }
    }

    public void clickResult(View view) {
        String newNumber = editText.getText().toString();
        Double result = 0.0;
        switch (operator) {
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        editText.setText(result + "");
    }

    public void clickAC(View view) {
        editText.setText("0");
        delZero = true; // delete zero
    }

    private boolean dotIsPresent(String number) {
        // Log.i("ind", "index point: " + number.indexOf("."));
        // return true;
        if (number.indexOf(".") == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void clickPrecent(View view) {

        if (operator == "") {
            String number = editText.getText().toString();
            double temp = Double.parseDouble(number) / 100;
            number = temp + "";
            editText.setText(number);
        } else {
            String newNumber = editText.getText().toString();
            Double result = 0.0;
            switch (operator) {
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;

                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "/":
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber) * 100;
                    break;
            }
            editText.setText(result + "");
            operator = "";
        }

    }


}
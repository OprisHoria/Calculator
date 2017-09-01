package opris.horia.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static String currentText = "";

    static int getNumberFromAscii(int Ascii) {
        return Ascii - 48;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        EditText input_1 = (EditText) findViewById(R.id.input_1);
        EditText input_2 = (EditText) findViewById(R.id.input_2);
        EditText output = (EditText) findViewById(R.id.outputTxt);

        /* Convert strings to ints */
        int a = Integer.parseInt(input_1.getText().toString());
        int b = Integer.parseInt(input_2.getText().toString());

        /* Perform an addition */
        int c = a + b;

        String result = Integer.toString(c);

        output.setText(result);
    }

    public void calcButtonPressed(View v) {
        EditText output = (EditText) findViewById(R.id.outputTxt);

        switch (v.getId()) {
            case R.id.no_0:
                currentText += "0";
                break;

            case R.id.no_1:
                currentText += "1";
                break;

            case R.id.no_2:
                currentText += "2";
                break;

            case R.id.no_3:
                currentText += "3";
                break;

            case R.id.no_4:
                currentText += "4";
                break;

            case R.id.no_5:
                currentText += "5";
                break;

            case R.id.no_6:
                currentText += "6";
                break;

            case R.id.no_7:
                currentText += "7";
                break;

            case R.id.no_8:
                currentText += "8";
                break;

            case R.id.no_9:
                currentText += "9";
                break;

            case R.id.minusBtn:
                currentText += "-";
                break;

            case R.id.plusBtn:
                currentText += "+";
                break;

            case R.id.enterBtn:
                calcOnEnter();
                break;
        }

        output.setText(currentText);
    }

    private void calcOnEnter() {
        EditText useAsOut = (EditText) findViewById(R.id.input_2);
        int[] a = new int[currentText.length()];
        int sum = 0;

        int[] helperInt = new int[currentText.length()];
        String[] helperString = new String[currentText.length()];

        for (int i = 0; i < currentText.length(); i++)
            helperString[i] = "";

        int helpIndex = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = currentText.charAt(i);

            switch (a[i]) {
                case '+':
                    helpIndex++;
                    break;

                case '-':
                    helpIndex++;
                    break;

                // default is number or group of numbers
                default: {
                    helperString[helpIndex] += currentText.charAt(i);
                }
                break;
            }
        }

        for (int i = 0; i <= helpIndex; i++)
            helperInt[i] = Integer.parseInt(helperString[i]);

        int finalResult = 0;
        int trackHelper = 0;

        finalResult += helperInt[trackHelper];

        trackHelper++;

        for (int i = 0; i < a.length; i++) {
            switch (a[i]) {
                case '+':
                    finalResult += helperInt[trackHelper];
                    trackHelper++;
                    break;

                case '-':
                    finalResult -= helperInt[trackHelper];
                    trackHelper++;
                    break;

                default:
                    break;
            }
        }

        useAsOut.setText(Integer.toString(finalResult));
    }
}

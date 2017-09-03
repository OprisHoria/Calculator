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
        EditText input_2 = (EditText) findViewById(R.id.input_2);
        EditText output = (EditText) findViewById(R.id.outputTxt);


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

            case R.id.multiplyBtn:
                currentText += "*";
                break;

            case R.id.divideBtn:
                currentText += "/";
                break;

            case R.id.cancelBtn:
                currentText = "";
                break;

            case R.id.enterBtn:
                calcOnEnter();
                break;
        }

        output.setText(currentText);
    }

    private void calcOnEnter() {
        String[] operandsGroupedString = new String[currentText.length()];
        int[] operators = new int[currentText.length()];

        for (int i = 0; i < currentText.length(); i++)
            operandsGroupedString[i] = "";

        int helpIndex = 0;

        /* separate operands from operators */
        for (int i = 0; i < currentText.length(); i++) {
            int[] character = new int[currentText.length()];
            character[i] = currentText.charAt(i);

            if ((character[i] >= '0') && (character[i] <= '9'))
                operandsGroupedString[helpIndex] += getNumberFromAscii(character[i]);
            else
                operators[helpIndex++] = character[i];
        }

        outputResult(getCalculationResult(operandsGroupedString, operators, helpIndex));
    }

    private int getCalculationResult(String[] operandsString, int[] operators, int helpIndex) {
        int[] operandsGroupedInt = new int[currentText.length()];
        for (int i = 0; i <= helpIndex; i++)
            operandsGroupedInt[i] = Integer.parseInt(operandsString[i]);

        int trackHelper = 0;
        int calculationsResult = operandsGroupedInt[trackHelper++];

        for (int i = 0; i < operators.length; i++) {
            switch (operators[i]) {
                case '+':
                    calculationsResult += operandsGroupedInt[trackHelper];
                    trackHelper++;
                    break;

                case '-':
                    calculationsResult -= operandsGroupedInt[trackHelper];
                    trackHelper++;
                    break;

                case '*':
                    calculationsResult *= operandsGroupedInt[trackHelper];
                    trackHelper++;
                    break;

                case '/':
                    calculationsResult /= operandsGroupedInt[trackHelper];
                    trackHelper++;
                    break;

                default:
                    break;
            }
        }

        return calculationsResult;
    }

    private void outputResult(int result) {
        EditText useAsOut = (EditText) findViewById(R.id.input_2);
        useAsOut.setText(Integer.toString(result));
    }
}

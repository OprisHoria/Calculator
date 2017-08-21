package opris.horia.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public String currentText = "";

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
            case R.id.no_1:
                currentText += "1";
                output.setText(currentText);
                break;

            case R.id.no_2:
                currentText += "2";
                output.setText(currentText);
                break;

            case R.id.enterBtn:
                int[] a = new int[currentText.length()];
                int sum = 0;

                for (int i = 0; i < a.length; i++) {
                    a[i] = currentText.charAt(i);
                    a[i] -= 48; // ASCII converter

                    sum += a[i];
                }

                output.setText(Integer.toString(sum));
                break;

        }

    }

}

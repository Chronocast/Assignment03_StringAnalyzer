package co.miniforge.corey.stringanalyzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class InputActivity extends AppCompatActivity {
    public static String intentTag = "inputData";

    EditText input;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        locateViews();

        bindFunctionality();
    }

    void locateViews(){
        input = (EditText) findViewById(R.id.stringToAnalyzeEditText);
        submit = (Button) findViewById(R.id.submitButton);
    }

    void bindFunctionality(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isEmpty(input))
                {
                    String concatenatedText = "*BLEEP BLOOP BLEEP BEEP BEEP BZZZT!!!* (Don't be lame, type a phrase!)";
                    Toast.makeText(view.getContext(), concatenatedText, Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), AnalyzerActivity.class);
                    intent.putExtra(intentTag, input.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    //checks if isEmpty
    private boolean isEmpty(EditText editText)
    {
        return editText.getText().toString().trim().length() == 0;
    }
}

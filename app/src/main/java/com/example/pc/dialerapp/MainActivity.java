package com.example.pc.dialerapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText myText = (EditText) findViewById(R.id.dialText);
        myText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    dialNumber();
                    handled = true;
                }
                return handled;
            }
        });
}
    private	void dialNumber()
    {
        EditText editText =	(EditText)	findViewById(R.id.dialText);
        String	mPhoneNum =	null;
        if (editText !=	null)
            mPhoneNum = "tel:"	+ editText.getText().toString();
       	Intent intent	=	new	Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(mPhoneNum));
        if	(intent.resolveActivity(getPackageManager()) !=	null)
        {
            startActivity(intent);
        }
        else
            {
                Toast.makeText(this, "Sorry cant dial!",
                        Toast.LENGTH_LONG).show();
            } }

}

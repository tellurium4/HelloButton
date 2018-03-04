package edu.rose_hulman.changb.hellobutton;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mNumClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView messageTextView = (TextView) findViewById(R.id.message_text);
        Button incrementButton = (Button) findViewById(R.id.button);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNumClicks++;
                String s = getResources().getQuantityString(
                        R.plurals.message_format, mNumClicks, mNumClicks
                );
                messageTextView.setText(s);
                if (mNumClicks > 10) {
                    int backgroundColor = ContextCompat.getColor(MainActivity.this, R.color.background);
                    messageTextView.setTextColor(backgroundColor);
//                    messageTextView.setVisibility(TextView.INVISIBLE);
                }
            }
        });
    }
}

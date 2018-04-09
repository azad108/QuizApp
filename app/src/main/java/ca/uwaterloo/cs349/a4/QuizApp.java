package ca.uwaterloo.cs349.a4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class QuizApp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_app);

        final Button btn = (Button)findViewById(R.id.btnNext);
        final TextView txt = (TextView)findViewById(R.id.txtName);
        btn.setEnabled(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String username;
                username = txt.getText().toString();
                Intent intent = new Intent(QuizApp.this, TopicSelection.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                boolean isReady = txt.getText().toString().length() > 0;
                btn.setEnabled(isReady);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }
}
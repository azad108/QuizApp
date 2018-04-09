package ca.uwaterloo.cs349.a4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        final String username = intent.getExtras().getString("username");
        TextView label	= findViewById(R.id.lblCurrUserQ);
        label.setText(username);
        final String scoreDisplay = intent.getExtras().getString("displayScore");
        TextView lblScore = findViewById(R.id.lblScore);
        lblScore.setText(scoreDisplay);

        final Button logoutBtn = (Button)findViewById(R.id.btnLogout);
        final Button reSelectBtn = (Button)findViewById(R.id.btnTopicSel);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        reSelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Results.this, TopicSelection.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}

package ca.uwaterloo.cs349.a4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TopicSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_selection);
        Intent intent = getIntent();
        final String username = intent.getExtras().getString("username");
        TextView label	= findViewById(R.id.lblCurrentUser);
        label.setText(username);

        Spinner spinner = findViewById(R.id.spnNumQs);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numSelectionsArr, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final Button logoutBtn = (Button)findViewById(R.id.btnLogoutSel);
        final Button loadBtn = (Button)findViewById(R.id.btnLoadQ);
        final Spinner spn = (Spinner)findViewById(R.id.spnNumQs);
        spn.setSelection(0);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String numQs = spn.getSelectedItem().toString();
                Intent intent = new Intent(TopicSelection.this, Question1.class);
                intent.putExtra("numQ", numQs);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}
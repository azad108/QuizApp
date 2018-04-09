package ca.uwaterloo.cs349.a4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Question1 extends AppCompatActivity {
    int currentQuestionNum = 1;
    boolean correctQ1 = false;
    boolean correctQ2 = false;
    boolean correctQ3 = false;
    boolean correctQ4 = false;
    boolean correctQ5 = false;

    boolean choice1 = false;
    boolean choice2 = false;
    boolean choice3 = false;
    boolean choice4 = false;

    boolean choice51 = false;
    boolean choice52 = false;
    boolean choice53 = false;
    boolean choice54 = false;
    LinearLayout[] questions = new LinearLayout[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        final Button logoutBtn = (Button)findViewById(R.id.btnLogout);
        final Button prev = (Button)findViewById(R.id.btnPrev);
        final Button next = (Button)findViewById(R.id.btnNext);
        final LinearLayout q1 = (LinearLayout)findViewById(R.id.layoutQ1);
        final LinearLayout q2 = (LinearLayout)findViewById(R.id.layoutQ2);
        final LinearLayout q3 = (LinearLayout)findViewById(R.id.layoutQ3);
        final LinearLayout q4 = (LinearLayout)findViewById(R.id.layoutQ4);
        final LinearLayout q5 = (LinearLayout)findViewById(R.id.layoutQ5);

        questions[0] = q1;
        questions[1] = q2;
        questions[2] = q3;
        questions[3] = q4;
        questions[4] = q5;

        Intent intent = getIntent();
        final String username = intent.getExtras().getString("username");
        TextView label	= findViewById(R.id.lblCurrUserQ);
        label.setText(username);
        final TextView currQNum = findViewById(R.id.lblCurrQ);
        final String totalQ = intent.getExtras().getString("numQ");
        currQNum.setText(Integer.toString(currentQuestionNum)+"/"+totalQ);

        prev.setEnabled(false);
        if (Integer.parseInt(totalQ) == 1) next.setText("Finish");
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                if(currentQuestionNum == Integer.valueOf(totalQ)) {
                    int score = 0;
                    if (correctQ1) {++score;}
                    if (correctQ2) {++score;}
                    if (correctQ3) {++score;}
                    if (correctQ4) {++score;}
                    if (correctQ5) {++score;}

                    String display = "Your Score: " + score + "/" + totalQ;
                    Intent intent = new Intent(Question1.this, Results.class);

                    intent.putExtra("username", username);
                    intent.putExtra("displayScore", display);
                    startActivity(intent);
                } else {
                    ++currentQuestionNum;
                    currQNum.setText(Integer.toString(currentQuestionNum)+"/"+totalQ);
                    questions[currentQuestionNum-1].setVisibility(View.VISIBLE);
                    for (int i=0; i<Integer.parseInt(totalQ); ++i) {
                        if (i+1 != currentQuestionNum) questions[i].setVisibility(View.GONE);
                    }
                    prev.setEnabled(true);
                }
                if (currentQuestionNum == Integer.parseInt(totalQ)) next.setText("Finish");
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                --currentQuestionNum;
                currQNum.setText(Integer.toString(currentQuestionNum)+"/"+totalQ);
                questions[currentQuestionNum-1].setVisibility(View.VISIBLE);
                for (int i=0; i<Integer.parseInt(totalQ); ++i) {
                    if (i+1 != currentQuestionNum) questions[i].setVisibility(View.GONE);
                }
                if (currentQuestionNum == 1) prev.setEnabled(false);
                if (currentQuestionNum < Integer.parseInt(totalQ)) next.setText("Next");
            }
        });
    }

    protected void onRadioButtonClicked(View	view)	{

        boolean checked	=	((RadioButton)	view).isChecked();

        switch	(view.getId()) {
            case R.id.radio1:
                if (checked) correctQ1 = true;
                else correctQ1 = false;
                break;
            case R.id.radio2:
                if (checked) correctQ1 = false;
                break;
            case R.id.radio3:
                if (checked) correctQ1 = false;
                break;
            case R.id.radio4:
                if (checked) correctQ1 = false;
                break;
        }

        switch	(view.getId())	{
            case	R.id.radio31:
                if	(checked) correctQ3 = false;
                break;
            case	R.id.radio32:
                if	(checked)correctQ3 = false;
                break;
            case	R.id.radio33:
                if	(checked) {correctQ3 = true; }
                else correctQ3 = false;
                break;
            case	R.id.radio34:
                if	(checked)correctQ3 = false;
                break;
        }


        switch	(view.getId())	{
            case	R.id.radio41:
                if	(checked) correctQ4 = false;
                break;
            case	R.id.radio42:
                if	(checked) correctQ4 = false;
                break;
            case	R.id.radio43:
                if	(checked) correctQ4 = false;
                break;
            case	R.id.radio44:
                if	(checked) {correctQ4 = true; }
                else correctQ4 = false;
                break;
        }
    }

    protected void onCheckboxClicked(View	view)	{
        boolean checked	=	((CheckBox)	view).isChecked();

        switch	(view.getId()) {
            case	R.id.chk1:
                if	(checked) choice1 = true;
                else choice1 = false;
                break;
            case	R.id.chk2:
                if	(checked) choice2 = true;
                else choice2 = false;
                break;
            case	R.id.chk3:
                if	(checked) choice3 = true;
                else choice3 = false;
                break;
            case	R.id.chk4:
                if	(checked) choice4 = true;
                else choice4 = false;
                break;
        }

        if (choice1 && choice3 && !choice2 && !choice4) correctQ2 = true;
        else correctQ2 = false;


        switch	(view.getId()) {
            case	R.id.chk51:
                if	(checked) choice51 = true;
                else choice51 = false;
                break;
            case	R.id.chk52:
                if	(checked) choice52 = true;
                else choice52 = false;
                break;
            case	R.id.chk53:
                if	(checked) choice53 = true;
                else choice53 = false;
                break;
            case	R.id.chk54:
                if	(checked) choice54 = true;
                else choice54 = false;
                break;
        }

        if (choice53 && choice54 && !choice51 && !choice52) correctQ5 = true;
        else correctQ5 = false;
    }
}

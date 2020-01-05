package com.example.android.quizfinal;

import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                            "Following is the example of Linux OS?",
                            "When did Google buy Android?",
                            "Who is known as the father of C programming language ?",
                            "A C variable name can start with a ____?",
                            "Prototype of a function means _____?",
                            "Which of the following is correct way of importing an entire package ‘pkg’?",
                            "Far pointer can access _____?",
                            "A pointer that is pointing to NOTHING is called ____?",
                            "Multicore computing is part of?",
                            "OS in cell phones, PDA, tablets, Palm PC, etc is known as?",
                            "The default connection type used by HTTP is _________?",
                            "The time taken by a packet to travel from client to server and then back to the client is called __________?"
                         };
    String answers[] = {"Fedora","2005","Dennis Ritchie","Underscore","Declaration of Function","import pkg.*","All memory location","NULL Pointer","Parallel system"," Handled system","Persistent","RTT"};
    String opt[] = {
                    "MacOS","HP-UX","Fedora","IBM-AIX",
                    "2000","2002","2008","2005",
                    "James A. Sosling","Vjarne Stroustrup","Dennis Ritchie","Dr. E. F. Codd",
                    "Number","Plus Sign (+)","Underscore","Asterisk (*)",
                    "Declaration of Function","Name of Function","Output of Function","Input of a Function",
                    "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
                    "Single memory location","All memory location","No memory location","First Memory Address",
                    "VOID Pointer","DANGLING Pointer","NULL Pointer","WILD Pointer",
                    "Distributed system","Parallel system","Embedded System","Multimedia system",
                     "Mobile OS"," Handled system","Multimedia system","Embedded system",
                    "Persistent","Non-persistent","Can be either of above two","None of the mentioned",
                    "STT","RTT","PTT","JTT"
                   };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello ");
        else
        textView.setText("Hello " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}

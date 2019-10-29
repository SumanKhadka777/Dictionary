package com.suman.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String word;
    private AutoCompleteTextView actv;
    private TextView tv;
    private Button btn;
    private ListView lv;
    private Map<String,String> wordMeaning;

    private String WordAndMeaning[] = {
            "consider", "deem to be",
            "minute", "infinitely or immeasurably small",
            "accord", "concurrence of opinion",
            "evident", "clearly revealed to the mind or the senses or judgment",
            "practice", "a customary way of operation or behavior",
            "intend", "have in mind as a purpose",
            "concern", "something that interests you because it is important",
            "commit", "perform an act, usually with a negative connotation",
            "issue", "some situation or event that is thought about",
            "approach", "move towards",
            "establish", "set up or found",
            "utter", "without qualification",
            "conduct", "direct the course of; manage or control",
            "engage", "consume all of one's attention or time"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv=findViewById(R.id.actv);
        btn=findViewById(R.id.btn);
        lv=findViewById(R.id.lv);
        tv=findViewById(R.id.tv);

        wordMeaning=new HashMap<>();
        for(int i=0; i<WordAndMeaning.length; i+=2)
        {
            wordMeaning.put(WordAndMeaning[i], WordAndMeaning[i+1]);
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList(wordMeaning.keySet())
        );
        lv.setAdapter(arrayAdapter);


        //code for autocomplete texxtview
        ArrayAdapter arrayAdapter1=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList(wordMeaning.keySet())
        );
        actv.setAdapter(arrayAdapter1);
        actv.setThreshold(1);
        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        word=actv.getText().toString();
        String meaning=wordMeaning.get(word);
        tv.setText("The meaning of" + word+ " is "+ meaning);
        //Toast.makeText(this, "The meaning of "+ word + " is " + meaning, Toast.LENGTH_SHORT).show();

    }
}

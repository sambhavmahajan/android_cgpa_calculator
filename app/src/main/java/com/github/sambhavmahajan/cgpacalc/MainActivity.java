package com.github.sambhavmahajan.cgpacalc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.view.View;
import android.widget.Toast;

class Subject{
    public String name;
    public int credit;
    public String grade;
    public Subject(String Name, int Credit, String Grade){
        name = Name;
        credit = Credit;
        grade = Grade;
    }
    public static double marks(String grade, int credit){
        switch(grade.toLowerCase().trim()){
            case "a+":
                return 10*credit;
            case "a":
                    return 9*credit;
            case "b+":
                return 8*credit;
            case "b":
                return 7*credit;
            case "c+":
                return 6*credit;
            case "c":
                return 5*credit;
            case "d":
                return 4*credit;
            case "e":
            case "f":
            case "i":
                return 0;
        }
        return -1;
    }
}
public class MainActivity extends AppCompatActivity {
    List<Subject> li = new ArrayList<Subject>();
    TextView subjectText;
    TextView gradeText;
    TextView creditText;
    Button btnRecent;
    Button btnAdd;
    TextView gpaFlash;
    TextView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        subjectText = findViewById(R.id.editTextText);
        gradeText = findViewById(R.id.editTextText2);
        creditText = findViewById(R.id.editTextText3);
        btnRecent = findViewById(R.id.button);
        btnAdd = findViewById(R.id.button2);
        gpaFlash = findViewById(R.id.textView2);
        myListView = findViewById(R.id.textView);
        myListView.setText("");
    }
    public double gpaCalc(){
        double myTotal = 0;
        double total = 0;
        for(Subject s : li){
            total += 10*s.credit;
            myTotal += Subject.marks(s.grade,s.credit);
        }
        return myTotal/total*10;
    }
    public void updateView(){
        StringBuilder res = new StringBuilder();
        for(Subject s: li){
            res.append("Subject: ").append(s.name).append("\nCredit: ").append(s.credit).append("\nGrade: ").append(s.grade).append("\n\n");
        }
        myListView.setText(res.toString());
    }
    public void addItem(View view){
        if(gradeText.getText().length() == 0 || creditText.getText().length() == 0){
            Toast.makeText(this, "Grade and Credit fields required", Toast.LENGTH_SHORT).show();
            return;
        }
        String creditSt = creditText.getText().toString();
        if(creditSt.isEmpty()){
            Toast.makeText(this, "Invalid Credits", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean grd = Subject.marks(gradeText.getText().toString(), Integer.parseInt(creditSt)) < 0;
        if(grd){
            Toast.makeText(this, "Invalid Grade", Toast.LENGTH_SHORT).show();
            return;
        }
        int creditInt = Integer.parseInt(creditSt);
        if(creditInt <= 0){
            Toast.makeText(this, "Credit must be greater than zero", Toast.LENGTH_SHORT).show();
            return;
        }
        Subject subject = new Subject(subjectText.getText().toString(),creditInt, gradeText.getText().toString());
        li.add(subject);
        double gpa = gpaCalc();
        String temp = "GPA: " + String.format("%.2f", gpa);
        gpaFlash.setText(temp);
        updateView();
    }

    public void removeRecent(View view) {
        if(li.size() > 0) {
            li.remove(li.size() - 1);
            updateView();
        }
    }
}
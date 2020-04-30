package com.android.scientificcalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    Button button;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button buttonPlus,buttonMinus,buttonMultiply,buttonDivision;
    Button buttonMod,buttonDivideByX,buttonSin,buttonCos,buttonTan,buttonFact,buttonPow;
    Button buttonClear,buttonBackspace,buttonBracketsOpen,buttonBracketsClose,buttonRoot,buttonDot,buttonPI;
    Button buttonEqual;
    TextView text1,text2;
    String calculate="";
    int f=0,tanFlag=0;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.layout_drawer);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        String[] menu={"Calculation History","About"};
        db=new DatabaseHandler(this);

        ListAdapter menuAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);
        mDrawerList.setAdapter(menuAdapter);
        mDrawerList.setBackgroundColor(Color.parseColor("#51baad"));

        button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mDrawerLayout.isDrawerOpen(mDrawerList)){
                    button1.setText(">>");
                    mDrawerLayout.closeDrawer(mDrawerList);
                }else {
                    button1.setText("<<");
                    mDrawerLayout.openDrawer(mDrawerList);
                }
            }
        });

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedFromList=(mDrawerList.getItemAtPosition(i).toString());
                if(selectedFromList.contains("About")){
                    Intent a=new Intent(view.getContext(),AboutActivity.class);
                    startActivity(a);
                }else if(selectedFromList.contains("Calculation")){
                    Intent a=new Intent(view.getContext(),CalculationActivity.class);
                    startActivity(a);
                }
            }
        });

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        button0 = (Button)findViewById(R.id.zero);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"0");
                    calculate=calculate+"0";
                }
            }
        });

        button1 = (Button)findViewById(R.id.one);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"1");
                    calculate=calculate+"1";
                }
            }
        });

        button2 = (Button)findViewById(R.id.two);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"2");
                    calculate=calculate+"2";
                }
            }
        });

        button3 = (Button)findViewById(R.id.three);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"3");
                    calculate=calculate+"3";
                }
            }
        });

        button4 = (Button)findViewById(R.id.four);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"4");
                    calculate=calculate+"4";
                }
            }
        });

        button5 = (Button)findViewById(R.id.five);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"5");
                    calculate=calculate+"5";
                }
            }
        });


        button6 = (Button)findViewById(R.id.six);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"6");
                    calculate=calculate+"6";
                }
            }
        });

        button7 = (Button)findViewById(R.id.seven);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"7");
                    calculate=calculate+"7";
                }
            }
        });

        button8 = (Button)findViewById(R.id.eight);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"8");
                    calculate=calculate+"8";
                }
            }
        });

        button9 = (Button)findViewById(R.id.nine);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"9");
                    calculate=calculate+"9";
                }
            }
        });

        buttonSin = (Button)findViewById(R.id.sin);
        buttonSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"sin(");
                    calculate=calculate+"Math.sin(";
                }
            }
        });

        buttonCos = (Button)findViewById(R.id.cos);
        buttonCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"cos(");
                    calculate=calculate+"Math.cos(";
                }
            }
        });


        buttonTan = (Button)findViewById(R.id.tan);
        buttonTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().length()>32){
                    Toast.makeText(MainActivity.this, "Number too long", Toast.LENGTH_SHORT).show();
                }else{
                    text2.setText(text2.getText()+"tan(");
                    calculate=calculate+"Math.tan(";
                }
            }
        });

        buttonFact  = (Button)findViewById(R.id.fact);
        buttonFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Double d = Double.parseDouble(text2.getText().toString());
                    double fact = 1;
                    for (int i = 1; i <= d; i++) {
                        fact = fact * i;
                    }
                    text2.setText(text2.getText() + "!");
                    f = 1;
                    calculate = fact + "";
                }catch(Exception e){

                }
            }
        });

        buttonPow = (Button)findViewById(R.id.power);
        buttonPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText()!="") {
                    text2.setText(text2.getText() + "^");
                    calculate = "Math.pow(" + calculate.charAt(calculate.length() - 1) + ",";
                }
            }
        });


        buttonClear = (Button)findViewById(R.id.clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText("");
                text2.setText("");
                calculate="";
            }
        });


        buttonBackspace = (Button)findViewById(R.id.back);
        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(text2.getText()!=""){
                    if(text2.getText().charAt(text2.getText().length()-1)>='1' && text2.getText().charAt(text2.getText().length()-1)<='9') {
                        if(text2.getText().length()>=1){
                            text2.setText(text2.getText().toString().substring(0, text2.getText().length() - 1));
                            calculate=calculate.substring(0,calculate.length()-1);
                        }else{
                            text2.setText("");
                        }
                    }else if(text2.getText().charAt(text2.getText().length()-1)=='('){
                        text2.setText(text2.getText().toString().substring(0, text2.getText().length() - 4));
                        calculate=calculate.substring(0,calculate.length()-4);
                    }
                }else if(text2.getText()==""){

                }
            }
        });

        buttonBracketsClose = (Button)findViewById(R.id.brackets);
        buttonBracketsClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText()==""){

                }else{
                    text2.setText(text2.getText()+")");
                    String a=text2.getText().toString();
                    //String check=a.substring(a.length()-10,a.length()-1);
                    String b;
                    Double d,d2=0.0;
                    int k=0;
                    if(a.contains("tan")){
                        b= a.substring(a.indexOf("(")+1,a.indexOf(")"));
                        d=Double.parseDouble(b);
                        if(d%180!=0 && d%90==0){
                            tanFlag=1;
                            return;
                        }
                    }
                    if(a.contains("sin") || a.contains("cos") || a.contains("tan")){
                        b= a.substring(a.indexOf("(")+1,a.indexOf(")"));
                        d=Double.parseDouble(b);
                        d2=Math.toRadians(d);
                        k=b.length();
                        calculate=calculate.substring(0,calculate.length()-k)+d2+")";
                    }else{
                        calculate=calculate+")";
                    }
                    Log.d("checkingname",calculate);
                }
            }
        });

        buttonBracketsOpen  = (Button)findViewById(R.id.bracketf);
        buttonBracketsOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText(text2.getText()+"(");
                if(text2.getText().toString().contains("sin") || text2.getText().toString().contains("cos") || text2.getText().toString().contains("tan") || text2.getText().toString().contains("pow")){

                }else{
                    calculate=calculate+"(";
                }
            }
        });

        buttonRoot  = (Button)findViewById(R.id.root);
        buttonRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text2.getText().toString()!=""){
                    text2.setText("\u221A"+text2.getText());
                    Double d=Double.parseDouble(text2.getText().toString().substring(1,text2.getText().length()).toString());
                    calculate=calculate.replace(String.valueOf(d.intValue()),"")+"Math.sqrt("+d+")";
                }
            }
        });

        buttonDot = (Button)findViewById(R.id.dot);
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText(text2.getText()+".");
                calculate=calculate+".";
            }
        });

        buttonPI = (Button)findViewById(R.id.pi);
        buttonPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText(text2.getText()+(Math.PI+""));
                calculate=calculate+(Math.PI+"");
            }
        });


        buttonDivision = (Button)findViewById(R.id.divide);
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(calculate!=""){
                    calculate="("+calculate+")";
                }
                if(text2.getText().toString()!=""){
                    calculate=calculate+"/";
                    text2.setText(text2.getText()+"/");
                }
            }
        });


        buttonMod = (Button)findViewById(R.id.mod);
        buttonMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(calculate!=""){
                    calculate="("+calculate+")";
                }
                if(text2.getText().toString()!=""){
                    calculate=calculate+"%";
                    text2.setText(text2.getText()+"%");
                }
            }
        });


        buttonMultiply = (Button)findViewById(R.id.multiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(calculate!=""){
                    calculate="("+calculate+")";
                }
                if(text2.getText().toString()!=""){
                    calculate=calculate+"*";
                    text2.setText(text2.getText()+"X");
                }
            }
        });


        buttonDivideByX = (Button)findViewById(R.id.dividebyx);
        buttonDivideByX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText("1/"+text2.getText());
                calculate=calculate+"1/"+text2.getText();
            }
        });

        buttonMinus = (Button)findViewById(R.id.minus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(calculate!=""){
                    calculate="("+calculate+")";
                }
                if(text2.getText().toString()!=""){
                    calculate=calculate+"-";
                    text2.setText(text2.getText()+"-");
                }
            }
        });


        buttonPlus = (Button)findViewById(R.id.plus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(calculate!=""){
                    calculate="("+calculate+")";
                }
                if(text2.getText().toString()!=""){
                    calculate=calculate+"+";
                    text2.setText(text2.getText()+"+");
                }
            }
        });


        buttonEqual = (Button)findViewById(R.id.equal);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
                if(calculate!=""){
                    try{
                        if(text2.getText().toString().contains("^")){
                            calculate=calculate+")";
                        }
                        if(tanFlag==1){
                            text1.setText(text2.getText());
                            text2.setText("Undefined");
                            tanFlag=0;
                            return;
                        }
                        Log.d("calculation",calculate);
                        Double result=(Double)engine.eval(calculate);
                        Log.d("result",result.toString());
                        if(result%1==0) {
                            String a=String.format("%.0f", result);
                            text1.setText(text2.getText());
                            text2.setText(a);
                            Log.d("intcheck","yes");
                        }else{
                            text1.setText(text2.getText());
                            text2.setText(result.toString());
                            Log.d("intcheck","no");
                        }
                        boolean b=db.insertData(text1.getText().toString()+" = "+text2.getText().toString());
                    }catch(Exception e){
                        text1.setText(text2.getText());
                        text2.setText("Math error!");
                    }
                }
            }
        });
    }
}

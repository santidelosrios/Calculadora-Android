package com.example.user.calculadora1;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.util.Stack;


public class CalculadoraActivity extends ActionBarActivity {

    private EditText txtResultado;
    private Stack<Operation> operation;
    private Button btnAC;
    private Button btnCE;
    private Button btnAdd;
    private Button btnMinus;
    private Button btnTimes;
    private Button btnDivision;
    private String oper1;
    private String oper2;
    private boolean operacionCompleta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        inicializarObjetos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void inicializarObjetos(){
        btnAC = (Button) findViewById(R.id.AC);
        btnAC.setEnabled(false);
        btnCE = (Button) findViewById(R.id.CE);
        btnCE.setEnabled(false);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnTimes = (Button) findViewById(R.id.btnTimes);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        txtResultado = (EditText) findViewById(R.id.editText);
        txtResultado.setTextColor(0xCCCC0000);
        txtResultado.setEnabled(false);
        oper1="";
        oper2="";
        operacionCompleta=false;
        operation =  new Stack<Operation>();
    }
    public void get0(View view){
        if(operation.size()==0){
            oper1 += "0";
            txtResultado.setText(oper1);
        }
        if(operation.size()==2){
            oper2 += "0";
            oper1 += "0";
            txtResultado.setText(oper1);
        }
        checkStateAC();
        checkStateCE();
    }
    public void get1(View view){
        if(operation.size()==0){
            oper1 += "1";
            txtResultado.setText(oper1);
        }
        if(operation.size()==2){
            oper2 += "1";
            oper1 +="1";
            txtResultado.setText(oper1);
        }
        checkStateAC();
        checkStateCE();
    }
    public void get2(View view){
        if(operation.size()==0){
            oper1 += "2";
            txtResultado.setText(oper1);
        }
        if(operation.size()==2){
            oper2 +="2";
            oper1 +="2";
            txtResultado.setText(oper1);
        }
        checkStateAC();
        checkStateCE();
    }
    public void get3(View view){
        if(operation.size()==0){
            oper1 += "3";
            txtResultado.setText(oper1);
        }
        if(operation.size()==2){
            oper2 +="3";
            System.out.println(oper2);
            System.out.println(oper1);
            oper1 +="3";
            System.out.println(oper1);
            txtResultado.setText(oper1);
        }
        checkStateAC();
        checkStateCE();
    }
    public void get4(View view){
        if(operation.size()==0){
            oper1 +=  "4";
            txtResultado.setText(oper1);
        }
        if(operation.size()==2){
            oper2 += "4";
            oper1 += "4";
            txtResultado.setText(oper1);
        }
        checkStateAC();
        checkStateCE();
    }
    public void get5(View view){
        if(operation.size()==0){
            oper1 = oper1 + "5";
            txtResultado.setText(oper1);
        }
        if(operation.size()==2){
            oper2 = oper2+"5";
            oper1 += "5";
            txtResultado.setText(oper1);
        }
        checkStateAC();
        checkStateCE();
    }
    public void get6(View view){
        if(operation.size()==0){
            oper1 = oper1 + "6";
            txtResultado.setText(oper1);
        }
        if(operation.size()==2){
            oper2 +="6";
            oper1 +="6";
            txtResultado.setText(oper1);
        }
        checkStateAC();
        checkStateCE();
    }
    public void get7(View view){
        if(operation.size()==0){
            oper1 += "7";
            txtResultado.setText(oper1);
        }
        if(operation.size()==2){
            oper2 +="7";
            oper1 +="7";
            txtResultado.setText(oper1);
        }
        checkStateAC();
        checkStateCE();
    }
    public void get8(View view){
        if(operation.size()==0){
            oper1 += "8";
            txtResultado.setText(oper1);
        }
        if(operation.size()==2){
            oper2 +="8";
            oper1 +="8";
            txtResultado.setText(oper1);
        }
        checkStateAC();
        checkStateCE();
    }
    public void get9(View view){
        if(operation.size()==0){
            oper1 +="9";
            txtResultado.setText(oper1);
        }
        if(operation.size()==2){
            oper2 +="9";
            oper1 += "9";
            txtResultado.setText(oper1);
        }
        checkStateAC();
        checkStateCE();
    }
    public void getAdd(View view){
        if(operation.size()==0 && oper1.length()>0) {
            System.out.println(oper1);
            operation.add(new Operation(true, Integer.parseInt(oper1), ""));
            oper1+="+";
            txtResultado.setText(oper1);
            operation.add(new Operation(false, 0, "+"));
        }
        checkStateAC();
        checkStateCE();
    }
    public void getMinus(View view){
        if(operation.size()==0) {
            operation.add(new Operation(true, Integer.parseInt(oper1), ""));
            oper1+="-";
            txtResultado.setText(oper1);
            operation.add(new Operation(false, 0, "-"));
        }
        checkStateAC();
        checkStateCE();
    }
    public void getTimes(View view){
        if(operation.size()==0) {
            operation.add(new Operation(true, Integer.parseInt(oper1), ""));
            oper1+="*";
            txtResultado.setText(oper1);
            operation.add(new Operation(false, 0, "*"));
        }
        checkStateAC();
        checkStateCE();
    }
    public void getDivision(View view){
        if(operation.size()==0) {
            operation.add(new Operation(true, Integer.parseInt(oper1), ""));
            oper1+="/";
            txtResultado.setText(oper1);
            operation.add(new Operation(false, 0, "/"));
        }
        checkStateAC();
        checkStateCE();
    }
    public void getEquals(View view){
        if(operation.size()==2){
            double operando2 = (double) Integer.parseInt(oper2);
            String operador = operation.pop().getOperador();
            double operando1 = (double)operation.pop().getOperando();
            double resultado = 0;
            if(operador.equals("+")) {
                resultado = operando1+operando2;
                txtResultado.setText("El resultado es: " + resultado);
            }
            if(operador.equals("-")) {
                resultado = operando1-operando2;
                System.out.println(resultado);
                txtResultado.setText("El resultado es: " + resultado);
            }
            if(operador.equals("*")) {
                resultado = operando1*operando2;
                txtResultado.setText("El resultado es: " + resultado);
            }
            if(operador.equals("/")) {
                if(operando2!=0){
                    resultado = (operando1/operando2);
                    txtResultado.setText("El resultado es: " + resultado);
                }else{
                    txtResultado.setText("Imposible dividir por cero. Por favor empiece de nuevo");
                }
            }
            operation.clear();
            operacionCompleta=true;
        }else{
            txtResultado.setText("Error, se esperaba una operacion. Empiece de nuevo");
            operation.clear();
        }
        oper1 ="";
        oper2="";
        checkStateAC();
        checkStateCE();
    }
    public void getAC(View view){
       operation.clear();
        oper1="";
        oper2="";
        txtResultado.setText("Calculadora limpiada, empiece otra operacion");
        btnAC.setEnabled(false);
        btnCE.setEnabled(true);
        operacionCompleta=false;
    }
    public void getCE(View view){
        if(oper1.length()>0) {
            if (operation.size() == 2 && (oper1.charAt(oper1.length() - 1) == '+' || oper1.charAt(oper1.length() - 1) == '-' || oper1.charAt(oper1.length() - 1) == '*' || oper1.charAt(oper1.length() - 1) == '/')) {
                operation.pop();
                operation.pop();
                oper1 = oper1.substring(0, oper1.length() - 1);
                txtResultado.setText(oper1);
            } else if (operation.size() == 2 && !(oper1.charAt(oper1.length() - 1) == '+' || oper1.charAt(oper1.length() - 1) == '-' || oper1.charAt(oper1.length() - 1) == '*' || oper1.charAt(oper1.length() - 1) == '/')) {
                oper1 = oper1.substring(0, oper1.length() - 1);
                oper2 = oper2.substring(0,oper2.length()-1);
                txtResultado.setText(oper1);
            } else {
                oper1 = oper1.substring(0, oper1.length() - 1);
                txtResultado.setText(oper1);
            }

        }
    }
    public void checkStateAC(){
        if(operacionCompleta){
            btnAC.setEnabled(true);
        }else{
            btnAC.setEnabled(false);
        }
    }
    public void checkStateCE(){
        if(oper1.length()>0) {
            if (!operacionCompleta) {
                btnCE.setEnabled(true);
            } else {
                btnCE.setEnabled(false);
            }
        }else{
            btnCE.setEnabled(false);
        }
    }



}

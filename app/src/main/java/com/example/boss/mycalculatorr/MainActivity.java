package com.example.boss.mycalculatorr;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int op = 0;
    static int a = 0,operatorClicked=0;
    static String s1 = "", s2 = "", operator = "", s3 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = "0";
        s2 = "";
        s3="";
    }

    public void allClear(View view) {
        TextView tv1 = (TextView) findViewById(R.id.textview);
        TextView tv2 = (TextView) findViewById(R.id.finalView);
        s1 = "0";
        s2 = "";
        s3 = "";
        operator = "";
        op = 0;
        a=0;
        tv1.setText("0");
        tv2.setText("");
    }

    public void delete(View view) {
        if (!(s1.length()==1&&s1.charAt(0)=='0')) {
            System.out.println("hhhhhhhhhhhhhhhh111111111");
            if (op == 1 && s2 != "") {
                System.out.println("hhhhhhhhhhhhhhhh22222222");
                if (s2.length() == 1)
                    s2 = "";
                else {
                    s2 = s2.substring(0, s2.length() - 1);
                    System.out.println("hhhhhhhhhhhhhhhh33333333333");
                }
            } else if (op == 1 && s2 == "") {
                System.out.println("hhhhhhhhhhhhhhhh444444444444");
                op = 0;
                operator = "";
            }
            else if ((s1.length()==1)) {
                s1="0";
            }   else
             {
                s1 = s1.substring(0, s1.length() - 1);
            }
        } else {
            System.out.println("hhhhhhhhhhhhhhhh55555555555555");
            s1 = "0";
            s2 = "";
        }
        display();
    }

    public void percentage(View view) {
        if (a == 1) {
            a = 0;
            if (s2.length() != 0) {
                if (operator == "+")
                    s1 = Double.toString((Double.parseDouble(s1) + Double.parseDouble(s2)) / 100);
                if (operator == "-")
                    s1 = Double.toString((Double.parseDouble(s1) - Double.parseDouble(s2)) / 100);
                if (operator == "x")
                    s1 = Double.toString((Double.parseDouble(s1) * Double.parseDouble(s2)) / 100);
                if (operator == "/")
                    s1 = Double.toString((Double.parseDouble(s1) / Double.parseDouble(s2)) / 100);
                s2 = "";
                if(op==0)s3=s1;
                op=0;
                operator = "";
            }
        } else {
            if (Double.parseDouble(s1) == 0.0&&op==0) {
                s1 = "0";
            }
            else if(Double.parseDouble(s1) != 0.0&&op==0)
            {
                s1=Double.toString(Double.parseDouble(s1)/100);
            }
            else if (s2 != "") {

                if (op == 0) {
                    double d = Double.parseDouble(s1) / 100;
                    s1 = Double.toString(d);
                } else {
                    double d = Double.parseDouble(s2) / 100;
                    s2 = Double.toString(d);
                }
            }
            if(op==0)s3=s1;
            op=0;
        }
        operatorClicked=1;
        display();
    }

    public void divide(View view) {
        if (op == 1) {
            if (s2.length() != 0) {
                if (operator == "+")
                    s1 = Double.toString(Double.parseDouble(s1) + Double.parseDouble(s2));
                if (operator == "-")
                    s1 = Double.toString(Double.parseDouble(s1) - Double.parseDouble(s2));
                if (operator == "x")
                    s1 = Double.toString(Double.parseDouble(s1) * Double.parseDouble(s2));
                if (operator == "/")
                    s1 = Double.toString(Double.parseDouble(s1) / Double.parseDouble(s2));
            }
            s2 = "";
        }
        operator = "/";
        op = 1;
        display();
    }

    public void seven(View view) {
        if (op == 1)
            s2 += "7";
        else if (Double.parseDouble(s1) == 0L&&s1.contains(".")==false)
            s1 = "7";
        else
            s1 += "7";
        operatorClicked=1;
        display();
    }

    public void eight(View view) {
        TextView tv = (TextView) findViewById(R.id.eight_button);
        if (op == 1)
            s2 += "8";
        else if (Double.parseDouble(s1) == 0L&&s1.contains(".")==false)
            s1 = "8";
        else
            s1 += "8";
        display();
    }

    public void nine(View view) {
        TextView tv = (TextView) findViewById(R.id.nine_button);
        if (op == 1)
            s2 += "9";
        else if (Double.parseDouble(s1) == 0L&&s1.contains(".")==false)
            s1 = "9";
        else
            s1 += "9";
        display();
    }

    public void multiply(View view) {
        if (op == 1) {
            if (s2.length() != 0) {
                if (operator == "+")
                    s1 = Double.toString(Double.parseDouble(s1) + Double.parseDouble(s2));
                if (operator == "-")
                    s1 = Double.toString(Double.parseDouble(s1) - Double.parseDouble(s2));
                if (operator == "x")
                    s1 = Double.toString(Double.parseDouble(s1) * Double.parseDouble(s2));
                if (operator == "/")
                    s1 = Double.toString(Double.parseDouble(s1) / Double.parseDouble(s2));
            }
            s2 = "";
        }
        operator = "x";
        op = 1;
        operatorClicked=1;
        display();
    }

    public void four(View view) {
        TextView tv = (TextView) findViewById(R.id.four_button);
        if (op == 1)
            s2 += "4";
        else if (Double.parseDouble(s1) == 0L&&s1.contains(".")==false)
            s1 = "4";
        else
            s1 += "4";
        display();
    }

    public void five(View view) {
        TextView tv = (TextView) findViewById(R.id.five_button);
        if (op == 1)
            s2 += "5";
        else if (Double.parseDouble(s1) == 0L&&s1.contains(".")==false)
            s1 = "5";
        else
            s1 += "5";
        display();
    }

    public void six(View view) {
        TextView tv = (TextView) findViewById(R.id.six_button);
        if (op == 1)
            s2 += "6";
        else if (Double.parseDouble(s1) == 0L&&s1.contains(".")==false)
            s1 = "6";
        else
            s1 += "6";
        display();
    }

    public void subtract(View view) {
        if (op == 1) {
            if (s2.length() != 0) {
                if (operator == "+")
                    s1 = Double.toString(Double.parseDouble(s1) + Double.parseDouble(s2));
                if (operator == "-")
                    s1 = Double.toString(Double.parseDouble(s1) - Double.parseDouble(s2));
                if (operator == "x")
                    s1 = Double.toString(Double.parseDouble(s1) * Double.parseDouble(s2));
                if (operator == "/")
                    s1 = Double.toString(Double.parseDouble(s1) / Double.parseDouble(s2));
            }
            s2 = "";
        }
        operator = "-";
        op = 1;
        operatorClicked=1;
        display();
    }

    public void one(View view) {
        TextView tv = (TextView) findViewById(R.id.one_button);
        if (op == 1)
            s2 += "1";
        else if (Double.parseDouble(s1) == 0L&&s1.contains(".")==false)
            s1 = "1";
        else
            s1 += "1";
        display();
    }

    public void two(View view) {
        TextView tv = (TextView) findViewById(R.id.two_button);
        if (op == 1)
            s2 += "2";
        else if (Double.parseDouble(s1) == 0L&&s1.contains(".")==false)
            s1 = "2";
        else
            s1 += "2";
        display();
    }

    public void three(View view) {
        TextView tv = (TextView) findViewById(R.id.three_button);
        if (op == 1)
            s2 += "3";
        else if (Double.parseDouble(s1) == 0L&&s1.contains(".")==false)
            s1 = "3";
        else
            s1 += "3";
        display();
    }

    public void addition(View view) {
        if (op == 1) {
            if (s2.length() != 0) {
                if (operator == "+")
                    s1 = Double.toString(Double.parseDouble(s1) + Double.parseDouble(s2));
                if (operator == "-")
                    s1 = Double.toString(Double.parseDouble(s1) - Double.parseDouble(s2));
                if (operator == "x")
                    s1 = Double.toString(Double.parseDouble(s1) * Double.parseDouble(s2));
                if (operator == "/")
                    s1 = Double.toString(Double.parseDouble(s1) / Double.parseDouble(s2));
            }
            s2 = "";
        }
        operator = "+";
        op = 1;
        operatorClicked=1;
        display();
    }

    public void zero(View view) {
        if (op == 1)
            s2 += "0";
        else if (Double.parseDouble(s1) == 0L&&s1.contains(".")==false)
            s1 = "0";
        else
            s1 += "0";
        display();
    }

    public void doubleZero(View view) {
        TextView tv = (TextView) findViewById(R.id.doubleZero_button);
        if (op == 1)
            s2 += "00";
        else if (Double.parseDouble(s1) == 0L&&s1.contains(".")==false)
            s1 = "00";
        else
            s1 += "00";
        display();
    }

    public void point(View view) {
        if (op == 0 && s1.contains(".") == false) {
            s1 += ".";
        } else if (op == 1 && s2.contains(".") == false && s2.length() == 0) {
            s2 += "0.";
        } else if (op == 1 && s2.contains(".") == false) {
            s2 += ".";
        }
        display();
    }

    public void equal(View view) {
        if (op == 1 && s2.length() != 0) {
            if (operator == "+")
                s3 = Double.toString(Double.parseDouble(s1) + Double.parseDouble(s2));
            if (operator == "-")
                s3 = Double.toString(Double.parseDouble(s1) - Double.parseDouble(s2));
            if (operator == "x")
                s3 = Double.toString(Double.parseDouble(s1) * Double.parseDouble(s2));
            if (operator == "/") {
                  s3 = Double.toString(Double.parseDouble(s1) / Double.parseDouble(s2));
              }
            s3 = s3;
        } else if (op == 1 && s2.length() == 0) {
            s3 = "error";
        } else {
            s3 = s1;
        }

        System.out.println("dfdff"+s3);
        operatorClicked=1;
        display();
        a = 1;
        s3 = "";
    }

    public void display() {
        TextView tv1 = (TextView) findViewById(R.id.textview);
        TextView tv2 = (TextView) findViewById(R.id.finalView);
        if(s1.length()>10&&operatorClicked==1){s1=String.format("%.2E",Double.parseDouble(s1));operatorClicked=0;}
        if(s2.length()>10&&operatorClicked==1){s2=String.format("%.2E",Double.parseDouble(s2));operatorClicked=0;}
        if(s3.length()>10&&operatorClicked==1){s3=String.format("%.2E",Double.parseDouble(s3));operatorClicked=0;}
        tv1.setText(s1 + operator + s2);
        if(s3.length()>0)tv2.setText("="+s3);
        String read1 = (String) tv2.getText();
        String read2 = (String) tv1.getText();
        if (read1.equals("=Infinity"))
            tv2.setText("∞");
        if (read1.equals("=NaN"))
            tv2.setText("Error");
        if (read2.contains("Infinity")) {
            tv1.setText("");
            tv2.setText("∞");
            s1="";s2="";s3="";op=0;operator="";
        }
        if (read2.contains("NaN")) {
            tv1.setText("");
            tv2.setText("Error");
            s1="";s2="";s3="";op=0;operator="";
        }
    }
}

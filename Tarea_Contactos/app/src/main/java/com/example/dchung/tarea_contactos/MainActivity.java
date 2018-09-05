package com.example.dchung.tarea_contactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.LocaleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtTelefono;
    private EditText txtEmail;
    private EditText txtDescripcion;
    private DatePicker DpFechaNac;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSiguiente=(Button)findViewById(R.id.btnSiguiente);
        final DatePicker DpFechaNac=(DatePicker)findViewById(R.id.dpFecha);
        txtNombre=(EditText) findViewById(R.id.txtNombre);
        txtTelefono=(EditText)findViewById(R.id.txtTelefono);
        txtEmail=(EditText)findViewById(R.id.txtEmail);
        txtDescripcion=(EditText)findViewById(R.id.txtDescripcion);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNombre;
                String strDias,strMes;
                String strFechaNac="";
                String strTelefono="";
                String strEmail="";
                String strDescripcion="";

                strNombre=txtNombre.getText().toString();
                int intAnno=DpFechaNac.getYear();
                int intMes=DpFechaNac.getMonth();
                int intDia=DpFechaNac.getDayOfMonth();
                Date FechaNac=new Date(intAnno,intMes,intDia);

                //Dia para que salga el 0 adelante
                if (Integer.toString(intDia).length()!=2)
                {
                    strDias="0"+intDia;
                }
                else
                {
                    strDias= String.valueOf(intDia);
                }

                //Mes para que salga el 0 adelante
                if (Integer.toString(intMes).length()!=2)
                {
                    strMes="0"+(intMes+1);
                }
                else
                {
                    strMes= String.valueOf(intMes+1);
                }
                strFechaNac=strDias+"/"+strMes+"/"+intAnno;
                strTelefono=txtTelefono.getText().toString();
                strEmail=txtEmail.getText().toString();
                strDescripcion=txtDescripcion.getText().toString();


                if (strNombre.length()==0 || strFechaNac.length()==0 || strTelefono.length()==0 || strEmail.length()==0 || strDescripcion.length()==0 )
                {
                    Snackbar.make(v,getResources().getString(R.string.Mensaje),Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent1=new Intent(MainActivity.this,ConfirmacionRegistro.class);
                    intent1.putExtra(getResources().getString(R.string.pNombre),strNombre);
                    intent1.putExtra(getResources().getString(R.string.pFechaNac),strFechaNac);
                    intent1.putExtra(getResources().getString(R.string.pTelefono),strTelefono);
                    intent1.putExtra(getResources().getString(R.string.pEmail),strEmail);
                    intent1.putExtra(getResources().getString(R.string.pDescrip),strDescripcion);
                    startActivity(intent1);
                }

            }
        });



        Intent intent = getIntent();
        if (null != intent) { //Null Checking

                String strFechaNac_1="";
                int dia;
                int mes;
                int anno;


                strFechaNac_1=intent.getStringExtra(getResources().getString(R.string.pFechaNac));

                if (strFechaNac_1!=null)
                {
                    dia = Integer.parseInt(strFechaNac_1.substring(1, 2));
                    mes = Integer.parseInt(strFechaNac_1.substring(4, 5));
                    anno = Integer.parseInt(strFechaNac_1.substring(6, 10));

                    DpFechaNac.init(anno, mes-1, dia, null);
                }

                txtNombre.setText(intent.getStringExtra(getResources().getString(R.string.pNombre)));
                txtTelefono.setText(intent.getStringExtra(getResources().getString(R.string.pTelefono)));
                txtEmail.setText(intent.getStringExtra(getResources().getString(R.string.pEmail)));
                txtDescripcion.setText(intent.getStringExtra(getResources().getString(R.string.pDescrip)));

        }

    }

}

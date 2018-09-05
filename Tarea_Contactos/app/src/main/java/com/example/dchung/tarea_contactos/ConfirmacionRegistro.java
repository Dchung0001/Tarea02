package com.example.dchung.tarea_contactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionRegistro extends AppCompatActivity {

    private TextView tvNombreData;
    private TextView tvFechaData;
    private TextView tvTelefonoData;
    private TextView tvEmailData;
    private TextView tvDescripcionData;
    private Button btnEditar;
    private String strnombre;
    private String strFechaNac;
    private String strTelefono;
    private String strEmail;
    String strDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_registro);

        Bundle parametros = getIntent().getExtras();
        strnombre = parametros.getString(getResources().getString(R.string.pNombre));
        strFechaNac=parametros.getString(getResources().getString(R.string.pFechaNac));
        strTelefono=parametros.getString(getResources().getString(R.string.pTelefono));
        strEmail=parametros.getString(getResources().getString(R.string.pEmail));
        strDescripcion=parametros.getString(getResources().getString(R.string.pDescrip));

        tvNombreData = (TextView) findViewById(R.id.tvNombre);
        tvFechaData=(TextView)findViewById(R.id.tvfechaData);
        tvTelefonoData=(TextView)findViewById(R.id.tvTelefonoData);
        tvEmailData=(TextView)findViewById(R.id.tvEmailData);
        tvDescripcionData=(TextView)findViewById(R.id.tvDescripData);
        Button btnEditar=(Button)findViewById(R.id.btnEditar);

        tvNombreData.setText(strnombre);
        tvFechaData.setText(strFechaNac);
        tvTelefonoData.setText(strTelefono);
        tvEmailData.setText(strEmail);
        tvDescripcionData.setText(strDescripcion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConfirmacionRegistro.this,MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pNombre), strnombre);
                intent.putExtra(getResources().getString(R.string.pFechaNac), strFechaNac);
                intent.putExtra(getResources().getString(R.string.pTelefono), strTelefono);
                intent.putExtra(getResources().getString(R.string.pEmail), strEmail);
                intent.putExtra(getResources().getString(R.string.pDescrip), strDescripcion);
                startActivity(intent);
            }
        });

    }


}

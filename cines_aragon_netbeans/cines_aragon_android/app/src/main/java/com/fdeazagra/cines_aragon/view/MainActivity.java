package com.fdeazagra.cines_aragon.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fdeazagra.cines_aragon.R;
import com.fdeazagra.cines_aragon.buscar_cine.BuscarCineContract;
import com.fdeazagra.cines_aragon.buscar_cine.BuscarCinePresenter;
import com.fdeazagra.cines_aragon.model.Cine;
import com.fdeazagra.cines_aragon.model.User;
import com.fdeazagra.cines_aragon.login_user.LoginUserContract;
import com.fdeazagra.cines_aragon.login_user.LoginUserPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements LoginUserContract.View, BuscarCineContract.View {

    private EditText edtUser;
    private EditText edtPass;
    private Button btnLogin;
    private Button btnBuscar;
    private Spinner spBusca;
    private LoginUserPresenter loginUserPresenter;
    private BuscarCinePresenter buscarCinePresenter;
    private String txtEmail;
    private String txtPassword;
    private String selecSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Instanciar Presenter*/
        loginUserPresenter = new LoginUserPresenter(this);
        buscarCinePresenter = new BuscarCinePresenter(this);

        initComponents();

        /*Crear el Spinner*/
        String [] opciones = {"Zaragoza", "Huesca", "Teruel"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, opciones);
        spBusca.setAdapter(adapter);

        /*Accion al pulsar el boton Login*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtEmail=edtUser.getText().toString();
                txtPassword=edtPass.getText().toString();
                User usuario = new User();
                usuario.setEmail(txtEmail);
                usuario.setPassword(txtPassword);
                loginUserPresenter.getUser(usuario);

            }
        });

        /*Accion al pulsar el boton Buscar*/
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selecSpinner=spBusca.getSelectedItem().toString();
                Cine cine = new Cine();
                cine.setProvincia(selecSpinner);
                buscarCinePresenter.getByProvincia(cine);
            }
        });

    }
    /*Declaramos objetos del layout*/
    private void initComponents(){
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        spBusca = (Spinner) findViewById(R.id.spBusca);
        btnBuscar = (Button) findViewById(R.id.btnSpinner);
    }

    @Override
    public void successLogin(User usuario) {
        Toast.makeText(this, "Bienvenido "
                + usuario.getNombre(), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getBaseContext(), MenuPrincipal.class);
        startActivity(intent);

    }

    @Override
    public void failureLogin(String message) {
        Toast.makeText(this, message,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void successCines(ArrayList<Cine> lstCines) {
        Toast.makeText(this, "Hay "+ lstCines.size()
                        + " salas de cine en " + selecSpinner, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getBaseContext(), CinesCercanos.class);
        intent.putExtra("valor", selecSpinner);
        intent.putExtra("propiedad", "provincia");
        startActivity(intent);
    }

    @Override
    public void failureCines(String message) {
        Toast.makeText(this, message,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

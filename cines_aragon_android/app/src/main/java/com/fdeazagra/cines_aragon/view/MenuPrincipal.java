package com.fdeazagra.cines_aragon.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fdeazagra.cines_aragon.R;
import com.fdeazagra.cines_aragon.buscar_cine.BuscarCineContract;
import com.fdeazagra.cines_aragon.buscar_cine.BuscarCinePresenter;
import com.fdeazagra.cines_aragon.buscar_Pelicula.BuscarPeliculaContract;
import com.fdeazagra.cines_aragon.buscar_Pelicula.BuscarPeliculaPresenter;
import com.fdeazagra.cines_aragon.login_user.LoginUserContract;
import com.fdeazagra.cines_aragon.login_user.LoginUserPresenter;
import com.fdeazagra.cines_aragon.model.Cine;
import com.fdeazagra.cines_aragon.model.Constantes;
import com.fdeazagra.cines_aragon.model.Pelicula;
import com.fdeazagra.cines_aragon.model.Ticket;
import com.fdeazagra.cines_aragon.model.User;
import com.fdeazagra.cines_aragon.webservice.PeliculaI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuPrincipal extends AppCompatActivity
        implements BuscarPeliculaContract.View, LoginUserContract.View, BuscarCineContract.View{

    private Button btnPeliculas;
    private Button btnGenero;
    private Button btnCines;
    private Button btnProvincia;
    private Button btnCartelera;
    private Button btnTickets;
    private Spinner spPeliculas;
    private Spinner spGenero;
    private Spinner spCines;
    private Spinner spProvincia;
    private BuscarCinePresenter buscarCinePresenter;
    private BuscarPeliculaPresenter buscarPeliculaPresenter;
    private LoginUserPresenter loginUserPresenter;
    private String selecSpPeliculas;
    private String selecSpGenero;
    private String selecSpCines;
    private String selecSpProvincia;
    private String filtroCine;
    private String filtroPelicula;
    private String filtro;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        /*Instanciar Presenter*/
        buscarPeliculaPresenter = new BuscarPeliculaPresenter(this);
        buscarCinePresenter = new BuscarCinePresenter(this);
        loginUserPresenter = new LoginUserPresenter(this);

        String nombreUsuario = getIntent().getStringExtra("nombre");

        initComponents();

        /*Crear los Spinner*/
        ArrayAdapter<String> adapterPeliculas = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Constantes.TITULOS);
        spPeliculas.setAdapter(adapterPeliculas);

        ArrayAdapter<String> adapterCines = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Constantes.CINES);
        spCines.setAdapter(adapterCines);

        ArrayAdapter<String> adapterGeneros = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Constantes.GENEROS);
        spGenero.setAdapter(adapterGeneros);

        ArrayAdapter<String> adapterProvincias = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Constantes.PROVINCIAS);
        spProvincia.setAdapter(adapterProvincias);

        /*Accion al pulsar el boton Peliculas*/
        btnPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selecSpPeliculas=spPeliculas.getSelectedItem().toString();
                Pelicula pelicula = new Pelicula();
                pelicula.setTitulo(selecSpPeliculas);
                filtroPelicula = "ficha";
                buscarPeliculaPresenter.getFicha(pelicula);
            }
        });

        /*Accion al pulsar el boton Cines*/
        btnCines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selecSpCines=spCines.getSelectedItem().toString();
                Cine cine = new Cine();
                cine.setNombre(selecSpCines);
                filtroCine = selecSpCines;
                filtro= "nombre";
                buscarCinePresenter.getByNombre(cine);
            }
        });

        /*Accion al pulsar el boton Genero*/
        btnGenero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selecSpGenero=spGenero.getSelectedItem().toString();
                Pelicula pelicula = new Pelicula();
                pelicula.setGenero(selecSpGenero);
                filtroPelicula = "genero";
                buscarPeliculaPresenter.getByGenero(pelicula);
            }
        });

        /*Accion al pulsar el boton Provincia*/
        btnProvincia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selecSpProvincia=spProvincia.getSelectedItem().toString();
                Cine cine = new Cine();
                cine.setProvincia(selecSpProvincia);
                filtroCine = selecSpProvincia;
                filtro= "provincia";
                buscarCinePresenter.getByProvincia(cine);
            }
        });

        /*Accion al pulsar el boton Cartelera*/
        btnCartelera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), PeliculasCartelera.class);
                startActivity(intent);
            }
        });

        /*Accion al pulsar el boton Tickets*/
        btnTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setNombre(nombreUsuario);
                loginUserPresenter.getTickets(user);
            }
        });

    }

    /*Declaramos objetos del layout*/
    private void initComponents(){

        btnPeliculas = (Button) findViewById(R.id.btnPeliculas);
        btnCines = (Button) findViewById(R.id.btnCines);
        btnGenero = (Button) findViewById(R.id.btnGenero);
        btnProvincia = (Button) findViewById(R.id.btnProvincia);
        btnCartelera = (Button) findViewById(R.id.btnCartelera);
        btnTickets = (Button) findViewById(R.id.btnTickets);
        spPeliculas = (Spinner) findViewById(R.id.spPeliculas);
        spCines = (Spinner) findViewById(R.id.spCines);
        spGenero = (Spinner) findViewById(R.id.spGenero);
        spProvincia = (Spinner) findViewById(R.id.spProvincia);
    }

    @Override
    public void successCines(ArrayList<Cine> lstCines) {

        Intent intent = new Intent(getBaseContext(), CinesCercanos.class);
        intent.putExtra("valor", filtroCine);
        intent.putExtra("propiedad", filtro);
        startActivity(intent);
    }

    @Override
    public void failureCines(String message) {

        Toast.makeText(this, message,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void successBuscarPeliculas(ArrayList<Pelicula> lstPeliculas) {

        if (filtroPelicula.equals("ficha")) {

            Intent intent = new Intent(getBaseContext(), PeliculaFicha.class);
            intent.putExtra("valor", selecSpPeliculas);
            startActivity(intent);
        }

        if (filtroPelicula.equals("genero")) {

            Intent intent = new Intent(getBaseContext(), PeliculasByGenero.class);
            intent.putExtra("valor", selecSpGenero);
            startActivity(intent);
        }

    }

    @Override
    public void failureBuscarPeliculas(String message) {

        Toast.makeText(this, message,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void successLogin(ArrayList<User> usuarios, ArrayList<Ticket> tickets) {

        for (Ticket ticket: tickets){
            user = ticket.getUsuario();
        }
        Intent intent = new Intent(getBaseContext(), TicketsHistorico.class);
        intent.putExtra("valor", user);
        startActivity(intent);
    }

    @Override
    public void failureLogin(String message) {

        Toast.makeText(this, message,
                Toast.LENGTH_LONG).show();
    }
}

package com.example.proyectitofinal.vistas;

import static com.example.proyectitofinal.R.*;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.proyectitofinal.R;
import com.example.proyectitofinal.clases.Usuario;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class App extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;
    private static final int PAGINA_PRINCIPAL = R.id.bottom_principal;
    private static final int PAGINA_REGISTRO = R.id.bottom_registrar;
    private static final int PAGINA_ESTADISTICAS = R.id.bottom_stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app);
        bottomNavigationView = findViewById(R.id.navBottom);
        bottomNavigationView.setItemActiveIndicatorColor(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        View vista = navigationView.getHeaderView(0);
        TextView nombre_edad = vista.findViewById(id.nombreProfile);
        TextView sexo = vista.findViewById(id.sexoProfile);
        TextView colonia_delegacion = vista.findViewById(id.locProfile);
        Intent intent = getIntent();
        String claveUsuario = intent.getStringExtra("Clave");


        Usuario usuario = Usuario.recuperarDeBase(this, claveUsuario);
        nombre_edad.setText(String.format("%s (%d años)", usuario.getNombre(), usuario.getEdad()));
        sexo.setText(usuario.getSexo());
        colonia_delegacion.setText(String.format("%s/%s", usuario.getDelegacion(), usuario.getColonia()));
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, (R.string.open), (R.string.close));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    MainPage.newInstance(claveUsuario)).commit();
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == PAGINA_PRINCIPAL) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        MainPage.newInstance(claveUsuario)).commit();
            } else if (item.getItemId() == PAGINA_REGISTRO) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        RegistroTransaccion.newInstance(claveUsuario)).commit();
            } else if (item.getItemId() == PAGINA_ESTADISTICAS) {
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                //        new Estadisticas()).commit();
            }
            return true;
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
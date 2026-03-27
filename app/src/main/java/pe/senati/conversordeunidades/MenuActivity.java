package pe.senati.conversordeunidades;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import androidx.navigation.ui.AppBarConfiguration;

import pe.senati.conversordeunidades.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    public void alPresionarLongitud(View view) {
        Intent iniciarLongitud = new Intent(this, LongitudActivity.class);
        startActivity(iniciarLongitud);
    }

    public void alPresionarPeso(View view){
        Intent iniciarPeso = new Intent(this, PesoActivity.class);
        startActivity(iniciarPeso);
    }

    public void alPresionarTemperatura(View view) {
        Intent iniciarTemperatura = new Intent(this, TemperaturaActivity.class);
        startActivity(iniciarTemperatura);
    }

}
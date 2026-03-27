package pe.senati.conversordeunidades;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import pe.senati.conversordeunidades.databinding.ActivityTemperaturaBinding;


public class TemperaturaActivity extends AppCompatActivity {

    private ActivityTemperaturaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTemperaturaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.selectorUnidad.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                Arrays.asList(opciones)));
    }

    // Aquí se encuentra la lista de opciones posibles
    String[] opciones = new String[]{"C", "F", "K", "R"};

    public void alPresionarCalcular(View view) {
        //Aquí obtenemos el valor ingresado
        double valor = Double.parseDouble(binding.campoValor.getText().toString());
        // Aquí obtenemos la unidad seleccionada
        String unidadSeleccionada = binding.selectorUnidad.getSelectedItem().toString();

        // Crea aquí las variables


        // Realiza aquí las comparaciones de la unidadSeleccionada con cada una de las opciones

        // Aquí formamos el resultado
        String resultado = valor + unidadSeleccionada + " es";
        // Forma aquí el resultado

        binding.textoResultado.setText(resultado);
    }
}
package pe.senati.conversordeunidades;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;

import pe.senati.conversordeunidades.databinding.ActivityLongitudBinding;


public class LongitudActivity extends AppCompatActivity {

    private ActivityLongitudBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLongitudBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.selectorUnidad.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                Arrays.asList(opciones)));
    }

    // Aquí se encuentra la lista de opciones posibles
    String[] opciones = new String[]{"mm", "cm", "m", "km"};
    public void alPresionarCalcular(View view) {
        //Aquí obtenemos el valor ingresado
        double valor = Double.parseDouble(binding.campoValor.getText().toString());

        // Aquí obtenemos la unidad seleccionada
        String unidadSeleccionada = binding.selectorUnidad.getSelectedItem().toString();

        // Aquí creamos las variables que se utilizarán para realizar los cálculos
        double milimetros = 0;
        double centimetros = 0;
        double metros = 0;
        double kilometros = 0;

        // Aquí comparamos la unidad seleccionada con cada una de las opciones disponibles
        if(unidadSeleccionada == "mm") {
            // Se ha seleccionado milímetros
            milimetros = valor;
            centimetros = valor / 10;
            metros = valor / 1000;
            kilometros = valor / 1000000;
        } else if (unidadSeleccionada == "cm") {
            // Se ha seleccionado centímetros
            milimetros = valor * 10;
            centimetros = valor;
            metros = valor / 100;
            kilometros = valor / 100000;
        } else if (unidadSeleccionada == "m") {
            // Se ha seleccionado metros
            milimetros = valor * 1000;
            centimetros = valor * 100;
            metros = valor;
            kilometros = valor / 1000;
        } else if (unidadSeleccionada == "km") {
            // Se ha seleccionado kilómetros
            milimetros = valor * 1000000;
            centimetros = valor * 100000;
            metros = valor * 1000;
            kilometros = valor;
        }

        // Aquí formamos el resultado
        String resultado = valor + unidadSeleccionada + " es";
        resultado = resultado + "\nEn milimetros: " + milimetros + "mm";
        resultado = resultado + "\nEn centímetros: " + centimetros + "cm";
        resultado = resultado + "\nEn metros: " + metros + "m";
        resultado = resultado + "\nEn kilómetros: " + kilometros + "km";
        binding.textoResultado.setText(resultado);
    }

}
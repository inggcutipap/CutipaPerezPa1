package com.gocp.cutipaperez.fragment.ejercicios;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gocp.cutipaperez.R;


public class AreaTrianguloFragment extends Fragment {

    EditText etLadoA, etLadoB, etLadoC;
    Button btnCalcular;
    TextView tvResultado;

    public AreaTrianguloFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_area_triangulo, container, false);

        etLadoA = view.findViewById(R.id.etLadoA);
        etLadoB = view.findViewById(R.id.etLadoB);
        etLadoC = view.findViewById(R.id.etLadoC);
        btnCalcular = view.findViewById(R.id.btnCalcular);
        tvResultado = view.findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularArea();
            }
        });

        return view;
    }
    private void calcularArea() {

        String sLadoA = etLadoA.getText().toString().trim();
        String sLadoB = etLadoB.getText().toString().trim();
        String sLadoC = etLadoC.getText().toString().trim();

        if (sLadoA.isEmpty()) {
            Toast.makeText(getContext(), "Ingrese el valor del lado A", Toast.LENGTH_SHORT).show();
            etLadoA.requestFocus();
            return;
        }

        if (sLadoB.isEmpty()) {
            Toast.makeText(getContext(), "Ingrese el valor del lado B", Toast.LENGTH_SHORT).show();
            etLadoB.requestFocus();
            return;
        }

        if (sLadoC.isEmpty()) {
            Toast.makeText(getContext(), "Ingrese el valor del lado C", Toast.LENGTH_SHORT).show();
            etLadoC.requestFocus();
            return;
        }



        double a = Double.parseDouble(sLadoA);
        double b = Double.parseDouble(sLadoB);
        double c = Double.parseDouble(sLadoC);

        // Validamos existencia del triángulo según la desigualdad triangular
        if (a + b <= c) {
            tvResultado.setText("No es un triángulo válido: la suma de los lados A y B debe ser mayor que el lado C.");
            return;
        }

        if (a + c <= b) {
            tvResultado.setText("No es un triángulo válido: la suma de los lados A y C debe ser mayor que el lado B.");
            return;
        }

        if (b + c <= a) {
            tvResultado.setText("No es un triángulo válido: la suma de los lados B y C debe ser mayor que el lado A.");
            return;
        }

        // Calculamos
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        //Imprimimos el Resultado y lo formateamos a 2 digitos
        tvResultado.setText("Área: " + String.format("%.2f", area));
    }
}
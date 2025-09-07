package com.gocp.cutipaperez.fragment.ejercicios;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gocp.cutipaperez.R;

import java.util.Random;


public class NumeroAleatorioFragment extends Fragment {


    Button btnGenerar;
    TextView tvResultado;

    public NumeroAleatorioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numero_aleatorio, container, false);

        btnGenerar = view.findViewById(R.id.btnGenerar);
        tvResultado = view.findViewById(R.id.tvResultado);

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generarNumero();
            }
        });

        return view;
    }
    private void generarNumero() {
        // Generamos un número aleatorio de 6 cifras (entre 100000 y 999999)
        Random random = new Random();
        int numero = 100000 + random.nextInt(900000);

        // Contamos los dígitos impares
        int impares = 0;
        int temp = numero;
        while (temp > 0) {
            int digito = temp % 10;
            if (digito % 2 != 0) {
                impares++;
            }
            temp /= 10;
        }

        // Imprimimos el resultado
        if (impares >= 3) {
            tvResultado.setText("Número: " + numero + "\n Es correcto: tiene " + impares + " dígitos impares.");
        } else {
            tvResultado.setText("Número: " + numero + "\n No cumple, solo tiene " + impares + " dígitos impares.");
        }
    }
}
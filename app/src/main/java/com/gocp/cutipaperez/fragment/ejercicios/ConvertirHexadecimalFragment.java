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


public class ConvertirHexadecimalFragment extends Fragment {

    EditText etHexadecimal;
     Button btnConvertir;
     TextView tvResultado;

    public ConvertirHexadecimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_convertir_hexadecimal, container, false);

        etHexadecimal = view.findViewById(R.id.etHexadecimal);
        btnConvertir = view.findViewById(R.id.btnConvertir);
        tvResultado = view.findViewById(R.id.tvResultado);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirHexABinario();
            }
        });

        return view;
    }
    private void convertirHexABinario() {
        String sHex = etHexadecimal.getText().toString().trim().toUpperCase();

        if (sHex.isEmpty()) {
            Toast.makeText(getContext(), "Ingrese un número hexadecimal", Toast.LENGTH_SHORT).show();
            etHexadecimal.requestFocus();
            return;
        }

        // Validar que solo tenga 0-9 y A-F
        if (!sHex.matches("[0-9A-F]+")) {
            tvResultado.setText("Entrada inválida. Solo se permiten dígitos 0-9 y letras A-F.");
            return;
        }

        // Conversión Hexadecimal → Decimal → Binario
        int decimal = Integer.parseInt(sHex, 16);
        String binario = Integer.toBinaryString(decimal);

        tvResultado.setText("Número hexadecimal: " + sHex + "\nBinario: " + binario);
    }
}
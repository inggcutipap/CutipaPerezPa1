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

public class ConvertirBinarioFragment extends Fragment {

    EditText etBinario;
    Button btnConvertir;
    TextView tvResultado;

    public ConvertirBinarioFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_convertir_binario, container, false);

        etBinario = view.findViewById(R.id.etBinario);
        btnConvertir = view.findViewById(R.id.btnConvertir);
        tvResultado = view.findViewById(R.id.tvResultado);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirBinario();
            }
        });

        return  view;
    }
    private void convertirBinario() {
        String sBinario = etBinario.getText().toString().trim();

        if (sBinario.isEmpty()) {
            Toast.makeText(getContext(), "Ingrese un número binario", Toast.LENGTH_SHORT).show();
            etBinario.requestFocus();
            return;
        }

        // Validar que solo contenga 0 y 1
        if (!sBinario.matches("[01]+")) {
            tvResultado.setText("Entrada inválida. Solo se permiten dígitos 0 y 1.");
            return;
        }

        // Conversión binario → decimal
        int decimal = Integer.parseInt(sBinario, 2);
        tvResultado.setText("Número binario: " + sBinario + "\nDecimal: " + decimal);
    }
}
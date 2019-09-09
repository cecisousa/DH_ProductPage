package com.example.dh_productpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nomeProduto;
    private EditText precoProduto;
    private EditText porcentagemDesconto;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeProduto = findViewById(R.id.nome);
        precoProduto = findViewById(R.id.preco);
        porcentagemDesconto = findViewById(R.id.porcentagem);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = nomeProduto.getText().toString();
                Float preco = Float.valueOf(precoProduto.getText().toString());
                Integer porcentagem = Integer.valueOf(porcentagemDesconto.getText().toString());
                calcularValor(preco, porcentagem);
            }

            @SuppressLint("DefaultLocale")
            public void calcularValor(Float precoProduto, Integer porcentagemDesconto){
                precoProduto -= (precoProduto/100) * porcentagemDesconto;
                Toast.makeText(
                        getApplicationContext(),
                        "O preço final a ser pago é de R$ " + String.format(
                                "%.2f",
                                precoProduto
                        ),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });


    }
}

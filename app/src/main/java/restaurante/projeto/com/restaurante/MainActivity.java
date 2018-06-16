package restaurante.projeto.com.restaurante;

import android.annotation.TargetApi;
import android.icu.text.DecimalFormat;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Button calcularConta;

    private EditText consumoTotal;
    private EditText courverArtistico;
    private EditText quantidadePessoas;
    private EditText taxaServico;
    private EditText totalConta;
    private EditText valorPorPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.nova);


         consumoTotal = findViewById(R.id.editConsumo_Id);
        courverArtistico = findViewById(R.id.editCouvert_Id);
        calcularConta = findViewById(R.id.calcularContaF_Id);
        quantidadePessoas = findViewById(R.id.editDividirPorP_Id);

        taxaServico = findViewById(R.id.editTaxa_Id);
        totalConta = findViewById(R.id.editContaTotal_Id);
        valorPorPessoa = findViewById(R.id.editPorPessoa_Id);


        calcularConta.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                if(consumoTotal.getText().toString().equals("") || courverArtistico.getText().toString().equals("")
                        || quantidadePessoas.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Obrigatório preencher todos os campos!!",Toast.LENGTH_SHORT).show();

                }else if(Integer.parseInt(quantidadePessoas.getText().toString())==0){
                    Toast.makeText(MainActivity.this, "Deve haver pelo menos uma pessoa!", Toast.LENGTH_LONG).show();
                }else{
                    double consumo = Double.parseDouble(consumoTotal.getText().toString());
                    double couver = Double.parseDouble(courverArtistico.getText().toString());
                    int qtdPessoas = Integer.parseInt(quantidadePessoas.getText().toString());

                    double taxa = ((consumo + couver) * 10) / 100;
                    double contaTotal = consumo + couver + taxa;

                    double totalPorPessoa = contaTotal / qtdPessoas;
                    DecimalFormat df = new DecimalFormat("###.##");


                    taxaServico.setText(String.format(df.format(taxa)));
                    totalConta.setText(String.format(df.format(contaTotal)));
                    valorPorPessoa.setText(String.format(df.format(totalPorPessoa)));


                }


            }
        });


    }


}


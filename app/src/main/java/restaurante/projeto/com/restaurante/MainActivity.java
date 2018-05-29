package restaurante.projeto.com.restaurante;

import android.annotation.TargetApi;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Button calcularConta;

    private EditText consumoTotal;
    private  EditText courverArtistico;
    private EditText quantidadePessoas;

    private  EditText taxaServico;
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
                double consumo = Double.parseDouble(consumoTotal.getText().toString());
                double couver = Double.parseDouble(courverArtistico.getText().toString());
                double qtdPessoas = Double.parseDouble(quantidadePessoas.getText().toString());

                double taxa = ((consumo+couver)*10)/100;
                double contaTotal = consumo+couver;
                double totalPorPessoa = contaTotal/qtdPessoas;
                DecimalFormat df = new DecimalFormat("###.##");


                taxaServico.setText(String.format(df.format(taxa)));
                totalConta.setText(String.format(df.format(contaTotal)));
                valorPorPessoa.setText(String.format(df.format(totalPorPessoa)));




            }
        });


    }
}

package restaurante.projeto.com.restaurante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText consumoTotal;
    private  EditText courverArtistico;
    private EditText dividirPorConta;
    private Button calcularConta;
    private  EditText taxaServico;
    private EditText totalConta;
    private EditText valorPorPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consumoTotal = findViewById(R.id.editConsumo_Id);
        courverArtistico = findViewById(R.id.editCouvert_Id);
        calcularConta = findViewById(R.id.calcularContaF_Id);

        taxaServico = findViewById(R.id.editTaxa_Id);
        totalConta = findViewById(R.id.editContaTotal_Id);
        valorPorPessoa = findViewById(R.id.)



        calcularConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double consumo = Double.parseDouble(consumoTotal.getText().toString());
                double couver = Double.parseDouble(courverArtistico.getText().toString());


                double taxa = ((consumo+couver)*10)/100;
                double contaTotal = consumo+couver;



                taxaServico.setText(String.format("%f", taxa));
                totalConta.setText(String.format("%f", contaTotal));






            }
        });


    }
}

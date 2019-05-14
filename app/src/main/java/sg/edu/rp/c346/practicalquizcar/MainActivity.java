package sg.edu.rp.c346.practicalquizcar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etBrand, etLitre;
    Button btnInsert, btnRetrieve;
    TextView tvResult;
    ArrayList<Car> carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBrand = findViewById(R.id.etBrand);
        etLitre = findViewById(R.id.etLitre);
        btnInsert = findViewById(R.id.btnInsert);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        tvResult = findViewById(R.id.tvResult);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertCar(etBrand.getText().toString(), Double.parseDouble(etLitre.getText().toString()));
                db.close();
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                ArrayList<Car> data = db.getCar();
                carList = db.getCar();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i + ". " + data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvResult.setText(txt);
            }
        });

    }
}

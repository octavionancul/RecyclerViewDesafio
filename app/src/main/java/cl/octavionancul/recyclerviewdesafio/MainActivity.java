package cl.octavionancul.recyclerviewdesafio;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.octavionancul.recyclerviewdesafio.adapters.WinesAdapter;
import cl.octavionancul.recyclerviewdesafio.models.Wine;

public class MainActivity extends AppCompatActivity {

    private WinesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.winesRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        List<Wine> wines = new ArrayList<>();
       //  Wine wine = new Wine("Santa Helena","Merlot",2);
        wines.add(new Wine("Santa Helena","Merlot",2));
        wines.add(new Wine("Ventisquero","Merlot Grey",3));
        wines.add(new Wine("Santa Rita","Cabernet Sauvignon",4));
        wines.add(new Wine("120","Carmenere",3));
        wines.add(new Wine("Santa Ema","Merlot",4));


         adapter = new WinesAdapter(wines);
        recyclerView.setAdapter(adapter);


        FloatingActionButton fab = findViewById(R.id.addFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_wine);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

                Button button = dialog.findViewById(R.id.saveBtn);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        EditText brandEt = dialog.findViewById(R.id.brandEt);
                        EditText typeEt = dialog.findViewById(R.id.typeEt);
                        EditText yearsEt = dialog.findViewById(R.id.yearsEt);

                        String brand = brandEt.getText().toString();
                        String type = typeEt.getText().toString();
                        int years = Integer.parseInt(yearsEt.getText().toString());

                        Wine wine = new Wine();
                        wine.setBrand(brand);
                        wine.setType(type);
                        wine.setYears(years);

                        updateList(wine);

                        dialog.dismiss();

                     //   Toast.makeText(MainActivity.this, "clickk", Toast.LENGTH_SHORT).show();

                    }
                });
                dialog.show();
            }
        });
    }

    public void updateList(Wine wine){

        adapter.update(wine);
     //   Toast.makeText(this, wine.getBrand(), Toast.LENGTH_SHORT).show();
    }
}

package sg.edu.rp.c346.id21012519.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    Button btnRetrieve;
    EditText etTitle;
    EditText etGenre;
    EditText etYear;
    ArrayList<Movies> al;
    Spinner spinGenre;
    ListView lv;
    ArrayAdapter<Movies> aa;
    Movies data;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String imageUrl= "https://i.imgur.com/tGbaZCY.jpg";
        Picasso.with(this).load(imageUrl).into(iv);

        //initialize the variables with UI here
        btnAdd = findViewById(R.id.btnAdd);
        btnRetrieve = findViewById(R.id.btnShow);
        lv = findViewById(R.id.lv);
        etTitle = findViewById(R.id.etTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        spinGenre = findViewById(R.id.spinnerGenre);

        Intent i = getIntent();
        data = (Movies) i.getSerializableExtra("data");

        al = new ArrayList<Movies>();
        aa = new ArrayAdapter<Movies>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataTitle  = etTitle.getText().toString();
                String dataGenre = etGenre.getText().toString();
                int dataYear = Integer.parseInt(etYear.getText().toString());
                String movieRating = spinGenre.getSelectedItem().toString();

                Log.d("result",movieRating+"");
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertNote(dataTitle,dataGenre,dataYear,movieRating);

                if (inserted_id != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Insert failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ShowMovie.class);
                startActivity(i);
            }
        });
    }
}
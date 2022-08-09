package sg.edu.rp.c346.id21012519.mymovies;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ModifyMovie extends AppCompatActivity {

    TextView tvID;
    EditText etNewTitle, etNewGenre, etNewYear;
    Button btnUpdate, btnDelete, btnCancel;
    Movies data;
    Spinner spinGenreEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_movie);

        tvID = findViewById(R.id.tvmovieid);
        etNewTitle = findViewById(R.id.etmovietitle);
        etNewGenre = findViewById(R.id.etgen);
        etNewYear = findViewById(R.id.etNewYear);
        btnUpdate = findViewById(R.id.btnupdate);
        btnDelete = findViewById(R.id.btndelete);
        btnCancel = findViewById(R.id.btncancel);
        spinGenreEdit = findViewById(R.id.spinnerGenreEdit);

        Intent i = getIntent();
        data = (Movies) i.getSerializableExtra("data");

        tvID.setText(data.getId() +"");
        etNewTitle.setText(data.getTitle());
        etNewGenre.setText(data.getGenre());
        etNewYear.setText(data.getYear()+"");
        Log.d("data.getRating().equals",data.getRating());

        spinGenreEdit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //new
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                if (data.getRating().equals("G")) {
                    int position = 0;
                    spinGenreEdit.setSelection(position);

                } else if (data.getRating().equals("PG")) {
                    int position = 1;
                    spinGenreEdit.setSelection(position);

                } else if (data.getRating().equals("PG13")) {
                    int position = 2;
                    spinGenreEdit.setSelection(position);

                } else if (data.getRating().equals("NC16")) {
                    int position = 3;
                    spinGenreEdit.setSelection(position);

                } else if (data.getRating().equals("M18")) {
                    int position = 4;
                    spinGenreEdit.setSelection(position);

                } else if (data.getRating().equals("R21")) {
                    int position = 5;
                    spinGenreEdit.setSelection(position);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifyMovie.this);
                data.setTitle(etNewTitle.getText().toString());
                data.setGenre(etNewGenre.getText().toString());
                data.setYear(Integer.parseInt(etNewYear.getText().toString()));
                String movieRatingE = spinGenreEdit.getSelectedItem().toString();
                data.setRating(movieRatingE);

                dbh.updateMovie(data);
                dbh.close();
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(ModifyMovie.this);
                myBuilder.setTitle("Danger");
                String Title = data.getTitle();
                myBuilder.setMessage("Are you sure you want to delete the movie " + Title +"?");

                myBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DBHelper dbh = new DBHelper(ModifyMovie.this);
                        dbh.deleteMovie(data.getId());
                        finish();
                    }
                });
                myBuilder.setNegativeButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(ModifyMovie.this);
                myBuilder.setTitle("Danger");
                String Title = data.getTitle();
                myBuilder.setMessage("Are you sure you want to discard changes?");

                myBuilder.setPositiveButton("Discard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                myBuilder.setNegativeButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
    }
}
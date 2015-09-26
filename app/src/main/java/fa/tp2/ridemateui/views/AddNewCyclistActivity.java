package fa.tp2.ridemateui.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import fa.tp2.ridemateui.MainActivity;
import fa.tp2.ridemateui.R;
import fa.tp2.ridemateui.model.Cyclist;
import fa.tp2.ridemateui.repositories.rest.RestCyclistAPI;

/**
 * Created by User on 2015/09/12.
 */
public class AddNewCyclistActivity extends Activity {
    private RestCyclistAPI restSubjectAPI = new RestCyclistAPI();
    Cyclist cyclist;
    EditText editName;
    EditText editSurname;
    EditText editAge;
    Button buttonSubmit1;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("AddNewCyclist page is open");//test
        setContentView(R.layout.addnewcyclist);

        editName = (EditText) findViewById(R.id.editName);
        editSurname = (EditText) findViewById(R.id.editSurname);
        editAge = (EditText) findViewById(R.id.editAge);
        buttonSubmit1 = (Button) findViewById(R.id.btnSubmitNew);

        //initailizing buttons
        ImageButton goHomeBtn        = (ImageButton) findViewById(R.id.imgBtnHome);
        ImageButton deleteCyclistBtn = (ImageButton) findViewById(R.id.imgBtnDelete);
        ImageButton updateCyclistBtn = (ImageButton) findViewById(R.id.imgBtnUpdate);
        ImageButton viewAllListBtn   = (ImageButton) findViewById(R.id.imageView);


        //Main Page: different buttons

        goHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addCyclist = new Intent(AddNewCyclistActivity.this, MainActivity.class);
                startActivity(addCyclist);
            }
        });

        deleteCyclistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteCyclist = new Intent(AddNewCyclistActivity.this, SelectListActivity.class);
                startActivity(deleteCyclist);
            }
        });

        updateCyclistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateCyclist = new Intent(AddNewCyclistActivity.this, SelectListActivity.class);
                startActivity(updateCyclist);
            }
        });

        viewAllListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewCyclists = new Intent(AddNewCyclistActivity.this, ViewAll.class);
                startActivity(viewCyclists);
            }
        });



        buttonSubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Submit button hit on AddNewCyclist");//test

                String firstname = editName.getText().toString();
                String lastname = editSurname.getText().toString();
                String age = editAge.getText().toString();

                //new PostCyclist().execute(cyclist);

                System.out.println("Name:" + firstname);//test
                System.out.println("Surname:" + lastname);//test
                System.out.println("Age:" + age);//test


                if (firstname.length() == 0 || lastname.length() == 0 || age.length() == 0) {
                    Toast.makeText(c, "Please fill in name, surname and age", Toast.LENGTH_SHORT).show();
                    return;
                }

            }

        });
    }
/*
    private class PostSubject extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... params) {
            String firstname = params[0];
            String lastname = params[0];
            String age = params[0];

            return null;
        }

    }*/
}




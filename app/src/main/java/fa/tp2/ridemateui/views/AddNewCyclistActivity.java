package fa.tp2.ridemateui.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

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
    EditText inputName;
    EditText inputSurname;
    EditText inputAge;
    Button buttonSubmit1;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnewcyclist);

        inputName = (EditText) findViewById(R.id.editName);
        inputSurname = (EditText) findViewById(R.id.editSurname);
        inputAge = (EditText) findViewById(R.id.editAge);
        buttonSubmit1 = (Button) findViewById(R.id.btnSubmitNew);



        //initailizing buttons
        ImageButton goHomeBtn        = (ImageButton) findViewById(R.id.imgBtnHome);
        ImageButton deleteCyclistBtn = (ImageButton) findViewById(R.id.imgBtnDelete);
        ImageButton updateCyclistBtn = (ImageButton) findViewById(R.id.imgBtnUpdate);
        ImageButton viewAllListBtn   = (ImageButton) findViewById(R.id.imageView);


        //Action listeners on image buttons

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




    }

    private class PostCyclist extends AsyncTask<String, String, String> {

        protected String doInBackground(String... params) {
            String firstname = params[0];
            String lastname = params[0];
            String age = params[0];

            return null;
        }

    }
}




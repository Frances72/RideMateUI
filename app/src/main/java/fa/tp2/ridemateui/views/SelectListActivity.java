package fa.tp2.ridemateui.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fa.tp2.ridemateui.MainActivity;
import fa.tp2.ridemateui.R;
import fa.tp2.ridemateui.model.Cyclist;
import fa.tp2.ridemateui.repositories.rest.RestCyclistAPI;
import fa.tp2.ridemateui.views.Adapters.CyclistAdapter;

/**
 * Created by User on 2015/09/24.
 */
public class SelectListActivity extends Activity {

    EditText editName;
    EditText editSurname;
    EditText editAge;
    Button btnDelete;
    Button btnUpdate;
    Context c;
    private static final int request_code = 5;



    private RestCyclistAPI restCyclistAPI = new RestCyclistAPI();
    List<Cyclist> cyclistList = new ArrayList<Cyclist>();
    ListView listView;
    CyclistAdapter adapter ;
    Cyclist[] cyclist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectlist);
        System.out.println("selectlist page is open");//test

        ImageButton createCyclistBtn = (ImageButton) findViewById(R.id.imgBtnAdd);
        ImageButton viewAllListBtn = (ImageButton) findViewById(R.id.imageView);
        ImageButton goHomeBtn        = (ImageButton) findViewById(R.id.imgBtnHome);

        //Add Button Handlers

        createCyclistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addCyclist = new Intent(SelectListActivity.this, AddNewCyclistActivity.class);
                startActivity(addCyclist);
            }
        });

        viewAllListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewCyclists = new Intent(SelectListActivity.this, ViewAll.class);
                startActivity(viewCyclists);
            }
        });

        goHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homePage = new Intent(SelectListActivity.this, MainActivity.class);
                startActivity(homePage);
            }
        });



        listView = (ListView) findViewById(R.id.listView);
       // new GetCyclistsTask().execute();

     //assign the EditText values to variable names
        editName    = (EditText) findViewById(R.id.editName);
        editSurname = (EditText) findViewById(R.id.editSurname);
        editAge     = (EditText) findViewById(R.id.editAge);
        btnDelete   = (Button) findViewById(R.id.btnDelete);
        btnUpdate   = (Button) findViewById(R.id.btnUpdate);

        //set the onClickListener for the delete and Submit Buttons
        btnDelete.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                System.out.println("Submit button hit on selectlist page");//test

                if (editName.length() == 0 || editSurname.length() == 0 || editAge.length() == 0) {
                    Toast.makeText(c, "Please fill in name, surname and age", Toast.LENGTH_SHORT).show();

                }
            }

        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                System.out.println("Submit button hit on SelectList");//test

                 if (editName.length() == 0 || editSurname.length() == 0 || editAge.length() == 0) {
                    Toast.makeText(c, "Please select a cyclist", Toast.LENGTH_SHORT).show();

                }
            }

        });

    }
 /*   class GetCyclistsTask extends AsyncTask<Void, Void, List<Cyclist>> {
        List<Cyclist> cyclists = new ArrayList<Cyclist>();

        protected List<Cyclist> doInBackground(Void... params) {
            cyclists = restCyclistAPI.getAll();
            return cyclists;
        }
        protected void onPostExecute( List<Cyclist> cyclists) {
            cyclistList = cyclists;
            cyclist = cyclistList.toArray(new Cyclist[cyclistList.size()]);
            adapter = new CyclistAdapter(SelectListActivity.this, R.id.listView, cyclist);
            listView.setAdapter(adapter);

        }*/

        //how to take name, surname and age to UpdateCyclistActivity

         protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if ((requestCode == request_code) && (resultCode == RESULT_OK)) {

				String returnString = data.getExtras().getString("returnData");

				editName.setText(returnString);
				editSurname.setText(returnString);
				editAge.setText(returnString);
		}
	}

        //move to the UpdateCyclistActivity page

         public void onClick(View view) {

    	Intent updateCycDetails = new Intent(SelectListActivity.this, UpdateCyclistActivity.class);

    	      final EditText editName        = (EditText) findViewById(R.id.editName);
              final EditText editSurname     = (EditText) findViewById(R.id.editSurname);
              final EditText editAge         = (EditText) findViewById(R.id.editAge);

    	String myName    = editName.getText().toString();
    	String mySurname = editSurname.getText().toString();
    	String myAge     = editAge.getText().toString();

             updateCycDetails.putExtra("qString", myName );
             updateCycDetails.putExtra("qString", mySurname );
             updateCycDetails.putExtra("qString", myAge );
    	startActivityForResult(updateCycDetails, request_code);
    }



    }

//}

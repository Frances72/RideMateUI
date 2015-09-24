package fa.tp2.ridemateui.views;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

    private RestCyclistAPI restCyclistAPI = new RestCyclistAPI();
    List<Cyclist> cyclistList = new ArrayList<Cyclist>();
    ListView listView;
    CyclistAdapter adapter ;
    Cyclist[] cyclist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectlist);
        System.out.println("selectlist page is open");

        listView = (ListView) findViewById(R.id.listView);
        new GetCyclistsTask().execute();

        c = this;


        editName        = (EditText) findViewById(R.id.editName);
        editSurname     = (EditText) findViewById(R.id.editSurname);
        editAge         = (EditText) findViewById(R.id.editAge);
        btnDelete       = (Button) findViewById(R.id.btnDelete);
        btnUpdate       = (Button) findViewById(R.id.btnUpdate);

        btnDelete.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                System.out.println("Submit button hit on DeleteCyclist");//test

                String firstname = editName.getText() + "";
                String lastname = editSurname.getText() + "";
                String age = editAge.getText() + "";

                System.out.println("Name:" + firstname);//test
                System.out.println("Surname:" + lastname);//test
                System.out.println("Age:" + age);//test


                if (firstname.length() == 0 || lastname.length() == 0 || age.length() == 0) {
                    Toast.makeText(c, "Please fill in name, surname and age", Toast.LENGTH_SHORT).show();

                }
            }

        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                System.out.println("Submit button hit on SelectList");//test

                String firstname = editName.getText() + "";
                String lastname = editSurname.getText() + "";
                String age = editAge.getText() + "";

                System.out.println("Name:" + firstname);//test
                System.out.println("Surname:" + lastname);//test
                System.out.println("Age:" + age);//test


                if (firstname.length() == 0 || lastname.length() == 0 || age.length() == 0) {
                    Toast.makeText(c, "Please select a cyclist", Toast.LENGTH_SHORT).show();

                }
            }

        });

    }
    class GetCyclistsTask extends AsyncTask<Void, Void, List<Cyclist>> {
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

        }

    }
}

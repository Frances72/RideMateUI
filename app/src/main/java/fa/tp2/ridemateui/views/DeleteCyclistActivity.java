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
 * Created by User on 2015/09/12.
 */
public class DeleteCyclistActivity extends Activity {

    EditText editName;
    EditText editSurname;
    EditText editAge;
    Button btnDelete;
    Context c;
    private RestCyclistAPI restCyclistAPI = new RestCyclistAPI();
    List<Cyclist> cyclistList = new ArrayList<Cyclist>();
    ListView listView;
    CyclistAdapter adapter ;
    Cyclist[] cyclist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletecyclist);
        System.out.println("DeleteCyclist page is open");

        listView = (ListView) findViewById(R.id.listView);
        new GetCyclistsTask().execute();

        c = this;


        editName        = (EditText) findViewById(R.id.editName);
        editSurname     = (EditText) findViewById(R.id.editSurname);
        editAge         = (EditText) findViewById(R.id.editAge);
        btnDelete  = (Button) findViewById(R.id.btnDelete);













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
            adapter = new CyclistAdapter(DeleteCyclistActivity.this, R.id.listView, cyclist);
            listView.setAdapter(adapter);

        }

    }
}
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_deletecyclist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

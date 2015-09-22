package fa.tp2.ridemateui.views;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fa.tp2.ridemateui.MainActivity;
import fa.tp2.ridemateui.R;
import fa.tp2.ridemateui.model.Cyclist;
import fa.tp2.ridemateui.repositories.rest.RestCyclistAPI;
import fa.tp2.ridemateui.views.Adapters.CyclistAdapter;

/**
 * Created by User on 2015/09/12.
 */
public class UpdateCyclistActivity extends Activity {

    private RestCyclistAPI restCyclistAPI = new RestCyclistAPI();
    List<Cyclist> cyclistList = new ArrayList<Cyclist>();
    ListView listView;
    CyclistAdapter adapter ;
    Cyclist[] cyclist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatecyclist);


        listView = (ListView) findViewById(R.id.listView);
        new GetCyclistsTask().execute();

        ImageButton createCyclistBtn = (ImageButton) findViewById(R.id.imgbtnAddNew);
        ImageButton deleteCyclistBtn = (ImageButton) findViewById(R.id.imgBtndelete2);
        ImageButton updateCyclistBtn = (ImageButton) findViewById(R.id.imgBtnUpdate);
        ImageButton goHomeBtn        = (ImageButton) findViewById(R.id.imgBtnHome);

//Add Button Handlers

        createCyclistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addCyclist = new Intent(UpdateCyclistActivity.this, AddNewCyclistActivity.class);
                startActivity(addCyclist);
            }
        });

        deleteCyclistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteCyclist = new Intent(UpdateCyclistActivity.this, DeleteCyclistActivity.class);
                startActivity(deleteCyclist);
            }
        });


        updateCyclistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateCyclist = new Intent(UpdateCyclistActivity.this, ViewAll.class);
                startActivity(updateCyclist);
            }
        });

        goHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homePage = new Intent(UpdateCyclistActivity.this, MainActivity.class);
                startActivity(homePage);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_updatecyclist, menu);
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
            adapter = new CyclistAdapter(UpdateCyclistActivity.this, R.id.listView, cyclist);
            listView.setAdapter(adapter);

        }

    }
}

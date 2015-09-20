package fa.tp2.ridemateui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fa.tp2.ridemateui.model.Cyclist;
import fa.tp2.ridemateui.repositories.rest.RestCyclistAPI;
import fa.tp2.ridemateui.views.Adapters.CyclistAdapter;
import fa.tp2.ridemateui.views.AddNewCyclistActivity;
import fa.tp2.ridemateui.views.DeleteCyclistActivity;
import fa.tp2.ridemateui.views.UpdateCyclistActivity;
import fa.tp2.ridemateui.views.ViewAll;

public class MainActivity extends AppCompatActivity {

    private RestCyclistAPI restSubjectAPI = new RestCyclistAPI();
    List<Cyclist> subjectList = new ArrayList<Cyclist>();
    ListView subjectsList;
    CyclistAdapter adapter ;
    Cyclist[] cyclistl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton createCyclistBtn = (ImageButton) findViewById(R.id.imgbtnAddNew);
        ImageButton deleteCyclistBtn = (ImageButton) findViewById(R.id.imgBtndelete2);
        ImageButton updateCyclistBtn = (ImageButton) findViewById(R.id.imgBtnUpdate);
        ImageButton viewAllListBtn = (ImageButton) findViewById(R.id.imgBtnList);

//Main Page: different buttons

        createCyclistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addCyclist = new Intent(MainActivity.this, AddNewCyclistActivity.class);
                startActivity(addCyclist);
            }
        });

        deleteCyclistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deleteCyclist = new Intent(MainActivity.this, DeleteCyclistActivity.class);
                startActivity(deleteCyclist);
            }
        });


        updateCyclistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateCyclist = new Intent(MainActivity.this, UpdateCyclistActivity.class);
                startActivity(updateCyclist);
            }
        });

        viewAllListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewCyclists = new Intent(MainActivity.this, ViewAll.class);
                startActivity(viewCyclists);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}

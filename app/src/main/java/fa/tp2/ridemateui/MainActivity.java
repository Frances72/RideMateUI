package fa.tp2.ridemateui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fa.tp2.ridemateui.model.Cyclist;
import fa.tp2.ridemateui.repositories.rest.RestCyclistAPI;
import fa.tp2.ridemateui.views.Adapters.CyclistAdapter;

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
        ImageButton createCyclist  = (ImageButton) findViewById(R.id.imageCreate);
        ImageButton deleteCyclist = (ImageButton) findViewById(R.id.imageDelete);
        ImageButton updateCyclist  = (ImageButton) findViewById(R.id.imageUpdate);

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

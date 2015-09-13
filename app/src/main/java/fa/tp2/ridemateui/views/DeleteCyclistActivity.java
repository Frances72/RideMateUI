package fa.tp2.ridemateui.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fa.tp2.ridemateui.R;

/**
 * Created by User on 2015/09/12.
 */
public class DeleteCyclistActivity extends AppCompatActivity {

    EditText editName;
    EditText editSurname;
    EditText editAge;
    Button buttonSubmit2;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletecyclist);
        System.out.println("DeleteCyclist page is open");

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();

        c = this;


        editName        = (EditText) findViewById(R.id.editName);
        editSurname     = (EditText) findViewById(R.id.editSurname);
        editAge         = (EditText) findViewById(R.id.editAge);
        buttonSubmit2   = (Button) findViewById(R.id.buttonSubmit2);

        buttonSubmit2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                System.out.println("Submit button hit on DeleteCyclist");

                String firstname = editName.getText() + "";
                String lastname = editSurname.getText() + "";
                String age = editAge.getText() + "";

                System.out.println("Name:" + firstname);
                System.out.println("Surname:" + lastname);
                System.out.println("Age:" + age);


                if (firstname.length() == 0 || lastname.length() == 0 || age.length() == 0) {
                    Toast.makeText(c, "Please fill in name, surname and age", Toast.LENGTH_SHORT).show();
                    return;
                }
                 };
            )
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
}
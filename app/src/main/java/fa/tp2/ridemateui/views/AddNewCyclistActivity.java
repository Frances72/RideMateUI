package fa.tp2.ridemateui.views;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fa.tp2.ridemateui.R;

/**
 * Created by User on 2015/09/12.
 */
public class AddNewCyclistActivity extends Activity {

    EditText editName;
    EditText editSurname;
    EditText editAge;
    Button buttonSubmit1;
    Context c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("AddNewCyclist page is open");//test

      //  getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
      //  getActionBar().hide();

        c = this;

        setContentView(R.layout.addnewcyclist);

        editName        = (EditText) findViewById(R.id.editName);
        editSurname     = (EditText) findViewById(R.id.editSurname);
        editAge         = (EditText) findViewById(R.id.editAge);
        buttonSubmit1   = (Button) findViewById(R.id.buttonSubmit1);

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

 public class Networking extends AsyncTask{
  @Override
    protected Object doInBackground(Object[] params){
      System.out.println("Do in background has been called");
      return null;
  }
private void getJson(String url,String state ){
    if (state.equals("NewCyclist"))
    {
        return;
    }
    }
}
}


  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addnewcyclist, menu);
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
}*/

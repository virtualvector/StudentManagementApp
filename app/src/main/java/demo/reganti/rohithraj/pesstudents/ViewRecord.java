package demo.reganti.rohithraj.pesstudents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewRecord extends AppCompatActivity {

    EditText usnEditText;
    TextView displayTextView;
    ArrayList<Student> ObjList = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);
        //ObjList = (ArrayList<Student>) getIntent().getSerializableExtra("studentObject");

        usnEditText = (EditText) findViewById(R.id.usnEditText);
        displayTextView = (TextView) findViewById(R.id.textView2);


        ObjList = (ArrayList<Student>) getIntent().getSerializableExtra("studentObject");


        //Toast.makeText(this, ObjList.get(0).getName(), Toast.LENGTH_SHORT).show();
    }
    /*
    public void fetchQuery(View view) {

        boolean val = true;
        String queryUsn = usnEditText.getText().toString();
        for (Student obj : ObjList) {
            //displayTextView.setText(queryUsn);


            if (queryUsn.equals(obj.getUsn().toString()))
                val = false;
            printDetails(obj);

        }
        if (!val) {
            Toast.makeText(this, "USN Not Found", Toast.LENGTH_SHORT).show();
        }

    }
    */

    public void fetchQuery(View view){
        boolean bool = false;

        String queryUsn = usnEditText.getText().toString();
        for (Student obj : ObjList) {
            //displayTextView.setText(queryUsn);


            if (queryUsn.equals(obj.getUsn().toString())) {
                printDetails(obj);
                bool=true;
            }

        }
        if(!bool){
            Toast.makeText(this, "USN not found", Toast.LENGTH_SHORT).show();
        }

    }


    public void printDetails(Student obj) {

//NAME,USN,MAT,CHEM,PCD,CAD,ELN,PLAB,CLAB,SGPA
        String str;
        Log.i("method called", "called");
        str = obj.getUsn() + "\n\n" + obj.getName() + "\n\n"
                + obj.getMat() + "\n\n"
                + obj.getChem() + "\n\n"
                + obj.getPcd() + "\n\n"
                + obj.getCad() + "\n\n"
                + obj.getEln() + "\n\n";

        Log.i(str, "val");

        displayTextView.setText(str);
    }


}

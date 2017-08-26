package demo.reganti.rohithraj.pesstudents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {

    EditText deleteRecordEditText;
    TextView deleteRecordTextView;
    Button deleteRecordButton;
    ArrayList<Student> ObjList = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        ObjList = (ArrayList<Student>) getIntent().getSerializableExtra("studentObject");
        deleteRecordButton = (Button)findViewById(R.id.deleteRecordButton);
        deleteRecordEditText = (EditText)findViewById(R.id.deleteRecordEditText);
        deleteRecordTextView = (TextView)findViewById(R.id.deleteRecordTextView);


    }


    public void deleteRecord(View view){
        boolean bool = false;

        String queryUsn = deleteRecordEditText.getText().toString();
        for (Student obj : ObjList) {
            //displayTextView.setText(queryUsn);


            if (queryUsn.equals(obj.getUsn().toString())) {
                printDetails(obj);
                bool=true;
                break;

            }

        }
        if(!bool){
            Toast.makeText(this, "USN not found", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent();
        intent.putExtra("returnKeyFromDelete",ObjList);
        setResult(RESULT_OK,intent);

    }

    public void printDetails(Student obj) {

//NAME,USN,MAT,CHEM,PCD,CAD,ELN,PLAB,CLAB,SGPA
        String str;
        Log.i("method called", "called");
        str = "usn : "+ obj.getUsn() + "\n\n" +"Name : "+ obj.getName() + "\n\n"
                +"Maths : " + obj.getMat() + "\n\n"
                + "Chem : " + obj.getChem() + "\n\n"
                + "Pcd : "+obj.getPcd() + "\n\n"
                +"cad : " +obj.getCad() + "\n\n"
                + "eln : "+obj.getEln() + "\n\n"
                + "sgpa : "+obj.getSgpa();


        deleteRecordTextView.setText(str);
        ObjList.remove(obj);
        Log.i(obj.getUsn(), "deleted");
    }


}

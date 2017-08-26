package demo.reganti.rohithraj.pesstudents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateRecord extends AppCompatActivity {

    EditText nameEdit ;
    EditText usnEdit;
    EditText matEdit;
    EditText chemEdit;
    EditText pcdEdit;
    EditText cadEdit;
    EditText elnEdit;
    EditText plabEdit;
    EditText clabEdit;
    EditText sgpa;

    ArrayList<Student> ObjList = new ArrayList<Student>();
    //NAME,USN,MAT,CHEM,PCD,CAD,ELN,PLAB,CLAB,SGPA

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_record);
        ObjList = (ArrayList<Student>) getIntent().getSerializableExtra("studentObject");

        nameEdit = (EditText)findViewById(R.id.nameEdit);
        usnEdit = (EditText)findViewById(R.id.usnEdit);
        matEdit = (EditText)findViewById(R.id.matEdit);
        chemEdit = (EditText)findViewById(R.id.chemEdit);
        pcdEdit = (EditText)findViewById(R.id.pcdText);
        cadEdit = (EditText)findViewById(R.id.cadEdit);
        elnEdit = (EditText)findViewById(R.id.elnEdit);
        plabEdit = (EditText)findViewById(R.id.pcdlabEdit);
        clabEdit = (EditText)findViewById(R.id.clabEdit);
        sgpa = (EditText)findViewById(R.id.sgpaEdit);



    }

    public void createRecord(View view){

        Student obj = new Student();
        obj.setName(nameEdit.getText().toString());
        obj.setUsn(usnEdit.getText().toString());
        obj.setMat(Double.parseDouble(matEdit.getText().toString()));
        obj.setChem(Double.parseDouble(chemEdit.getText().toString()));
        obj.setPcd(Double.parseDouble(pcdEdit.getText().toString()));
        obj.setCad(Double.parseDouble(matEdit.getText().toString()));
        obj.setEln(Double.parseDouble(matEdit.getText().toString()));
        obj.setPlab(Double.parseDouble(matEdit.getText().toString()));
        obj.setClab(Double.parseDouble(matEdit.getText().toString()));
        obj.setSgpa(Double.parseDouble(sgpa.getText().toString()));;

        ObjList.add(obj);

        Toast.makeText(this, "Hey", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("returnKeyFromCreate",ObjList);
        setResult(RESULT_OK,intent);

    }
}

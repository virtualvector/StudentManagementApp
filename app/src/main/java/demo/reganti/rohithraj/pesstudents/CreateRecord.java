package demo.reganti.rohithraj.pesstudents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateRecord extends AppCompatActivity {

    ArrayList<Student> ObjList = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_record);
        ObjList = (ArrayList<Student>) getIntent().getSerializableExtra("studentObject");
    }

    public void createRecord(View view){

        Toast.makeText(this, "Hey", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("returnKeyFromCreate",ObjList);
        setResult(RESULT_OK,intent);

    }
}

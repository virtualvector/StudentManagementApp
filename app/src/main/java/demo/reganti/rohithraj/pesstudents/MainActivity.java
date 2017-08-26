package demo.reganti.rohithraj.pesstudents;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    //arrayList storing student data
    ArrayList<Student> objList = new ArrayList<Student>();
    static int value=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            //myReader();
            readAndInsert(value);
            value++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void myReader() throws IOException {
        InputStreamReader is = new InputStreamReader(getAssets().open("hello.csv"));

        BufferedReader reader = new BufferedReader(is);
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null) {

            Log.i("line", line.toString());

        }
    }

    //to read the file in assests folder
    private void readAndInsert(int value) throws UnsupportedEncodingException {

    if(value==1) {
        AssetManager assetManager = getAssets();
        InputStream is = null;

        try {
            is = assetManager.open("hello.csv");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line = "";
        StringTokenizer st = null;
        try {

            while ((line = reader.readLine()) != null) {
                st = new StringTokenizer(line, ",");
                Student obj = new Student();
                //your attributes
                // obj.se(st.nextToken());

//NAME,USN,MAT,CHEM,PCD,CAD,ELN,PLAB,CLAB,SGPA
                obj.setName(st.nextToken());
                obj.setUsn(st.nextToken());
                obj.setMat((Double.parseDouble(st.nextToken())));
                obj.setChem(Double.parseDouble(st.nextToken()));
                obj.setPcd((Double.parseDouble(st.nextToken())));
                obj.setCad(Double.parseDouble(st.nextToken()));
                obj.setEln(Double.parseDouble(st.nextToken()));
                obj.setPlab(Double.parseDouble(st.nextToken()));
                obj.setClab(Double.parseDouble(st.nextToken()));
                obj.setSgpa(Double.parseDouble(st.nextToken()));

                objList.add(obj);

            }
        } catch (IOException e) {

            e.printStackTrace();
        }


        Log.i("name", objList.get(0).getName());
    }

    }

    //method to be called when viewRecord button is clicked
    public void openView(View view) {

        Intent openViewerIntent = new Intent(MainActivity.this, ViewRecord.class);
        openViewerIntent.putExtra("studentObject", objList);
        startActivityForResult(openViewerIntent,1);

    }

    //method to be called when DeleteRecord button is clicked
    public void openDelete (View view) {

        Intent openDeleteIntent  = new Intent(MainActivity.this,DeleteActivity.class);
        openDeleteIntent.putExtra("studentObject",objList);
        startActivityForResult(openDeleteIntent,2);
    }

    //method to be called when CreateRecord button is clicked
    public void openCreate (View view){

        Intent openDeleteIntent  = new Intent(MainActivity.this,CreateRecord.class);
        openDeleteIntent.putExtra("studentObject",objList);
        startActivityForResult(openDeleteIntent,3);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode==1 && resultCode==RESULT_OK) {
            objList = (ArrayList<Student>) intent.getSerializableExtra("returnKey");
        }
        if(requestCode==2 && resultCode==RESULT_OK){
            objList = (ArrayList<Student>) intent.getSerializableExtra("returnKeyFromDelete");

        }
        if(requestCode==3 && resultCode==RESULT_OK){
            objList = (ArrayList<Student>) intent.getSerializableExtra("returnKeyFromCreate");

        }

    }


}



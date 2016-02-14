package rohan.appcheck;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button check;
    TextView display;
    EditText packageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check = (Button) findViewById(R.id.button);
        display = (TextView) findViewById(R.id.textView);
        packageName = (EditText) findViewById(R.id.editText);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (packageName.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Please enter the package of the app you want to check", Toast.LENGTH_SHORT).show();
                }
                else {
                    PackageManager pm = getPackageManager();
                    try {
                        // package name of the app
                        pm.getPackageInfo(packageName.getText().toString(), PackageManager.GET_ACTIVITIES);
                        // app exists. Do something
                        display.setText("This app exists on your phone.");
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                        // app does not exists. Do something
                        display.setText("This app does not exist on your phone.");
                    }

                }
            }
        });
    }
}

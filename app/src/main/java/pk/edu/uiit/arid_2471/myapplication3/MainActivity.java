package pk.edu.uiit.arid_2471.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mail, password;
    Button in;
    TextView sSignup;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail=findViewById(R.id.etMail);
        password=findViewById(R.id.etPass);

        in=findViewById(R.id.loginBtn);
        sSignup=findViewById(R.id.signupBtn);

        db=new DatabaseHelper(MainActivity.this);

        in.setOnClickListener((View v)->{
            String email=mail.getText().toString();
            String Pwd= password.getText().toString();

            Cursor check=db.login(email, Pwd);
            if(check.getCount()==0)
                Toast.makeText(MainActivity.this,"Record not found", Toast.LENGTH_LONG).show();
            else {
                Intent intent = new Intent(MainActivity.this, studentActivity.class);
                while (check.moveToNext()) {
                    intent.putExtra("name", check.getString(0));
                    intent.putExtra("mail", check.getString(1));
                    intent.putExtra("phone", check.getString(2));
                }
                startActivity(intent);
            }

        });

        sSignup.setOnClickListener((View v)->{
            Intent intent=new Intent(MainActivity.this, signup.class);
            startActivity(intent);
        });
    }
}
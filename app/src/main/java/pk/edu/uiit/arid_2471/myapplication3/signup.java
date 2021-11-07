package pk.edu.uiit.arid_2471.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText name, mail, phone, pwd, cPwd;
    Button clear, submit;
    TextView login;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name=findViewById(R.id.aName);
        mail=findViewById(R.id.aEmail);
        phone=findViewById(R.id.aPhone);
        pwd=findViewById(R.id.aPwd);
        cPwd=findViewById(R.id.cPwd);

        clear=findViewById(R.id.cBtn);
        submit=findViewById(R.id.sBtn);
        login = findViewById(R.id.lginBtn);

        clear.setOnClickListener((View v)->{
            name.setText("");
            mail.setText("");
            phone.setText("");
            pwd.setText("");
            cPwd.setText("");
        });

        submit.setOnClickListener((View v)->{
            db=new DatabaseHelper(signup.this);
            if(pwd.getText().toString().equals(cPwd.getText().toString())) {
                long check = db.insertion(name.getText().toString(), mail.getText().toString(), phone.getText().toString(), pwd.getText().toString());
                if (check != -1) {
                    Toast.makeText(signup.this, "Inserted ", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(signup.this, studentActivity.class);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("mail", mail.getText().toString());
                    intent.putExtra("phone", phone.getText().toString());
                    startActivity(intent);
                } else
                    Toast.makeText(signup.this, "Error in insertion", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(signup.this, "password not matched", Toast.LENGTH_LONG).show();
        });

        login.setOnClickListener((View v)->{
            Intent intent=new Intent(signup.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
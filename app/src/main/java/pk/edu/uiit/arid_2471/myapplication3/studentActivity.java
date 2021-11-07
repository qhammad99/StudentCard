package pk.edu.uiit.arid_2471.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class studentActivity extends AppCompatActivity {
    TextView name, email, phone;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        name=findViewById(R.id.sName);
        email= findViewById(R.id.sEmail);
        phone=findViewById(R.id.sPhone);
        logout=findViewById(R.id.lgOut);

        name.setText("Name: "+getIntent().getStringExtra("name"));
        email.setText("Email: "+getIntent().getStringExtra("mail"));
        phone.setText("Phone: "+getIntent().getStringExtra("phone"));

        logout.setOnClickListener((View v)->{
            Intent intent =new Intent(studentActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
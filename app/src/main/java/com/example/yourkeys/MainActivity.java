package com.example.yourkeys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView ulogin = (TextView) findViewById(R.id.ulogin);
                TextView usenha = (TextView) findViewById(R.id.usenha);
                String login = ulogin.getText().toString();
                String senha = usenha.getText().toString();
                if(login.equals("uiza") && senha.equals("123")){
                    alert("Você está logado!!");
                 }else {
                    alert("Erro no login, favor tente novamente...");
                }
            }
        });
    }
    private void alert(String logou){
        Toast.makeText(this,logou,Toast.LENGTH_LONG).show();
    }
}

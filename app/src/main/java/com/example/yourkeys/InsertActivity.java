package com.example.yourkeys;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class InsertActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = (EditText) findViewById(R.id.editUsuario);
                String usuario = editText.getText().toString();

                EditText editText2 = (EditText) findViewById(R.id.editSenha);
                String senha = editText2.getText().toString();

                EditText editText3 = (EditText) findViewById(R.id.editEmail);
                String email = editText3.getText().toString();

                Cadastro cadastro = new Cadastro();
                cadastro.setUsuario(usuario);
                cadastro.setSenha(senha);
                cadastro.setEmail(email);

                CadastroDB cadastroDB = new CadastroDB(getContext());
                cadastroDB.save(cadastro);

            }
        });
    }
}

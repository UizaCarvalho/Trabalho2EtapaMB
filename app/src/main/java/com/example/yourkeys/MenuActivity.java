package com.example.yourkeys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends LifeCycle {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);

            Bundle bundle = getIntent().getExtras();
            String user = bundle.getString("usuario");


            boolean isClicked = PreferenciasUser.isCheckNotification(this);
            Log.i("click", Boolean.toString(isClicked));

        }

        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_main, menu);
            return true;
        }

        public boolean onOptionsItemSelected(MenuItem item) {

            switch(item.getItemId()) {

                case R.id.action_settings:
                    Intent intent = new Intent(getApplicationContext(), Configuracoes.class);
                    startActivity(intent);
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        public void selecionarOpcao(View v) {
            TextView textView = (TextView) v;

            switch(textView.getId()) {


                case R.id.iconInsert:
                    Log.i("click", "insert");
                    Intent intentInsert = new Intent(getApplicationContext(), InsertActivity.class);
                    startActivity(intentInsert);
                    break;

                case R.id.iconUpdate:
                    Log.i("click", "update");
                    Intent intentUpdate = new Intent(getApplicationContext(), UpdateActivity.class);
                    startActivity(intentUpdate);
                    break;

                case R.id.iconSelect:
                    Log.i("click", "select");
                    Intent intentSelect = new Intent(getApplicationContext(), SelectActivity.class);
                    startActivity(intentSelect);
                    break;
                case R.id.iconDelete:
                    Log.i("click", "listar");
                    Intent intentDelete = new Intent(getApplicationContext(), DeleteActivity.class);
                    startActivity(intentDelete);
                    break;
            }
        }
    }

}

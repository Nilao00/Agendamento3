package agendamento.androidtcc.mateuscardoso.com.agendamento.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import agendamento.androidtcc.mateuscardoso.com.agendamento.R;
import agendamento.androidtcc.mateuscardoso.com.agendamento.activities.DeskActivity;

/**
 * Created by mateus polonini cardoso on 20/03/2017.
 */

public class LoginAgendamento extends Activity {
    private EditText nomeEditText;
    private EditText senhaEditText;
    private Button entrarButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_agendamento);
        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        senhaEditText = (EditText) findViewById(R.id.senhaEditText);
        entrarButton = (Button) findViewById(R.id.entrarButton);

    }

    public void logarUsuario(View view){
        String login = nomeEditText.getText().toString();
        String senha = senhaEditText.getText().toString();
        if("mateus".equals(login) && "123".equals(senha)){
            startActivity(new Intent(this, DeskActivity.class));
        }else{
            Toast.makeText(this, "Usuario ou senha invalidos", Toast.LENGTH_SHORT).show();
        }
    }
}

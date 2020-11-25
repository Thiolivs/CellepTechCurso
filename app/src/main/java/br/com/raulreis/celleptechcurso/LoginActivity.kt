package br.com.raulreis.celleptechcurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Executando (Escutando) o clique do botão entrar
        btnLoginEntrar.setOnClickListener {

            //Capturando os dados digitados
            val email = edtLoginEmail.text.toString().trim().toLowerCase()
            val senha = edtLoginSenha.text.toString().trim()

            //validação dos campos
            if (email.isEmpty()){

                edtLoginEmail.error ="Campo obrigatório!"
                edtLoginEmail.requestFocus()
            } else if (senha.isEmpty()){
                edtLoginSenha.error ="Campo obrigatório!"
                edtLoginSenha.requestFocus()
            } else { // E-mail e senha não são vazios
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                //Recuperando os dados do Shared Preferences

                val emailPrefs =sharedPrefs.getString("EMAIL", "")
                val senhaPrefs =sharedPrefs.getString("SENHA", "")

                // Verificar o e-mail e senha
                if(email==emailPrefs && senha ==senhaPrefs){

                    //apresentar uma mensagem de sucesso ao usuário
                    Toast.makeText(this,"Usuário logado com sucesso", Toast.LENGTH_LONG).show()

                    //Abrindo a MainActivity

                    val mIntent = Intent(this, MainActivity::class.java)

                    mIntent.putExtra("INTENT_EMAIL", email)

                    startActivity(mIntent)
                    finish()
                }

                else {
                    //apresentando uma mensagem de erro ao usuario
                    Toast.makeText(this,"Usuário ou Senha Inválidos", Toast.LENGTH_LONG).show()
                }
            }
        }

        // Executando o clique do botão cadastrar
        btnLoginCadastrar.setOnClickListener {
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)

        }


    }
}
package com.example.agrodetect_mobile;

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.agrodetect_mobile.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtEmail = findViewById<EditText>(R.id.editTextEmail)
        val txtSenha = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.btnSubmitLogin)
        val newUserBtn = findViewById<Button>(R.id.new_user_btn)


        newUserBtn.setOnClickListener{
            val i = Intent(this,  ActivityRegister::class.java)
            startActivity(i)
            finish()
        }

        btnLogin.setOnClickListener{
            val db = DatabaseManager (this, "tbl_dadosBasicos")
            val (success, id) = db.login(txtEmail.text.toString(),txtSenha.text.toString() )


            if (success)  {
                val idPersistencia = this.getSharedPreferences("id_persistencia", Context.MODE_PRIVATE)
                val editor = idPersistencia.edit()
                if (id != null) {
                    editor.putLong("id", id)
                    editor.apply()
                }
                val i = Intent(this,  HomeActivity::class.java)
                startActivity(i)
                finish()
            } else  {
                Toast.makeText(this, "Insira um usuário válido, por favor!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
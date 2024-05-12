package com.luizafmartinez.m24_realm_android

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.luizafmartinez.m24_realm_android.database.DatabaseRealm
import com.luizafmartinez.m24_realm_android.databinding.ActivityMainBinding
import com.luizafmartinez.m24_realm_android.model.Usuario
import org.mongodb.kbson.ObjectId

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val realm by lazy {
        DatabaseRealm()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnSalvar.setOnClickListener {

            val nomeRecuperado = binding.editNome.text.toString()

            val usuario = Usuario().apply {
                nome = nomeRecuperado
                idade = 10
            }

            realm.salvar( usuario )
        }

        binding.btnListar.setOnClickListener {

            val lista = realm.listar()

            var textoLista = ""

            lista.forEach { usuario ->
                textoLista += "nome: ${usuario.nome} - idade: ${usuario.idade} \n"
                Log.i("info_realm", "id: ${usuario.id} - nome: ${usuario.nome} ")
            }

            binding.textResultado.text = textoLista
        }

        binding.btnRemover.setOnClickListener {
            // 633a1f29ab1d031d7a04068a
            val id = ObjectId("633a1f29ab1d031d7a04068a")
            realm.remover( id )
        }

        binding.btnAtualizar.setOnClickListener{

            val nomeRecuperado = binding.editNome.text.toString()
            val idSelecionado = ObjectId("633a1f29ab1d031d7a04068a") //Exemplo

            val usuario = Usuario().apply {
                id = idSelecionado
                nome = nomeRecuperado
                idade = 40
            }

            realm.atualizar( usuario )
        }

    }
}
package com.luizafmartinez.m24_realm_android.database

import com.luizafmartinez.m24_realm_android.model.Usuario
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.query.Sort
import org.mongodb.kbson.ObjectId

class DatabaseRealm {

     val configuracao = RealmConfiguration.Builder(
        schema = setOf( Usuario::class )).build()

    //private val realm = Realm.open( configuracao.build() )
    private val realm = Realm.open( configuracao )

    fun salvar( usuario: Usuario ){

        realm.writeBlocking {
            copyToRealm( usuario )
        }
    }

    fun listar() : RealmResults<Usuario> {

        return realm
            //.query<Usuario>("nome == $0", "jamilton")
            .query<Usuario>()
            .sort("nome", Sort.ASCENDING)
            .find()
    }

    fun remover( id: ObjectId) {

        realm.writeBlocking {
            val usuarioRemover = query<Usuario>("_id == $0", id)
                .find()
                .first()

            delete( usuarioRemover )
        }
    }

    fun atualizar( usuario: Usuario) {

        realm.writeBlocking {
            val usuarioAtualizar = query<Usuario>("_id == $0", usuario.id)
                .find()
                .first()

            usuarioAtualizar.nome = usuario.nome
            usuarioAtualizar.idade = usuario.idade
        }
    }
}

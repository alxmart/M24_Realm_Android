package com.luizafmartinez.m24_realm_android.database

import com.luizafmartinez.m24_realm_android.model.Usuario
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.query.Sort

class DatabaseRealm {

    private val configuracao = RealmConfiguration.Builder(
        schema = setOf( Usuario::class )
    )
    private val realm = Realm.open( configuracao.build() )

    fun salvar( usuario: Usuario ){

        realm.writeBlocking {
            copyToRealm( usuario )
        }
    }

    fun listar() : RealmResults<Usuario> {

        return realm
            //.query<Usuario>("nome = $0", "jamilton")
            .query<Usuario>()
            .sort("nome", Sort.ASCENDING)
            .find()
    }



}
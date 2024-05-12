package com.luizafmartinez.m24_realm_android.database

import com.luizafmartinez.m24_realm_android.model.Usuario
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

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

}

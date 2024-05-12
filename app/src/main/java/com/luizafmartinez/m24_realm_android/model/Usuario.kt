package com.luizafmartinez.m24_realm_android.model

import org.mongodb.kbson.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId

class Usuario : RealmObject {

    @PrimaryKey
    var id: org.mongodb.kbson.ObjectId = BsonObjectId.invoke()
    var nome = ""
    var idade = 0

}



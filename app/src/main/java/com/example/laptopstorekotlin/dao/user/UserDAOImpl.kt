package com.example.laptopstorekotlin.dao.user

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.telephony.PhoneNumberUtils
import android.util.Patterns
import com.example.laptopstorekotlin.model.user.User
import com.example.laptopstorekotlin.utils.*

class UserDAOImpl(val context: Context) :  UserDAO{
    val dbHelper: DBHelper by lazy{
        DBHelper(context)
    }
    val db : SQLiteDatabase by lazy {
        dbHelper.writableDatabase
    }

    override fun addUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun checkLogin(identity: String?, password: String?): Boolean {
        val selection = if(Patterns.EMAIL_ADDRESS.matcher(identity).matches()){
            "$COLUMN_USER_EMAIL = ? AND $COLUMN_USER_PASSWORD = ?"
        } else if (PhoneNumberUtils.isGlobalPhoneNumber(identity)){
            "$COLUMN_USER_TEL = ? AND $COLUMN_USER_PASSWORD = ?"
        } else {
            "$COLUMN_USER_NAME  = ? AND $COLUMN_USER_PASSWORD = ?"
        }
        val selectionArgs = arrayOf(identity, password)
        val cursor = db.query(TABLE_USER,
            null,
            selection,
            selectionArgs,
            null,
            null,
            null)
        val count = cursor.count
        cursor.close()
        return count>0
    }
}
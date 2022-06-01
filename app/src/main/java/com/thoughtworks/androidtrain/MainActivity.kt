package com.thoughtworks.androidtrain

import android.app.AlertDialog
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

val PICK_CONTACT_REQUEST = 1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)
        Log.i("MainActivity", "create")
    }

    fun goNextActivity(view: View) {
        val intent = Intent(this, HelloActivity::class.java).apply {}
        startActivity(intent)
    }

    fun goThreadActivity(view: View){
        val intent = Intent(this, ThreadActivity::class.java).apply{}
        startActivity(intent)
    }

    fun goLoginActivity(view: View) {
        val intent = Intent(this, LoginActivity::class.java).apply {}
        startActivity(intent)
    }

    fun goContactActivity(view: View) {
//        val intent = Intent("android.permission.READ_CONTACTS").apply {}
//        startActivityForResult(intent, 1)
        val intent = Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"))
        intent.addCategory(Intent.CATEGORY_DEFAULT)
        intent.setType("vnd.android.cursor.dir/phone_v2")
        startActivityForResult(intent, PICK_CONTACT_REQUEST)
    }

    fun goFragmentActivity(view: View) {
        val intent = Intent(this, FragmentChangeActivity::class.java).apply {}
        startActivity(intent)
    }

    fun goRecyclerViewActivity(view: View) {
        val intent = Intent(this, RecyclerViewActivity::class.java).apply {}
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
//            val a = data.getParcelableExtra<Phone>(KEY)
//            if (a != null) {
//                Toast.makeText(this, a.name + "\n" + a.phone_number, Toast.LENGTH_SHORT).show()
//            }
//        }
        if (requestCode == PICK_CONTACT_REQUEST && resultCode == RESULT_OK) {
            val cursor: Cursor? = data?.getData()?.let {
                contentResolver.query(
                    it, arrayOf(
                        "display_name",
                        "data1"
                    ), null, null, null
                )
            }

            if (cursor != null) {
                cursor.moveToNext()
                val contactName =
                    cursor?.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val phoneNumber = cursor?.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
//                Toast.makeText(this, contactName + "\n"+ phoneNumber, Toast.LENGTH_SHORT).show()

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Contact message")
                builder.setMessage(contactName + "\n"+ phoneNumber)
                builder.setPositiveButton("cancel") { dialog, which ->  }
                val dialog = builder.create()
                dialog.setCanceledOnTouchOutside(false)
                dialog.show()
            }

        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "onRestart")
    }
}

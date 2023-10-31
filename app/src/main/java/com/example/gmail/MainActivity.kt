package com.example.gmail

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var emails: List<Email>
    private lateinit var adapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list_view)

        emails = listOf(
            Email("Test@gmai.com", "testtttttttttttt"),
            Email("Test@gmai.com", "testtttttttttttt"),
            Email("Test@gmai.com", "testtttttttttttt"),
            Email("Test@gmai.com", "testtttttttttttt"),
            Email("Test@gmai.com", "testtttttttttttt"),
            Email("Test@gmai.com", "testtttttttttttt"),
            Email("Test@gmai.com", "testtttttttttttt"),
            Email("Test@gmai.com", "testtttttttttttt"),
            Email("Test@gmai.com", "testtttttttttttt"),
            Email("Test@gmai.com", "testtttttttttttt"),
        )

        adapter = EmailAdapter(this, emails)
        listView.adapter = adapter
    }


}

data class Email(val senderName: String, val emailSubject: String)

class EmailAdapter(context: Context, emails: List<Email>) : ArrayAdapter<Email>(context, 0, emails) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val email = getItem(position)

        val senderName = view.findViewById<TextView>(R.id.sender_name)
        val emailSubject = view.findViewById<TextView>(R.id.email_subject)

        senderName.text = email?.senderName
        emailSubject.text = email?.emailSubject

        return view
    }
}
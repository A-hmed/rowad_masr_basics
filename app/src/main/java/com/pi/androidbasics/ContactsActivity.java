package com.pi.androidbasics;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.pi.androidbasics.model.ContactDM;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ContactsAdapter contactsAdapter;

    ArrayList<ContactDM> contacts;
    EditText nameEd;
    EditText phoneNumberEd;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        recyclerView = findViewById(R.id.contacts_recycler_view);
        nameEd = findViewById(R.id.name_ed);
        phoneNumberEd = findViewById(R.id.phone_number_ed);
        addBtn = findViewById(R.id.add_btn);
        mockContacts();
        contactsAdapter = new ContactsAdapter(contacts);
        recyclerView.setAdapter(contactsAdapter);
        contactsAdapter.onClickListener = new ContactsAdapter.OnClickListener() {
            @Override
            public void onItemClick(ContactDM contactDM, int position) {
                Toast.makeText(ContactsActivity.this, contactDM.getName(), Toast.LENGTH_SHORT).show();
            }
        };
    }

    void mockContacts() {
        contacts = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            contacts.add(new ContactDM(R.drawable.car, "Test name" + i, "01111111" + i));
        }
    }
}
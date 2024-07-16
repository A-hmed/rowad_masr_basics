package com.pi.androidbasics;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

    ArrayList<ContactDM> contacts = new ArrayList<>();
    EditText nameEd;
    EditText phoneNumberEd;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        initViews();
        initRecyclerView();
        initListeners();
    }

    private void initListeners() {
        addBtn.setOnClickListener(__ -> {
            String name = nameEd.getText().toString();
            String phoneNumber = phoneNumberEd.getText().toString();
            if(name.isEmpty() || phoneNumber.isEmpty()){
                Toast.makeText(this, "Enter valid contact", Toast.LENGTH_SHORT).show();
                return;
            }
            contacts.add(new ContactDM(R.drawable.car, name, phoneNumber));
            contactsAdapter.refreshList(contacts);
            nameEd.setText("");
            phoneNumberEd.setText("");
        });
    }

    void initRecyclerView(){
        contactsAdapter = new ContactsAdapter(contacts);
        recyclerView.setAdapter(contactsAdapter);
        contactsAdapter.onClickListener = new ContactsAdapter.OnClickListener() {
            @Override
            public void onItemClick(ContactDM contactDM, int position) {
                Toast.makeText(ContactsActivity.this, contactDM.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteIconClick(ContactDM contactDM, int position) {
                contacts.remove(position);
                contactsAdapter.refreshList(contacts);
            }
        };
    }
    void initViews(){
        recyclerView = findViewById(R.id.contacts_recycler_view);
        nameEd = findViewById(R.id.name_ed);
        phoneNumberEd = findViewById(R.id.phone_number_ed);
        addBtn = findViewById(R.id.add_btn);
    }

}
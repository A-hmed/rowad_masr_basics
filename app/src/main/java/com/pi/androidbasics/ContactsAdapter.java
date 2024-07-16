package com.pi.androidbasics;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pi.androidbasics.model.ContactDM;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
    ArrayList<ContactDM> contacts;
    public ContactsAdapter(ArrayList<ContactDM> contacts) {
        this.contacts = contacts;
    }

    ContactsAdapter(ArrayList<ContactDM> contacts,ContactsActivity activity){
        this.contacts = contacts;
      //  this.activity = activity;
    }

    public void refreshList(ArrayList<ContactDM> newList){
        this.contacts = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,
                parent, false);
        Log.e("ContactsAdapter", "onCreateViewHolder");
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        ContactDM contactDM = contacts.get(position);
        holder.profileIv.setImageResource(contactDM.getImageDrawableId());
        holder.nameTv.setText(contactDM.getName());
        holder.phoneNumber.setText(contactDM.getPhoneNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onClickListener.onItemClick(contactDM, position);
            }
        });
        holder.deleteIcon.setOnClickListener(view -> {
            onClickListener.onDeleteIconClick(contactDM, position);
        });
//        holder.profileIv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        Log.e("ContactsAdapter", "onBindViewHolder: position = " + position);
    }
    OnClickListener onClickListener;
    interface OnClickListener{
        void onItemClick(ContactDM contactDM, int position);

        void onDeleteIconClick(ContactDM contactDM, int position);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {
        ImageView profileIv;
        TextView nameTv;
        TextView phoneNumber;
        ImageView deleteIcon;

        ContactsViewHolder(View view) {
            super(view);
            profileIv = view.findViewById(R.id.contact_profile_image_view);

            nameTv = view.findViewById(R.id.contact_name_textview);

            phoneNumber = view.findViewById(R.id.contact_phone_number_textview);

            deleteIcon = view.findViewById(R.id.contact_delete_icon);
        }
    }
}

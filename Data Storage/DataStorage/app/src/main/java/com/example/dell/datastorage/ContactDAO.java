package com.example.dell.datastorage;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Contact... contacts);

    @Update
    public void update(Contact... contacts);

    @Delete
    public void delete(Contact contact);

    @Query("SELECT * FROM Contact")
    public List<Contact> getAllContacts();

    @Query("select * from Contact where phoneNumber= :number")
    public Contact getContact(String number);

    @Query("update Contact set phoneNumber = :number where lastName= :ln and firstName = :fn")
    public void updatePhoneNumber(String number, String fn, String ln);
}
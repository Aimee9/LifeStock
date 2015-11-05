package com.epicodus.lifestock.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by oem on 11/2/15.
 */
@Table(name = "Users", id = "_id")
public class User extends Model {

    @Column(name = "Name")
    private String mName;

    public User() {
        super();
    }

    public User(String name){
        super();
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public List<Siting> sitings() {
        return getMany(Siting.class, "User");
    }

    public static User find(String username) {
        return new Select()
                .from(User.class)
                .where("Name = ?", username)
                .executeSingle();
    }
}

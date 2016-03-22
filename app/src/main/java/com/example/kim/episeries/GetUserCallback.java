package com.example.kim.episeries;

/**
 * Created by kim on 22/03/2016.
 */
interface GetUserCallback {

    //executed when background task is completed
    public abstract void done(User returnedUser);
}

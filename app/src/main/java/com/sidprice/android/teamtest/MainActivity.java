package com.sidprice.android.teamtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sidprice.android.teamtest.models.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private FirebaseAuth    mAuth ;
    private FirebaseDatabase    mDb ;
    private DatabaseReference   mRootReference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mDb = FirebaseDatabase.getInstance() ;
        mRootReference = mDb.getReference() ;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.NewTeamButton: {
                if ( mRootReference != null ) {
                    //
                    // First step is to create a user account of type "owner"
                    //
                    User    newUser = new User("sidprice", "sid@sidprice.com", "owner") ;
                    DatabaseReference usersReference = mDb.getReference().child("users") ;
                    DatabaseReference newUserReference = usersReference.push() ;
                    newUserReference.setValue(newUser) ;
                    //
                    // Add the owner to the "AvianAmb" team members
                    //
                    mDb.getReference().child("teams").child("AvianAmb").child("members").child(newUserReference.getKey()).setValue("owner") ;

                } else {
                    Toast.makeText(this, "Database Reference Null", Toast.LENGTH_SHORT).show();
                }
                break;
            }

            case R.id.InvitedUserButton :
                Log.d(TAG, "onClick: Invited user button");
               break;

            default: {
                break;
            }
        }
    }
}

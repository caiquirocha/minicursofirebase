package cardoso.guilherme.minicursofirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    private static String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }

    @Override
    protected void onResume() {
        super.onResume();

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null) {
            // User is signed in
            Log.d(TAG, "onAuthStateChanged: signed_in: " + user.getUid());
        } else {
            // User is signed out
            Log.d(TAG, "onAuthStateChanged: signed_out");
            finish();
        }
    }
}

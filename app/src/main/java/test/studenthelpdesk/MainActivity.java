package test.studenthelpdesk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.iid.FirebaseInstanceId;


public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    private SignInButton SignIn;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;
    private String name;
    String gname;
    private String img_url;
    private String pic_url;
    String email;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignIn = (SignInButton) findViewById(R.id.btn_login);

        SignIn.setOnClickListener(this);

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                signIn();
                break;
            //  case R.id.bn_logout:
            //    signOut();
            //  break;
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    private void signIn() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent, REQ_CODE);
    }
    private void handleResult(GoogleSignInResult result) {

        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            Intent intent = new Intent(this, NavActivity.class);
            intent.putExtra(gname,account.getDisplayName());
            intent.putExtra(pic_url, account.getPhotoUrl().toString());
            intent.putExtra(email, account.getEmail().toString());
            startActivity(intent);
           // Intent intent = new Intent(this, MainList.class);
            //String name = account.getDisplayName();
            //String email = account.getEmail();
            //String img_url = account.getPhotoUrl().toString();
            //Name.setText(name);
            //Email.setText(email);
            //updateUI(true);
            name = account.getDisplayName();


            //User newUser = new User();
           // newUser.setUserID(email);
            //newUser.setToken(FirebaseInstanceId.getInstance().getToken());
            //Log.d("USER_TOKEN", newUser.getToken());

            img_url = account.getPhotoUrl().toString();
            System.out.println("hi" + result.getStatus().toString());
            startActivity(intent);
        } else {
            System.out.println("hi" + result.getStatus().toString());

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }
    public void setName(String i) {
        name = i;
    }

    public String getName(){
        return name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

}

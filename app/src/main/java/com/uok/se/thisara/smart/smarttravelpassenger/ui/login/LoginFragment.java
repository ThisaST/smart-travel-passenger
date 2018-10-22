package com.uok.se.thisara.smart.smarttravelpassenger.ui.login;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.twitter.sdk.android.core.Twitter;
import com.uok.se.thisara.smart.smarttravelpassenger.LoginActivity;
import com.uok.se.thisara.smart.smarttravelpassenger.MainActivity;
import com.uok.se.thisara.smart.smarttravelpassenger.R;
import com.uok.se.thisara.smart.smarttravelpassenger.ui.main.MainFragment;
import com.uok.se.thisara.smart.smarttravelpassenger.viewmodel.LoginViewModel;

import org.json.JSONObject;

import java.util.Arrays;

import static com.facebook.FacebookSdk.getApplicationContext;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;
    private LoginButton fbLoginButton;
    public static CallbackManager callbackManager;
    private static final String EMAIL = "email";
    private AccessToken mAccessToken;
    private static final String TAG = "fblogin";

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);


    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        //twitter initialization

        Twitter.initialize(getApplicationContext());

        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel

        callbackManager = CallbackManager.Factory.create();

        useFacebookLogIn();

        fbLoginButton = getActivity().findViewById(R.id.fbLoginButton);
        fbLoginButton.setReadPermissions(Arrays.asList(EMAIL, "public_profile"));


        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                mAccessToken = loginResult.getAccessToken();

                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {


                    }
                });
                getUserProfile(mAccessToken);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

                Log.d(TAG, "onError: ", error);
            }
        });

        if (AccessToken.getCurrentAccessToken() != null) {

            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }



        Button twitterLoginButton = getActivity().findViewById(R.id.twitterLoginButton);

        twitterLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });



    }

    private void useFacebookLogIn() {


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    private void getUserProfile(AccessToken mAccessToken) {



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        Fragment fragment = getFragmentManager().findFragmentById(R.id.login);
        if (fragment != null) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }
}

package com.michael.gadsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.michael.gadsproject.Services.ServiceBuilder;
import com.michael.gadsproject.Services.SubmitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Submit extends AppCompatActivity {

    EditText FirstName, LastName, Email, GithubLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        FirstName = findViewById(R.id.firstName);
        LastName = findViewById(R.id.lastName);
        Email = findViewById(R.id.email);
        GithubLink = findViewById(R.id.githubLink);
    }

    public void submit(View view) {
        PopUpService popUpService = new PopUpService();
        popUpService.showPopupWindow(view, R.layout.pop_up_are);
    }

    public void submitDetails(final View view) {

        final String url = "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";

        String firstName = FirstName.getText().toString();
        String lastName = LastName.getText().toString();
        String email =Email.getText().toString();
        String githubLink = GithubLink.getText().toString();

        SubmitService submitService = ServiceBuilder.buildService(SubmitService.class);
        Call<Void> call = submitService.submit(url, firstName, lastName, email, githubLink);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Submit.this, "Success", Toast.LENGTH_SHORT).show();
                    PopUpService popUpService = new PopUpService();
                    popUpService.showPopupWindow(view, R.layout.pop_up_success);
                }else {
                    PopUpService popUpService = new PopUpService();
                    popUpService.showPopupWindow(view, R.layout.pop_up_failed);
                    Toast.makeText(Submit.this, "Failure", Toast.LENGTH_SHORT).show();
                }
                Log.i("respomse", response.body().toString());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.i("respomseFailed", t.getMessage());
            }
        });

    }
}
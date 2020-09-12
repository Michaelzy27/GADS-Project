package com.michael.gadsproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.michael.gadsproject.Services.ServiceBuilder;
import com.michael.gadsproject.Services.SubmitService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Submit extends AppCompatActivity {

    EditText FirstName, LastName, Email, GithubLink;

    String firstName;
    String lastName;
    String email;
    String githubLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        FirstName = findViewById(R.id.firstName);
        LastName = findViewById(R.id.lastName);
        Email = findViewById(R.id.emailText);
        GithubLink = findViewById(R.id.githubLink);
    }

    public void submit(View view) {

        lastName = LastName.getText().toString();
        firstName = FirstName.getText().toString();
        email =Email.getText().toString();
        githubLink = GithubLink.getText().toString();

        PopUpService popUpService = new PopUpService();
        popUpService.showPopupWindow(view, R.layout.pop_up_are);
    }

    public void submitDetails(final View view) {

        final String url = "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";

        SubmitService submitService = ServiceBuilder.buildService(SubmitService.class);
        Call<ResponseBody> call = submitService.submit(url, firstName, lastName, email, githubLink);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(Submit.this, "Success", Toast.LENGTH_SHORT).show();
//                    PopUpService popUpService = new PopUpService();
//                    popUpService.showPopupWindow(view, R.layout.pop_up_success);

                    dialogSuccess();

                }else {
                    dialogFailure();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("respomseFailed", t.getMessage());
            }
        });

    }

    private void dialogFailure() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Submit.this);
        builder.setTitle("Name");

        final View customView = getLayoutInflater().inflate(R.layout.pop_up_failed, null);
        builder.setView(customView);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void dialogSuccess() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Submit.this);
        builder.setTitle("Name");

        final View customView = getLayoutInflater().inflate(R.layout.pop_up_success, null);
        builder.setView(customView);
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
package com.michael.gadsproject;

import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.michael.gadsproject.Services.ServiceBuilder;
import com.michael.gadsproject.Services.SubmitService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopUpService {

    public void showPopupWindow(final View view, int id) {

        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(id, null);

        int width = ConstraintLayout.LayoutParams.MATCH_PARENT;
        int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;

        final PopupWindow popupWindow = new PopupWindow(popUpView, width, height, true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow.setFocusable(true);

        popUpView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return true;
            }
        });

        if (id == R.layout.pop_up_are) {

            Button submit = popUpView.findViewById(R.id.submitConfirm);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    Submit submit1 = new Submit();
                    submit1.submitDetails(view);

//                    final String url = "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";
//
//                    SubmitService submitService = ServiceBuilder.buildService(SubmitService.class);
//                    Call<ResponseBody> call = submitService.submit(url, submit1.firstName, submit1.lastName, submit1.email, submit1.githubLink);
//
//                    call.enqueue(new Callback<ResponseBody>() {
//                        @Override
//                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                            Log.i("response", response.body().toString());
////                            if (response.isSuccessful()) {
//////                                Toast.makeText(get, "Success", Toast.LENGTH_SHORT).show();
//////                                PopUpService popUpService = new PopUpService();
//////                                popUpService.showPopupWindow(view, R.layout.pop_up_success);
////
////                                LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
////                                View popUpView = inflater.inflate(R.layout.pop_up_success, null);
////
////                                int width = ConstraintLayout.LayoutParams.MATCH_PARENT;
////                                int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
////
////                                final PopupWindow popupWindow = new PopupWindow(popUpView, width, height, true);
////                                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
////                                popupWindow.setFocusable(true);
////
////
////                            }else {
//////                                PopUpService popUpService = new PopUpService();
//////                                popUpService.showPopupWindow(view, R.layout.pop_up_failed);
//////                                Toast.makeText(Submit.this, "Failure", Toast.LENGTH_SHORT).show();
////
////                                LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
////                                View popUpView = inflater.inflate(R.layout.pop_up_failed, null);
////
////                                int width = ConstraintLayout.LayoutParams.MATCH_PARENT;
////                                int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
////
////                                final PopupWindow popupWindow = new PopupWindow(popUpView, width, height, true);
////                                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
////                                popupWindow.setFocusable(true);
////
////
////                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseBody> call, Throwable t) {
//                            Log.i("respomseFailed", t.getMessage());
//                        }
//                    });
//
                }
            });

        }

    }

    public void showSuccessWindow() {



    }

}

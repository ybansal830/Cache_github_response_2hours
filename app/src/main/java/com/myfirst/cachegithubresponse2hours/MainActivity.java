package com.myfirst.cachegithubresponse2hours;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EditText mEtEnterId;
    private ImageButton mIbSearch;
    private List<ResponseGitHub> list;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mIbSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiCall();
            }
        });
    }

    private void apiCall() {
        mProgressBar.setVisibility(View.VISIBLE);
        ApiServices apiServices = Network.getInstance(this).create(ApiServices.class);
        String user = mEtEnterId.getText().toString();
        apiServices.getData(user).enqueue(new Callback<List<ResponseGitHub>>() {
            @Override
            public void onResponse(Call<List<ResponseGitHub>> call, Response<List<ResponseGitHub>> response) {
                if(response.body() != null) {
                    list = response.body();
                    setRecyclerView();
                    mProgressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<ResponseGitHub>> call, Throwable t) {

            }
        });
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mEtEnterId = findViewById(R.id.etEnterId);
        mIbSearch = findViewById(R.id.ibSearch);
        mProgressBar = findViewById(R.id.progressBar);
    }

    private void setRecyclerView(){
        GitHubAdapter gitHubAdapter = new GitHubAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setAdapter(gitHubAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
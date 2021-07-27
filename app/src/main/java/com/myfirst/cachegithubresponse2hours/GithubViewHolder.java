package com.myfirst.cachegithubresponse2hours;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GithubViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvName,mTvLogin,mTvDescription;

    public GithubViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews();
    }

    private void initViews() {
        mTvName = itemView.findViewById(R.id.tvName);
        mTvLogin = itemView.findViewById(R.id.tvLogin);
        mTvDescription = itemView.findViewById(R.id.tvDescription);
    }

    public void setData(ResponseGitHub responseGitHub){
        mTvName.setText(responseGitHub.getName());
        mTvLogin.setText(responseGitHub.getOwner().getLogin());
        mTvDescription.setText("null");
    }
}

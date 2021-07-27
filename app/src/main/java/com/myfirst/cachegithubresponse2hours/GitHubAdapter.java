package com.myfirst.cachegithubresponse2hours;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GitHubAdapter extends RecyclerView.Adapter<GithubViewHolder> {

    private List<ResponseGitHub> responseGitHub;

    public GitHubAdapter(List<ResponseGitHub> responseGitHub) {
        this.responseGitHub = responseGitHub;
    }

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_github,parent,
                false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  GithubViewHolder holder, int position) {
        holder.setData(responseGitHub.get(position));
    }

    @Override
    public int getItemCount() {
        return responseGitHub.size();
    }
}

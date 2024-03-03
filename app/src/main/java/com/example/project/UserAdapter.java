package com.example.project;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<UserInfo> userInfoList;

    public UserAdapter(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserInfo userInfo = userInfoList.get(position);
        holder.userNameTextView.setText(userInfo.getUsername());
        holder.userBioTextView.setText(userInfo.getBio());
        holder.userEmailTextView.setText(userInfo.getEmail());
    }

    @Override
    public int getItemCount() {
        return userInfoList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView userNameTextView, userBioTextView, userEmailTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            userNameTextView = itemView.findViewById(R.id.userNameTextView);
            userBioTextView = itemView.findViewById(R.id.userBioTextView);
            userEmailTextView = itemView.findViewById(R.id.userEmailTextView);
        }
    }
}




//package com.example.project;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import java.util.List;
//
//public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
//
//    private List<UserInfo> userInfoList;
//    private OnUserClickListener onUserClickListener; // Listener for user clicks
//
//    public UserAdapter(List<UserInfo> userInfoList, OnUserClickListener onUserClickListener) {
//        this.userInfoList = userInfoList;
//        this.onUserClickListener = onUserClickListener;
//    }
//
//    @NonNull
//    @Override
//    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
//        return new UserViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
//        UserInfo userInfo = userInfoList.get(position);
//        holder.bind(userInfo);
//    }
//
//    @Override
//    public int getItemCount() {
//        return userInfoList.size();
//    }
//
//    class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        TextView usernameTextView;
//
//        UserViewHolder(@NonNull View itemView) {
//            super(itemView);
//            usernameTextView = itemView.findViewById(R.id.userNameTextView);
//            itemView.setOnClickListener(this); // Set click listener on the entire item
//        }
//
//        void bind(UserInfo userInfo) {
//            usernameTextView.setText(userInfo.getUsername());
//        }
//
//        @Override
//        public void onClick(View v) {
//            int position = getAdapterPosition();
//            if (position != RecyclerView.NO_POSITION && onUserClickListener != null) {
//                onUserClickListener.onUserClick(position); // Notify activity about user click
//            }
//        }
//    }
//
//    // Interface to handle user clicks
//    public interface OnUserClickListener {
//        void onUserClick(int position);
//    }
//}

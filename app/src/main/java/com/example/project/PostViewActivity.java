package com.example.project;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.List;

public class PostViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post> postList;

    private DatabaseReference postsReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_view);

        recyclerView = findViewById(R.id.recyclerView);
        postList = new ArrayList<>();
        postAdapter = new PostAdapter(postList);

        recyclerView.setLayoutManager(new LinearLayoutManager(PostViewActivity.this));
        recyclerView.setAdapter(postAdapter);

        // Retrieve the current user's ID
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userId = user.getUid();

            // Reference to the "posts" node in the Realtime Database
            postsReference = FirebaseDatabase.getInstance().getReference("posts");

            // Retrieve and display posts for the current user
            retrieveAndDisplayPosts(userId);
        }
    }

    private void retrieveAndDisplayPosts(String userId) {
        postsReference.orderByChild("userId").equalTo(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postList.clear(); // Clear the list before adding new items
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // Get post information from the snapshot
                    Post post = postSnapshot.getValue(Post.class);

                    // Add post to the list
                    if (post != null) {
                        postList.add(post);
                    }
                }

                // Notify the adapter about the data change
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });
    }

}

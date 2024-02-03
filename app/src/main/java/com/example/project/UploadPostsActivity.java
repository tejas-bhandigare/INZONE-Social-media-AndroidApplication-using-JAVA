package com.example.project;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UploadPostsActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView postImageView;
    private EditText captionEditText;
    private Button chooseImageButton, uploadButton;

    private Uri imageUri;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_posts);

        postImageView = findViewById(R.id.postImageView);
        captionEditText = findViewById(R.id.captionEditText);
        chooseImageButton = findViewById(R.id.chooseImageButton);
        uploadButton = findViewById(R.id.uploadButton);

        storageReference = FirebaseStorage.getInstance().getReference("posts");
        databaseReference = FirebaseDatabase.getInstance().getReference("posts");

        chooseImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadPost();
            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            postImageView.setImageURI(imageUri);
        }
    }

    private void uploadPost() {
        if (imageUri != null) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            if (user != null) {
                String userId = user.getUid();
                String caption = captionEditText.getText().toString().trim();

                // Create a unique filename for the image
                String imageName = System.currentTimeMillis() + "_" + userId;

                StorageReference imageReference = storageReference.child(imageName);

                // Upload image to Firebase Storage
                imageReference.putFile(imageUri)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                // Image uploaded successfully
                                imageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        // Get the download URL of the image
                                        String imageUrl = uri.toString();

                                        // Save post information to Firebase Realtime Database
                                        savePostToDatabase(userId, caption, imageUrl);
                                    }
                                });
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Handle image upload failure
                            }
                        });
            }
        }
    }

    private void savePostToDatabase(String userId, String caption, String imageUrl) {
        // Create a unique post ID
        String postId = databaseReference.push().getKey();

        // Create a Post object
        Post post = new Post(postId, userId, caption, imageUrl);

        // Save post information to the "posts" node in the Realtime Database
        databaseReference.child(postId).setValue(post);

        // Optionally, show a success message or redirect the user
        // based on your app's flow.
    }
}

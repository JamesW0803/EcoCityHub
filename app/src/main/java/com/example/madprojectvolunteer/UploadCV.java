package com.example.madprojectvolunteer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UploadCV extends AppCompatActivity {

    Button btnUploadCV;
    Button btnSubmit;
    ImageButton btnBack;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    // Value (of USERNAME) to put in Intent
    private String username; // TODO: Intent Value
    private String activityKey;
    private String organizerName;

    private String fileName; // self-custom filename


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_cv);


        //TODO: Authentication Testing 1

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();


//        if (currentUser != null) {
//            String username = currentUser.getDisplayName();
//
//            if (username != null && !username.isEmpty()) {
//                // Use the username as needed (e.g., display it or store it)
//                Toast.makeText(UploadCV.this, "Username: " + username, Toast.LENGTH_SHORT).show();
//            } else {
//                // Handle the case where the username is not available
//                Toast.makeText(UploadCV.this, "Username not available", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            // Handle the case where the user is not logged in
//            Toast.makeText(UploadCV.this, "User not logged in", Toast.LENGTH_SHORT).show();
//        }

        //TODO: Authentication Testing 2
//        mAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                currentUser = firebaseAuth.getCurrentUser();
//                if (currentUser != null) {
//                    // User is signed in
//                    String userId = currentUser.getUid();
//                    String email = currentUser.getEmail();
//
//                    Toast.makeText(UploadCV.this, "User ID: " + userId + "\nEmail: " + email, Toast.LENGTH_SHORT).show();
//                } else {
//                    // User is signed out
//                    Toast.makeText(UploadCV.this, "User not logged in", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        // Get username using Intent
        username = getIntent().getStringExtra("USERNAME"); //TODO: get Intent
        activityKey = getIntent().getStringExtra("ACTIVITY_KEY");
        organizerName = getIntent().getStringExtra("ORGANIZER_NAME");

        // Back Button
//        ImageButton btnBack = findViewById(R.id.BtnBackUploadCV);
//        btnBack.setOnClickListener(v -> {
//            //finish(); // Close the current activity (UploadCV)
//            startActivity(new Intent(UploadCV.this, VolunteerPostUser.class));
//        });

        // Select and Upload CV
        storageReference = FirebaseStorage.getInstance().getReference("cv_file/");
        databaseReference = FirebaseDatabase.getInstance().getReference("Application");
        btnUploadCV = findViewById(R.id.BtnUploadCV);
        btnSubmit = findViewById(R.id.BtnSubmitCV);
        btnBack = findViewById(R.id.BtnBackUploadCV);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(UploadCV.this, VolunteerPostUser.class);
//                intent.putExtra("ACTIVITY_KEY", activityKey);
//                intent.putExtra("USERNAME", username); //TODO: Pass username & activityKey back to Volunteer Post page
//                intent.putExtra("ORGANIZER_NAME",organizerName);
//                startActivity(intent);
                finish();
            }
        });
        btnUploadCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityResultLauncher.launch(new Intent(Intent.ACTION_GET_CONTENT).setType("application/pdf"));
            }
        });

        // if haven't uploaded CV and click submit button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UploadCV.this,"Please select a PDF File",Toast.LENGTH_LONG).show();
            }
        });

    }

    // Select PDF
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK) {
            Intent data = result.getData();
            if (data != null && data.getData() != null) {

                // Generate a unique name using the current timestamp
                fileName = "upload_CV_" + System.currentTimeMillis() + ".pdf";

                btnUploadCV.setText(fileName);
                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Upload PDF
                        uploadPDFFileFirebase(data.getData());
                    }
                });
            }
        }
    });


    // Upload PDF
    private void uploadPDFFileFirebase(Uri data){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("File is loading...");
        progressDialog.show();

        StorageReference reference = storageReference.child(fileName);

        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete());
                        Uri uri= uriTask.getResult();

                        String pdfName = fileName;
                        String status = "Pending";

                        // Put value into UploadCVHelper
                        UploadCVHelper UploadCVHelper = new UploadCVHelper(activityKey, status, pdfName, uri.toString(), username);
                        databaseReference.child(username).child(databaseReference.push().getKey()).setValue(UploadCVHelper);
                        Toast.makeText(UploadCV.this, "File Uploaded", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

//                        Intent intent = new Intent(UploadCV.this, VolunteerPostUser.class);
//                        intent.putExtra("ACTIVITY_KEY", activityKey);
//                        intent.putExtra("USERNAME", username); //Pass username & activityKey back to Volunteer Post page
//                        intent.putExtra("ORGANIZER_NAME",organizerName);
//                        intent.putExtra("finishUpload","true");
//                        startActivity(intent);

//                        finish();
//                        startActivity(getIntent());

                        finish();
                        Toast.makeText(UploadCV.this, "Applied successfully", Toast.LENGTH_LONG).show();

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progress = (100.0 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();
                        progressDialog.setMessage("File Uploading: " + (int) progress + "%");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UploadCV.this, "Unable to Upload File", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();

//                        Intent intent = new Intent(UploadCV.this, VolunteerPostUser.class);
//                        intent.putExtra("ACTIVITY_KEY", activityKey);
//                        intent.putExtra("USERNAME", username);
//                        intent.putExtra("ORGANIZER_NAME",organizerName);
//                        startActivity(intent);
                        finish();
                    }
                });
    }

}
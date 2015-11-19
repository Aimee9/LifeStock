package com.epicodus.lifestock.ui;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.lifestock.R;
import com.epicodus.lifestock.adapters.ListAdapter;
import com.epicodus.lifestock.model.Siting;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ParseQuery;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewSitingActivity extends AppCompatActivity {

    private static final String TAG = NewSitingActivity.class.getSimpleName();
    public static final int REQUEST_IMAGE_CAPTURE = 0;
    public static final int PICK_PHOTO_REQUEST = 23;


    private DialogInterface.OnClickListener mDialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch(which) {
                case 0:
                    Intent capturePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if (capturePic.resolveActivity(getPackageManager()) != null) {
                            File photoFile = null;
                            try {
                                photoFile = createImageFile();
                            } catch (IOException e) {
                                Log.d(TAG, e.toString());
                            }
                            if (photoFile != null) {
                                capturePic.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                                startActivityForResult(capturePic, REQUEST_IMAGE_CAPTURE);
                            }
                        }
                    break;
                case 1:
                    Intent choosePhoto = new Intent(Intent.ACTION_GET_CONTENT);
                    choosePhoto.setType("image/*");
                    startActivityForResult(choosePhoto, PICK_PHOTO_REQUEST);
            }
        }
    };




    @Bind(R.id.speciesLabel) EditText mSpecies;
    @Bind(R.id.locationLabel) EditText mLocation;
    @Bind(R.id.notesLabel) EditText mNotes;
    @Bind(R.id.submitButton) Button mSubmitButton;
    @Bind(R.id.imageButton) Button mImageButton;
    @Bind(R.id.animalPhoto)ImageView mAnimalPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_siting);
        ButterKnife.bind(this);

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NewSitingActivity.this);
                builder.setItems(R.array.photo_options, mDialogListener);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ParseObject newListing = new ParseObject("NewListing");
                String species = mSpecies.getText().toString();
                String location = mLocation.getText().toString();
                String notes = mNotes.getText().toString();
                newListing.put("species", species);
                newListing.put("location", location);
                newListing.put("notes", notes);
                newListing.saveInBackground();

                Intent intent = new Intent(NewSitingActivity.this, SitingsListActivity.class);
                startActivity(intent);

            }
        });
    }

    String mCurrentPhotoPath;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == REQUEST_IMAGE_CAPTURE || requestCode == PICK_PHOTO_REQUEST )&& resultCode == RESULT_OK ) {
            Bitmap myBitmap = BitmapFactory.decodeFile(mCurrentPhotoPath);
            ImageView myPhoto = (ImageView) findViewById(R.id.animalPhoto);
            myPhoto.setImageBitmap(myBitmap);
        }
    }

    private File createImageFile() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd=HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timestamp;
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );
        mCurrentPhotoPath = "//" + image.getAbsolutePath();
        return image;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int itemId = item.getItemId();
//
//        if (itemId == R.id.action_logout) {
//            ParseUser.logOut();
//            Intent intent = new Intent(NewSitingActivity.this, MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//        }
//        return super.onOptionsItemSelected(item);
//    }
}


package my.edu.tarc.student.lab33;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment
{
    private static final int REQUEST_PHOTO = 1;
    private ImageView imageViewPhoto;

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);

        Button buttonGetPhoto = (Button) v.findViewById(R.id.buttonGetPhoto);
        imageViewPhoto = (ImageView) v.findViewById(R.id.imageViewPhoto);

        buttonGetPhoto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_PHOTO);
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == REQUEST_PHOTO && resultCode == RESULT_OK)
        {
            Uri uri = null;

            if (data != null)
            {
                uri = data.getData();
                imageViewPhoto.setImageURI(uri);
            }
        }
    }
}

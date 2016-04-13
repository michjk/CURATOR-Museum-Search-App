package com.cz2006.curator.Crawler;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.Places;

/**
 * Created by Acceleration on 10/04/2016.
 */
public class PhotoCrawler extends AsyncTask<String, Void, Bitmap> {

    GoogleApiClient mGoogleApiClient;


    public PhotoCrawler(GoogleApiClient mGoogleApiClient) {
        this.mGoogleApiClient = mGoogleApiClient;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        if(params.length != 1) {
            return null;
        }

        final String placeId = params[0];
        Bitmap photoBitmap = null;

        PlacePhotoMetadataResult result = Places.GeoDataApi.getPlacePhotos(mGoogleApiClient, placeId).await();

        if(result.getStatus().isSuccess()) {
            PlacePhotoMetadataBuffer photoMetadataBuffer = result.getPhotoMetadata();
            if(photoMetadataBuffer.getCount() > 0 && !isCancelled()) {
                PlacePhotoMetadata photo = photoMetadataBuffer.get(0);
                photoBitmap = photo.getPhoto(mGoogleApiClient).await().getBitmap();
            }
            photoMetadataBuffer.release();
        }

        return photoBitmap;
    }

}

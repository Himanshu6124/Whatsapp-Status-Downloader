package com.himanshu.downloadstatus;

import android.net.Uri;

public class ModelClass {
    String path,filename;
    Uri uri;        //to hold image icon

    public ModelClass(String path, String filename, Uri uri) {
        this.path = path;
        this.filename = filename;
        this.uri = uri;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public ModelClass() {
    }
}

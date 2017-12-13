package com.jonzhou.nytime.update.model.impl;

import android.text.TextUtils;


import com.jonzhou.nytime.update.model.base.DownloadWorker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class DefaultDownloadWorker extends DownloadWorker {
    private HttpURLConnection urlConn;

    @Override
    protected void download(String url, File target) throws Exception {
        URL httpUrl = new URL(url);
        urlConn = (HttpURLConnection) httpUrl.openConnection();
        setDefaultProperties();
        urlConn.connect();
        int responseCode = urlConn.getResponseCode();
        if (responseCode < 200 || responseCode >= 300) {
            urlConn.disconnect();
            throw new HttpException(responseCode, urlConn.getResponseMessage());
        }
        long contentLength = urlConn.getContentLength();
//        if (checkIsDownAll())
        RandomAccessFile raf = supportBreakpointDownlaod(target, httpUrl, url);
//        if (contentLength>0){
        long offset = target.exists() ? (int) target.length() : 0;
        InputStream inputStream = urlConn.getInputStream();
        byte[] buffer = new byte[8 * 1024];
        int length;
        long start = System.currentTimeMillis();
        while ((length = inputStream.read(buffer)) != -1) {
            raf.write(buffer, 0, length);
            offset += length;
            long end = System.currentTimeMillis();
            if (end - start > 1000) {
//                senDownloadProcess()
            }
        }
        urlConn.disconnect();
        raf.close();
        urlConn = null;
        // notify download completed
//       send

    }

    private RandomAccessFile supportBreakpointDownlaod(File target, URL httpUrl, String url) throws IOException {
        String range = urlConn.getHeaderField("Accept-Ranges");
        if (TextUtils.isEmpty(range) || !range.startsWith("bytes")) {
            target.delete();
            return new RandomAccessFile(target, "rw");
        }

        long length = target.length();
        long contentLength = Long.parseLong(urlConn.getHeaderField("Content-Length"));
        urlConn.disconnect();
        urlConn = (HttpURLConnection) httpUrl.openConnection();
        urlConn.setRequestProperty("RANGE", "bytes=" + length + "-" + contentLength);
        setDefaultProperties();
        urlConn.connect();
        int responseCode = urlConn.getResponseCode();
        if (responseCode < 200 || responseCode >= 300) {
            throw new HttpException(responseCode, urlConn.getResponseMessage());
        }
        RandomAccessFile raf = new RandomAccessFile(target, "rw");
        raf.seek(length);
        return raf;
    }

    private void setDefaultProperties() throws IOException {
        urlConn.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
        urlConn.setRequestMethod("GET");
        urlConn.setConnectTimeout(10000);
    }
}

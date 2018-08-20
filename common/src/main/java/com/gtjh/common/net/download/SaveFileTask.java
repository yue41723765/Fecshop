package com.gtjh.common.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;


import com.gtjh.common.app.ProjectInit;
import com.gtjh.common.util.file.FileUtil;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

/**
 * Created by jett on 2018/6/6.
 */

public class SaveFileTask extends AsyncTask<Object,Void,File>{

    @Override
    protected File doInBackground(Object... params) {
        String downloadDir=(String)params[0];
        String extension=(String)params[1];
        ResponseBody body=(ResponseBody)params[2];
        String name=(String)params[3];
        InputStream is=body.byteStream();
        if(downloadDir==null || downloadDir.equals("")){
            downloadDir="down_loads";
        }
        if(extension==null){
            extension="";
        }
        if(name==null){
            return FileUtil.writeToDisk(is,downloadDir,extension.toUpperCase(),extension);
        }else{
            return FileUtil.writeToDisk(is,downloadDir,name);
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    //如果文件已经下完了
    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);


        //下到了APK直接安装
        autoInstallApk(file);
    }

    private void autoInstallApk(File file) {
        if(FileUtil.getExtension(file.getPath()).equals("apk")){
            final Intent install=new Intent();
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
            ProjectInit.getApplicationContext().startActivity(install);
        }
    }
}

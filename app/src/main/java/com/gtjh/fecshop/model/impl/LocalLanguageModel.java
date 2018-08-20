package com.gtjh.fecshop.model.impl;

import android.content.res.AssetManager;

import com.gtjh.common.GTJHApplication;
import com.gtjh.common.entity.Language;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.RYLog;
import com.gtjh.common.util.file.FileUtil;
import com.gtjh.fecshop.model.ILanguageModel;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by android on 2018/7/4.
 */

public class LocalLanguageModel implements ILanguageModel {
    @Override
    public void loadLanguageData(int tag) {

        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                try {
                    InputStream open = GTJHApplication.getApplication().getAssets().open("language.xml", AssetManager.ACCESS_STREAMING);
                    String streamString = FileUtil.getStreamString(open);
                    //创建xStream对象
                    XStream xstream = new XStream();
                    //将别名与xml名字相对应
                    xstream.alias("entry", HashMap.class);
                    xstream.alias("languageInfo", Language.languageInfo.class);
                    HashMap<String, Language.languageInfo> languageMap = (HashMap<String, Language.languageInfo>) xstream.fromXML(streamString);
                    return Observable.just(languageMap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }, tag);

    }
}

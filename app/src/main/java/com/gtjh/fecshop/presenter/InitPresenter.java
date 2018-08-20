package com.gtjh.fecshop.presenter;

import com.google.gson.internal.LinkedTreeMap;
import com.gtjh.common.GTJHApplication;
import com.gtjh.common.entity.Language;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.GsonUtils;
import com.gtjh.common.util.RYLog;
import com.gtjh.common.view.IBaseView;
import com.gtjh.fecshop.model.ILanguageModel;
import com.gtjh.fecshop.model.impl.LocalLanguageModel;
import com.gtjh.fecshop.model.impl.NetLanguageModel;
import com.thoughtworks.xstream.XStream;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by android on 2018/7/3.
 */

public class InitPresenter extends BasePresenter implements IWelcomePresenter {
    private ILanguageModel model;

    public InitPresenter(IBaseView view) {
        super(view);
        model = new LocalLanguageModel();
    }


    @Override
    public void initLanguage(int tag) {
        model.loadLanguageData(tag);
    }

    @RegisterRxBus(Contans.Tag.INIT_LANGUAGE)
    private void languageResult(HashMap<String, Language.languageInfo> language, int tag) {
        getView().showSuccess(language, tag);
    }

}

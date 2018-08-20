package com.gtjh.common.util.language;

import com.gtjh.common.entity.Language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by android on 2018/7/6.
 */

public class LanguageManage {
    private static final LanguageManage ourInstance = new LanguageManage();
    private final Map<String, Language.languageInfo> languageMap = new HashMap<>();

    public static LanguageManage getInstance() {
        return ourInstance;
    }

    private LanguageManage() {
    }

    public void addLanguage(Map<String, Language.languageInfo> language) {
        languageMap.putAll(language);
    }

    public Language.languageInfo getLanguageByCode(String code) {
        return languageMap.get(code);
    }

    public List<String> getAllCode() {
        return new ArrayList<>(languageMap.keySet());
    }
}

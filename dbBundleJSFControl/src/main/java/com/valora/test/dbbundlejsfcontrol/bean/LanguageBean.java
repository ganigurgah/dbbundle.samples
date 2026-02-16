package com.valora.test.dbbundlejsfcontrol.bean;

import com.valora.dbbundle.service.DbBundleService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Locale;

@Component
@Named("languageBean")
@SessionScoped
public class LanguageBean implements Serializable {

    @Autowired
    private DbBundleService dbBundleService;

    private String selectedLocale = "tr";

    public void changeLocale(String localeCode){
        dbBundleService.changeLocale(localeCode);
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(new Locale(localeCode));

        this.selectedLocale = localeCode;
    }

    public String getSelectedLocale() {
        return selectedLocale;
    }

    public void setSelectedLocale(String selectedLocale) {
        this.selectedLocale = selectedLocale;
    }

    public String getCurrentLocale() {
        return dbBundleService.getCurrentLocale().getLanguage();
    }
}

package com.valora.test.dbbundlecontrol.endpoint;

import com.valora.dbbundle.annotation.ValoraBundle;
import com.valora.dbbundle.service.DbBundleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api")
public class MessageController {

    @ValoraBundle
    private ResourceBundle bundle;

    @Autowired
    private DbBundleService dbBundleService;

    @GetMapping("message/{key}")
    public String getMessage(@PathVariable String key) {
        return dbBundleService.getMessage(key);
    }

    @GetMapping("message/{key}/{localeCode}")
    public String getMessage(@PathVariable String key, @PathVariable String localeCode) {
        Locale locale = Locale.forLanguageTag(localeCode);
        return dbBundleService.getMessage(key, locale);
    }

    @GetMapping("locale/{code}")
    public ResponseEntity<String> changeLocale(@PathVariable String code) {
        dbBundleService.changeLocale(code);
        return ResponseEntity.ok("Locale changed to: " + code);
    }

    @GetMapping("cache/stats")
    public String getCacheStats() {
        return dbBundleService.getCacheStats();
    }
}

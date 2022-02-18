package edu.umd.enpm614.sample.service;

import edu.umd.enpm614.sample.AppConfig;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

@Component
public class PlaceholderService {
    private Database db;
    public PlaceholderService() {
        db = new OracleDatabase();
        doSomeWork();
    }

    @Inject
    public PlaceholderService(@Named(AppConfig.INJECT_OPEN_DB) Database db) {
        this.db = db;
        System.out.println("From inside placeholder service " + db);
        doSomeWork();
    }

    @Inject
    public void setDb(@Named(AppConfig.INJECT_OPEN_DB) Database db) {
        this.db = db;
    }

    public boolean doSomeWork() {
        try {
            Thread.sleep(50l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}

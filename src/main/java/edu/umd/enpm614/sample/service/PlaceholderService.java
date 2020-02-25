package edu.umd.enpm614.sample.service;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class PlaceholderService {
    private final Database db;
    public PlaceholderService() {
        db = new OracleDatabase();
        doSomeWork();
    }

    @Inject
    public PlaceholderService(Database db) {
        this.db = db;
        System.out.println("From inside placeholder service " + db);
        doSomeWork();
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

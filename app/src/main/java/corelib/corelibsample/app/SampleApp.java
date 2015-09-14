package corelib.corelibsample.app;

import android.app.Application;
import com.michael.corelib.config.CoreConfig;
import corelib.corelibsample.config.Config;

/**
 * Created by michael on 15/9/14.
 */
public class SampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CoreConfig.init(getApplicationContext(), Config.DEBUG);
    }

}

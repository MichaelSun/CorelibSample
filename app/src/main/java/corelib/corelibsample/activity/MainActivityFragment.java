package corelib.corelibsample.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.michael.corelib.config.CoreConfig;
import com.michael.corelib.internet.InternetClient;
import com.michael.corelib.internet.core.NetworkResponse;
import com.michael.corelib.internet.core.RequestBase;
import corelib.corelibsample.R;
import corelib.corelibsample.api.BaiduWebRequest;
import corelib.corelibsample.api.EmptyHostRequest;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private boolean debug = true;

    public MainActivityFragment() {
    }

    @Bind(R.id.version)
    TextView version;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);

        version.setText(String.format("V %s", CoreConfig.VERSION.SDK_VERSION));

        return view;
    }

    @OnClick(R.id.debug_switch)
    public void debug_switch() {
        if (debug) {
            debug = false;
        } else {
            debug = true;
        }

        CoreConfig.init(getActivity().getApplicationContext(), debug);
    }

    @OnClick(R.id.api_fetch_baidu)
    public void api_fetch_baidu() {
        InternetClient.getInstance(getContext()).postRequest(new BaiduWebRequest(), new InternetClient.NetworkCallback<String>() {
            @Override
            public void onSuccess(RequestBase<String> request, String ret) {
                CoreConfig.LOGD("[[MainActivityFragment::api_fetch_baidu::onSuccess]] ret = " + ret);
            }

            @Override
            public void onFailed(RequestBase<String> request, NetworkResponse httpResponseCode) {
                CoreConfig.LOGD("[[MainActivityFragment::api_fetch_baidu::onFailed]] httpResponseCode = " + httpResponseCode);
            }
        });
    }

    @OnClick(R.id.custom_http_params)
    public void custom_http_params() {
        BaiduWebRequest baiduWebRequest = new BaiduWebRequest();
        RequestBase.CustomHttpParams customHttpParams = new RequestBase.CustomHttpParams();
        customHttpParams.so_timeout = 3 * 1000;
        customHttpParams.connection_timeout = 3 * 1000;
        customHttpParams.buffer_size = 8 * 1024;
        baiduWebRequest.setCustomHttpParams(customHttpParams);
        InternetClient.getInstance(getContext()).postRequest(baiduWebRequest, new InternetClient.NetworkCallback<String>() {
            @Override
            public void onSuccess(RequestBase<String> request, String ret) {
                CoreConfig.LOGD("[[MainActivityFragment::custom_http_params::onSuccess]] ret = " + ret);
            }

            @Override
            public void onFailed(RequestBase<String> request, NetworkResponse httpResponseCode) {
                CoreConfig.LOGD("[[MainActivityFragment::custom_http_params::onFailed]] httpResponseCode = " + httpResponseCode);
            }
        });
    }

    @OnClick(R.id.empty_host_test)
    public void empty_host_test() {
        InternetClient.getInstance(getContext()).postRequest(new EmptyHostRequest(), new InternetClient.NetworkCallback<String>() {
            @Override
            public void onSuccess(RequestBase<String> request, String ret) {
                CoreConfig.LOGD("[[MainActivityFragment::empty_host_test::onSuccess]] ret = " + ret);
            }

            @Override
            public void onFailed(RequestBase<String> request, NetworkResponse httpResponseCode) {
                CoreConfig.LOGD("[[MainActivityFragment::empty_host_test::onFailed]] httpResponseCode = " + httpResponseCode);
            }
        });
    }

}

package corelib.corelibsample.api;

import com.michael.corelib.internet.core.RequestBase;
import com.michael.corelib.internet.core.annotations.HttpMethod;
import com.michael.corelib.internet.core.annotations.RestMethodUrl;

/**
 * Created by michael on 15/9/14.
 */

@RestMethodUrl("http://www.baidu.com")
@HttpMethod("GET")
public class BaiduWebRequest extends RequestBase<String> {
}

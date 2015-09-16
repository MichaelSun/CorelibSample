package corelib.corelibsample.api;

import com.michael.corelib.internet.core.RequestBase;
import com.michael.corelib.internet.core.annotations.HttpMethod;
import com.michael.corelib.internet.core.annotations.RestMethodUrl;

/**
 * Created by michael on 15/9/16.
 */

@RestMethodUrl("")
@HttpMethod("GET")
public class EmptyHostRequest extends RequestBase<String> {
}

package util;

import java.util.Random;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.request.AlibabaAliqinFcTtsNumSinglecallRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.taobao.api.response.AlibabaAliqinFcTtsNumSinglecallResponse;

public class send {
public int send(String phonenumber) throws ApiException{
	TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest","23321388","9df2f1dbc62250fdef5c1adbfc7d0180");
	AlibabaAliqinFcTtsNumSinglecallRequest req = new AlibabaAliqinFcTtsNumSinglecallRequest();
	req.setExtend("12345");
	int code = new Random().nextInt(99999);String product="钟科租房";
	String uString="{'product':'"+product+"','code':'"+code+"'}";
	System.out.println(uString);
	req.setTtsParamString(uString);
	req.setCalledNum(phonenumber);
	req.setCalledShowNum("4008823220");
	req.setTtsCode("TTS_5475065");
	AlibabaAliqinFcTtsNumSinglecallResponse rsp = client.execute(req);
	System.out.println(rsp.getBody());
	return code;
}
}

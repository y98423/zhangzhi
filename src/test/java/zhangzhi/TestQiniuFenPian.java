package zhangzhi;

import java.io.File;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.resumableio.ResumeableIoApi;
import com.qiniu.api.rs.PutPolicy;

public class TestQiniuFenPian {

	public static void main(String[] args) throws AuthException, JSONException {

		Config.ACCESS_KEY = "vVRQb0jLFGB6uQoP19hQKNGv4ArYFT_tYOGPTf5A";
		Config.SECRET_KEY = "mAAT8VCbUAgEXxZKeIc-UwEH9-MD2M4hNN4ty8Na";
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		// 请确保该bucket已经存在
		String bucketName = "fjsaf";
		PutPolicy p = new PutPolicy(bucketName);
		p.returnBody = "{\"key\": $(key), \"hash\": $(etag),\"mimeType\": $(mimeType)}";
		String uptoken = p.token(mac);
		File file = new File("E:/upload/apache-cassandra-2.1.2-bin.tar.gz");
		long begin = System.currentTimeMillis();
		PutRet ret = ResumeableIoApi.put(file, uptoken, null, null);
		System.out.println("响应：" + ret.getResponse() + "," + "code:"
				+ ret.getStatusCode());
		System.out.println("耗时：" + (System.currentTimeMillis() - begin) + "毫秒");
		
	}
}

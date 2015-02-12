package zhangzhi;

import net.sf.json.JSONException;

import org.apache.commons.codec.EncoderException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;

public class TestQiNiu {

	public void test() {
	}

	public static void main(String[] args) throws EncoderException,
			AuthException, org.json.JSONException {
		Config.ACCESS_KEY = "vVRQb0jLFGB6uQoP19hQKNGv4ArYFT_tYOGPTf5A";
		Config.SECRET_KEY = "mAAT8VCbUAgEXxZKeIc-UwEH9-MD2M4hNN4ty8Na";
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		// 请确保该bucket已经存在
		String bucketName = "fjsaf";
		PutPolicy putPolicy = new PutPolicy(bucketName);
		try {
			long begin = System.currentTimeMillis();
			String uptoken = putPolicy.token(mac);
			PutExtra extra = new PutExtra();
	        String key = "apache-cassandra-2.2.2-bin.tar.gz";
	        String localFile = "E:/upload/apache-cassandra-2.1.2-bin.tar.gz";
	        PutRet ret = IoApi.putFile(uptoken, key, localFile, extra);
	        System.out.println(ret.getResponse());
	        System.out.println(ret.getStatusCode());
	        System.out.println("耗时："+(System.currentTimeMillis()-begin)+"毫秒");
		} catch (AuthException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}

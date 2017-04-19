package cn.itcast.mobilesafe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewLoadHtml extends Activity {
	private String url;
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//将屏幕设置为全屏
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//去掉标题栏
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.map_webview);
		webView = (WebView)findViewById(R.id.map_webview);
		url = "file:///android_asset/mcontactus.html";
		loadLocalHtml(url);
	}

	@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
	public void loadLocalHtml(String url){
		WebSettings ws = webView.getSettings();
		ws.setJavaScriptEnabled(true);//开启JavaScript支持
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				//重写此方法，用于捕捉页面上的跳转链接
				if ("http://start/".equals(url)){
					//在html代码中的按钮跳转地址需要同此地址一致
					Toast.makeText(getApplicationContext(), "开始体验", Toast.LENGTH_SHORT).show();
					finish();
				}
				return true;
			}
		});
		webView.loadUrl(url);
	}
}
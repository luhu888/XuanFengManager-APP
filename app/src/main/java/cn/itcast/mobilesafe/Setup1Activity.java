package cn.itcast.mobilesafe;


public class Setup1Activity extends BaseSetupActivity {

	@Override
	public void findView() {
		setContentView(R.layout.activity_setup1);
	}

	@Override
	public void setupView() {
		
	}

	@Override
	public void showNext() {
		openActivity(Setup2Activity.class);
		overridePendingTransition(R.anim.tran_shownext_in, R.anim.tran_shownext_out);
	}

	@Override
	public void showPre() {
		
	}

}

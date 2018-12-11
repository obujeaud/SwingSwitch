package factor;

import conf.Config;
import service.IService;

public class MyFactory {
	private static MyFactory m = null;
	private IService s;

	private MyFactory() throws Exception {
	}

	public static MyFactory getInstance() throws Exception {
		if (m == null) {
			m = new MyFactory();
		}
		return m;
	}

	public IService getService() throws Exception {
		String choice = Config.getInstance().getChoice();
		s = (IService) Class.forName(choice).newInstance();
		return s;
	}
}

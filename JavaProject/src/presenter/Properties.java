package presenter;

import java.io.Serializable;

public class Properties implements Serializable {

	int numberOfThread;
	
	public Properties(){
		numberOfThread = 3;
	}

	/**
	 * @return the numberOfThread
	 */
	public int getNumberOfThread() {
		return numberOfThread;
	}

	/**
	 * @param numberOfThread the numberOfThread to set
	 */
	public void setNumberOfThread(int numberOfThread) {
		this.numberOfThread = numberOfThread;
	}
	
	
	
}

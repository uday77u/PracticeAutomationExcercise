package BaseTest;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Listner--"+result.getMethod().getMethodName()+" is started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Listner--"+result.getMethod().getMethodName()+" is success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Listner--"+result.getMethod().getMethodName()+" is failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Listner--"+result.getMethod().getMethodName()+" is skipped");
	}
	

}

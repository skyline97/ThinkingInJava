package concurrent_;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex11 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exe = Executors.newCachedThreadPool();
		Student s = new Student();
		for(int i=0;i<10;i++) {
			exe.execute(new MyCallable(s));
		}
		exe.shutdown();
	}
}

class MyCallable implements Runnable {
	
	private Student s;
	
	public MyCallable(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		System.out.println("语文成绩是" + s.getChinese());
		System.out.println("数学成绩是" + s.getMath());
		System.out.println("总分是" + s.add());
	}
	
}

class Student {
	private int chinese;
	private int math;
	
	public int add() {
		chinese++;
		Thread.yield();
		math++;
		return chinese + math;
	}
	
	public int getChinese() {
		return chinese;
	}
	
	public int getMath() {
		return math;
	}
}

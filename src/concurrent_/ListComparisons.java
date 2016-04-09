package concurrent_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import deepInContainer.CountingIntegerList;

public class ListComparisons {
	public static void main(String[] args) {
		Tester.initMain(args);
		new SynchronizedArrayListTest(10, 0);
		new SynchronizedArrayListTest(9, 1);
		new SynchronizedArrayListTest(5, 5);
		
		new CopyOnWriteArrayListTest(10, 0);
		new CopyOnWriteArrayListTest(9, 1);
		new CopyOnWriteArrayListTest(5, 5);
		
		Tester.exe.shutdown();
	}
}

abstract class ListTest extends Tester<List<Integer>> {
	ListTest(String testId,int nReaders,int nWriters) {
		super(testId, nReaders, nWriters);
	}
	
	class Reader extends TestTask {
		long result = 0;
		
		void test() {
			for(long i=0;i<testCycles;i++)
				for(int index=0;index<containerSize;index++)
					result += testContainer.get(index);
		}
		
		void putResults() {
			readResult += result;
			readTime += duration;
		}
	}
	
	class Writer extends TestTask {
		@Override
		void test() {
			for(long i=0;i<testCycles;i++)
				for(int index=0;index<containerSize;index++)
					testContainer.set(index, writeData[index]);
		}
		
		@Override
		void putResults() {
			writeTime += duration;
		}
		
	}
	
	@Override
	void startReadersAndWriters() {
		for(int i=0;i<nReaders;i++)
			exe.execute(new Reader());
		for(int i=0;i<nWriters;i++)
			exe.execute(new Writer());
	}
}


class SynchronizedArrayListTest extends ListTest {
	
	@Override
	List<Integer> containerInitializer() {
		return Collections.synchronizedList(new ArrayList<Integer>(
				new CountingIntegerList(containerSize)));
	}
	
	SynchronizedArrayListTest(int nReaders,int nWriters) {
		super("Synched ArrayList", nReaders, nWriters);
	}
}

class CopyOnWriteArrayListTest extends ListTest {
	@Override
	List<Integer> containerInitializer() {
		return new CopyOnWriteArrayList<Integer>(
				new CountingIntegerList(containerSize));
	}
	
	CopyOnWriteArrayListTest(int nReaders,int nWriters) {
		super("CopyOnWriteArrayList", nReaders, nWriters);
	}
}
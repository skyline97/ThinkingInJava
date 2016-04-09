package deepInContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import array.CountingGenerator;
import generic.Generator;

public class StringListPerformance {

	static Random ran = new Random();
	static int reps = 1000;
	static List<Test<List<String>>> tests = new ArrayList<Test<List<String>>>();
	static List<Test<LinkedList<String>>> qTests = new ArrayList<Test<LinkedList<String>>>();
	static List<Test<List<String>>> sortTests = new ArrayList<Test<List<String>>>();
	
	static Generator<String> gen = new CountingGenerator.String();
	
	static {
		tests.add(new Test<List<String>>("add") {
			@Override
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops;
				int listSize = tp.size;
				for(int i=0;i<loops;i++) {
					list.clear();
					for(int j=0;j<listSize;j++) {
						list.add(gen.next());
					}
				}
				return loops * listSize;
			}
		});
		
		tests.add(new Test<List<String>>("get") {
			@Override
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops;
				int listSize = list.size();
				for(int i=0;i<loops;i++) {
					list.get(ran.nextInt(listSize));
				}
				return loops;
			}
		});
		
		tests.add(new Test<List<String>>("set") {
			@Override
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				for(int i=0;i<loops;i++) {
					list.set(ran.nextInt(listSize), gen.next());
				}
				return loops;
			}
		});
		
		tests.add(new Test<List<String>>("iteradd") {
			@Override
			int test(List<String> list, TestParam tp) {
				final int LOOPS = 1000000;
				int half = list.size() / 2;
				ListIterator<String> it = list.listIterator(half);
				for(int i=0;i<LOOPS;i++) {
					it.add(gen.next());
				}
				return LOOPS;
			}
		});
		
		tests.add(new Test<List<String>>("insert") {
			@Override
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops;
				for(int i=0;i<loops;i++) {
					list.add(5,gen.next());
				}
				return loops;
			}
		});
		
		tests.add(new Test<List<String>>("remove") {
			@Override
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i=0;i<loops;i++) {
					list.clear();
					list.addAll(new CountingStringList(size));
					while(list.size() > 5) 
						list.remove(5);
				}
				return loops * size;
			}
		});
		
		qTests.add(new Test<LinkedList<String>>("addFirst") {
			@Override
			int test(LinkedList<String> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i=0;i<loops;i++) {
					list.clear();
					for(int j=0;j<size;j++) {
						list.addFirst(gen.next());
					}
				}
				return loops * size;
			}
		});
		
		qTests.add(new Test<LinkedList<String>>("addLast") {
			@Override
			int test(LinkedList<String> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i=0;i<loops;i++) {
					list.clear();
					for(int j=0;j<size;j++) {
						list.addLast(gen.next());
					}
				}
				return loops * size;
			}
		});
		
		qTests.add(new Test<LinkedList<String>>("rmFirst") {
			@Override
			int test(LinkedList<String> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i=0;i<loops;i++) {
					list.clear();
					list.addAll(new CountingStringList(size));
					while(list.size() > 0) 
						list.removeFirst();
				}
				return loops * size;
			}
		});
		
		qTests.add(new Test<LinkedList<String>>("rmLast") {
			@Override
			int test(LinkedList<String> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i=0;i<loops;i++) {
					list.clear();
					list.addAll(new CountingStringList(size));
					while(list.size() > 0) 
						list.removeLast();
				}
				return loops * size;
			}
		});
		
		sortTests.add(new Test<List<String>>("sort") {
			@Override
			int test(List<String> list, TestParam tp) {
				int loops = tp.loops;
				for(int i=0;i<loops;i++) {
					Collections.shuffle(list);
					Collections.sort(list);
				}
				return loops;
			}
		});
	}
	
	static class StringListTester extends Tester<List<String>> {
		
		public StringListTester(List<String> container,List<Test<List<String>>> tests) {
			super(container,tests);
		}
		
		@Override
		protected List<String> initialize(int size) {
			container.clear();
			container.addAll(new CountingStringList(size));
			return container;
		}
	}
	
	public static void main(String[] args) {
		if(args.length > 0) 
			Tester.defaultParams = TestParam.array(args);
		
//		Tester<List<String>> arrayTest = new Tester<List<String>>(null, tests.subList(1, 3)) {
//			@Override
//			protected List<String> initialize(int size) {
//				String[] ia = Generated.array(String.class, new CountingGenerator.String(), size);
//				return Arrays.asList(ia);
//			}
//		};
		
//		arrayTest.setHeadline("Array as List");
//		arrayTest.timedTest();
		
//		Tester.defaultParams = TestParam.array(10,5000,100,5000,1000,1000,10000,200);
//		
//		if(args.length > 0) 
//			Tester.defaultParams = TestParam.array(args);
//		
//		StringListTester.run(new ArrayList<String>(), tests);
//		StringListTester.run(new LinkedList<String>(), tests);
//		StringListTester.run(new Vector<String>(), tests);
		
		StringListTester.run(new ArrayList<String>(), sortTests);
		StringListTester.run(new LinkedList<String>(), sortTests);
		
//		Tester.fieldWidth = 12;
//		Tester<LinkedList<String>> qTest = new Tester<LinkedList<String>>(
//				new LinkedList<String>(), qTests);
//		qTest.setHeadline("Queue tests");
//		qTest.timedTest();
		
		
	}
}

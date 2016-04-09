package containObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class TestPriority {

	public static void main(String[] args) {
		Queue<Integer> nums = new PriorityQueue<Integer>(10,Collections.reverseOrder());
		Random ran = new Random(47);
		for(int i=0;i<15;i++) {
			nums.offer(ran.nextInt(i + 10));
		}
		printQ(nums);
		
		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split(" "));
		Queue<String> q = new PriorityQueue<String>(strings);
		printQ(q);
		
		q = new PriorityQueue<String>(strings.size(),Collections.reverseOrder());
		q.addAll(strings);
		printQ(q);
		
		Set<Character> s = new HashSet<Character>();
		for(char c:fact.toCharArray()) {
			s.add(c);
		}
		Queue<Character> queue = new PriorityQueue<Character>(s);
		printQ(queue);
	}
	
	public static <T> void printQ(Queue<T> queue) {
		while(queue.peek() != null) {
			System.out.print(queue.poll() + "  ");
		}
		System.out.println();
	}
}

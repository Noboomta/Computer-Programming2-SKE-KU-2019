import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Some utility methods for lists.
 * 
 * <T> is a type parameter of a static method. When you call the method, Java
 * automatically determines the value of T from the parameter used to all the
 * method, so you don't need to specify a type when invoking the method. Just
 * invoke it like an ordinary static method:
 * 
 * <pre>
 * List<String> fruit = new ArrayList<>();
 * fruit.addAll( ... );
 * 
 * List<String> result = ListUtil.unique(fruit);
 * </pre>
 * 
 * @author NoBoomTa.
 * 
 */

public class ListUtil {

	/**
	 * Return a list containing the first unique occurrence of elements in the
	 * parameter list. Does not modify the parameter. For example, if list = { a, b,
	 * b, b, c, b, c, c} then unique(list) will return {a, b, c}.
	 * 
	 * Objects in the list are compared using their own equals method.
	 * 
	 * @param list<T> is a list of any kind of object. The elements are not null.
	 * @return a new list containing first unique occurrence of elements in list
	 */
	public static <T> List<T> unique(List<T> list) {
		if (list.size() == 1) {
			return list;
		}
		return helpIndex(0, list);
	}

	public static <T> List<T> helpIndex(int index, List<T> list) {
		if (list.size() == index) {
			return list;
		}
		List<T> copy = new ArrayList<>(list);
		T front = list.get(index);
		List<T> last = copy.subList(index + 1, copy.size());
		if (last.contains(front)) {
			copy.remove(front);
		} else {
			index++;
		}
		return helpIndex(index, copy);
	}

	/**
	 * Flatten a list containing nested lists into a single list containing all the
	 * elements of the nested lists.
	 * 
	 * For Example: list = { a, {b,c}, {d,e,{f,g}} } flatten(list) returns {a, b, c,
	 * d, e, f, g}
	 * 
	 * list = {a, b, c} flatten(list) returns {a, b, c} because there are no nested
	 * lists
	 * 
	 * The type parameter <?> means that the list can contain anything.
	 * 
	 * @param list a list of anything, possibly containing other lists as elements
	 * @return a list of all elements without any nested lists
	 */
	public static List<?> flatten(List<?> list) {
		List<Object> ans = new ArrayList<>();
		Object front = list.get(0);
		if (front instanceof List) {
			List<?> insideAns = flatten((List<?>) front);
			ans.addAll(insideAns);
		} else {
			ans.add(front);
		}
		if (list.size() > 1) {
			List<?> last = (flatten((list.subList(1, list.size()))));
			ans.addAll(last);
		}
		return ans;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("a", "b", "a", "a", "z", "b", "z"));
		System.out.println(ListUtil.unique(list));

		List<String> list1 = Arrays.asList("a", "b");
		List<?> list2 = Arrays.asList(list1, "c", "d");
		List<?> list3 = Arrays.asList("x", "y", list2, "z");
		System.out.println(flatten(list3));
		System.out.println(ListUtil.flatten(list3));
		System.out.println(ListUtil.flatten(list1));
	}

}

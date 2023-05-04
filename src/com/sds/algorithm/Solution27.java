import java.util.*;

class Solution27{
	private int removeElement(int[] nums, int val){
		// 1 参数合法性校验
		if(nums.length < 1) return 0;

		// 2 定义双指针
		int left = 0, right = nums.length - 1;

		// 3 双指针操作移除对应的元素
		while(left <= right){
			if(nums[left] == val){
				int e = nums[left];
				nums[right] = nums[left];
				nums[left] = e;
				right--;
			}else{
				left++;
			}
		}

		// 4 返回结果
		return left;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] strs = line.split(" ");
		int[] nums = new int[strs.length];
		for(int i = 0; i < nums.length; i++){
			nums[i] = Integer.parseInt(strs[i]);
		}
		sc.nextLine();
		int n = sc.nextInt();

		Solution27 so = new Solution27();
		int len = so.removeElement(nums, n);
		System.out.println(len);
	}
}
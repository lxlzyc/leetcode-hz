package lxl.work;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-08-09 10:36
 **/
public class FindKthBitInNthBinaryString {

    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int length = this.getlength(n);
        int fanzhuan = 0;
        while (length > 1) {
            int mid = (length + 1) / 2;
            if (k == mid) {
                return fanzhuan % 2 == 0 ? '1' : '0';
            } else if (k > mid) {
                k = mid - (k - mid);
                fanzhuan++;
            }
            length = mid - 1;
        }
        return fanzhuan % 2 == 0 ? '0' : '1';
    }

    private int getlength(int n) {
        if (n == 1) {
            return 1;
        }
        return this.getlength(n - 1) * 2 + 1;
    }

    public static void main(String[] args) {
        FindKthBitInNthBinaryString findKthBitInNthBinaryString = new FindKthBitInNthBinaryString();
        System.out.println(findKthBitInNthBinaryString.findKthBit(3, 1));
    }
}

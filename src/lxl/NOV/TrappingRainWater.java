package lxl.NOV;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-25 10:35
 **/
public class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sumRain = 0;
        int leftHeight = 0;
        int rightHeight = 0;

        for (int i = 0,l=height.length; i < l; i++) {
            int index = height[i];
            if(stack.isEmpty()){
                //初始化左高
                if(index>0){
                    leftHeight = index;
                    stack.push(index);
                }
            }else{
                int peek = stack.peek();
                //不为空时，与左高比较，有三种情况
                //1.大于 等于，此时右高= index 计算水，清空，初始化
                //2.小于 检查虽然小于左高，但是否比peek高,高于peek记作右高
                if(index>=leftHeight){
                    rightHeight = index;
                    sumRain += getStackRain(stack,Math.min(leftHeight,rightHeight));
                    leftHeight = index;
                    rightHeight = 0;
                }else{
                    if(index>=peek){
                        rightHeight = index;
                    }
                }
                stack.push(index);
            }
        }
        if(!stack.isEmpty()){
            //此时栈有值，以为这栈中呈阶梯型下降，即栈底最高，从栈顶往下遍历，遇到比栈顶高的，即可开始计算
            //翻转栈即栈顶为左高，寻找右高
            Stack<Integer> innerStack = new Stack<>();
            while (!stack.empty()) {
                int index = stack.pop();
                if(innerStack.isEmpty()){
                    //初始化左高
                    if(index>0){
                        leftHeight = index;
                        innerStack.push(index);
                    }
                }else{
                    int peek = innerStack.peek();
                    //不为空时，与左高比较，有三种情况
                    //1.大于 等于，此时右高= index 计算水，清空，初始化
                    //2.小于 检查虽然小于左高，但是否比peek高,高于peek记作右高
                    if(index>=leftHeight){
                        rightHeight = index;
                        sumRain += getStackRain(innerStack,Math.min(leftHeight,rightHeight));
                        leftHeight = index;
                        rightHeight = 0;
                    }else{
                        if(index>=peek){
                            rightHeight = index;
                        }
                    }
                    innerStack.push(index);
                }
            }
            sumRain += getStackRain(innerStack,Math.min(leftHeight,rightHeight));
        }
        return sumRain;
    }

    private int getStackRain(Stack<Integer> stack, int height) {
        int sum = 0;
        int pop = 0;
        System.out.print("height="+height+"|");
        while (!stack.empty()) {
            pop = height - stack.pop();
            if(pop>0){
                sum += pop;
            }
            System.out.print(","+pop);
        }
        System.out.println("="+sum);
        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater.trap(height));
    }

}

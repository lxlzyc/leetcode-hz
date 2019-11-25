package lxl.NOV;

import java.util.Map;
import java.util.TreeMap;

/**
 * @program: leetcode-hz
 * @description:
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 *
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 *
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 *
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 *
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 *
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *
 * 示例 1:
 *
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 *
 * 示例 2:
 *
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 *
 * 示例 3:
 *
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 *
 * 注意:
 *
 *     所有原子的第一个字母为大写，剩余字母都是小写。
 *     formula的长度在[1, 1000]之间。
 *     formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-atoms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2019-11-21 14:15
 **/
public class CountOfAtoms {
    private TreeMap<String,Integer> map = new TreeMap<>();


    public String countOfAtoms(String formula) {

        StringBuilder str = new StringBuilder(formula);
        char[] chars = formula.toCharArray();
        int left = 0;
        int right = formula.length();
        //int leftKuoHao = formula.indexOf("(");
        //int rightKuoHao = formula.lastIndexOf(")");
       //if(leftKuoHao>0){
       //
       //}
        int leftKuoHao ;
        int rightKuoHao ;
        int KHNUM = 1;
        String NextKHNUM = "";
        while (true){
            leftKuoHao = str.indexOf("(");
            if(leftKuoHao == 0){
                str.replace(leftKuoHao,leftKuoHao+1,"_");
                rightKuoHao = str.lastIndexOf(")");
                str.replace(rightKuoHao,rightKuoHao+1,"_");
                for(int i=rightKuoHao+1;i<right;i++){
                    if(this.isNum(chars[i])){
                        NextKHNUM += chars[i];
                    }else{
                        break;
                    }
                }
                if(!NextKHNUM.isEmpty()){
                    KHNUM = KHNUM * Integer.valueOf(NextKHNUM);
                    NextKHNUM = "";
                }
                right = rightKuoHao;
            }else if(leftKuoHao > 0){
                //处理左边
                str.replace(leftKuoHao,leftKuoHao+1,"_");
                //System.out.println("deal left="+str.substring(left,leftKuoHao)+"|"+KHNUM);
                this.dealLeft(chars,left,leftKuoHao,KHNUM);
                left = leftKuoHao+1;
                rightKuoHao = str.lastIndexOf(")");
                str.replace(rightKuoHao,rightKuoHao+1,"_");
                for(int i=rightKuoHao+1;i<right;i++){
                    if(this.isNum(chars[i])){
                        NextKHNUM += chars[i];
                    }else{
                        //处理右边
                        //System.out.println("deal right="+str.substring(i,right)+"|"+KHNUM);;

                        this.dealRight(chars,right,i,KHNUM);
                        break;
                    }
                }
                if(!NextKHNUM.isEmpty()){
                    KHNUM = KHNUM * Integer.valueOf(NextKHNUM);
                    NextKHNUM = "";
                }
                right = rightKuoHao;
            }else{
                //System.out.println("deal innner="+str.substring(left,right)+"|"+KHNUM);;

                this.dealLeft(chars,left,right,KHNUM);
                break;
            }

       }

        //删除括号左边
        //算出括号右边
        //删除括号右边
        //解括号
        StringBuffer stringBuffer = new StringBuffer();

        for (String name: map.keySet()) {
            stringBuffer.append(name);
            int multiplicity = map.get(name);
            if (multiplicity > 1) {
                stringBuffer.append("" + multiplicity);
            }
        }

        return stringBuffer.toString();
    }

    private void dealLeft(char[] chars,int left,int leftKuoHao,
                          int KHNUM){
        String Atom = "";
        String Num ="";
        //找到左边第一个括号
            //算出括号左边 left 到 leftKuoHao
            for(int i = left,l=leftKuoHao;i<l;i++){
                //大写字母 开始Atom
                if(this.isUpperCase(chars[i])){
                    if(!Atom.isEmpty()){
                        this.addToMap(map,Atom,Num,KHNUM);
                        Num = "";
                    }
                    Atom = String.valueOf(chars[i]);
                }else if(this.isLowerCase(chars[i])){//小写字母，继续补全Atom
                    Atom += String.valueOf(chars[i]);
                }else if(this.isNum(chars[i])){//数字,继续补全Num
                    Num += String.valueOf(chars[i]);
                }
            }
        if(!Atom.isEmpty()){
            this.addToMap(map,Atom,Num,KHNUM);
            Num = "1";
        }
    }


    private void dealRight(char[] chars,int right,int rightKuoHao,
                          int KHNUM){
        String Atom = "";
        String Num ="";
        //找到左边第一个括号
            //算出括号左边 left 到 leftKuoHao
            for(int i = rightKuoHao,l=right;i<l;i++){
                //大写字母 开始Atom
                if(this.isUpperCase(chars[i])){
                    if(!Atom.isEmpty()){
                        this.addToMap(map,Atom,Num,KHNUM);
                        Num = "1";
                    }
                    Atom = String.valueOf(chars[i]);
                }else if(this.isLowerCase(chars[i])){//小写字母，继续补全Atom
                    Atom += String.valueOf(chars[i]);
                }else if(this.isNum(chars[i])){//数字,继续补全Num
                    Num += String.valueOf(chars[i]);
                }
            }
        if(!Atom.isEmpty()){
            this.addToMap(map,Atom,Num,KHNUM);
            Num = "1";
        }
    }

    private void addToMap(Map<String,Integer> map,String key,String value,int KHNUM){

        if(value.isEmpty()){
            value = "1";
        }
        if(map.containsKey(key)){
            map.put(key,map.get(key)+(Integer.valueOf(value)*KHNUM));
        }else{
            map.put(key,Integer.valueOf(value)*KHNUM);
        }
    }
    /*
     * 是否是数字
     */
    public boolean isNum(char c) {
        return c >=48 && c <= 57;
    }
    /*
     * 是否是大写
     */
    public boolean isUpperCase(char c) {
        return c >=65 && c <= 90;
    }
    /*
     * 是否是小写
     */
    public boolean isLowerCase(char c) {
        return c >=97 && c <= 122;
    }

    public static void main(String[] args) {
        CountOfAtoms countOfAtoms = new CountOfAtoms();
        System.out.println(countOfAtoms.countOfAtoms("(NB3)33"));
        //StringBuilder stringBuilder = new StringBuilder("Mg(OH)2");
        //stringBuilder.replace(2,3,"_");
        //System.out.println(stringBuilder.toString());

        //System.out.println("0".charAt(0));
        //System.out.println("9".charAt(0));
        //System.out.println("A".charAt(0));
        //System.out.println("Z".charAt(0));
        //System.out.println("a".charAt(0));
        //System.out.println("z".charAt(0));


    }

}

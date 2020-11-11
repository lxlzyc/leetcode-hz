package lxl.util;

/**
 * @program: leetcode-hz
 * @description:
 * @author: lxl
 * @create: 2020-08-20 14:02
 **/
public class BuildArrays {


    public static String build(String arr) {
        //arr.replaceAll("\\[,\\]","\r\n");
        arr = arr.replaceAll("\\[", "{");
        arr = arr.replaceAll("\\]", "}");
        arr = arr.replaceAll("\\{\\{", "{\r\n{");
        arr = arr.replaceAll("\\}\\}", "}\r\n}");
        arr = arr.replaceAll("\\},\\{", "},\r\n{");
        arr = arr.replaceAll("\"", "\'");
        return arr;
    }

    public static void main(String[] args) {
//[[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
        System.out.println(BuildArrays.build(
                " [[1,5],[8,12],[15,24],[25,26]]"
        ));
    }
}

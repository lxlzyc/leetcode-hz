package lxl.AUG;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode-hz
 * @description: 929. 独特的电子邮件地址
 * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 * <p>
 * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 * <p>
 * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
 * <p>
 * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 * <p>
 * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 * <p>
 * 可以同时使用这两个规则。
 * <p>
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-email-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-10 16:43
 **/
public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            emailSet.add(clearEmail(email));
        }
        return emailSet.size();
    }

    private String clearEmail(String email) {
        String[] emailSplit = email.split("@");
        String[] pre = emailSplit[0].split("\\+");
        return pre[0].replaceAll("\\.", "") + "@" + emailSplit[1];
    }

    public static void main(String[] args) {
        UniqueEmailAddresses uniqueEmailAddresses = new UniqueEmailAddresses();
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(uniqueEmailAddresses.numUniqueEmails(emails));
    }
}

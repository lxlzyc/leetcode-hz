package lxl.y2020.APR;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 535. TinyURL 的加密与解密
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，
 * 它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 * <p>
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，
 * 你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 * @author: lxl
 * @create: 2020-04-16 17:15
 **/
public class EncodeAndDecodeTinyurl {

    Map<Integer, String> urlMap = new HashMap<>();
    private Integer i = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urlMap.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        Integer i = Integer.valueOf(shortUrl.substring(19));
        return urlMap.get(i);
    }

    public static void main(String[] args) {
        EncodeAndDecodeTinyurl encodeAndDecodeTinyurl = new EncodeAndDecodeTinyurl();
        String url = encodeAndDecodeTinyurl.encode("ddddd");
        //System.out.println(url );
        System.out.println(encodeAndDecodeTinyurl.decode(url));

    }
}

package com.platform.admin.common.util;



import com.platform.admin.common.security.DesUtils;


public class CookieUtils {

    // DES密钥
   //private final static String DES_KEY = DesUtils.initSecretKey(56);

    // 定义cookie value的最大长度
    private static int COOKIE_MAX_LENTH = 2048;

    /**
     * <p>
     * <b>功能描述:写cookie</b>
     * <ul>
     * <li>可见性原因：需要被其他应用调用</li>
     * <li>目的：检查签名</li>
     * <li>适用的前提条件:</li>
     * <li>后置条件：</li>
     * <li>例外处理：无 </li>
     * <li>已知问题：</li>
     * <li>调用的例子： </li>
     * </ul>
     * </p>
     *
     * @param response
     * @param cookieName
     * @param cookieValue
     */
//    public static void writeCookie(HttpServletResponse response, String desKey,
//                                   String cookieName, String cookieValue) {
//        Cookie cookie = new Cookie(cookieName, cookieValue);
//        cookie.setPath("/");
//        writeCookie(response,desKey, cookie);
//    }

    /**
     * <p>
     * <b>功能描述:写cookie</b>
     * <ul>
     * <li>可见性原因：需要被其他应用调用</li>
     * <li>目的：检查签名</li>
     * <li>适用的前提条件:</li>
     * <li>后置条件：</li>
     * <li>例外处理：无 </li>
     * <li>已知问题：</li>
     * <li>调用的例子： </li>
     * </ul>
     * </p>
     *
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param domain
     */
//    public static void writeCookie(HttpServletResponse response, String desKey,
//                                   String cookieName, String cookieValue, String domain) {
//        Cookie cookie = new Cookie(cookieName, cookieValue);
//        cookie.setDomain(domain);
//        cookie.setPath("/");
//        writeCookie(response, desKey,cookie);
//    }

    /**
     * <p>
     * <b>功能描述:写cookie</b>
     * <ul>
     * <li>可见性原因：需要被其他应用调用</li>
     * <li>目的：检查签名</li>
     * <li>适用的前提条件:</li>
     * <li>后置条件：</li>
     * <li>例外处理：无 </li>
     * <li>已知问题：</li>
     * <li>调用的例子： </li>
     * </ul>
     * </p>
     *
     * @param response
     * @param desKey
     * @param cookieName
     * @param cookieValue
     * @param domain
     * @param maxAge
     */
//    public static void writeCookie(HttpServletResponse response, String desKey,
//                                   String cookieName, String cookieValue, String domain, int maxAge) {
//        Cookie cookie = new Cookie(cookieName, cookieValue);
//
//        if (domain != null && !domain.equalsIgnoreCase("")) {
//            cookie.setDomain(domain);
//        }
//        cookie.setMaxAge(maxAge);
//        cookie.setPath("/");
//        writeCookie(response, desKey,cookie);
//    }

    /**
     * <p>
     * <b>功能描述:写cookie</b>
     * <ul>
     * <li>可见性原因：需要被其他应用调用</li>
     * <li>目的：检查签名</li>
     * <li>适用的前提条件:</li>
     * <li>后置条件：</li>
     * <li>例外处理：无 </li>
     * <li>已知问题：</li>
     * <li>调用的例子： </li>
     * </ul>
     * </p>
     *
     * @param response
     * @param desKey
     * @param cookie
     */
//    private static void writeCookie(HttpServletResponse response, String desKey , Cookie cookie) {
//
//        //加密后
//        String cookieName =  DesUtils.encrypt(desKey, cookie.getName());
//        String cookieValue = DesUtils.encrypt(desKey, cookie.getValue());
//
//        int lenth = cookieValue.length();
//        int count = lenth / COOKIE_MAX_LENTH;
//        if (lenth % COOKIE_MAX_LENTH > 0) {
//            count++;
//        }
//
//        for (int i = 0; i < count; i++) {
//            String key = cookieName + i;
//            String value = "";
//            if (i != count - 1) {
//                if ((i + 1) * COOKIE_MAX_LENTH - 1 < lenth) {
//                    value = cookieValue.substring(i * COOKIE_MAX_LENTH
//                            , (i + 1) * COOKIE_MAX_LENTH);
//
//                } else {
//                    value = cookieValue.substring(i * COOKIE_MAX_LENTH);
//                }
//            } else {
//                value = cookieValue.substring(i * COOKIE_MAX_LENTH);
//            }
//            Cookie breakupCookie = new Cookie(key, value);
//            breakupCookie.setPath(cookie.getPath());
//            response.addCookie(breakupCookie);
//
//        }
//    }

    /**
     * <p>
     * <b>功能描述:读取COOKIE内容</b>
     * <ul>
     * <li>可见性原因：需要被其他应用调用</li>
     * <li>目的：检查签名</li>
     * <li>适用的前提条件:</li>
     * <li>后置条件：</li>
     * <li>例外处理：无 </li>
     * <li>已知问题：</li>
     * <li>调用的例子： </li>
     * </ul>
     * </p>
     *
     * @param request
     * @param desKey
     * @param cookieName
     * @return
     */
//    public static String readCookie(HttpServletRequest request, String desKey,
//                                    String cookieName) {
//        //获取解密后的Cookie集合
//        Cookie[] cookies = request.getCookies();
//        //加密后
//        String name =  DesUtils.encrypt(desKey, cookieName);
//        StringBuilder cookieStr = null;
//        if (cookies != null) {
//            cookieStr = new StringBuilder();
//            for (int i = 0; i < cookies.length; i++) {
//                if (cookies[i].getName().startsWith(name)) {
//                    cookieStr.append(cookies[i].getValue());
//                }
//            }
//        }
//
//        if (cookieStr != null) {
//            return DesUtils.decrypt(desKey, cookieStr.toString());
//        }
//
//        return null;
//    }

    /**
     * <p>
     * <b>功能描述:清除指定cookieName的Cookie</b>
     * <ul>
     * <li>可见性原因：需要被其他应用调用</li>
     * <li>目的：检查签名</li>
     * <li>适用的前提条件:</li>
     * <li>后置条件：</li>
     * <li>例外处理：无 </li>
     * <li>已知问题：</li>
     * <li>调用的例子： </li>
     * </ul>
     * </p>
     *
     * @param request
     * @param response
     * @param cookieName
     */
//    public static void invalidate(HttpServletRequest request,
//                                  HttpServletResponse response, String cookieName) {
//        //获取解密后的Cookie集合
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (int i = 0; i < cookies.length; i++) {
//                if (cookies[i].getName().startsWith(cookieName)) {
//                    Cookie cookie = cookies[i];
//                    cookie.setMaxAge(0);
//                    cookie.setPath("/");
//                    cookie.setValue("");
//                    response.addCookie(cookie);
//                }
//            }
//        }
//    }

    /**
     * <p>
     * <b>功能描述:清除所有Cookie</b>
     * <ul>
     * <li>可见性原因：需要被其他应用调用</li>
     * <li>目的：检查签名</li>
     * <li>适用的前提条件:</li>
     * <li>后置条件：</li>
     * <li>例外处理：无 </li>
     * <li>已知问题：</li>
     * <li>调用的例子： </li>
     * </ul>
     * </p>
     *
     * @param request
     * @param response
     */
//    public static void invalidate(HttpServletRequest request,
//                                  HttpServletResponse response) {
//
//        Cookie[] cookies = request.getCookies();
//
//        if(cookies!=null) {
//            for (int i = 0; i < cookies.length; i++) {
//                System.out.println(":::invalidate:::cookiename::::" + cookies[i].getName());
//                cookies[i].setMaxAge(0);
//                cookies[i].setPath("/");
//                response.addCookie(cookies[i]);
//            }
//        }
//    }
}

package util;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.MalformedURLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dell on 2016/7/10.
 */
public class HttpCurl {

    private static final Logger logger = Logger.getLogger(HttpCurl.class);
    private static final String userName = "320520196212300422";
    private static final String password = "1230";

    public void tryCurl() throws IOException {
        long now = System.currentTimeMillis();
        String indexUrl = "http://wx01.jscsyy.com/index.asp";
        String imgCodeUrl  = "http://wx01.jscsyy.com/code.asp";
        String imgCodeUrl2 = "http://wx01.jscsyy.com/code2.asp";
        String imgPicSavePath = "E:\\BaiduYunDownload\\";
        String imgPicSavePath2= "E:\\MyDownloads\\";
        String getDataUrl = "http://wx01.jscsyy.com/getdata.asp?sectionId=010101020217";
        String loginUrl = "http://wx01.jscsyy.com/login.asp";
        String planUrl = "http://wx01.jscsyy.com/goyyinfo.asp";
        String tokenUrl = "http://wx01.jscsyy.com/goyyinfo.asp";
        String planOver = "";//没名额图片
        DefaultHttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,10000);

        String saveFileName = imgPicSavePath + UUID.randomUUID() + ".png";
        String cookieCode = getImgCode(httpclient,imgCodeUrl,saveFileName);

        //输入验证码
        Scanner scanner = new Scanner(System.in);
        String code  = scanner.next();

        //get token getData params begin
        HttpGet httpGetIndexToken = new HttpGet(indexUrl);
        httpGetIndexToken.setHeader("Cookie",cookieCode);
        httpGetIndexToken.setHeader("Connection","keep-alive");

        HttpResponse responseTokenAndParam = httpGet(httpclient,httpGetIndexToken);

        logger.info("===== first code cookie " + cookieCode);
        BufferedReader inToken = new BufferedReader(new InputStreamReader(responseTokenAndParam.getEntity().getContent(), "gbk"));
        String sbToken = getHtmlBody(inToken);
        String token1 = reg(sbToken);
        String params = regDataParam(sbToken);
        httpGetIndexToken.releaseConnection();

        String dataUrl = getDataUrl + handleParams(params);
        logger.info("===== dataUrl " + dataUrl);
        HttpGet getData = new HttpGet(dataUrl);
        HttpResponse responseData = httpGet(httpclient,getData);
        getData.releaseConnection();

        BufferedReader responseDataReader = new BufferedReader(new InputStreamReader(responseData.getEntity().getContent(), "gbk"));
        String data = getHtmlBody(responseDataReader);
        Map<String, String> dataMap = handlePlanParams(data);

        if(dataMap.size() == 0){
            // TODO: 2016/7/12 打开没名额的图片
            System.exit(0);
        }

        String loginCookie = loginForCookie(httpclient,loginUrl,token1,code,cookieCode);

        logger.info("===== data " + data);
        logger.info("===== token1 " + token1 + " params " + params + " " + dataMap.toString() + " loginCookie " + loginCookie);
        ////get token getData params end

        //拿到token
        String refererUrl = tokenUrl + "?rq=" + dataMap.get("rq") + "&sjd=" + "&pbid=" + dataMap.get("pbid");

        logger.info("===== refererUrl " + refererUrl );
        HttpGet httpGetToken = new HttpGet(refererUrl);
        httpGetToken.setHeader("Cookie",loginCookie);
        httpGetToken.setHeader("Connection","keep-alive");
        HttpResponse responseToken2 = httpGet(httpclient,httpGetToken);

        BufferedReader in3 = new BufferedReader(new InputStreamReader(responseToken2.getEntity().getContent(), "gbk"));
        String tokenHtml = getHtmlBody(in3);
        String token3 = reg(tokenHtml);

        List<Cookie> cookiesList4 = httpclient.getCookieStore().getCookies();
        String cookieToken = getCookie(cookiesList4);
        httpGetToken.releaseConnection();

        logger.info("===== cookieToken " + cookieToken + " token3 " + token3);

        //第二次去code2.asp拿到下次的验证码
        HttpGet httpGetCode2 = new HttpGet(imgCodeUrl2);
        httpGetCode2.setHeader("Cookie",cookieToken);
        httpGetCode2.setHeader("Connection","keep-alive");

        HttpResponse responseCode2 = httpGet(httpclient,httpGetCode2);
        //get img and cookie
        List<Cookie> cookiesList = httpclient.getCookieStore().getCookies();

        String cookieCode2 = getCookie(cookiesList);
        logger.info("===== cookie3 " + cookieCode2 + " token3 " + token3);

        //保存img
        String saveFileName2 = imgPicSavePath2 + UUID.randomUUID() + ".png";
        download(responseCode2.getEntity().getContent(),saveFileName2);
        openCodePic(saveFileName2);
        //second code end
        httpGetCode2.releaseConnection();

        //二次输入验证码
        //输入验证码
        Scanner scanner2 = new Scanner(System.in);
        String code2  = scanner2.next();

        //带上cookie提交
        List<NameValuePair> postList2 = new ArrayList<NameValuePair>();

        HttpPost planPost = new HttpPost(planUrl);
        planPost.setHeader("Cookie",cookieCode2);
        planPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
        planPost.setHeader("Cache-Control","max-age=0");
        planPost.setHeader("Content-Type","application/x-www-form-urlencoded");
        planPost.setHeader("DNT","1");
        planPost.setHeader("Host","wx01.jscsyy.com");
        planPost.setHeader("Origin","http://wx01.jscsyy.com");
        planPost.setHeader("Referer",refererUrl);

        postList2.add(new BasicNameValuePair("act","save"));
        postList2.add(new BasicNameValuePair("pbid",dataMap.get("pbid")));
        postList2.add(new BasicNameValuePair("rq",dataMap.get("rq")));
        postList2.add(new BasicNameValuePair("thissjd",dataMap.get("thissjd")));
        postList2.add(new BasicNameValuePair("thistime",DateUtil.longToDate(now,"HH:mm:ss")));
        postList2.add(new BasicNameValuePair("sjd",dataMap.get("sjd")));
        postList2.add(new BasicNameValuePair("token",token3));
        postList2.add(new BasicNameValuePair("mintueof",""));
        postList2.add(new BasicNameValuePair("valcode",code2));
        postList2.add(new BasicNameValuePair("submit"," 提交预约 "));
        planPost.setEntity(new UrlEncodedFormEntity(postList2,"gbk"));

        //报名成功
        HttpResponse responsePlan = httpclient.execute(planPost);
        BufferedReader inPlan = new BufferedReader(new InputStreamReader(responsePlan.getEntity().getContent(), "gbk"));
        logger.info(getHtmlBody(inPlan));
        planPost.releaseConnection();
    }

    public static String reg(String s){
        String pattern = "<input type=\"hidden\" name=\"token\" value=\"(.*)\">";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(s);
        String res = "";
        if (matcher.find()) {
            res += matcher.group(1);
        }
        return res;
    }

    public static String regDataParam(String s){
        String pattern = "onclick=\"javascript:showinfo\\(this,(.*)\\)\">汪波";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(s);
        String res = "";
        while (matcher.find()) {
            res += matcher.group(1) + "|";
        }
        return res;
    }




    public void openCodePic(String path){
        try {
            Runtime.getRuntime().exec("rundll32 c:\\Windows\\System32\\shimgvw.dll,ImageView_Fullscreen "+path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static void download(InputStream in, String path)
    {
        FileOutputStream out = null;
        try
        {
            out = new FileOutputStream(path);
            byte b[] = new byte[1024];
            int j = 0;
            while ((j = in.read(b)) != -1)
            {
                out.write(b, 0, j);
            }
            out.flush();

        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            if("FileNotFoundException".equals(e.getClass().getSimpleName()))
                System.err.println("download FileNotFoundException");
            if("SocketTimeoutException".equals(e.getClass().getSimpleName()))
                System.err.println("download SocketTimeoutException");
            else
                e.printStackTrace();
        } finally{

            if(out != null)
                try
                {
                    out.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            if(in != null)
                try
                {
                    in.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
    }


    public String getHtmlBody(BufferedReader in) throws IOException {
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = in.readLine()) != null)
        {
            sb.append(s.trim()).append("\n");
        }
        return sb.toString();
    }


    public String getImgCode(DefaultHttpClient httpClient,String imgCodeUrl,String saveFileName) throws IOException {
        HttpGet httpGet = new HttpGet(imgCodeUrl);
        httpGet.setHeader("Connection","keep-alive");
        HttpResponse responseCode = httpGet(httpClient,httpGet);
        //get img and cookie
        List<Cookie> cookies = httpClient.getCookieStore().getCookies();
        //保存img
        download(responseCode.getEntity().getContent(),saveFileName);
        openCodePic(saveFileName);
        //get1 end
        httpGet.releaseConnection();
        return getCookie(cookies);
    }


    public String loginForCookie(DefaultHttpClient httpClient,String loginUrl,String token1,String code,String cookie1) throws IOException {

        long now = System.currentTimeMillis();
        List<NameValuePair> postList = new ArrayList<NameValuePair>();
        postList.add(new BasicNameValuePair("act","login"));
        postList.add(new BasicNameValuePair("thistime",DateUtil.longToDate(now,"yyyy/M/dd")));
        postList.add(new BasicNameValuePair("token",token1));
        postList.add(new BasicNameValuePair("username",userName));
        postList.add(new BasicNameValuePair("loginpassword",password));
        postList.add(new BasicNameValuePair("logincode",code));
        postList.add(new BasicNameValuePair("loginsubmit","登录"));


        HttpPost loginPost = new HttpPost(loginUrl);
        loginPost.setHeader("Cookie",cookie1);
        loginPost.setHeader("Connection","keep-alive");
        loginPost.setEntity(new UrlEncodedFormEntity(postList,"gbk"));

        logger.info("===== cookie1"+ cookie1);

        //登录成功
        loginPost.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
        HttpResponse responseLogin = httpClient.execute(loginPost);
        BufferedReader inLogin = new BufferedReader(new InputStreamReader(responseLogin.getEntity().getContent(), "gbk"));
        logger.info(getHtmlBody(inLogin));
        //login end
        loginPost.releaseConnection();
        //登录成功后的cookies
        List<Cookie> cookiesList = httpClient.getCookieStore().getCookies();

        return getCookie(cookiesList);
    }



    public HttpResponse httpGet(HttpClient client,HttpGet httpGet){
        httpGet.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);
        try {
            return client.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCookie(List<Cookie> cookieList){
        StringBuilder cookiesSB = new StringBuilder();
        for (int i = 0; i < cookieList.size(); i++) {
            cookiesSB.append(cookieList.get(i).getName()).append("=")
                    .append(cookieList.get(i).getValue()).append("; ");
        }
        return cookiesSB.toString();
    }

    public static String handleParams(String params){
        long now = System.currentTimeMillis();
        String[] s = params.split("\\|");
        String param = "";
        if(s.length > 0){
            String s2 = s[0];
            String[] s3 = s2.split(",");
            param = "&bmno=" + s3[0]+ "&zzrq="+s3[1]+"&did="+s3[2]+"&ma="+s3[4]+ "&rid=" + s3[3] + "&t=" + now;
            return param.replaceAll("\'","");
        }
        return param;
    }


    public static Map<String,String> handlePlanParams(String planParms){
        Map<String,String> map = new HashMap<String,String>();
        String[] s = planParms.split("\\|");
        if(s.length > 0){
            String s2 = s[1];
            String[] s3 = s2.split("\\*");
            for (String s1 : s3) {
                String[] s4 = s1.split(",");
                if(Integer.parseInt(s4[3]) != 0){
                    map.put("pbid",s4[0]+","+s4[1]);
                    map.put("rq",s4[2]);
                    map.put("thissjd",s4[1]);
                    map.put("sjd",s4[1]);
                    break;
                }
            }
        }

        return map;
    }

    public static void main(String[] args) throws IOException {
        //long now = System.currentTimeMillis();
        //System.out.println(DateUtil.longToDate(now, "M-dd"));
        new HttpCurl().tryCurl();

        //String s = "<div class=\"ysdiv\" sectionid=\"010101020217\" onclick=\"javascript:showinfo(this,'2033','20160714','100401','002000','13017','010101020217')\">张红丹<span>";
        //System.out.println(regDataParam(s));
    }
}

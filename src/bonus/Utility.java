package bonus;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Utility {
	public static String getKoreanDate(String date) {
		String koreanDate = null;
		SimpleDateFormat from = new SimpleDateFormat("MMM dd, yyyy",Locale.US);
		SimpleDateFormat to = new SimpleDateFormat("yyyy-MM-dd",Locale.KOREAN);
		
		try {
			Date d = from.parse(date); 
			koreanDate = to.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return koreanDate;
	}
	public static boolean isQrcode(String content,int Width,int height) {
		boolean isSuccess = false;
		
		QRCodeWriter writer = new QRCodeWriter();
		try {
			BitMatrix qrCode = writer.encode(content, BarcodeFormat.QR_CODE, Width, height);
			BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(qrCode);
			
			File f = new File("c:\\dev\\test\\qrcode.png");
			isSuccess = ImageIO.write(qrImage,"PNG",f);
			
		} catch(WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	public static String getCaptchaKey(String id, String secret){
		
		String key= null;
		
		String clientId = id;
        String clientSecret = secret;
        
        try {
            String code = "0";
            String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else { 
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine); 
            }
            br.close();
            
            JSONParser jsonParse = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParse.parse(response.toString());
            key=(String)jsonObj.get("key");
 
        } catch (Exception e) {
            System.out.println(e);
        }
		return key;
	}
	
	public static boolean isCaptchaImage(String id, String secret , String key) {
		
		boolean isSuccess = false;
		
		String clientId = id;
        String clientSecret = secret;
        try {
            String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { 
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                String tempname = String.valueOf(new Date().getTime()); 
               
                String path = "c:\\dev\\test"; //여러분 환경에 맞게 절대경로를 입력해주세요.
                
                Calendar c = Calendar.getInstance();
                File file = new File(path,Utility.getDate(c, "yyyy\\MM\\dd"));
                
                Utility.mkdirs(file.getPath());
                
                File f = new File(file , tempname + ".jpg");
               
                FileOutputStream fos = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    fos.write(bytes, 0, read);
                }
                is.close();
                fos.close();
                isSuccess = true;
            } else { 
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
		return isSuccess;
	}
	
	public static boolean isCaptchaResult(String id, String secret, String key, String value ) {
		boolean result = false;
		
		String clientId = id;
        String clientSecret = secret;
        try {
            String code = "1"; 
            String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code +"&key="+ key + "&value="+ value;

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            
            JSONParser jsonParse = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParse.parse(response.toString());
            
            result = (Boolean)jsonObj.get("result");
        
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return result;
	}
	
	public static String getShortenURL(String id, String secret, String oriUrl){
		 String clientId = id;
	        String clientSecret = secret;
	        StringBuffer response = new StringBuffer();
	        try {
	            String text = oriUrl;
	            String apiURL = "https://openapi.naver.com/v1/util/shorturl?url=" + text;
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { 
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            
	            JSONParser jsonParse = new JSONParser();
	            JSONObject jsonObj = (JSONObject) jsonParse.parse(response.toString());
	            JSONObject dataObject = (JSONObject) jsonObj.get("result");
	            response.setLength(0); //StringBuffer 에 저장된 문자열 모두 지우기
	            response.append((String)dataObject.get("url"));
	            
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return response.toString();
	}
	
	//pattern 예시
	//"yyyy-MM월-dd일 a hh:mm:ss E요일" / a : 오전/오후
	public static String getDate(Calendar c, String pattern) {
		return new SimpleDateFormat(pattern).format(c.getTime());
	}
	
	public static boolean mkdirs(String path) {
		boolean isSuccess = false;
		File file = new File(path);
		boolean isExisted = file.isDirectory();
		if(!isExisted) {
			isSuccess = file.mkdirs();
		}
		return isSuccess;
	}
	
	public static String getComma(long name) {
		return String.format("%,d", name);
	}
	public static String getComma(double name,int precision) {
		return String.format("%,."+precision+"f", name);
	}
	
	public static boolean changeFile(String path) {
		boolean isSuccess = false;
		File oldFile = new File(path);
		String fileName = oldFile.getName(); 
		String name = fileName.substring(0,fileName.lastIndexOf("."));
		String extensionWithDot = fileName.substring(fileName.lastIndexOf("."));
		
		//마음에 안들면 아래 부분을 수정하세요..
		name = String.valueOf(System.currentTimeMillis());
		
		fileName = name + extensionWithDot;
		String parent = oldFile.getParent();
		File newfile = new File(parent,fileName);
		isSuccess = oldFile.renameTo(newfile);
		return isSuccess;
	}
}

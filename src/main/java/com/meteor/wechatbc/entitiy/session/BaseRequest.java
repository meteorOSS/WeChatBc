package com.meteor.wechatbc.entitiy.session;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.ToString;
import okhttp3.Cookie;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.List;

/**
 * 公共请求
 * 登陆后的所有接口都需要携带该类
 */
@Data
@ToString
public class BaseRequest{
    @JSONField(name = "Uin")
    private String uin;
    @JSONField(name = "Sid")
    private String sid;
    @JSONField(name = "Skey")
    private String skey;
    @JSONField(name = "DeviceID")
    private String deviceId;
    @JSONField(name = "webwx_data_ticket")
    private String dataTicket;
    @JSONField(name = "pass_ticket")
    private String passTicket;
    @JSONField(name = "webwx_auth_ticket")
    private String authTicket;

    @JSONField
    private List<Cookie> initCookie;

    // 解析xml
    public BaseRequest(String xmlData){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlData.getBytes()));
            NodeList skeyList = document.getElementsByTagName("skey");
            if (skeyList.getLength() > 0) {
                Element skeyElement = (Element) skeyList.item(0);
                this.skey = skeyElement.getTextContent();;
            }
            NodeList wxsidList = document.getElementsByTagName("wxsid");
            if (wxsidList.getLength() > 0) {
                Element wxsidElement = (Element) wxsidList.item(0);
                this.sid = wxsidElement.getTextContent();
            }
            NodeList wxuniList = document.getElementsByTagName("wxuin");
            if (wxsidList.getLength() > 0) {
                Element wxuniElement = (Element) wxuniList.item(0);
                this.uin = wxuniElement.getTextContent();
            }
            NodeList passTicketList = document.getElementsByTagName("pass_ticket");
            if (passTicketList.getLength() > 0) {
                Element passTicketElement = (Element) passTicketList.item(0);
                this.passTicket = passTicketElement.getTextContent();
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static BaseRequest createFromFile(File file) {
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            String jsonString = br.readLine();
            return JSON.parseObject(jsonString, BaseRequest.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BaseRequest create(File file){
        try (FileInputStream fileIn = new FileInputStream(file);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
             return (BaseRequest) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return null;
        }
    }

    public void saveToJson(File file) {
        String jsonString = JSON.toJSONString(this);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

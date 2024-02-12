package com.meteor.wechatbc.entitiy.message;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Message {
    @JSONField(name = "MsgId")
    private Long msgId;

    @JSONField(name = "FromUserName")
    private String fromUserName;

    @JSONField(name = "ToUserName")
    private String toUserName;

    @JSONField(name = "MsgType")
    private Integer msgType;

    @JSONField(name = "Content")
    private String content;

    @JSONField(name = "Status")
    private Integer status;

    @JSONField(name = "ImgStatus")
    private Integer imgStatus;

    @JSONField(name = "CreateTime")
    private Long createTime;

    @JSONField(name = "VoiceLength")
    private Integer voiceLength;

    @JSONField(name = "PlayLength")
    private Integer playLength;

    @JSONField(name = "FileName")
    private String fileName;

    @JSONField(name = "FileSize")
    private String fileSize;

    @JSONField(name = "MediaId")
    private String mediaId;

    @JSONField(name = "Url")
    private String url;

    @JSONField(name = "AppMsgType")
    private Integer appMsgType;

    @JSONField(name = "StatusNotifyCode")
    private Integer statusNotifyCode;

    @JSONField(name = "StatusNotifyUserName")
    private String statusNotifyUserName;

    @JSONField(name = "RecommendInfo")
    private RecommendInfo recommendInfo;

    @JSONField(name = "ForwardFlag")
    private Integer forwardFlag;

    @JSONField(name = "AppInfo")
    private AppInfo appInfo;

    @JSONField(name = "HasProductId")
    private Integer hasProductId;

    @JSONField(name = "Ticket")
    private String ticket;

    @JSONField(name = "ImgHeight")
    private Integer imgHeight;

    @JSONField(name = "ImgWidth")
    private Integer imgWidth;

    @JSONField(name = "SubMsgType")
    private Integer subMsgType;

    @JSONField(name = "NewMsgId")
    private Long newMsgId;

    @JSONField(name = "OriContent")
    private String oriContent;

    @JSONField(name = "EncryFileName")
    private String encryFileName;
}